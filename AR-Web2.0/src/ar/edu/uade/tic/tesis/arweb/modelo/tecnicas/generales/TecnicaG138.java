package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG138 extends TecnicaGeneral {

	public TecnicaG138(CategoriaTecnica categoriaTecnica) {
		super(
				"G138", 
				"Usar marcado semántico cuando se utilizan las señales de color.", 
				"El objetivo de esta técnica es combinar color y marcado semántico para transmitir información. La mayoría de los usuarios pueden escanear rápidamente el contenido para localizar la información facilitada mediante el uso del color . Para los usuarios que no pueden ver el color, el marcado semántico puede proporcionar un tipo diferente de señal . Los agentes de usuario pueden entonces hacer este tipo de estructura perceptible para el usuario, por ejemplo, utilizando una presentación visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentación auditiva. La mayoría de las aplicaciones de usuario se distinguen visualmente el texto, que ha sido identificado utilizando el marcado semántico . Algunas tecnologías de apoyo proporcionan un mecanismo para determinar las características de los contenidos que se ha creado usando el marcado semántico adecuado.", 
				categoriaTecnica);
	}

	/**
	 * Para cualquier contenido que se utilizan diferencias de color para transmitir información:
	 * 1. Verificar que la misma información está disponible a través de marcado semántico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCombinacionColorYMarcadoSemantico = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Combinar color y marcado semántico para transmitir información", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cualquier contenido que se utilizan diferencias de color para transmitir información: Verificar que la misma información está disponible a través de marcado semántico.",
				"Comunica la información y sus relaciones mediante la estructura de la página web: el marcado semántico cuando se utilizan claves de colores (por ejemplo, si se colorea el texto en rojo para indicar que es un error).");
		comprobacionCombinacionColorYMarcadoSemantico.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCombinacionColorYMarcadoSemantico);
		return resultadoEvaluacionTecnica;
	}

}