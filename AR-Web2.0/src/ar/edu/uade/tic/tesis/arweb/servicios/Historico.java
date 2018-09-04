package ar.edu.uade.tic.tesis.arweb.servicios;

public class Historico {
	public Long id;
	public String recurso;
	public String fechaHora;
	public String principios;
	public String cantProblemas;
	public String cantAdvertencias;
	public String cantNoVerificados;
	public String puntos;
	public String pautas;
	public String nivelAccesibilidad;
	public String tecnologias;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getCantProblemas() {
		return cantProblemas;
	}
	public void setCantProblemas(String cantProblemas) {
		this.cantProblemas = cantProblemas;
	}
	public String getCantAdvertencias() {
		return cantAdvertencias;
	}
	public void setCantAdvertencias(String cantAdvertencias) {
		this.cantAdvertencias = cantAdvertencias;
	}
	public String getCantNoVerificados() {
		return cantNoVerificados;
	}
	public void setCantNoVerificados(String cantNoVerificados) {
		this.cantNoVerificados = cantNoVerificados;
	}
	public String getPuntos() {
		return puntos;
	}
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}
	public String getPautas() {
		return pautas;
	}
	public void setPautas(String pautas) {
		this.pautas = pautas;
	}
	public String getNivelAccesibilidad() {
		return nivelAccesibilidad;
	}
	public void setNivelAccesibilidad(String nivelAccesibilidad) {
		this.nivelAccesibilidad = nivelAccesibilidad;
	}
	public String getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}
}
