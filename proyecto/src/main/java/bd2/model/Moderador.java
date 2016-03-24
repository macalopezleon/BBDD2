package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.rmi.CORBA.UtilDelegate;

public class Moderador extends Usuario {
	private Collection<Idioma> idiomas = new ArrayList<Idioma>();
	private Collection<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();

	public Moderador(String email, String nombre, Date fechaDeCreacion) {
		super(email, nombre, fechaDeCreacion);
		// TODO Auto-generated constructor stub
	}

	public Collection<Idioma> getIdiomas() {
		return idiomas;
	}

	public Collection<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public int reputacion() {
		return this.evaluaciones.size();
	}

	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) {
		if (this.manejaIdioma(traduccion.getIdioma())) {
			Date fecha = new Date(Calendar.getInstance().getTime().getTime());
			Evaluacion unaEvaluacion = new Evaluacion(fecha, descripcion, true, traduccion, puntaje);
			this.evaluaciones.add(unaEvaluacion);
		}else{
			throw new RuntimeException("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}

	public Boolean manejaIdioma(Idioma idioma) {
		return this.idiomas.contains(idioma);
	}

	public void agregarIdioma(Idioma idioma) {
		this.idiomas.add(idioma);
	}

}
