package bd2.model;

import java.util.Date;

public class Traduccion extends Tarea {
	private String texto;
	private Idioma idioma;
	private Parrafo parrafo;

	public Traduccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma) {
		super(fecha, descripcion, completa);
		this.idioma = idioma;
		this.parrafo = parrafo;
		this.texto = texto;
		// TODO Auto-generated constructor stub
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Parrafo getParrafo() {
		return parrafo;
	}

	public String getTexto() {
		return texto;
	}

	public Idioma getIdiomaOriginal() {
		return this.parrafo.getDocumento().getIdioma();
	}

}
