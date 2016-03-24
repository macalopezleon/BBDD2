package bd2.model;

public class Idioma {
	private String nombre;
	private Diccionario diccionario = new Diccionario();

	public Idioma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Idioma(String nombre, Diccionario diccionario) {
		super();
		this.nombre = nombre;
		this.diccionario = diccionario;
	}

	public Idioma(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Diccionario getDiccionario() {
		return diccionario;
	}

	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.nombre.equals(((Idioma) obj).getNombre());
	}

}
