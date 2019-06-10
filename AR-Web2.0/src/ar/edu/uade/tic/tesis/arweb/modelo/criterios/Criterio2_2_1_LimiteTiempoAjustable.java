package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG133;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG180;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG198;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG4;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR16;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR33;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR36;

public class Criterio2_2_1_LimiteTiempoAjustable extends Criterio {

	public Criterio2_2_1_LimiteTiempoAjustable() {
		super(
				"2.2.1",
				"L�mite de tiempo ajustable.",
				"Para cada l�mite de tiempo que se establece en el contenido, se cumple al menos uno de los siguientes casos: Desactivar: Al usuario se le permite desactivar el l�mite de tiempo antes de encontrarse con �l, o Ajustar: Al usuario se le permite ajustar el l�mite de tiempo antes de encontrarse con �l, hasta un rango de al menos diez veces la duraci�n por defecto o Extender: Al usuario se le avisa antes de que el l�mite expire con un margen de al menos 20 segundos y se le permite extender ese mismo l�mite por medio de alguna acci�n simple (por ejemplo, 'pulse la barra espaciadora'), y adem�s se le permite repetir la acci�n al menos diez veces, o Excepci�n de tiempo real: El l�mite de tiempo es un requisito de un evento en tiempo real (por ejemplo, una subasta), y no es posible ninguna alternativa a ese l�mite, o Excepci�n esencial: El l�mite de tiempo es esencial y su extensi�n invalidar�a la actividad, o Excepci�n de 20 horas: El l�mite de tiempo supera las 20 horas.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG133(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG198(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG180(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG4(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR16(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR33(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR36(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}