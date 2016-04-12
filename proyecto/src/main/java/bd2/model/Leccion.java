package bd2.model;

/**
 * Representa las lecciones que debera realizar los usuarios para la aprobacion
 * de las cursadas
 * 
 * @author Grupo01
 *
 */
public class Leccion {
	private Long id;
	private String nombre;

	public Leccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Leccion con parametro
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 */
	public Leccion(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getNombre().equals(((Leccion) obj).getNombre());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

}
