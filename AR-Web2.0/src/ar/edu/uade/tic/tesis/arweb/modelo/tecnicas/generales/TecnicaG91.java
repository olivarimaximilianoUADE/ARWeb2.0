package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG91 extends TecnicaGeneral {

	public TecnicaG91(CategoriaTecnica categoriaTecnica) {
		super(
				"G91", 
				"Proporcionar enlaces de texto que describe el propósito de un enlace.", 
				"El objetivo de esta técnica es describir el propósito de un enlace en el texto del enlace. La descripción permite a un usuario a distinguir este enlace siguiendo los enlaces de la página Web que conducen a otros destinos y ayuda al usuario a determinar si seguir el enlace o no. El URL de destino en general no es suficientemente descriptivo.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace en el contenido que utiliza esta técnica:
	 * 1. Verificar que el texto del enlace describe el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceDescribePropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace describe el propósito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido que utiliza esta técnica: Verificar que el texto del enlace describe el propósito del enlace.",
				"Identifica el objetivo de un enlace usando un texto clarificador en el enlace.");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A))
			if (!elementoA.getTextExtractor().toString().isEmpty())
				comprobacionTextoEnlaceDescribePropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceDescribePropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}