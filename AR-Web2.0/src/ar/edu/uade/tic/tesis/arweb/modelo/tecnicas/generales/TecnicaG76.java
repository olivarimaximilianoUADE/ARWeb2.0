package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG76 extends TecnicaGeneral {

	public TecnicaG76(CategoriaTecnica categoriaTecnica) {
		super(
				"G76",
				"Proporcionar un mecanismo para solicitar una actualizaci�n del contenido en lugar de actualizar autom�ticamente.",
				"El objetivo de esta t�cnica es permitir que el usuario controle si se actualiza el contenido, para evitar confusi�n o desorientaci�n causada por actualizaciones autom�ticas que causan un cambio de contexto. Los usuarios de lectores de pantalla pueden encontrar las actualizaciones autom�ticas confusas porque no siempre est� claro lo que est� sucediendo. Cuando se actualiza una p�gina, el \"cursor virtual\" del lector de pantalla, que marca la ubicaci�n actual del usuario en la p�gina, se mueve a la parte superior de la p�gina. Las personas que usan software de aumento de pantalla y las personas con discapacidades de lectura tambi�n pueden desorientarse cuando las p�ginas se actualizan autom�ticamente.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encuentre mecanismos para actualizar el contenido (si tal mecanismo est� presente).
	 * 2. Para cada mecanismo, verifique si le permite al usuario solicitar una actualizaci�n.
	 * 3. Para cada mecanismo, verifique si puede causar una actualizaci�n autom�tica.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMecanismoActualizacionContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Mecanismo para actualizar el contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuanta con un mecanismo que permita actualizar el contenido bajo demanda.",
				"Aseg�rate que el sitio tenga alg�n mecanismo que permita actualizar el contenido del sitio bajo demanda del usuario.");
		comprobacionMecanismoActualizacionContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMecanismoActualizacionContenido);
		return resultadoEvaluacionTecnica;
	}

}