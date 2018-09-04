package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC12;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC13;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC14;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC19;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC20;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC21;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC23;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC24;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC25;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG146;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG148;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG156;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG169;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG172;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG175;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG188;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG204;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG206;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR34;

public class Criterio1_4_8_PresentacionVisual extends Criterio {

public Criterio1_4_8_PresentacionVisual() {
	super(
			"1.4.8",
			"Presentación Visual.",
			"En la presentación visual de bloques de texto, se proporciona algún mecanismo para lograr lo siguiente:" + 
			"\r\n" + 
			"1. Los colores de fondo y primer plano pueden ser elegidos por el usuario.\r\n" + 
			"\r\n" + 
			"2. El ancho no es mayor de 80 caracteres o signos (40 si es CJK).\r\n" + 
			"\r\n" + 
			"3. El texto no está justificado (alineado a los márgenes izquierdo y derecho a la vez).\r\n" + 
			"\r\n" + 
			"4. El espacio entre líneas (interlineado) es de, al menos, un espacio y medio dentro de los párrafos y el espacio entre párrafos es, al menos, 1.5 veces mayor que el espacio entre líneas.\r\n" + 
			"\r\n" + 
			"5. El texto se ajusta sin ayudas técnicas hasta un 200 por ciento de modo tal que no requiere un desplazamiento horizontal para leer una línea de texto en una ventana a pantalla completa.",
			NivelAccesibilidad.AAA);
}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaC12(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC13(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC14(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC19(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC20(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC21(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC23(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC24(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC25(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG146(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG148(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG156(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG169(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG172(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG175(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG188(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG204(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG206(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR34(CategoriaTecnica.SUFICIENTE));
		
		return listaTecnicas;
	}

}