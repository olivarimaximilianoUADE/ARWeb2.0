package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC8;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC21;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC28;

public class Criterio1_4_12_EspaciadoDeTexto  extends Criterio {

	public Criterio1_4_12_EspaciadoDeTexto() {
		super(
				"1.4.12",
				"Espaciado de texto.",
				"El criterio se aplica a los lenguajes que, como HTML, permiten definir el espaciado entre l�neas, p�rrafos, palabras o caracteres. En estos casos, si el usuario configura dichas propiedades de la manera que se enumera a continuaci�n (y sin necesidad de tocar otros estilos), no se debe producir p�rdida de contenido ni de funcionalidad:\r\n" + 
				"\r\n" + 
				"Espacio entre l�neas: al menos 1.5 veces el tama�o de la fuente.\r\n" + 
				"Espacio entre p�rrafos: al menos 2 veces el tama�o de la fuente.\r\n" + 
				"Espacio entre las letras (tracking): al menos 0.12 veces el tama�o de la fuente.\r\n" + 
				"Espacio entre palabras: al menos 0.16 veces el tama�o de la fuente.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.1"));
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaC8(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC21(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC28(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}
