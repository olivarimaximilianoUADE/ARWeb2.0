package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG188 extends TecnicaGeneral {

	public TecnicaG188(CategoriaTecnica categoriaTecnica) {
		super(
				"G188",
				"Proporcionar un bot�n en la p�gina para aumentar espacios de l�nea y espacios de p�rrafo.",
				"Muchas personas con discapacidades cognitivas tienen problemas para leer textos separados por espacios simples. Un bot�n que aumenta la altura de la l�nea les ayudar� a leer el contenido. Para mantener la separaci�n de los p�rrafos, el espacio entre los p�rrafos tambi�n debe aumentar, de modo que sea al menos 1,5 veces m�s alto que el espaciado entre l�neas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que haya un bot�n o enlace en la p�gina que aumente el tama�o de la altura de la l�nea y el espaciado entre p�rrafos, que est� etiquetado como tal.
	 * 2. Activa el bot�n o enlace.
	 * 3. Compruebe que el bot�n o enlace aumenta la altura de la l�nea a al menos 1,5 (150%)
	 * 4. Compruebe que el bot�n o enlace aumenta el espaciado entre p�rrafos al menos 1,5 veces mayor que el espaciado entre l�neas.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAumentoEspacioLineasYEntreParrafos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Bot�n que aumente el espacio de lineas y de p�rrafos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un bot�n o enlace que aumente el tama�o de la altura de la l�nea y el espacio entre los p�rrafos.",
				"El sitio debe tener una opci�n para aumentar la altura de la l�nea al menos en 1,5 (150%) y el espacio entre p�rrados al menos 1,5 veces mayor al espacio entre l�neas.");
		comprobacionAumentoEspacioLineasYEntreParrafos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAumentoEspacioLineasYEntreParrafos);
		return resultadoEvaluacionTecnica;
	}

}