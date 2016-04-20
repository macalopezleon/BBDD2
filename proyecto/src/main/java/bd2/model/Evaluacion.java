package bd2.model;

import java.util.Date;

/**
 * Representa las evaluaciones realizadas por los moderadores de las tareas
 * generadas por las traducciones de los parrafos de los documentos
 * 
 * @author Grupo01
 *
 */
public class Evaluacion extends Tarea {
	private Integer puntaje;
	private Traduccion traduccion;

	public Evaluacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Evaluacion con parametros
	 * 
	 * @param fecha
	 *            Date que se setea en fecha
	 * @param descripcion
	 *            String que se setea en descripcion
	 * @param completa
	 *            Boolean que se setea en completa
	 * @param traduccion
	 *            Traduccion que se setea en traduccion
	 * @param puntaje
	 *            Integer que se setea en puntaje
	 */
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, Integer puntaje) {
		super();
		this.puntaje = puntaje;
		this.traduccion = traduccion;
		super.setDescripcion(descripcion);
		if (completa) {
			this.completar();
		}
		this.setFecha(fecha);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Traduccion getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(Traduccion traduccion) {
		this.traduccion = traduccion;
	}
	
	

}
