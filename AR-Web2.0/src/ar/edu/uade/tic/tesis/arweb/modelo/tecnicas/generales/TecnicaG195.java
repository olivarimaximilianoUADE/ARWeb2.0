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
				"El objetivo de esta técnica es mejorar el indicador de enfoque en el navegador, creando uno altamente visible en el contenido. El indicador de enfoque predeterminado en muchos navegadores es una línea delgada, punteada y negra. Puede ser difícil ver la línea cuando está alrededor de un elemento de formulario que ya tiene un contorno, cuando el elemento enfocado está dentro de una celda de tabla, cuando el elemento enfocado es muy pequeño o cuando el fondo de la página es oscuro .", 
				categoriaTecnica);
	}

	/**
	 * 1. Coloque el foco en cada elemento de interfaz de usuario enfocable en la página usando el mouse.
	 * 2. Verifique que haya un indicador de enfoque altamente visible.
	 * 3. Coloque el foco en cada elemento de interfaz de usuario enfocable en la página usando el teclado.
	 * 4. Verifique que haya un indicador de enfoque altamente visible.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFocoAltoContraste = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Foco de alto contraste en elementos de interfaz de usuario enfocables.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que cuando el usuario coloca el foco en un elemento, usando el mouse, la tecla de tabulación, las teclas de flecha, los atajos de teclado o cualquier otro método, la aplicación lo hace más visible, usando una combinación de un color de alto contraste, un grosor línea y otros indicadores visuales como un resplandor.",
				"Mejora el indicar de enfoque creando uno altamente visible en el contenido usando una combinación de colores de alto contraste o mayor grosor de línea.");
		comprobacionFocoAltoContraste.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFocoAltoContraste);
		return resultadoEvaluacionTecnica;
	}

}