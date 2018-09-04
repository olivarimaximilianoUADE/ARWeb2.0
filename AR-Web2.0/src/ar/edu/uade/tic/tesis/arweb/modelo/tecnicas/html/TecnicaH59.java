package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH59 extends TecnicaHTML {

	public TecnicaH59(CategoriaTecnica categoriaTecnica) {
		super(
				"H59",
				"Usar el elemento de enlace y las herramientas de navegaci�n.",
				"El objetivo de esta t�cnica es describir c�mo el elemento de enlace puede proporcionar metadatos sobre la posici�n de una p�gina HTML dentro de un conjunto de p�ginas web o puede ayudar a localizar contenido en un conjunto de p�ginas web. El valor de los atributos rel indica qu� tipo de relaci�n se est� describiendo, y el atributo href proporciona un enlace al documento que tiene esa relaci�n. M�ltiples elementos de enlace pueden proporcionar m�ltiples relaciones.",
				categoriaTecnica);
	}

	/**
	 * Para una p�gina web que se encuentra dentro de una secuencia o conjunto de p�ginas web:
	 *  1. Verifique que todos los elementos del enlace pertenecientes a la navegaci�n se encuentren en la secci�n principal del documento.
	 *  2. Para cada elemento de enlace en la secci�n principal del documento que pertenece a la navegaci�n, verifique que contenga al menos:
	 *   a. un atributo rel que identifica el tipo de enlace
	 *   b. un atributo href v�lido para ubicar el recurso apropiado
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlancesNavegacionEnSeccionPrincipal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Enlaces pertenecientes a la navegaci�n en la secci�n principal.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los enlaces que pertenecen a la navegaci�n del sitio se encuentren en la secci�n principal del mismo.",
				"En la secci�n principal del sitio web deben estar los enlaces que formen parte de la navegaci�n del mismo.");
		ResultadoEvaluacionTecnicaItem comprobacionLinksConHrefRel = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces con atributo rel y href que lo identifiquen.",
				"Verificar que los elementos enlaces en la secci�n principal del documento que pertenecen a la navegaci�n tengan los atributos \"rel\" y \"href\".",
				"Para los enlaces pertenecientes a la navegaci�n del sitio en la secci�n principal, se deben indicar el atributo \"rel\" que identifique el control y un atributo \"href\" valido para ubicarlo.");
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			Boolean flagRel = Boolean.FALSE;
			Boolean flagHref = Boolean.FALSE;
			if ((elementoLINK.getAttributeValue("rel") != null) && (!elementoLINK.getAttributeValue("rel").isEmpty())) { 
				flagRel = Boolean.TRUE;
			}
			if ((elementoLINK.getAttributeValue("href") != null) && (!elementoLINK.getAttributeValue("href").isEmpty())) {
				flagHref = Boolean.TRUE;
			}
			if (!flagRel && !flagHref) 
				comprobacionLinksConHrefRel.procesar(elementoLINK);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlancesNavegacionEnSeccionPrincipal);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLinksConHrefRel);
		return resultadoEvaluacionTecnica;
	}

}