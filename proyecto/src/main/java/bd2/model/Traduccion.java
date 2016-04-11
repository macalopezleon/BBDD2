package bd2.model;

import java.util.Date;

/**
 * Representa las traducciones de los parrafos realizadas por los usuarios y que
 * generan tareas para luegos ser evaluadas por los moderadores
 * 
 * @author Grupo01
 *
 */
public class Traduccion extends Tarea {
	private String texto;
	private Idioma idioma;
	private Parrafo parrafo;

	public Traduccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Traduccion con parametros
	 * 
	 * @param fecha
	 *            Date que se setea en fecha>Tarea
	 * @param descripcion
	 *            String que se setea en descripcion>Tarea
	 * @param completa
	 *            Boolean que se setea en completa>Tarea
	 * @param texto
	 *            String que se setea en texto
	 * @param parrafo
	 *            Parrafo que se setea en parrafo
	 * @param idioma
	 *            Idioma que se setea en idioma
	 */
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

	/**
	 * Informa cual es el idioma original del documento que se esta traduciendo
	 * 
	 * @return Idioma
	 */
	public Idioma getIdiomaOriginal() {
		return this.getParrafo().getDocumento().getIdioma();
	}

}
