package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Representa los cursos del sitio, que corresponder�n a distintas cursadas que
 * puede realizar el usuario est� ligado a las distintas lecciones y
 * corresponder� a un idioma en particular
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
	 * Constructor de Curso con par�metros
	 * 
	 * @param nombre
	 *            String que se setear� en nombre
	 * @param nivel
	 *            Integer que se setear� en nivel
	 * @param lecciones
	 *            Collection<Leccion> que se setear� en lecciones
	 * @param idioma
	 *            Idioma que se setear� en idioma
	 */
	public Curso(String nombre, Integer nivel, Collection<Leccion> lecciones, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.lecciones = lecciones;
		this.idioma = idioma;
	}

	/**
	 * Constructor de Curso con par�metros
	 * 
	 * @param nombre
	 *            String que se setear� en nombre
	 * @param idioma
	 *            Idioma que se setear� en idioma
	 * @param nivel
	 *            Integer que se setear� en nivel
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
