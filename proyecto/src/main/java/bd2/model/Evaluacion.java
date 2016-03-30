package bd2.model;

import java.util.Date;

/**
 * Representa las evaluaciones realizadas por los moderadores de las tareas
 * generadas por las traducciones de los párrafos de los documentos
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
	 * Constructor de Evaluacion con parámetros
	 * 
	 * @param fecha
	 *            Date que se seteará en fecha
	 * @param descripcion
	 *            String que se seteará en descripcion
	 * @param completa
	 *            Boolean que se seteará en completa
	 * @param traduccion
	 *            Traduccion que se seteará en traduccion
	 * @param puntaje
	 *            Integer que se seteará en puntaje
	 */
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, Integer puntaje) {
		super();
		this.puntaje = puntaje;
		this.traduccion = traduccion;
		super.setDescripcion(descripcion);
		if (completa) {
			super.completar();
		}
		super.setFecha(fecha);
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
