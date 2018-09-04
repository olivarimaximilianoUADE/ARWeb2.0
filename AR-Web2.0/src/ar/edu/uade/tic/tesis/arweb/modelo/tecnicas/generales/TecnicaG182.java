package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG182 extends TecnicaGeneral {

	public TecnicaG182(CategoriaTecnica categoriaTecnica) {
		super(
				"G182",
				"Asegurarse de que las señales visuales adicionales están disponibles cuando se utilizan las diferencias de color de texto para transmitir información.",
				"La intención de esta técnica es proporcionar una señal visual redundante para usuarios que pueden no ser capaces de discernir la diferencia en el color del texto . El color se utiliza normalmente para indicar los diferentes estados de las palabras que forman parte de un párrafo u otro bloque de texto o en caracteres o gráficos especiales no se pueden utilizar para indicar qué palabras tienen un estatus especial . Por ejemplo , las palabras dispersas en el texto pueden ser enlaces de hipertexto que están marcados como tal al ser impresa en un color diferente . Esta técnica se describe una manera de proporcionar señales , además de color de modo que los usuarios que pueden tener dificultades para percibir las diferencias de color o con baja visión puede identificarlos. Para utilizar esta técnica, un autor incorpora una señal visual, además de color para cada lugar en el que sólo el color se utiliza para transmitir información. Las indicaciones visuales pueden tomar muchas formas, incluyendo cambios en el estilo de fuente, la adición de subrayados, negrita o cursiva, o cambios en el tamaño de la fuente .", 
				categoriaTecnica);
	}

	/**
	 * 1. Localizar todos los casos en los que se utiliza el color del texto para transmitir información.
	 * 2. Verificar que cualquier texto en el que se utiliza el color para transmitir información también se labra o utiliza una fuente que hace que sea visualmente distinta del resto del texto alrededor de ella.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoConColorConFuenteDistinta = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Texto con color con fuente visualmente distinta del resto del texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que cualquier texto en el que se utiliza el color para transmitir información también se labra o utiliza una fuente que hace que sea visualmente distinta del resto del texto alrededor de ella.",
				"Si se comunica información mediante el color en palabras, fondos u otros contenidos: Asegúrate que hay señales visuales adicionales cuando las diferencias de color en el texto contienen información.");
		comprobacionTextoConColorConFuenteDistinta.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoConColorConFuenteDistinta);
		return resultadoEvaluacionTecnica;
	}

}