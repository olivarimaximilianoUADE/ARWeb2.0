package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_1_4_AtajosDeTeclado extends Criterio {

	public Criterio2_1_4_AtajosDeTeclado() {
		super(
				"2.1.4",
				"Atajos de teclado.",
				"Si un m�todo abreviado de teclado se implementa en el contenido utilizando solo letras (incluyendo may�sculas y min�sculas), signos de puntuaci�n, n�meros o s�mbolos, entonces al menos uno de los siguientes es verdadero:\r\n" + 
				"\r\n" + 
				"Apagar:\r\n" + 
				"Hay un mecanismo disponible para desactivar el acceso directo;\r\n" + 
				"Reasignar:\r\n" + 
				"Hay un mecanismo disponible para volver a asignar el acceso directo para usar uno o m�s caracteres de teclado no imprimibles (por ejemplo, Ctrl, Alt, etc.);\r\n" + 
				"Activo solo en foco:\r\n" + 
				"El m�todo abreviado de teclado para un componente de la interfaz de usuario solo est� activo cuando el componente tiene el foco.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
