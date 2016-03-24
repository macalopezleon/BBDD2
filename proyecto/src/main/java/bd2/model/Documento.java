package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

public class Documento {
	private String nombre;
	private Integer complejidad;
	private Collection<Parrafo> parrafos = new ArrayList<Parrafo>();
	private Idioma idioma;

	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documento(String nombre, Integer complejidad, Collection<Parrafo> parrafos, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.complejidad = complejidad;
		this.parrafos = parrafos;
		this.idioma = idioma;
	}

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
		this.parrafos.add(unParrafo);
		return unParrafo;
	}

}
