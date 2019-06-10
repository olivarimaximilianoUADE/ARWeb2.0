package ar.edu.uade.tic.tesis.arweb.controlador;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.NivelAccesibilidad;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.uade.tic.tesis.arweb.modelo.guia.WCAG20;
import ar.edu.uade.tic.tesis.arweb.modelo.principios.Principio;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Contexto;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.ContextoClaves;

public class GestorValidacionAccesibilidad implements Runnable {

	private TipoValidacion tipoValidacion;
	private String texto;
	private String principios;

	public GestorValidacionAccesibilidad(TipoValidacion tipoValidacion, String texto, String principios) { 
		this.setTipoValidacion(tipoValidacion);
		this.setTexto(texto);
		this.setPrincipios(principios);
	}

	private void validarAccesibilidad() {
		Parseador parseador = null;
		switch(this.getTipoValidacion().getRepresentacionNumerica()) {
		case 1:	try {			
			parseador = new Parseador(new URL(this.getTexto()), NivelAccesibilidad.A, "2.0");
		} catch (MalformedURLException e) {	} 
		catch (IOException e) { } 
		break;
		case 2: try {			
			parseador = new Parseador(new File(this.getTexto()), NivelAccesibilidad.AA, "2.0");
		} catch (IOException e) {} 
		break;
		case 3:	parseador = new Parseador(this.getTexto(), NivelAccesibilidad.AAA, "2.0");
		}
		List<ResultadoEvaluacionPrincipio> resultadoValidacionGeneral = new LinkedList<ResultadoEvaluacionPrincipio>();
		for (Principio principio : new WCAG20().getPrincipios())
			if (this.getPrincipios().indexOf(principio.getNumero()) != -1)
				resultadoValidacionGeneral.add(principio.validarAccesibilidadPorPrincipio(parseador));
		Contexto.set(ContextoClaves.RESULTADOS, resultadoValidacionGeneral);
		Contexto.set(ContextoClaves.PARSEADOR, parseador);
	}

	public void run() {
		Contexto.set(ContextoClaves.RESULTADOS, null);
		this.validarAccesibilidad();
	}

	public TipoValidacion getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(TipoValidacion tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPrincipios() {
		return this.principios;
	}

	public void setPrincipios(String principios) {
		this.principios = principios;
	}

}