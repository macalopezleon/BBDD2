package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Representa los documentos del sitio y que seran traducidos por los usuarios y
 * que tienen un idioma en particular
 * 
 * @author Grupo01
 *
 */
public class Documento {
	private Long id;
	private String nombre;
	private Integer complejidad;
	private Collection<Parrafo> parrafos = new ArrayList<Parrafo>();
	private Idioma idioma;

	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Documento con parametros
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 * @param complejidad
	 *            Integer que se setea en complejidad
	 * @param parrafos
	 *            Collection<Parrafo> que se setea en parrafos
	 * @param idioma
	 *            Idioma que se setea en idioma
	 */
	public Documento(String nombre, Integer complejidad, Collection<Parrafo> parrafos, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.complejidad = complejidad;
		this.parrafos = parrafos;
		this.idioma = idioma;
	}

	/**
	 * Constructor de Documento con parametros
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 * @param idioma
	 *            Idioma que se setea en idioma
	 */
	public Documento(String nombre, Idioma idioma) {
		this.nombre = nombre;
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Collection<Parrafo> getParrafos() {
		return parrafos;
	}

	public Parrafo agregarParrafo(String parrafo) {
		Parrafo unParrafo = new Parrafo(parrafo, this);
		this.getParrafos().add(unParrafo);
		return unParrafo;
	}

	public Integer getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(Integer complejidad) {
		this.complejidad = complejidad;
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
