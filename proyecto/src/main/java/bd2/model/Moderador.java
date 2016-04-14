package bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.rmi.CORBA.UtilDelegate;

/**
 * Representa los moderadores del sitio encargados de evaluar las traducciones
 * realizadas por los usuarios
 * 
 * @author Grupo01
 *
 */
public class Moderador extends Usuario {
	private Collection<Idioma> idiomas = new ArrayList<Idioma>();
	private Collection<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();

	public Moderador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de Moderador con parametros
	 * 
	 * @param email
	 *            String que se setea en email
	 * @param nombre
	 *            String que se setea en nombre
	 * @param fechaDeCreacion
	 *            Date que se setea en fechaDeCreacion
	 */
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

	/**
	 * Representa la cantidad de las evaluaciones realizadas conocido como
	 * Reputacion
	 * 
	 * @return int que es un size de las evaluaciones
	 */
	public int reputacion() {
		return this.getEvaluaciones().size();
	}

	/**
	 * Representa la evaluacion llevada a cabo por el moderador y el registro de
	 * la misma en caso que corresponda el idioma manejado por le moderador
	 * 
	 * @param traduccion
	 *            Traduccion que permite validar el conociemiento del idioma
	 *            por parte del moderador
	 * @param descripcion
	 *            String que se registra en la creacion de la evaluacion
	 * @param puntaje
	 *            Integer que se registra en la creacion de la evaluacion
	 */
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) {
		if (this.manejaIdioma(traduccion.getIdioma())) {
			Date fecha = new Date(Calendar.getInstance().getTime().getTime());
			Evaluacion unaEvaluacion = new Evaluacion(fecha, descripcion, true, traduccion, puntaje);
			this.getEvaluaciones().add(unaEvaluacion);
		} else {
			throw new RuntimeException("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}

	/**
	 * Representa la verificacion del manejo del idioma recibido por parte del
	 * moderador
	 * 
	 * @param idioma
	 *            Idioma que sirve de filtro
	 * @return Boolean
	 */
	public Boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}

	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}

	public void setIdiomas(Collection<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public void setEvaluaciones(Collection<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	
}
