package ar.edu.uade.tic.tesis.arweb.servicios;

import java.util.List;

public class Resultado {
	public Detalle detalle;
	public Historico historico;
	public List<ResultadoEvaluacion> resultadoEvaluacion;
	public String codigoHTML;
	public Long analisisId;
	
	public Detalle getDetalle() {
		return detalle;
	}
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	public List<ResultadoEvaluacion> getResultadoEvaluaciono() {
		return resultadoEvaluacion;
	}
	public void setResultadoEvaluacion(List<ResultadoEvaluacion> resultadoEvaluacion) {
		this.resultadoEvaluacion = resultadoEvaluacion;
	}
	public String getCodigoHTML() {
		return codigoHTML;
	}
	public void setCodigoHTML(String codigoHTML) {
		this.codigoHTML = codigoHTML;
	}
	public Long getAnalisisId() {
		return analisisId;
	}
	public void setAnalisisId(Long analisisId) {
		this.analisisId = analisisId;
	}
	
}
