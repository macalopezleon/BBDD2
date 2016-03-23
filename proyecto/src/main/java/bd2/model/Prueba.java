package bd2.model;

public class Prueba {
	private Integer puntaje;
	private Leccion leccion;

	public Prueba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prueba(Leccion leccion, Integer puntaje) {
		super();
		this.puntaje = puntaje;
		this.leccion = leccion;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Leccion getLeccion() {
		return leccion;
	}

	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	public Boolean aprobada() {
		return this.puntaje >= 60;
	}

}
