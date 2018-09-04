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
				"Proporcionar versiones en lenguaje de se�as de informaci�n, ideas y procesos que deben ser entendidos para usar el contenido.", 
				"El objetivo de esta t�cnica es proporcionar versiones en lenguaje de se�as de contenido que ayuden a los usuarios que firman a entender el texto dif�cil que describe conceptos o procesos. El contenido del lenguaje de se�as se proporciona adem�s del texto. Como se trata de contenido complementario (y no de lenguaje de se�as para el contenido), debe verse como algo separado del contenido y no necesariamente sincronizado. Aunque puede haber ocasiones en que eso sea �til, no es necesario. Para que la versi�n en lenguaje de se�as est� disponible con el resto de los contenidos de la p�gina web, el video puede estar incrustado en la p�gina web directamente o la p�gina web puede incluir un enlace que muestra un reproductor de video en una ventana separada. ",
				categoriaTecnica);
	}

	/**
	 * 1. Identifique texto que discuta ideas o procesos que deben ser comprendidos para usar el contenido.
	 * 2. Compruebe si los complementos de lenguaje de se�as del texto est�n disponibles en el contenido o a trav�s de enlaces dentro del contenido.
	 * 3. Verifique que los suplementos de lenguaje de se�as muestren los conceptos o procesos discutidos en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVersionLenguajeDeSe�as = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Versi�n en lenguaje de se�as del contenido.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Proporcionar versiones en lenguajes de se�as de contenido que ayuden a los usuarios a comprender el texto dif�cil de conceptos y procesos.",
				"Ofrece versi�n en lenguaje de se�as tanto en el mismo contenido o a trav�s de enlaces dentro del sitio para aquellos textos que describren conceptos o procesos dif�ciles de comprender por los usuarios.");
		comprobacionVersionLenguajeDeSe�as.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVersionLenguajeDeSe�as);
		return resultadoEvaluacionTecnica;
	}

}