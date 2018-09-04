package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG54 extends TecnicaGeneral{

	public TecnicaG54(CategoriaTecnica categoriaTecnica) {
		super(
				"G54",
				"Incluir una interpretación en lengua de señas en la secuencia de vídeo.",
				"El objetivo de esta técnica es permitir que los usuarios que no pueden oír o leer el texto rápidamente puedan acceder al video. Para aquellos que se comunican principalmente en lenguaje de señas, a veces es menos preferible y a veces no es posible para ellos leer y entender el texto a la velocidad que se presenta en los subtítulos. Para estos últimos individuos, es importante proporcionar una presentación en lenguaje de señas de la información de audio. Una forma universalmente compatible de hacerlo es simplemente insertar un video del intérprete de lenguaje de señas en la secuencia de video. Esto tiene la desventaja de proporcionar una imagen de menor resolución que no se puede agrandar fácilmente sin ampliar toda la imagen.",
				categoriaTecnica);
	}

	/**
	 * 1.  Haga que alguien mire el programa que puede escuchar y que esté familiarizado con el lenguaje de señas que se está utilizando.
	 * 2.  Verifique si hay un intérprete de lenguaje de señas en la pantalla.
	 * 3.  Verifique que el intérprete visible en la pantalla transmita el diálogo y los sonidos importantes.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInterpretacionLenguaSeñas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Incluir una interpretación en lengua de señas en la secuencia de vídeo", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el video tenga intérprete de lenguaje de señas en la pantalla.",
				"Incluir en los videos un interprete en lengua de señas para que el mismo pueda ser comprendido por personas con disminución auditiva.");
		comprobacionInterpretacionLenguaSeñas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInterpretacionLenguaSeñas);
		return resultadoEvaluacionTecnica;
	}

}
