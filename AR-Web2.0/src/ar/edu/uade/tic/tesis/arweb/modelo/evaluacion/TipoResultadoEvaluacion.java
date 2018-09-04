package ar.edu.uade.tic.tesis.arweb.modelo.evaluacion;

public enum TipoResultadoEvaluacion {

	OK (1, "(/)", "ok.png", "OK", "No se han encontrado problemas.", "No hay problemas de carácter automático."),
	ERROR (2, "(x)", "error.png", "Problemas", "Existen problemas.", "Hay problemas de carácter automático."),
	MANUAL (3, "(!)", "manual.png", "Advertencias", "Requiere revisión manual.", "Es necesario revisar manualmente."),
	IMPOSIBLE (4, "(?)", "imposible.png", "No Verificados", "Imposible realizar comprobación automática.", "Comprobación completamente manual.");

	private Integer representacionNumerica;
	private String representacionSimbolica;
	private String representacionPathImagen;
	private String representacionStringDescripcionCorta;
	private String representacionStringDescripcionLarga;
	private String representacionStringMensaje;

	private TipoResultadoEvaluacion(Integer representacionNumerica, String representacionSimbolica, String representacionPathImagen, String representacionStringDescripcionCorta, String representacionStringDescripcionLarga, String representacionStringMensaje) {
		this.setRepresentacionNumerica(representacionNumerica);
		this.setRepresentacionSimbolica(representacionSimbolica);
		this.setRepresentacionPathImagen(representacionPathImagen);
		this.setRepresentacionStringDescripcionCorta(representacionStringDescripcionCorta);
		this.setRepresentacionStringDescripcionLarga(representacionStringDescripcionLarga);
		this.setRepresentacionStringMensaje(representacionStringMensaje);
	}

	public Integer getRepresentacionNumerica() {
		return this.representacionNumerica;
	}

	public void setRepresentacionNumerica(Integer representacionNumerica) {
		this.representacionNumerica = representacionNumerica;
	}

	public String getRepresentacionSimbolica() {
		return this.representacionSimbolica;
	}

	public void setRepresentacionSimbolica(String representacionSimbolica) {
		this.representacionSimbolica = representacionSimbolica;
	}

	public String getRepresentacionPathImagen() {
		return this.representacionPathImagen;
	}

	public void setRepresentacionPathImagen(String representacionPathImagen) {
		this.representacionPathImagen = representacionPathImagen;
	}

	public String getRepresentacionStringDescripcionCorta() {
		return this.representacionStringDescripcionCorta;
	}

	public void setRepresentacionStringDescripcionCorta(String representacionStringDescripcionCorta) {
		this.representacionStringDescripcionCorta = representacionStringDescripcionCorta;
	}

	public String getRepresentacionStringDescripcionLarga() {
		return this.representacionStringDescripcionLarga;
	}

	public void setRepresentacionStringDescripcionLarga(String representacionStringDescripcionLarga) {
		this.representacionStringDescripcionLarga = representacionStringDescripcionLarga;
	}

	public String getRepresentacionStringMensaje() {
		return this.representacionStringMensaje;
	}

	public void setRepresentacionStringMensaje(String representacionStringMensaje) {
		this.representacionStringMensaje = representacionStringMensaje;
	}

}