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

		cuarta(session);

		quinta(session);

		sexta(session);

		septima(session);

		octava(session);

		novena(session);
		
		

		session.close();

	}

	public static void primera(Session session) {
		// a)
		//tx = session.beginTransaction();

		Query query = session.createQuery("from Documento");

		List<Documento> documentos = query.list();
		System.out.println("A. Listar los nombres de todos los documentos\n");
		for (Documento d : documentos) {
			System.out.println("Documento: " + d.getNombre() + "\n");
		}
		System.out.println("\n");

		//tx.commit();
	}

	public static void segunda(Session session) {
		// b)
		//tx = session.beginTransaction();

		Query query = session.createQuery(
				"select distinct m from Moderador m join m.evaluaciones e where e.traduccion.idioma.nombre = 'ingles'");

		List<Moderador> moderadores = query.list();
		System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés\n");
		for (Moderador m : moderadores) {
			System.out.println("Email: " + m.getEmail() + "\n");
		}

		System.out.println("\n");
		//tx.commit();
	}

	public static void tercera(Session session) {
		// c)
		//tx = session.beginTransaction();

		Query query = session.createQuery(
				"select distinct u from Usuario u join u.cursadasRealizadas c where c.curso.idioma.nombre = 'Frances' and c.curso.nivel >= 3");
		// query.setParameter("busqueda", "%news%");

		System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3\n");
		List<Usuario> usuarios = query.list();
		for (Usuario u : usuarios) {
			System.out.println("Usuario: " + u.getNombre() + "\n");
		}
		System.out.println("\n");

		//tx.commit();
	}

	public static void cuarta(Session session) {
		// d)
		//tx = session.beginTransaction();

		Query query = session.createQuery(
				"select distinct m from Moderador m join m.evaluaciones e where (e.traduccion.fecha between :fechaDesde and :fechaHasta)");
		query.setString("fechaDesde", "2015-07-01");
		query.setString("fechaHasta", "2015-12-31");

		System.out.println(
				"D. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.\n");
		List<Moderador> moderadores = query.list();
		for (Moderador m : moderadores) {
			System.out.println("Nombre: " + m.getNombre() + "\n");
		}
		System.out.println("\n");

		//tx.commit();
	}

	public static void quinta(Session session) {
		// e)
		//tx = session.beginTransaction();
		// tx.setTimeout(10);
		Query query = session.createQuery(
				"from Traduccion t where t.idioma.nombre = 'Frances' and t.parrafo.documento.idioma.nombre = 'Ingles'");

		System.out.println("E. Listar traducciones completas del Inglés\n");
		System.out.println("\n");
		List<Tarea> tareas = query.list();
		for (Tarea t : tareas) {
			System.out.println("Nombre: " + t.getDescripcion() + "\n");
		}
		System.out.println("\n");

		//tx.commit();
	}

	public static void sexta(Session session) {
		// f)
		//tx = session.beginTransaction();
		Query query = session.createQuery(
				"select distinct u from Usuario u join u.cursadasRealizadas cr");

		System.out.println(
				"F. Obtener los emails de los usuarios con alguna cursada aprobada\n");
		
		List<Usuario> usuarios = query.list();
		for (Usuario u : usuarios) {
			System.out.println("Usuario con cursada aprobada: " + u.getEmail() + "\n");
		}
		System.out.println("\n");
		
		//tx.commit();

	}

	public static void septima(Session session) {
		// g)
		//tx = session.beginTransaction();
		String palabra = "Leuchtturm";
		Query query = session.createQuery(
				"select distinct d from Diccionario d join d.definiciones def where index(def) = :palabra");
		query.setString("palabra", palabra);

		System.out.println("G. Obtener el idioma que define la palabra enviada como parámetro en su diccionario\n");
		List<Diccionario> diccionarios = query.list();
		for (Diccionario d : diccionarios) {
			System.out.println("El idioma " + d.getIdioma().getNombre() + " define la palabra " + palabra + "\n");
		}
		System.out.println("\n");

		//tx.commit();
	}

	public static void octava(Session session) {
		// h)
		//tx = session.beginTransaction();
		
		Query query = session.createQuery(
				"from Documento d where d not in (select doc from Documento doc join doc.parrafos p where p in (select t.parrafo from Traduccion t))");

		System.out.println(
				"H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)\n");
		
		List<Documento> documentos = query.list();
		for (Documento d : documentos) {
			System.out.println("El documento " + d.getNombre() + " no tiene ninguna traducción\n");
		}
		System.out.println("\n");
		
		//tx.commit();
	}

	public static void novena(Session session) {
		// i)
		//tx = session.beginTransaction();

		String nombreIdioma = "Aleman";

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

		//tx.commit();
	}

}