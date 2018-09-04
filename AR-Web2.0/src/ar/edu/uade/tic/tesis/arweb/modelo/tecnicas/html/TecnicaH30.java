package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH30 extends TecnicaHTML {

	public TecnicaH30(CategoriaTecnica categoriaTecnica) {
		super(
				"H30",
				"Proporcionar en los enlaces textos que describan el propósito del enlace para los elementos ancla",
				"El objetivo de esta técnica es describir el propósito de un enlace al proporcionar texto descriptivo como el contenido del elemento a. La descripción permite a un usuario a distinguir este enlace de otros enlaces en la página web y ayuda al usuario a determinar si seguir el enlace . El URI del destino en general no es suficientemente descriptivo. Cuando una imagen es el único contenido de un enlace, el texto alternativo para la imagen describe la función única del enlace. Cuando el contenido de un enlace contiene texto y una o más imágenes , si el texto es suficiente para describir el propósito del enlace, las imágenes pueden tener una alternativa de texto vacío.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace en el contenido que utiliza esta técnica:
	 * 1. Verificar que el texto o un texto alternativo para el contenido no textual está incluido en el elemento a.
	 * 2. Si un elemento 'img' es el único contenido del elemento 'a', verificar que su alternativa textual describe el propósito del enlace.
	 * 3. Si el elemento 'a' contiene uno o más elementos 'img' y la alternativa textual del elemento img está vacía, verificar que el texto del enlace describe el propósito del enlace.
	 * 4. Si el elemento 'a' sólo contiene texto, verificar que el texto describe el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Imágenes del enlace con atributo \"alt\" no describen el propósito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido: Si un elemento \"img\" es el único contenido del elemento \"a\", verificar que su alternativa textual describe el propósito del enlace.",
				"No dejes el atributo \"alt\" vacío de una imagen cuando la imagen sea el único contenido de un enlace.");
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceNoDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace no describen el propósito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido:  Si el elemento \"a\" sólo contiene texto, verificar que el texto describe el propósito del enlace.",
				"Asegúrate que el texto de un enlace describe el propósito del enlace cuando el elemento \"a\" solo contiene texto. No ofrezcas enlaces sin un texto informativo que lo contextualice (como \"Click aquí\" o \"Leer más\").");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			List<Element> listaElementos = elementoA.getAllElements();
			List<Element> listaElementosIMGenA = elementoA.getAllElements(HTMLElementName.IMG);
			if ((listaElementos.size() == 2) && (listaElementosIMGenA.size() == 1)) 
				comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace.procesar(listaElementosIMGenA.get(0));
			if (listaElementosIMGenA.size() >= 1) {
				for (Element elementoIMG : listaElementosIMGenA) {
					if ((elementoIMG.getAttributeValue("alt") != null) && (!elementoIMG.getAttributeValue("alt").isEmpty())) {

					} else 
						comprobacionTextoEnlaceNoDescribenPropositoEnlace.procesar(elementoA);
				}
			} else 
				comprobacionTextoEnlaceNoDescribenPropositoEnlace.procesar(elementoA);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceNoDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}