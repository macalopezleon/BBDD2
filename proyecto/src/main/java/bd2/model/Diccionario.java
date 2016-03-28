package bd2.model;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {
	private Map<String, String> definiciones = new HashMap<String, String>();
	private String edicion;
	private Idioma idioma;

	public Diccionario() {
		super();
		// TODO Auto-generated constructor stub
	}

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

}
