package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG178 extends TecnicaGeneral {

	public TecnicaG178(CategoriaTecnica categoriaTecnica) {
		super(
				"G178", 
				"Proporciona controles en la página web que permiten a los usuarios cambiar incrementalmente el tamaño de todo el texto en la página hasta en un 200 por ciento.", 
				"El objetivo de esta técnica es proporcionar un mecanismo en la página web para aumentar gradualmente el tamaño del texto. Muchas personas con baja visión no usan software de ampliación y es posible que no estén familiarizados con los ajustes de tamaño de texto de su navegador. Esto puede ser particularmente cierto en el caso de las personas mayores que están aprendiendo a usar la computadora y que pueden estar experimentando pérdida de la visión relacionada con la edad. También puede ser cierto para algunas personas con discapacidades cognitivas que requieren un mayor tamaño de fuente. Esta técnica proporciona un mecanismo que algunos usuarios encontrarán más fácil de usar. El mecanismo puede incluir enlaces o botones que cambiarán la presentación visual a una hoja de estilos diferente o utilizarán secuencias de comandos para cambiar el tamaño del texto de forma dinámica.", 
				categoriaTecnica);
	}

	/**
	 * 1. Establezca el tamaño de la ventana gráfica en 1024 px por 768 px o superior.
	 * 2. Aumente el tamaño del texto y verifique si el tamaño del texto aumentó.
	 * 3. Verifique que el tamaño del texto se pueda aumentar al 200% del tamaño original.
	 * 4. Compruebe que después de aumentar el tamaño del texto al 200% del tamaño original, no hay pérdida de contenido o funcionalidad (por ejemplo: no se recortan partes del texto, los cuadros no se superponen, los controles no se oscurecen o se separan de sus etiquetas, etc. )
	 * 5. Disminuya el tamaño del texto a su valor predeterminado y verifique si de hecho volvió al tamaño predeterminado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAumentoTamañoTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"El sitio web proporciona un control para aumentar el tamaño del texto hasta un 200 por ciento.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página web tenga un control que permita al usuario aumentar el tamaño de los textos hasta un 200 por ciento.",
				"Debe existir dentro del sitio un control que permita que los usuarios puedan aumentar gradualmente el tamañi del texto hasta un 200 por ciento.");
		comprobacionAumentoTamañoTexto.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAumentoTamañoTexto);
		return resultadoEvaluacionTecnica;
	}
	
}