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
				"El objetivo de esta t�cnica es proporcionar la descripci�n de nombres o t�rminos present�ndolos en una lista de descripci�n. La lista est� marcada usando el elemento dl. Dentro de la lista, cada t�rmino se coloca en un elemento dt por separado, y su descripci�n se encuentra en el elemento dd que lo sigue directamente. Se pueden asociar varios t�rminos con una sola descripci�n, al igual que un �nico t�rmino con m�ltiples descripciones, siempre que se mantenga la secuencia sem�ntica. El atributo de t�tulo se puede usar para proporcionar informaci�n adicional sobre la lista de descripci�n. El uso de listas de descripci�n garantiza que los t�rminos y sus descripciones est�n relacionados sem�nticamente incluso cuando se modifiquen los formatos de presentaci�n, adem�s de garantizar que estos t�rminos y descripciones se agrupen sem�nticamente como una unidad.",
				categoriaTecnica);
	}

	/**
	 * Para cualquier conjunto de t�rminos y sus descripciones asociadas:
	 *  1. Verifique que la lista est� contenida dentro de un elemento dl.
	 *  2. Verifique que cada t�rmino de la lista que se describe est� dentro de un elemento dt.
	 *  3. Verifique que cuando hay m�s de un t�rmino que comparte la misma descripci�n, los elementos dt se siguen inmediatamente.
	 *  4. Verifique que la descripci�n de cada t�rmino est� contenida en uno o m�s elementos dd.
	 *  5. Compruebe que uno o m�s elementos dd siguen inmediatamente uno o m�s elementos dt que contienen el t�rmino que se describe.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTerminosDescripcion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.LISTAS, 
				"Listas descriptivas deben tener termino y la descripci�n del mismo.",
				"Verificar las listas descriptivas tengan los terminos \"dt\" y la descripci�n de los mismos \"dd\".",
				"Cuando se crean listas descriptivas \"dl\" se les debe agrecar un elemento \"dt\" por cada termino y un elemento \"dd\" por cada descripci�n del mismo.");
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