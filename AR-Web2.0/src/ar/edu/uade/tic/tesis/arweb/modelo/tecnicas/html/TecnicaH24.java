package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH24 extends TecnicaHTML {

	public TecnicaH24(CategoriaTecnica categoriaTecnica) {
		super(
				"H24", 
				"Proporcionar alternativas textuales para los elementos area de los mapas de imagen",
				"El propósito de esta técnica es proporcionar alternativas textuales que sirvan al mismo propósito que las regiones seleccionables de un mapa de imagen. Un mapa de imagen es una imagen dividida en regiones seleccionables definidas por los elementos area. Cada area es un enlace a otra página Web o a otra parte de la página Web actual. El atributo alt de cada elemento area sirve al mismo propósito que el area seleccionable de la imagen.",
				categoriaTecnica);
	}

	/**
	 * Por cada elemento 'area' en un mapa de imagen:
	 * 1. Verificar que el elemento 'area' tiene un atributo 'alt'
	 * 2. Verificar que el texto alternativo especificado por el atributo 'alt' sirve al mismo propósito que la parte de imagen de mapa de imagen de referenciada por el elemento 'area' del mapa de imagen  
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAreaMapasDeImagenSinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Elementos \"area\" de los mapas de imagen sin atributo \"alt\".",
				"Por cada elemento \"area\" en un mapa de imagen: Verificar que el elemento \"area\" tiene un atributo \"alt\".",
				"Ofrece una alternativa textual para las \"area\" de los mapas de imágenes.");
		ResultadoEvaluacionTecnicaItem comprobacionAreaEnMapConAltConIgualProposito = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Elementos \"area\" de los mapas de imagen con atributo \"alt\" sin propósito que la parte de imagen de mapa.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada elemento \"area\" en un mapa de imagen: Verificar que el texto alternativo especificado por el atributo \"alt\" sirve al mismo propósito que la parte de imagen de mapa de imagen de referenciada por el elemento \"area\" del mapa de imagen.",
				"Asegúrate que el texto alternativo especificado por el atributo \"alt\" sirve al mismo propósito que la parte de imagen de mapa de imagen de referenciada por el elemento \"area\" del mapa de imagen.");
		for (Element elementoMAP : this.getParseador().getElementos(HTMLElementName.MAP)) {
			for (Element elementoAREA : elementoMAP.getAllElements(HTMLElementName.AREA)) {
				String atributoAlt = elementoAREA.getAttributeValue("alt"); 
				if (atributoAlt == null) 
					comprobacionAreaMapasDeImagenSinAlt.procesar(elementoAREA);
				else {
					if (atributoAlt.isEmpty()) 	
						comprobacionAreaMapasDeImagenSinAlt.procesar(elementoAREA);
					comprobacionAreaEnMapConAltConIgualProposito.procesar(elementoAREA);
				}	
			}
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAreaMapasDeImagenSinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAreaEnMapConAltConIgualProposito);
		return resultadoEvaluacionTecnica;
	}

}