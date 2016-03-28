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
		if (puntaje > 100) {
			throw new RuntimeException("No se puede usar valores mayores a 100 como puntaje de una prueba.");

		} else if (puntaje < 0) {
			throw new RuntimeException("No se puede usar valores negativos como puntaje de una prueba.");
		} else {
			this.puntaje = puntaje;
			this.leccion = leccion;
		}
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		if (puntaje > 100) {
			throw new RuntimeException("No se puede usar valores mayores a 100 como puntaje de una prueba.");

		} else if (puntaje < 0) {
			throw new RuntimeException("No se puede usar valores negativos como puntaje de una prueba.");
		} else {
			this.puntaje = puntaje;
		}
	}

	public Leccion getLeccion() {
		return leccion;
	}

	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	public Boolean aprobada() {
		return this.getPuntaje() >= 60;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getLeccion().equals(((Prueba)obj).getLeccion());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getLeccion() + " " + this.getPuntaje();
	}

}
