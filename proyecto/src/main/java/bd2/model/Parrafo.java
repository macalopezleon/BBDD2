package bd2.model;

/**
 * Representa los parrafos del documento y que podran ser traducidos
 * 
 * @author Grupo01
 *
 */
public class Parrafo {
	private String texto;
	private Documento documento;

	public Parrafo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de Parrafo con par�metros
	 * 
	 * @param texto
	 *            String que se setear� en texto
	 * @param documento
	 *            Documento que se setear� en documento
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

}
