package bd2.model;

public class Evaluacion extends Tarea {
	private Integer puntaje;
	private Traduccion traduccion;

	public Evaluacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPuntaje() {
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
