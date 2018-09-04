package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC18;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC9;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG100;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG143;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG144;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG196;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG68;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG73;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG74;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG82;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG92;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG94;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG95;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH2;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH24;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH30;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH35;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH36;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH37;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH44;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH45;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH46;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH53;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH65;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH67;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH86;

public class Criterio1_1_1_ContenidoNoTextual extends Criterio {

	public Criterio1_1_1_ContenidoNoTextual() {
		super(
				"1.1.1",
				"Contenido no textual.",
				"Todo contenido no textual que se presenta al usuario cuenta con una alternativa textual que sirve para un propósito equivalente.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG94(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG196(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG95(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG73(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG74(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG92(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG82(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG68(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG100(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG143(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG144(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH2(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH24(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH35(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH37(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH53(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH86(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH45(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH36(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH67(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH46(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC9(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC18(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}