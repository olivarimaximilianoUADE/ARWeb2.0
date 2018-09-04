package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH62 extends TecnicaHTML {

	public TecnicaH62(CategoriaTecnica categoriaTecnica) {
		super(
				"H62",
				"Usar el elemento ruby para proporcionar infomación sobre la pronunciación.",
				"El objetivo de esta técnica es usar la anotación ruby ​​para proporcionar información sobre la pronunciación y el significado de una serie de textos cuyo significado está determinado por la pronunciación. Hay muchos idiomas en los que una corrida de texto puede significar cosas diferentes según cómo se pronuncie el texto. Esto es común en los idiomas de Asia oriental, así como en hebreo, árabe y otros idiomas; también ocurre en inglés y otros idiomas de Europa occidental.",
				categoriaTecnica);
	}

	/**
	 * Para cada ejecución de texto donde se usa una anotación de Ruby para proporcionar información de pronunciación:
	 *  1. Compruebe que un elemento rt contiene información de pronunciación para cada corrida de texto definida por el elemento rb.
	 *  2. Si se usa el marcado Ruby simple, verifique que el elemento rp esté presente para indicar a los agentes de usuario que no son compatibles con las anotaciones Ruby que el texto en el elemento rt proporciona la información de pronunciación
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRtEnElementoRuby = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Elementos \"rt\" y \"rb\" dentro de elemento \"ruby\".",
				"Para cada elemento ruby: Verificar que todos los elementos \"rt\" contiene información de pronunciación para cada elemento \"rb\".",
				"Para brindar información sobre pronunciación se debe utilizar la anotación ruby con los elementos \"rb\" y \"rt\" bien definidos.");
		ResultadoEvaluacionTecnicaItem comprobacionRpEnElementoRuby = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Elementos \"rp\" dentro de elemento \"ruby\".",
				"Para cada elemento ruby: Verificar que el elemento \"rp\" esté presente.",
				"Para aquellos navegadores que no son compatibles con la anotación ruby debe estar presente el elemento \"rp\".");
		for (Element elementoRUBY : this.getParseador().getElementos(HTMLElementName.RUBY)) {
			if(elementoRUBY.getAllElements(HTMLElementName.RT).size()==0) {
				comprobacionRtEnElementoRuby.procesar(elementoRUBY);
			}
			if(elementoRUBY.getAllElements(HTMLElementName.RP).size()==0) {
				comprobacionRpEnElementoRuby.procesar(elementoRUBY);
			}
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRtEnElementoRuby);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRpEnElementoRuby);
		return resultadoEvaluacionTecnica;
	}

}