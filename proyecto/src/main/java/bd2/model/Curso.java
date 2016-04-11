package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Representa los cursos del sitio, que corresponder a distintas cursadas que
 * puede realizar el usuario esta ligado a las distintas lecciones y
 * corresponde a un idioma en particular
 * 
 * @author Grupo01
 *
 */
public class Curso {
	private String nombre;
	private Integer nivel;
	private Collection<Leccion> lecciones = new ArrayList<Leccion>();
	private Idioma idioma;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Curso con parametros
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 * @param nivel
	 *            Integer que se setea en nivel
	 * @param lecciones
	 *            Collection<Leccion> que se setea en lecciones
	 * @param idioma
	 *            Idioma que se setea en idioma
	 */
	public Curso(String nombre, Integer nivel, Collection<Leccion> lecciones, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.lecciones = lecciones;
		this.idioma = idioma;
	}

	/**
	 * Constructor de Curso con parametros
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 * @param idioma
	 *            Idioma que se setea en idioma
	 * @param nivel
	 *            Integer que se setea en nivel
	 */
	public Curso(String nombre, Idioma idioma, Integer nivel) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Collection<Leccion> getLecciones() {
		return lecciones;
	}

	public void agregarLeccion(Leccion leccion) {
		this.getLecciones().add(leccion);
	}

}
