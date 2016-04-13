package bd2.model;

import java.util.Collection;

/**
 * Representa el sitio general encargado de registrar los usuarios, los
 * documentos y los cursos
 * 
 * @author Grupo01
 *
 */
public class Sitio {
	private Long id;
	private Collection<Curso> cursos;
	private Collection<Usuario> usuarios;
	private Collection<Documento> documentos;

	public Sitio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public Collection<Documento> getDocumentos() {
		return documentos;
	}

	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}

	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}

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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
