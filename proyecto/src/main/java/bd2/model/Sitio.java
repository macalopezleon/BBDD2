package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Representa el sitio general encargado de registrar los usuarios, los
 * documentos y los cursos
 * 
 * @author Grupo01
 *
 */
public class Sitio {
	private long id;
	private Collection<Curso> cursos = new HashSet<Curso>();
	private Collection<Usuario> usuarios = new HashSet<Usuario>();
	private Collection<Documento> documentos = new HashSet<Documento>();

	public Sitio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return Devuelve el curso
	 */
	public Collection<Curso> getCursos() {
		return cursos;
	}

	/**
	 * 
	 * @return Devuelve los usuarios
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * 
	 * @return Devuelve los documentos
	 */
	public Collection<Documento> getDocumentos() {
		return documentos;
	}

	/**
	 * 
	 * @param usuario
	 *            Recibe un usuario y lo agrega a la coleccion
	 */
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}

	/**
	 * 
	 * @param curso
	 *            Agrega un curso a la coleccion
	 */

	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}

	/**
	 * 
	 * @param documento
	 *            Agrega un documento a la coleccion
	 */
	public void agregarDocumento(Documento documento) {
		this.getDocumentos().add(documento);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setDocumentos(Collection<Documento> documentos) {
		this.documentos = documentos;
	}

}
