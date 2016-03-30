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
	 * Constructor de Traduccion con parámetros
	 * 
	 * @param fecha
	 *            Date que se seteará en fecha>Tarea
	 * @param descripcion
	 *            String que se seteará en descripcion>Tarea
	 * @param completa
	 *            Boolean que se seteará en completa>Tarea
	 * @param texto
	 *            String que se seteará en texto
	 * @param parrafo
	 *            Parrafo que se seteará en parrafo
	 * @param idioma
	 *            Idioma que se seteará en idioma
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
	 * Informa cual es el idioma original del documento que se está traduciendo
	 * 
	 * @return Idioma
	 */
	public Idioma getIdiomaOriginal() {
		return this.getParrafo().getDocumento().getIdioma();
	}

}
