package bd2.model;

import java.util.Date;

public class Evaluacion extends Tarea {
	private Integer puntaje;
	private Traduccion traduccion;

	public Evaluacion() {
		super();
		// TODO Auto-generated constructor stub
	}

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
