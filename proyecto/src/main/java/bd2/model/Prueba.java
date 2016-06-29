package bd2.model;

/**
 * Representa las pruebas que llevaran a cabo los usuarios a lo largo de la
 * cursada
 * 
 * @author Grupo01
 *
 */
public class Prueba {
	private long id;
	private Integer puntaje;
	private Leccion leccion;

	public Prueba() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Prueba con parametros se setear siempre y cuando los
	 * valores de puntaje este entre 0 y 100
	 * 
	 * @param leccion
	 *            Leccion que se setea en leccion
	 * @param puntaje
	 *            Integer que se setea en puntaje
	 */
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

	/**
	 * Representa la verificacion de aprobacion de la prueba, dada en caso que
	 * el puntaje iguale o supere los 60
	 * 
	 * @return Boolean
	 */
	public Boolean aprobada() {
		return this.getPuntaje() >= 60;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getLeccion().equals(((Prueba) obj).getLeccion())
				&& this.getPuntaje() == (((Prueba) obj).getPuntaje());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getLeccion() + " " + this.getPuntaje();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
