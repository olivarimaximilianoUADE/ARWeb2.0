package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG94 extends TecnicaGeneral {
	
	public TecnicaG94(CategoriaTecnica categoriaTecnica) {
		super(
				"G94",
				"Proporcionar alternativas textuales cortas para el contenido no textual que sirvan al mismo propósito y presenten la misma información que el contenido no textual.",
				"El objetivo de esta técnica es crear una alternativa textual que sirva el mismo proposito y presenta la informacion que el contenido no textual original. Como resultado, es posible remover el contenido no textual y reemplazarlo por la alternativa textual y ninguna funcionalidad o informacion seria perdida. Esta alternativa textual no necesariamente describe el contenido no textual. Debe servir el mismo proposito y transmitir la misma informacion. A veces esto puede resultar en una alternativa textual que se ve como una descripcion no textual. Pero esto solo seria cierto si esa era la mejor manera de servir el mismo proposito.\n\nSi es posible, la alternativa textual corta debe transmitir completamente el proposito y la informacion. Si no es posible hacer esto en una frase corta o sentencia, entonces la alternativa textual corta deberia proporcionar una breve vision general de la informacion. Una alternativa textual larga seria utilizada ademas para transmitir la informacion completa.\n\nLa alternativa textual debe ser capaz de sustituir el contenido no textual. Si el contenido no textual se elimina de la pagina y se sustituye por la alternativa textual, la pagina todavia proporcionaria la misma funcion e informacion. La alternativa textual seria breve, pero lo más completa posible.\n\nAl decidir que texto introducir en la alternativa textual, es buena idea tener en cuenta las siguientes preguntas: \n\n¿Por que es este contenido no textual?\n¿Que informacion esta presentando?\n¿Que proposito cumple?\nSi no pudiera utilizar el contenido no textual, ¿que palabras deberia usar para transmitir la misma funcion y/o informacion?\n\nCuando el contenido no textual contiene palabras que son importantes para entender el contenido, el texto alternativo deberia incluir esas palabras. Si el texto en la imagen es mayor al que puede caber en una alternativa textual corta entonces deberia ser descrita en ella y una alternativa textual larga deberia ser proporcionada, con el texto completo.",
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Reemplazarlo con el texto alternativo.
	 * 3. Verificar que no se pierde nada (el propósito del contenido no textual es satisfecho por la alternativa textual).
	 * 4. Si el contenido no textual contiene palabras que son importantes para entender el contenido, esas palabras se incluyen en el texto alternativo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualCortaPresentaMismaInformacionContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual corta presenta la misma información que el contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no se pierde nada (el propósito del contenido no textual es satisfecho por la alternativa textual).",
				"Asegúrate que la alternativa textual corta presenta la misma información que el contenido no textual.");
		comprobacionAlternativaTextualCortaPresentaMismaInformacionContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualCortaPresentaMismaInformacionContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}