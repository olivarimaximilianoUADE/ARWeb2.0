package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG18;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG145;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG174;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG183;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG195;

public class Criterio1_4_11_ContrasteSinTexto extends Criterio {

	public Criterio1_4_11_ContrasteSinTexto() {
		super(
				"1.4.11",
				"Contraste sin texto.",
				"Indica que, la presentación visual de los siguientes elementos tiene una ratio de contraste de al menos 3:1 respecto a los colores adyacentes:\r\n" + 
				"\r\n" + 
				"Componentes de la interfaz de usuario: información visual utilizada para identificar los componentes de la interfaz de usuario y los estados, excepto para componentes inactivos o cuando la apariencia del componente es determinada por el agente de usuario y el autor no la modifica.\r\n" + 
				"Objetos gráficos: partes de los gráficos necesarias para comprender el contenido, excepto cuando una presentación particular de los gráficos es esencial para la información que se transmite (esencial como por ejemplo en los logotipos o en las banderas, en una captura de un sitio que muestra cómo es su apariencia, en un mapa de calor, en un diagrama médico que usa los colores utilizados en biología, etc.)",
				NivelAccesibilidad.AA,
				Arrays.asList("2.1"));
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG18(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG145(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG174(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG195(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG183(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
}
