package bd2.model;

import java.util.Map;

public class Diccionario {
	private Map<String, String> definiciones;
	private String edicion;
	private Idioma idioma;

	public Diccionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diccionario(Map<String, String> definiciones, String edicion, Idioma idioma) {
		super();
		this.definiciones = definiciones;
		this.edicion = edicion;
		this.idioma = idioma;
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

	public void agregarDeficion(String clave, String valor) {
		this.definiciones.put(clave, valor);
	}

	public String definicion(String clave) {
		return this.definiciones.get(clave);
	}

}
