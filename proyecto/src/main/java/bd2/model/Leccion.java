package bd2.model;

public class Leccion {
	private String nombre;

	public Leccion() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		return this.getNombre().equals(((Leccion)obj).getNombre());
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

}
