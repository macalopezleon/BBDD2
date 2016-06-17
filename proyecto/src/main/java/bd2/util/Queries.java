package bd2.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.Diccionario;
import bd2.model.Documento;
import bd2.model.Moderador;
import bd2.model.Tarea;
import bd2.model.Usuario;

/**
 *
 * @author Grupo 01
 */
public class Queries {

	private static SessionFactory sessions;
	private static Transaction tx = null;

	public Queries() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("----------------------- Setting up Hibernate -----------------------");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");

		System.out.println("Building sessions.........");
		sessions = cfg.buildSessionFactory();

		Session session = sessions.openSession();

		primera(session);

		segunda(session);

		tercera(session);

		cuarta(session,"2015-07-01","2015-12-31");

		quinta(session);

		sexta(session);

		septima(session, "Leuchtturm");

		octava(session);

		novena(session, "Aleman");
		
		

		session.close();

	}
/**
 * Lista los nombres de todos los documentos
 * @param session se le envia la sesion de la base de datos
 */
	
	public static void primera(Session session) {
		Query query = session.createQuery("from Documento");

		List<Documento> documentos = query.list();
		System.out.println("A. Listar los nombres de todos los documentos\n");
		for (Documento d : documentos) {
			System.out.println("Documento: " + d.getNombre() + "\n");
		}
		System.out.println("\n");
	}
	/**
	 * Lista los emails de los moderadores que hayan evaluado traducciones al inglés
	 * @param session se le envia la sesion de la base de datos
	 */

	public static void segunda(Session session) {
		
		Query query = session.createQuery(
				"select distinct m from Moderador m join m.evaluaciones e where e.traduccion.idioma.nombre = 'ingles'");

		List<Moderador> moderadores = query.list();
		System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés\n");
		for (Moderador m : moderadores) {
			System.out.println("Email: " + m.getEmail() + "\n");
		}

		System.out.println("\n");
	}

	/**
	 * Lista los usuarios que hayan iniciado una cursada de Francés de nivel
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void tercera(Session session) {
		Query query = session.createQuery(
				"select distinct u from Usuario u join u.cursadasRealizadas c where c.curso.idioma.nombre = 'Frances' and c.curso.nivel >= 3");
		
		System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3\n");
		List<Usuario> usuarios = query.list();
		for (Usuario u : usuarios) {
			System.out.println("Usuario: " + u.getNombre() + "\n");
		}
		System.out.println("\n");
	}
	
	/**
	 * Lista los moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento
	 * @param session se le envia la sesion de la base de datos
	 * @param fechaDesde se especifica la fecha desde donde comienza la busqueda
	 * @param fechaHasta se especifica la fecha hasta donde termina la busqueda
	 */

	public static void cuarta(Session session, String fechaDesde, String fechaHasta) {
		Query query = session.createQuery(
				"select distinct m from Moderador m join m.evaluaciones e where (e.fecha between :fechaDesde and :fechaHasta)");
		query.setString("fechaDesde", fechaDesde);
		query.setString("fechaHasta", fechaHasta);

		System.out.println(
				"D. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.\n");
		List<Moderador> moderadores = query.list();
		for (Moderador m : moderadores) {
			System.out.println("Nombre: " + m.getNombre() + "\n");
		}
		System.out.println("\n");

	}

	/**
	 * Lista las traducciones completas del Inglés
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void quinta(Session session) {
		Query query = session.createQuery(
				"from Traduccion t where t.idioma.nombre = 'Frances' and t.parrafo.documento.idioma.nombre = 'Ingles'");

		System.out.println("E. Listar traducciones completas del Inglés\n");
		System.out.println("\n");
		List<Tarea> tareas = query.list();
		for (Tarea t : tareas) {
			System.out.println("Nombre: " + t.getDescripcion() + "\n");
		}
		System.out.println("\n");

	}

	/**
	 * Obtiene los emails de los usuarios con alguna cursada aprobada
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void sexta(Session session) {
		Query query = session.createQuery(
				"select distinct u from Usuario u where u in ("
						+ "select c.usuario from Cursada c join c.pruebas p "
						+ "where p.puntaje >= 60 "
						+ "and c.usuario = u "
						+ "group by c.curso "
						+ "having count(p) = ("
								+ "select cur.lecciones.size from Curso cur where cur = c.curso))");

		System.out.println(
				"F. Obtener los emails de los usuarios con alguna cursada aprobada\n");
		
		List<Usuario> usuarios = query.list();
		for (Usuario u : usuarios) {
			System.out.println("Usuario con cursada aprobada: " + u.getEmail() + "\n");
		}
		System.out.println("\n");

	}
/**
 * Obtiene el idioma que define la palabra enviada como parámetro en su diccionario
 * @param session se le envia la sesion de la base de datos
 */
	
	public static void septima(Session session, String palabra) {
		
		Query query = session.createQuery(
				"select distinct d from Diccionario d join d.definiciones def where index(def) = :palabra");
		query.setString("palabra", palabra);

		System.out.println("G. Obtener el idioma que define la palabra enviada como parámetro en su diccionario\n");
		List<Diccionario> diccionarios = query.list();
		for (Diccionario d : diccionarios) {
			System.out.println("El idioma " + d.getIdioma().getNombre() + " define la palabra " + palabra + "\n");
		}
		System.out.println("\n");

	}

	/**
	 * Obtiene los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void octava(Session session) {		
		Query query = session.createQuery(
				"from Documento d where d not in (select doc from Documento doc join doc.parrafos p where p in (select t.parrafo from Traduccion t))");

		System.out.println(
				"H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)\n");
		
		List<Documento> documentos = query.list();
		for (Documento d : documentos) {
			System.out.println("El documento " + d.getNombre() + " no tiene ninguna traducción\n");
		}
		System.out.println("\n");

	}
	
	/**
	 * Obtiene los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro
	 * @param session se le envia la sesion de la base de datos
	 */

	public static void novena(Session session, String nombreIdioma) {
		
		Query query = session.createQuery(
				"select distinct d from Documento d join d.parrafos p where p not in (select t.parrafo from Traduccion t where t.idioma.nombre = :nombreIdioma)");
		query.setString("nombreIdioma", nombreIdioma);

		List<Documento> documentos = query.list();

		System.out.println(
				"I. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro.\n");
		for (Documento d : documentos) {
			System.out.println("El documento " + d.getNombre() + " no está totalmente traducido.\n");
		}
		System.out.println("\n");

	}

}