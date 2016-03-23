package bd2.model;

import java.util.Collection;

public class Sitio {
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
		this.usuarios.add(usuario);
	}

	public void agregarCurso(Curso curso) {
		this.cursos.add(curso);
	}

	public void agregarDocumento(Documento documento) {
		this.documentos.add(documento);
	}

}
