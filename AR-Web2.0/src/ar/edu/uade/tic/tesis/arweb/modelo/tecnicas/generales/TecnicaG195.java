package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG195 extends TecnicaGeneral {

	public TecnicaG195(CategoriaTecnica categoriaTecnica) {
		super(
				"G195",
				"Uso de un indicador de enfoque altamente visible y proporcionado por el autor.",
				"El objetivo de esta t�cnica es mejorar el indicador de enfoque en el navegador, creando uno altamente visible en el contenido. El indicador de enfoque predeterminado en muchos navegadores es una l�nea delgada, punteada y negra. Puede ser dif�cil ver la l�nea cuando est� alrededor de un elemento de formulario que ya tiene un contorno, cuando el elemento enfocado est� dentro de una celda de tabla, cuando el elemento enfocado es muy peque�o o cuando el fondo de la p�gina es oscuro .", 
				categoriaTecnica);
	}

	/**
	 * 1. Coloque el foco en cada elemento de interfaz de usuario enfocable en la p�gina usando el mouse.
	 * 2. Verifique que haya un indicador de enfoque altamente visible.
	 * 3. Coloque el foco en cada elemento de interfaz de usuario enfocable en la p�gina usando el teclado.
	 * 4. Verifique que haya un indicador de enfoque altamente visible.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFocoAltoContraste = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Foco de alto contraste en elementos de interfaz de usuario enfocables.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que cuando el usuario coloca el foco en un elemento, usando el mouse, la tecla de tabulaci�n, las teclas de flecha, los atajos de teclado o cualquier otro m�todo, la aplicaci�n lo hace m�s visible, usando una combinaci�n de un color de alto contraste, un grosor l�nea y otros indicadores visuales como un resplandor.",
				"Mejora el indicar de enfoque creando uno altamente visible en el contenido usando una combinaci�n de colores de alto contraste o mayor grosor de l�nea.");
		comprobacionFocoAltoContraste.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFocoAltoContraste);
		return resultadoEvaluacionTecnica;
	}

}