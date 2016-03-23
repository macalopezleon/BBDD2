package bd2.model;

import java.util.Collection;

public class Curso {
	private String nombre;
	private Integer nivel;
	private Collection<Leccion> lecciones;
	private Idioma idioma;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String nombre, Integer nivel, Collection<Leccion> lecciones, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.lecciones = lecciones;
		this.idioma = idioma;
	}

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
		this.lecciones.add(leccion);
	}

}
