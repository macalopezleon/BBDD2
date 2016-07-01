package bd2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	    Date fd = null;
		try {
			fd = sdf.parse("2015-07-01");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Date fh = null;
		try {
			fh = sdf.parse("2015-12-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		cuarta(session,fd,fh);

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
		
		tx = session.beginTransaction();
		Query query = session.createQuery("select nombre from Documento");
		query.setFirstResult(0);
		
		List<String> documentos = query.list();
		
		
		System.out.println("A. Listar los nombres de todos los documentos\n");
		for (int i = 0; i < documentos.size(); i++) {
			System.out.println("Documento: " + documentos.get(i) + "\n");
        }
		System.out.println("\n");
		
		tx.commit();
	}
	/**
	 * Lista los emails de los moderadores que hayan evaluado traducciones al inglés
	 * @param session se le envia la sesion de la base de datos
	 */

	public static void segunda(Session session) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct m.email from Moderador m where exists (from Evaluacion e where e in elements(m.evaluaciones) and e.traduccion.idioma.nombre='ingles') ");
		
		query.setFirstResult(0);
		
		List<String> moderadores = query.list();
		
		
		System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés\n");
		for (int i = 0; i < moderadores.size(); i++) {
			System.out.println("Email: " + moderadores.get(i) + "\n");
        }
		
		System.out.println("\n");
		
		tx.commit();
	}

	/**
	 * Lista los usuarios que hayan iniciado una cursada de Francés de nivel
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void tercera(Session session) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct u from Usuario u where exists (from Cursada c where c in elements(u.cursadasRealizadas) and c.curso.idioma.nombre = 'Frances' and c.curso.nivel >= 3)");
		
		
		List<Usuario> usuarios = query.list();
		
		
		System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3\n");
		
		for (Usuario u : usuarios) {
			System.out.println("Usuario: " + u.getNombre() + "\n");
		}
		System.out.println("\n");
		
		tx.commit();
	}
	
	/**
	 * Lista los moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento
	 * @param session se le envia la sesion de la base de datos
	 * @param fechaDesde se especifica la fecha desde donde comienza la busqueda
	 * @param fechaHasta se especifica la fecha hasta donde termina la busqueda
	 */

	public static void cuarta(Session session, Date fechaDesde, Date fechaHasta) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct m from Moderador m where exists (from Evaluacion e where e in elements (m.evaluaciones) and e.fecha between :fechaDesde and :fechaHasta)");
		query.setDate("fechaDesde", fechaDesde);
		query.setDate("fechaHasta", fechaHasta);

		
		List<Moderador> moderadores = query.list();
		
		
		System.out.println(
				"D. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.\n");
		
		for (Moderador m : moderadores) {
			System.out.println("Nombre: " + m.getNombre() + "\n");
		}
		System.out.println("\n");
		
		tx.commit();

	}

	/**
	 * Lista las traducciones completas del Inglés
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void quinta(Session session) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"from Traduccion t where t.idioma.nombre = 'Frances' and t.parrafo.documento.idioma.nombre = 'Ingles' and t.completa = true");

		
		List<Tarea> tareas = query.list();
		
		
		System.out.println("E. Listar traducciones completas del Inglés\n");
		System.out.println("\n");
		
		for (Tarea t : tareas) {
			System.out.println("Nombre: " + t.getDescripcion() + "\n");
		}
		System.out.println("\n");
		
		tx.commit();

	}

	/**
	 * Obtiene los emails de los usuarios con alguna cursada aprobada
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void sexta(Session session) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct u from Usuario u where exists(from Cursada c where c in elements(u.cursadasRealizadas) and not exists(from Leccion l where l in elements (c.curso.lecciones) and l not in (from Leccion l2 where exists(from Prueba p where p.puntaje >= 60 and p.leccion=l2 and p in elements(c.pruebas) and p.leccion in elements (c.curso.lecciones)))))");

		
		List<Usuario> usuarios = query.list();
		
		
		System.out.println(
				"F. Obtener los emails de los usuarios con alguna cursada aprobada\n");
		
		
		for (Usuario u : usuarios) {
			System.out.println("Usuario con cursada aprobada: " + u.getEmail() + "\n");
		}
		System.out.println("\n");
		
		tx.commit();

	}
/**
 * Obtiene el idioma que define la palabra enviada como parámetro en su diccionario
 * @param session se le envia la sesion de la base de datos
 */
	
	public static void septima(Session session, String palabra) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct d.idioma.nombre from Diccionario d join d.definiciones def where index(def) = :palabra");
		query.setString("palabra", palabra);

		query.setFirstResult(0);
		
		List<String> diccionarios = query.list();
		
		
		System.out.println("G. Obtener el idioma que define la palabra enviada como parámetro en su diccionario\n");
		for (int i = 0; i < diccionarios.size(); i++) {
			System.out.println("El idioma " + diccionarios.get(i) + " define la palabra " + palabra + "\n");
		}
		
		
		System.out.println("\n");
		
		tx.commit();

	}

	/**
	 * Obtiene los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)
	 * @param session se le envia la sesion de la base de datos
	 */
	
	public static void octava(Session session) {	
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select d.nombre from Documento d where d not in (select t.parrafo.documento from Traduccion t))");
		query.setFirstResult(0);
		
		List<String> documentos = query.list();
		
		
		System.out.println(
				"H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)\n");
		
		for (int i = 0; i < documentos.size(); i++) {
			System.out.println("El documento " + documentos.get(i) + " no tiene ninguna traducción\n");
		}
		
		System.out.println("\n");
		
		tx.commit();

	}
	
	/**
	 * Obtiene los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro
	 * @param session se le envia la sesion de la base de datos
	 */

	public static void novena(Session session, String nombreIdioma) {
		
		tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct d.nombre from Documento d where exists (from Parrafo p where (p in elements(d.parrafos)) and (p not in (select t.parrafo from Traduccion t where t.idioma.nombre = :nombreIdioma)))");
		query.setString("nombreIdioma", nombreIdioma);
		query.setFirstResult(0);
		
		List<String> documentos = query.list();
		

		System.out.println(
				"I. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro.\n");
		for (int i = 0; i < documentos.size(); i++) {
			System.out.println("El documento " + documentos.get(i) + " no está totalmente traducido.\n");
		}
		System.out.println("\n");
		
		tx.commit();

	}

}