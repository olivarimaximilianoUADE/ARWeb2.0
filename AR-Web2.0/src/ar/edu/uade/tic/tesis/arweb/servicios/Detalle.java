package ar.edu.uade.tic.tesis.arweb.servicios;

public class Detalle {
	public String recurso;
	public String fechaHora;
	public String principios;
	public int cantProblemas;
	public int cantAdvertencias;
	public int cantNoVerificados;
	public int puntos;
	
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getPrincipios() {
		return principios;
	}
	public void setPrincipios(String principios) {
		this.principios = principios;
	}
	public int getCantProblemas() {
		return cantProblemas;
	}
	public void setCantProblemas(int cantProblemas) {
		this.cantProblemas = cantProblemas;
	}
	public int getCantAdvertencias() {
		return cantAdvertencias;
	}
	public void setCantAdvertencias(int cantAdvertencias) {
		this.cantAdvertencias = cantAdvertencias;
	}
	public int getCantNoVerificados() {
		return cantNoVerificados;
	}
	public void setCantNoVerificados(int cantNoVerificados) {
		this.cantNoVerificados = cantNoVerificados;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
