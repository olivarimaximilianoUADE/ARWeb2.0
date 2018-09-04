package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG160 extends TecnicaGeneral {

	public TecnicaG160(CategoriaTecnica categoriaTecnica) {
		super(
				"G160", 
				"Proporcionar versiones en lenguaje de señas de información, ideas y procesos que deben ser entendidos para usar el contenido.", 
				"El objetivo de esta técnica es proporcionar versiones en lenguaje de señas de contenido que ayuden a los usuarios que firman a entender el texto difícil que describe conceptos o procesos. El contenido del lenguaje de señas se proporciona además del texto. Como se trata de contenido complementario (y no de lenguaje de señas para el contenido), debe verse como algo separado del contenido y no necesariamente sincronizado. Aunque puede haber ocasiones en que eso sea útil, no es necesario. Para que la versión en lenguaje de señas esté disponible con el resto de los contenidos de la página web, el video puede estar incrustado en la página web directamente o la página web puede incluir un enlace que muestra un reproductor de video en una ventana separada. ",
				categoriaTecnica);
	}

	/**
	 * 1. Identifique texto que discuta ideas o procesos que deben ser comprendidos para usar el contenido.
	 * 2. Compruebe si los complementos de lenguaje de señas del texto están disponibles en el contenido o a través de enlaces dentro del contenido.
	 * 3. Verifique que los suplementos de lenguaje de señas muestren los conceptos o procesos discutidos en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVersionLenguajeDeSeñas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Versión en lenguaje de señas del contenido.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Proporcionar versiones en lenguajes de señas de contenido que ayuden a los usuarios a comprender el texto difícil de conceptos y procesos.",
				"Ofrece versión en lenguaje de señas tanto en el mismo contenido o a través de enlaces dentro del sitio para aquellos textos que describren conceptos o procesos difíciles de comprender por los usuarios.");
		comprobacionVersionLenguajeDeSeñas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVersionLenguajeDeSeñas);
		return resultadoEvaluacionTecnica;
	}

}