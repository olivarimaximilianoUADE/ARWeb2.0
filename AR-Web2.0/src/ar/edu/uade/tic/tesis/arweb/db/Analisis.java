package ar.edu.uade.tic.tesis.arweb.db;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Analisis {

	private Long id;
	private String url;
	private String fechaHora;
	private String principios;
	private String nivelAccesibilidad;
	private Integer umbral;
	private Integer problemas;
	private Integer advertencias;
	private Integer noVerificados;
	private Integer accesibilidad;

	public Analisis() {
		this(0L, "", "", "", -1, -1, -1, -1, -1);
		this.setFechaHora("");
	}

	public Analisis(String url) {
		this(0L, url, "", "", -1, -1, -1, -1, -1);
	}

	public Analisis(Long id, String url, String principios, String nivelAccesibilidad, Integer umbral, Integer problemas, Integer advertencias, Integer noVerificado, Integer accesibilidad) {
		this.setId(id);
		this.setUrl(url);
		this.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		this.setPrincipios(principios);
		this.setNivelAccesibilidad(nivelAccesibilidad);
		this.setUmbral(umbral);
		this.setProblemas(problemas);
		this.setAdvertencias(advertencias);
		this.setNoVerificados(noVerificado);
		this.setAccesibilidad(accesibilidad);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getPrincipios() {
		return this.principios;
	}

	public void setPrincipios(String principios) {
		this.principios = principios;
	}

	public String getNivelAccesibilidad() {
		return this.nivelAccesibilidad;
	}

	public void setNivelAccesibilidad(String nivelAccesibilidad) {
		this.nivelAccesibilidad = nivelAccesibilidad;
	}

	public Integer getUmbral() {
		return this.umbral;
	}

	public String getUmbralString() {
		if (this.getUmbral() == -1)
			return "";
		return String.valueOf(this.getUmbral());
	}

	public void setUmbral(Integer umbral) {
		this.umbral = umbral;
	}

	public Integer getProblemas() {
		return this.problemas;
	}

	public String getProblemasString() {
		if (this.getProblemas() == -1) 
			return "";
		return String.valueOf(this.getProblemas());
	}

	public void setProblemas(Integer problemas) {
		this.problemas = problemas;
	}

	public Integer getAdvertencias() {
		return this.advertencias;
	}

	public String getAdvertenciasString() {
		if (this.getAdvertencias() == -1) 
			return "";
		return String.valueOf(this.getAdvertencias());
	}

	public void setAdvertencias(Integer advertencias) {
		this.advertencias = advertencias;
	}

	public Integer getNoVerificados() {
		return this.noVerificados;
	}

	public String getNoVerificadosString() {
		if (this.getNoVerificados() == -1) 
			return "";
		return String.valueOf(this.getNoVerificados());
	}

	public void setNoVerificados(Integer noVerificados) {
		this.noVerificados = noVerificados;
	}

	public Integer getAccesibilidad() {
		return this.accesibilidad;
	}

	public String getAccesibilidadString() {
		if (this.getAccesibilidad() == -1) 
			return "";
		return String.valueOf(this.getAccesibilidad());
	}

	public void setAccesibilidad(Integer accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

}