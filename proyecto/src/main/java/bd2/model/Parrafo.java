package bd2.model;

/**
 * Representa los parrafos del documento y que podran ser traducidos
 * 
 * @author Grupo01
 *
 */
public class Parrafo {
	private long id;
	private String texto;
	private Documento documento;

	public Parrafo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Parrafo con parametros
	 * 
	 * @param texto
	 *            String que se setea en texto
	 * @param documento
	 *            Documento que se setea en documento
	 */
	public Parrafo(String texto, Documento documento) {
		super();
		this.texto = texto;
		this.documento = documento;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
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
