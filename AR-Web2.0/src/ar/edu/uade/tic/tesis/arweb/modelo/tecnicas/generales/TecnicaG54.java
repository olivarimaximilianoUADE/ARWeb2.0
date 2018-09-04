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
				"Incluir una interpretaci�n en lengua de se�as en la secuencia de v�deo.",
				"El objetivo de esta t�cnica es permitir que los usuarios que no pueden o�r o leer el texto r�pidamente puedan acceder al video. Para aquellos que se comunican principalmente en lenguaje de se�as, a veces es menos preferible y a veces no es posible para ellos leer y entender el texto a la velocidad que se presenta en los subt�tulos. Para estos �ltimos individuos, es importante proporcionar una presentaci�n en lenguaje de se�as de la informaci�n de audio. Una forma universalmente compatible de hacerlo es simplemente insertar un video del int�rprete de lenguaje de se�as en la secuencia de video. Esto tiene la desventaja de proporcionar una imagen de menor resoluci�n que no se puede agrandar f�cilmente sin ampliar toda la imagen.",
				categoriaTecnica);
	}

	/**
	 * 1.  Haga que alguien mire el programa que puede escuchar y que est� familiarizado con el lenguaje de se�as que se est� utilizando.
	 * 2.  Verifique si hay un int�rprete de lenguaje de se�as en la pantalla.
	 * 3.  Verifique que el int�rprete visible en la pantalla transmita el di�logo y los sonidos importantes.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInterpretacionLenguaSe�as = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Incluir una interpretaci�n en lengua de se�as en la secuencia de v�deo", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el video tenga int�rprete de lenguaje de se�as en la pantalla.",
				"Incluir en los videos un interprete en lengua de se�as para que el mismo pueda ser comprendido por personas con disminuci�n auditiva.");
		comprobacionInterpretacionLenguaSe�as.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInterpretacionLenguaSe�as);
		return resultadoEvaluacionTecnica;
	}

}
