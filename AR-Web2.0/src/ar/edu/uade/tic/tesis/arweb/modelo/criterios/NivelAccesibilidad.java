package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

public enum NivelAccesibilidad {
	A ("A"),
	AA ("AA"),
	AAA ("AAA");

	private String representacion;

	private NivelAccesibilidad(String representacion) {
		this.setRepresentacion(representacion);
	}

	public String getRepresentacion() {
		return this.representacion;
	}

	public void setRepresentacion(String representacion) {
		this.representacion = representacion;
	}
	
	public int getValueName() {
		switch(this.name()) {
		case "A":
			return 1;			
		case "AA":
			return 2;
		case "AAA":
			return 3;
		}
		return 0;
	}
	
	public int getValueRepresentacion() {
		switch(this.getRepresentacion()) {
		case "A":
			return 1;			
		case "AA":
			return 2;
		case "AAA":
			return 3;
		}
		return 0;
	}
}