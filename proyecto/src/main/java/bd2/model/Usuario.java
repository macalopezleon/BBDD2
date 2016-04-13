package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Representa los usuarios del sitio, quienes realizaran las cursadas que crean
 * convenientes ademas podran realizar traducciones de documentos que seran
 * evaluadas por moderadores
 * 
 * @author Grupo01
 *
 */
public class Usuario {
	private Long id;
	private String email;
	private String nombre;
	private Date fechaDeCreacion;
	private Collection<Cursada> cursadasRealizadas = new ArrayList<Cursada>();
	private Collection<Traduccion> traducciones = new ArrayList<Traduccion>();

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Usuario con parametros
	 * 
	 * @param email
	 *            String que se setea en email
	 * @param nombre
	 *            String que se setea en nombre
	 * @param fechaDeCreacion
	 *            Date que se setea en fechaDeCreacion
	 */
	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Collection<Cursada> getCursadasRealizadas() {
		return cursadasRealizadas;
	}

	public Collection<Traduccion> getTraducciones() {
		return traducciones;
	}

	/**
	 * Representa el mayor nivel entre las cursadas aprobadas por el usuario
	 * 
	 * @param idioma
	 *            Idioma por el que se realizar el filtro de las cursadas
	 *            aprobadas
	 * @return int valor maximo entre los niveles de las cursadas aprobadas
	 */
	public int nivel(Idioma idioma) {
		int max = 0;
		for (Cursada cursada : this.cursadasAprobadas(idioma)) {
			if (cursada.getNivel() > max) {
				max = cursada.getNivel();
			}
		}
		return max;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	/**
	 * Coleccion de las cursadas aprobadas por el usuario
	 * 
	 * @param idioma
	 *            Idioma por el que se realiza el filtro de entre las cursadas
	 *            realizadas
	 * @return Collection<Cursada> cursadasAprobadas para dicho Idioma
	 */
	public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
		Collection<Cursada> cursadasAprobadas = new ArrayList<Cursada>();
		for (Cursada cursada : this.getCursadasRealizadas()) {
			if (cursada.getIdioma().equals(idioma) && cursada.finalizada()) {
				cursadasAprobadas.add(cursada);
			}

		}
		return cursadasAprobadas;
	}

	public void agregarCursada(Cursada cursada) {
		this.getCursadasRealizadas().add(cursada);
	}

	public void agregarTraduccion(Traduccion traduccion) {
		this.getTraducciones().add(traduccion);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
