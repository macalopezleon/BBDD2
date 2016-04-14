package bd2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa el diccionario con las distintas definiciones y el idioma al cual
 * hace referencia
 * 
 * @author Grupo01
 *
 */
public class Diccionario {
	private Long id;
	private Map<String, String> definiciones = new HashMap<String, String>();
	private String edicion;
	private Idioma idioma;

	public Diccionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Diccionario con parametros
	 * 
	 * @param idioma
	 *            Idioma que se setea en idioma
	 * @param edicion
	 *            String que se setea en edicion
	 */
	public Diccionario(Idioma idioma, String edicion) {
		super();
		this.edicion = edicion;
		this.idioma = idioma;
	}

	public Map<String, String> getDefiniciones() {
		return definiciones;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public void agregarDefinicion(String clave, String valor) {
		this.getDefiniciones().put(clave, valor);
	}

	public String definicion(String clave) {
		return this.getDefiniciones().get(clave);
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

	public void setDefiniciones(Map<String, String> definiciones) {
		this.definiciones = definiciones;
	}
	
	
}
