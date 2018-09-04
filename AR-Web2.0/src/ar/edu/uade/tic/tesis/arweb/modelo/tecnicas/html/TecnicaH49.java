package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH49 extends TecnicaHTML {

	public TecnicaH49(CategoriaTecnica categoriaTecnica) {
		super(
				"H49", 
				"Usar marcado semántico para identificar el texto especial o enfatizado.", 
				"El objetivo de esta técnica es demostrar cómo el marcado semántico puede ser utilizado para marcar énfasis o texto especial para que se pueda determinar por programación. El uso de marcas semánticas para marcar énfasis o texto especial también proporciona estructura al documento. Los agentes de usuario pueden entonces hacer la estructura perceptible para el usuario, por ejemplo, utilizando una presentación visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentación auditiva. La mayoría de las aplicaciones de usuario se distinguen visualmente el texto, que ha sido identificado utilizando el marcado semántico . Algunas tecnologías de apoyo proporcionan un mecanismo para determinar las características de los contenidos que se ha creado usando el marcado semántico adecuado.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar el contenido de la información que se transmite a través de las variaciones en la presentación del texto.
	 * 2. Verificar que el marcado semántico apropiado (como em, strong, cite, blockquote, sub y sup) se han utilizado para marcar el texto que transmite información a través de variaciones en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMarcadoSemanticoSinTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Marcado semántico sin texto.",
				"Verificar que el marcado semántico apropiado (como \"em\", \"strong\", \"cite\", \"blockquote\", \"sub\" y \"sup\") se han utilizado para marcar el texto.",
				"Formatea la estructura y el texto con elementos semánticos.");
		ResultadoEvaluacionTecnicaItem comprobacionMarcadoSemanticoTransmiteInformacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Marcado semántico se ha utilizado para identificar texto especial o enfatizado.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el marcado semántico apropiado (como \"em\", \"strong\", \"cite\", \"blockquote\", \"sub\" y \"sup\") se han utilizado para marcar el texto que transmite información a través de variaciones en el texto.",
				"Formatea la estructura y el texto con elementos semánticos.");
		for (Element elemento : this.getParseador().getElementos()) {
			if (elemento.getName().matches("(" + HTMLElementName.EM + "|" + HTMLElementName.STRONG + "|" + HTMLElementName.CITE + "|" + HTMLElementName.BLOCKQUOTE  + "|" + HTMLElementName.SUB + "|" + HTMLElementName.SUP + ")")) {
				if (elemento.getTextExtractor().toString().isEmpty()) 
					comprobacionMarcadoSemanticoSinTexto.procesar(elemento);
				comprobacionMarcadoSemanticoTransmiteInformacion.procesar(elemento);
			}	
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcadoSemanticoSinTexto);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcadoSemanticoTransmiteInformacion);
		return resultadoEvaluacionTecnica;
	}

}