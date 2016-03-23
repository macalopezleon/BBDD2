package bd2.model;

import java.util.Date;

public class Tarea {
	private Date fecha;
	private String descripcion;
	private Boolean completa;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(Date fecha, String descripcion, Boolean completa) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completa = completa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getCompleta() {
		return completa;
	}

	public void completar() {
		this.completa = true;
	}

}
