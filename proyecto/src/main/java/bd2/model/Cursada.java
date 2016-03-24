package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Cursada {
	private Date inicio;
	private Curso curso;
	private Collection<Prueba> pruebas = new ArrayList<Prueba>();
	private Usuario usuario;

	public Cursada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.curso = curso;
		this.usuario = usuario;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Prueba> getPruebas() {
		return pruebas;
	}

	public Boolean finalizada() {
		return this.curso.getLecciones().contains(this.leccionesAprobadas());
	}

	public void agregarPrueba(Prueba prueba) {
		this.pruebas.add(prueba);
	}

	public Collection<Leccion> leccionesAprobadas() {
		Collection<Leccion> leccionesAprobadas = new HashSet<Leccion>();
		for (Prueba prueba : pruebas) {
			if (prueba.aprobada()) {
				leccionesAprobadas.add(prueba.getLeccion());
			}
		}
		return leccionesAprobadas;
	}

	public Integer getNivel() {
		return this.curso.getNivel();
	}

	public Idioma getIdioma() {
		return this.curso.getIdioma();
	}

}
