package bd2.model;

import java.util.Date;

/**
 * Representa las tareas que se registran a partir de las traducciones y
 * evaluaciones que se hacen de los parrafos de los documentos
 * 
 * @author Grupo01
 *
 */
public class Tarea {
	private Long id;
	private Date fecha;
	private String descripcion;
	private Boolean completa;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Tarea con parametros
	 * 
	 * @param fecha
	 *            Date que se setea en fecha
	 * @param descripcion
	 *            String que se setea en descripcion
	 * @param completa
	 *            Boolean que se setea en completa
	 */
	public Tarea(Date fecha, String descripcion, Boolean completa) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completa = completa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getCompleta() {
		return completa;
	}

	public void completar() {
		this.completa = true;
	}

}
