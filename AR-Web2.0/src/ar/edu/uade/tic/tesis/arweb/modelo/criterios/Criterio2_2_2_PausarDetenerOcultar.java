package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG11;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG152;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG186;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG187;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG191;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG4;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR22;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR33;

public class Criterio2_2_2_PausarDetenerOcultar extends Criterio {

	public Criterio2_2_2_PausarDetenerOcultar() {
		super(
				"2.2.2",
				"Pausar, detener, ocultar.",
				"Para cualquier informaci�n que se mueva, parpadee, se desplace o se actualice autom�ticamente, se cumplen todos los puntos siguientes: Movimiento, parpadeo, desplazamiento: Para cualquier informaci�n que se mueva, parpadee o se desplace, y que (1) comience autom�ticamente, (2) dure m�s de cinco segundos, y (3) se presente paralelamente a otro contenido, existe un mecanismo que permite al usuario pausar, detener u ocultar la informaci�n, a menos que ese movimiento, parpadeo o desplazamiento sea esencial para la actividad, y Actualizaci�n autom�tica: Para cualquier informaci�n que (1) comience autom�ticamente y (2) se presente paralelamente a otro contenido, existe un mecanismo que permite al usuario pausar, detener u ocultar la informaci�n, o controlar la frecuencia de la actualizaci�n, a menos que la actualizaci�n autom�tica sea esencial para la actividad.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG4(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG11(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG187(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG152(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG186(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG191(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR22(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR33(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}