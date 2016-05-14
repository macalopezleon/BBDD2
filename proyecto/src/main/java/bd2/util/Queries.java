package bd2.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        /* 
        quinta(session);
        
        sexta(session);
        
        septima(session);
        
        octaba(session);
*/
    }

    public static void primera(Session session) {
        // a)
        tx = session.beginTransaction();

        Query query = session.createQuery("from Documento");

        List<Documento> documentos = query.list();
        System.out.println("A.     Listar los nombres de todos los documentos\n");
        for (Documento d : documentos) {
            System.out.println("Documento: " + d.getNombre() + "\n");
        }

        tx.commit();
    }

    public static void segunda(Session session) {
        // c)
        tx = session.beginTransaction();

        Query query = session.createQuery("select u from Usuario u join u.cursadasRealizadas c where c.curso.idioma.nombre = 'Frances' and c.curso.nivel >= 3");
        //query.setParameter("busqueda", "%news%");

        System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3");
        List<Usuario> usuarios = query.list();
        for (Usuario u : usuarios) {
            System.out.println("Usuario: " + u.getNombre() + "\n");
        }

        tx.commit();
    }

    public static void tercera(Session session) {
        // e)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("from Traduccion t where t.idioma.nombre = 'Frances' and t.parrafo.documento.idioma.nombre = 'Ingles'");

        System.out.println("E. Listar traducciones completas del Inglés");
        System.out.println("\n");
        List<Tarea> tareas = query.list();
        for (Tarea t : tareas) {
            System.out.println("Nombre: " + t.getDescripcion() + "\n");
        }

        tx.commit();
    }

    public static void cuarta(Session session) {
        // b)
        tx = session.beginTransaction();

        Query query = session.createQuery("select m from Moderador m join m.evaluaciones e where e.traduccion.idioma.nombre = 'ingles'");

        List<Moderador> moderadores = query.list();
        System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés");
        for (Moderador m : moderadores) {
            System.out.println("Moderador: " + m.getEmail() + "\n");
        }

        tx.commit();
    }

    public static void quinta(Session session) {
        // e)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("select t from Tarea t join t.pasos p where p.pizarra.nombre like :busqueda");
        query.setParameter("busqueda", "%backlogproyecto8149%");

        System.out.println("Obtener las tareas que hayan pasado por la pizarra cuyo nombre contenga una secuencia de caracteres enviada como parámetro. Imprimir “Tarea: <descripción>”");
        List<Tarea> tar = query.list();
        for (Tarea t : tar) {
            System.out.println("Tarea: " + t.getDescripcion() + "\n");
        }

        tx.commit();
    }

    public static void sexta(Session session) {
        // f)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("select new list(t.descripcion,count(p.id) as CantidadPasos) from Tarea t join t.pasos p group by t having count(p) > :cant");
        query.setFirstResult(0);
        query.setParameter("cant", new Long(2));

        List<List> listaResultadosF = query.list();
        System.out.println("f.Obtener las tareas que hayan sido cambiadas de pizarras mas de un numero veces enviado como parametro. Imprimir	\"Tarea: <descripcion> (<cantidad de pasos> pasos)");
        System.out.println("\n");
        for (int i = 0; i < listaResultadosF.size(); i++) {
            System.out.println("Tarea: " + listaResultadosF.get(i).get(0) + " (" + listaResultadosF.get(i).get(1) + " pasos)\n");
        }

        tx.commit();
    }

    public static void septima(Session session) {
        // g)
        tx = session.beginTransaction();
        //tx.setTimeout(10); exists(select t from p.tareas t where t.class = TareaDeInvestigacion) AND exists(select t2 from p.tareas t2 where t2.class = TareaDeDesarrollo)
        Query query = session.createQuery("from Pizarra p where exists (from TareaDeInvestigacion ti where ti in (from p.tareas)) AND exists (from TareaDeDesarrollo td where td in (from p.tareas))");

        List<Pizarra> piz = query.list();
        System.out.println("Obtener las pizarras que tengan tareas tanto de investigación como de desarrollo. Imprimir Pizarra: <nombre> \n");
        for (Pizarra p : piz) {
            System.out.println("Pizarra: " + p.getNombre() + "\n");
        }

        tx.commit();
    }

    public static void octaba(Session session) {
        // h)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("SELECT p from Pizarra p join p.tareas t WHERE (t.fechaLimite between '2015-03-01 00:00' and '2015-04-01 00:00') and t.completa = false");

        List<Pizarra> pizarrasH = query.list();
        System.out.println("Obtener las pizarras que tengan tareas vencidas en marzo, es decir que sus fechas límite estén dentro marzo de 2015 y no estén completas. Imprimir “Pizarra: <nombre>” \n");
        for (Pizarra p : pizarrasH) {
            System.out.println("Pizarra: " + p.getNombre() + "\n");
        }

        tx.commit();

        session.close();
    }
}