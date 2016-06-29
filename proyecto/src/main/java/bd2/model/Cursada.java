package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa las cursadas que pueden llevar a cabo los usuarios ademas de estar
 * ligada a las prubas y al curso determinado
 * 
 * @author Grupo01
 *
 */
public class Cursada {
	private long id;
	private Date inicio;
	private Curso curso;
	private Collection<Prueba> pruebas = new ArrayList<Prueba>();
	private Usuario usuario;

	public Cursada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Cursada con parametros
	 * 
	 * @param curso
	 *            Curso que se setea en curso
	 * @param inicio
	 *            Date que se setea en inicio
	 * @param usuario
	 *            Usuario que se setea en usuario, ademas asigna la cursada
	 *            a dicho usuario
	 */
	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.curso = curso;
		this.usuario = usuario;
		usuario.agregarCursada(this);
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

	/**
	 * Determina si la cursada esta finalizada o no para eso debe existir al
	 * menos una prueba aprobada para cada leccion del curso correspondiente
	 * 
	 * @return Boolean
	 */
	public Boolean finalizada() {
		for (Leccion le : this.getCurso().getLecciones()) {
			if (!this.leccionesAprobadas().contains(le)) {
				return false;
			}
		}
		return true;
	}

	public void agregarPrueba(Prueba prueba) {
		this.getPruebas().add(prueba);
	}

	/**
	 * Coleccio de las lecciones aprobadas de la cursada
	 * 
	 * @return Collection<Leccion> de las lecciones aprobadas a partir de las
	 *         pruebas registradas de la cursada
	 */
	public Collection<Leccion> leccionesAprobadas() {
		Collection<Leccion> leccionesAprobadas = new HashSet<Leccion>();
		for (Prueba prueba : this.getPruebas()) {
			if (prueba.aprobada()) {
				leccionesAprobadas.add(prueba.getLeccion());
			}
		}
		return leccionesAprobadas;
	}

	public Integer getNivel() {
		return this.getCurso().getNivel();
	}

	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
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

	public void setPruebas(Collection<Prueba> pruebas) {
		this.pruebas = pruebas;
	}

	
}
