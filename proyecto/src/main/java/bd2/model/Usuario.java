package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
	private String email;
	private String nombre;
	private Date fechaDeCreacion;
	private Collection<Cursada> cursadasRealizadas = new ArrayList<Cursada>();
	private Collection<Traduccion> traducciones = new ArrayList<Traduccion>();

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Collection<Cursada> getCursadasRealizadas() {
		return cursadasRealizadas;
	}

	public Collection<Traduccion> getTraducciones() {
		return traducciones;
	}

	public int nivel(Idioma idioma) {
		int max = 0;
		for (Cursada cursada : this.cursadasAprobadas(idioma)) {
			if (cursada.getNivel() > max) {
				max = cursada.getNivel();
			}
		}
		// return this.cursadasAprobadas(idioma).size();
		return max;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
		Collection<Cursada> cursadasAprobadas = new ArrayList<Cursada>();
		for (Cursada cursada : this.getCursadasRealizadas()) {
			if (cursada.getIdioma().equals(idioma) && cursada.finalizada()) {
				cursadasAprobadas.add(cursada);
			}

		}
		return cursadasAprobadas;
	}

	public void agregarCursada(Cursada cursada) {
		this.getCursadasRealizadas().add(cursada);
	}

	public void agregarTraduccion(Traduccion traduccion) {
		this.getTraducciones().add(traduccion);
	}

}
