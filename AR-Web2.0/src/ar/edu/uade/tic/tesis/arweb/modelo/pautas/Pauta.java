package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.base.Estructura;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public abstract class Pauta extends Estructura {

	private List<Criterio> criterios;

	public Pauta(String numero, String nombre, String descripcion) {
		super(numero, nombre, descripcion);
		this.setCriterios(new LinkedList<Criterio>());
		for (Criterio criterio : this.getCriteriosAAgregar())
			this.agregarCriterio(criterio);
	}

	public abstract List<Criterio> getCriteriosAAgregar();

	private void agregarCriterio(Criterio criterio) {
		this.getCriterios().add(criterio);
	}

	public ResultadoEvaluacionPauta validarAccesibilidadPorPauta(Parseador parseador) {
		ResultadoEvaluacionPauta resultadoEvaluacionPauta = new ResultadoEvaluacionPauta(this);
		for (Criterio criterio : this.getCriterios()) {
			int criterioNivel = criterio.getNivelAccesibilidad().getValueName();
			int parseadorNivel = parseador.getNivelAccesibilidad().getValueRepresentacion(); 
			if(criterioNivel <= parseadorNivel)
				resultadoEvaluacionPauta.agregarResultadoEvaluacionCriterio(criterio.validarAccesibilidadPorCriterio(parseador));
		}
		return resultadoEvaluacionPauta;
	}

	public List<Criterio> getCriterios() {
		return this.criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public String getPackageClassName() {
		return this.getClass().getCanonicalName();
	}
	
	public String toString() {
		return this.getNumero();
	}

}