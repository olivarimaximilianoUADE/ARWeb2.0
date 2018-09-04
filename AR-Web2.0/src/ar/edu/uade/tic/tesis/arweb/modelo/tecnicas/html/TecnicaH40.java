package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH40 extends TecnicaHTML {

	public TecnicaH40(CategoriaTecnica categoriaTecnica) {
		super(
				"H40",
				"Usar listas descriptivas.",
				"El objetivo de esta técnica es proporcionar la descripción de nombres o términos presentándolos en una lista de descripción. La lista está marcada usando el elemento dl. Dentro de la lista, cada término se coloca en un elemento dt por separado, y su descripción se encuentra en el elemento dd que lo sigue directamente. Se pueden asociar varios términos con una sola descripción, al igual que un único término con múltiples descripciones, siempre que se mantenga la secuencia semántica. El atributo de título se puede usar para proporcionar información adicional sobre la lista de descripción. El uso de listas de descripción garantiza que los términos y sus descripciones estén relacionados semánticamente incluso cuando se modifiquen los formatos de presentación, además de garantizar que estos términos y descripciones se agrupen semánticamente como una unidad.",
				categoriaTecnica);
	}

	/**
	 * Para cualquier conjunto de términos y sus descripciones asociadas:
	 *  1. Verifique que la lista esté contenida dentro de un elemento dl.
	 *  2. Verifique que cada término de la lista que se describe esté dentro de un elemento dt.
	 *  3. Verifique que cuando hay más de un término que comparte la misma descripción, los elementos dt se siguen inmediatamente.
	 *  4. Verifique que la descripción de cada término esté contenida en uno o más elementos dd.
	 *  5. Compruebe que uno o más elementos dd siguen inmediatamente uno o más elementos dt que contienen el término que se describe.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTerminosDescripcion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.LISTAS, 
				"Listas descriptivas deben tener termino y la descripción del mismo.",
				"Verificar las listas descriptivas tengan los terminos \"dt\" y la descripción de los mismos \"dd\".",
				"Cuando se crean listas descriptivas \"dl\" se les debe agrecar un elemento \"dt\" por cada termino y un elemento \"dd\" por cada descripción del mismo.");
		for (Element elementoDl : this.getParseador().getElementos(HTMLElementName.DL)) {
			List<Element> listaElementos = elementoDl.getAllElements();
			for (int i=1; i < listaElementos.size(); i++) {
				if (listaElementos.get(i).getName().equals(HTMLElementName.DT)) {
					if(!listaElementos.get(i+1).getName().equals(HTMLElementName.DD)) {
						comprobacionTerminosDescripcion.procesar(listaElementos.get(i));
					}
					i++;
				}
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTerminosDescripcion);
		return resultadoEvaluacionTecnica;
	}
}