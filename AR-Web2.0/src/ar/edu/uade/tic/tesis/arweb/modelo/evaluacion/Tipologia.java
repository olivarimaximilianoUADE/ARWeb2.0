package ar.edu.uade.tic.tesis.arweb.modelo.evaluacion;

public enum Tipologia {

	NO_DEFINIDA(0, "No Definida"), 
	IMAGENES(1, "Im�genes"), 
	FORMULARIOS(2, "Formularios"), 
	ESTRUCTURA_Y_SEMANTICA(3, "Sem�ntica"), 
	PRESENTACION(4, "Presentaci�n"), 
	PAGINA_WEB(5, "P�gina web"), 
	NAVEGACION(6, "Navegaci�n"), 
	SCRIPTS(7, "Scripts"), 
	APPLETS(8, "Applets"), 
	TABLAS(9, "Tablas"), 
	LISTAS(10, "Listas");

	private Integer representacionNumerica;
	private String representacionString;

	private Tipologia(Integer representacionNumerica, String representacionString) {
		this.setRepresentacionNumerica(representacionNumerica);
		this.setRepresentacionString(representacionString);
	}

	public Integer getRepresentacionNumerica() {
		return this.representacionNumerica;
	}

	public void setRepresentacionNumerica(Integer representacionNumerica) {
		this.representacionNumerica = representacionNumerica;
	}

	public String getRepresentacionString() {
		return this.representacionString;
	}

	public void setRepresentacionString(String representacionString) {
		this.representacionString = representacionString;
	}

}