package bd2.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.Documento;

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
/*
        segunda(session);
        
        tercera(session);
        
        cuarta(session);
        
        quinta(session);
        
        sexta(session);
        
        septima(session);
        
        octaba(session);
*/
    }

    public static void primera(Session session) {
        // a)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("from Documento");

        List<Documento> documentos = query.list();
        System.out.println("A.     Listar los nombres de todos los documentos\n");
        for (Documento d : documentos) {
            System.out.println("Documento: " + d.getNombre() + "\n");
        }

        tx.commit();
    }

    public static void segunda(Session session) {
        // b)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("from Tarea t where t.descripcion like :busqueda");
        query.setParameter("busqueda", "%news%");

        System.out.println("Listar las tareas cuya descripción contenga una secuencia específica de caracteres (enviada como parámetro). Imprimir en consola: \"Tarea: < descripción > \" \n");
        List<Tarea> tareas = query.list();
        for (Tarea t : tareas) {
            System.out.println("Tarea: " + t.getDescripcion() + "\n");
        }

        tx.commit();
    }

    public static void tercera(Session session) {
        // c)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("select new list(p.nombre, size(p.tareas) as CantidadTareas) from Pizarra p group by p.id order by CantidadTareas DESC");
        query.setFirstResult(0);
        query.setMaxResults(1);

        List<List> listaResultados = query.list();
        System.out.println("c.Obtener la Pizarra que tenga más tareas. Imprimir	\"Pizarra con más tareas: <nombre> (<cantidad de tareas> tareas)");
        System.out.println("\n");
        for (int i = 0; i < listaResultados.size(); i++) {
            System.out.println("Pizarra con más tareas: " + listaResultados.get(i).get(0) + " (" + listaResultados.get(i).get(1) + " tareas)\n");
        }

        tx.commit();
    }

    public static void cuarta(Session session) {
        // d)
        tx = session.beginTransaction();
        //tx.setTimeout(10); 
        Query query = session.createQuery("select p from Proyecto p join p.pizarrasArchivadas");

        List<Proyecto> proy = query.list();
        System.out.println("Obtener los emails de los administradores de los proyectos que tengan al menos una pizarra archivada. Imprimir “Administrador: <email>”");
        for (Proyecto p : proy) {
            for (PerfilDeUsuario u : p.getPerfiles()) {
                if (u.esAdministrador()) {
                    System.out.println("Administrador: " + u.getUsuario().getEmail() + "\n");
                }
            }
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