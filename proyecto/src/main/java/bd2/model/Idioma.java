package bd2.model;

/**
 * Representa los idiomas del sistema en los cuales se pueden encontrar los
 * documentos, los diccionarios y las traducciones que se llevaran a cabo
 * 
 * @author Grupo01
 *
 */
public class Idioma {
	private long id;
	private String nombre;
	private Diccionario diccionario = new Diccionario();

	public Idioma() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Idioma con parametros
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 * @param diccionario
	 *            Diccionario que se setea en diccionario
	 */
	public Idioma(String nombre, Diccionario diccionario) {
		super();
		this.nombre = nombre;
		this.diccionario = diccionario;
	}

	/**
	 * Constructor de Idioma con parametro
	 * 
	 * @param nombre
	 *            String que se setea en nombre
	 */
	public Idioma(String nombre) {
		super();
		this.diccionario = new Diccionario(this, "Carouse");
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
		return this.getNombre().equals(((Idioma) obj).getNombre());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
