package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_1_UsoColor;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_2_ControlAudio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_3_ContrasteMinimo;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_4_VariarElTamañoDelTexto;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_5_ImagenesDeTexto;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_6_ContrasteMejorado;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_7_SonidosDeFondoDeAudioBajoOInexistente;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_8_PresentacionVisual;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_4_9_ImagenesDeTextoSinExcepcion;

public class Pauta1_4_Distinguible extends Pauta {

	public Pauta1_4_Distinguible() {
		super(
				"1.4", 
				"Distinguible.", 
				"Haga más fácil para los usuarios ver y oír el contenido, incluyendo la separación entre primer plano y fondo.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_4_1_UsoColor());
		listaCriterios.add(new Criterio1_4_2_ControlAudio());
		listaCriterios.add(new Criterio1_4_3_ContrasteMinimo());
		listaCriterios.add(new Criterio1_4_4_VariarElTamañoDelTexto());
		listaCriterios.add(new Criterio1_4_5_ImagenesDeTexto());
		listaCriterios.add(new Criterio1_4_6_ContrasteMejorado());
		listaCriterios.add(new Criterio1_4_7_SonidosDeFondoDeAudioBajoOInexistente());
		listaCriterios.add(new Criterio1_4_8_PresentacionVisual());
		listaCriterios.add(new Criterio1_4_9_ImagenesDeTextoSinExcepcion());
		return listaCriterios;
	}

}