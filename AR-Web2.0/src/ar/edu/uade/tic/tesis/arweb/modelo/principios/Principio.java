package ar.edu.uade.tic.tesis.arweb.modelo.principios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.base.Estructura;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.uade.tic.tesis.arweb.modelo.pautas.Pauta;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public abstract class Principio extends Estructura {

	private List<Pauta> pautas;

	public Principio(String numero, String nombre, String descripcion) {
		super(numero, nombre, descripcion);
		this.setPautas(new ArrayList<Pauta>());
		for (Pauta pauta : this.getPautasAAgregar())
			this.agregarPauta(pauta);
	}

	public abstract List<Pauta> getPautasAAgregar();

	private void agregarPauta(Pauta pauta) {
		this.getPautas().add(pauta);
	}

	public ResultadoEvaluacionPrincipio validarAccesibilidadPorPrincipio(Parseador parseador) {
		ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio = new ResultadoEvaluacionPrincipio(this);
		for (Pauta pauta : this.getPautas())
			resultadoEvaluacionPrincipio.agregarResultadoEvaluacionPauta(pauta.validarAccesibilidadPorPauta(parseador));
		return resultadoEvaluacionPrincipio;
	}

	public List<Pauta> getPautas() {
		return this.pautas;
	}

	public void setPautas(List<Pauta> pautas) {
		this.pautas = pautas;
	}
	
	public String getPackageClassName() {
		return this.getClass().getCanonicalName();
	}

	public String toString() {
		return this.getNumero();
	}

}