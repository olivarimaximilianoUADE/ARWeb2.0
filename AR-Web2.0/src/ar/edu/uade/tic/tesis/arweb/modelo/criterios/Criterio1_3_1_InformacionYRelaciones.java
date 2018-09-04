package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC22;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG115;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG117;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG138;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG140;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG141;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG162;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH39;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH42;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH43;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH44;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH48;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH49;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH51;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH63;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH65;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH71;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH73;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH85;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH97;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR21;

public class Criterio1_3_1_InformacionYRelaciones extends Criterio {
	
	public Criterio1_3_1_InformacionYRelaciones() {
		super(
			"1.3.1",
			"Informaci�n y relaciones.",
			"La informaci�n, la estructura y las relaciones transmitidas a trav�s de la presentaci�n pueden ser programablemente determinadas o se encuentran disponibles en texto.",
			NivelAccesibilidad.A);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG115(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG117(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG140(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG138(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG162(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaG141(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH49(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH51(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH39(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH73(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH63(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH43(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH71(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH85(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH48(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH42(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH97(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR21(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC22(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}
