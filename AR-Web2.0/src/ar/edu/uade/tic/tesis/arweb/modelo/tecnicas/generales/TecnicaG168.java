package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG168 extends TecnicaGeneral {

	public TecnicaG168(CategoriaTecnica categoriaTecnica) {
		super(
				"G168", 
				"Solicitar confirmaci�n para continuar con la acci�n seleccionada.", 
				"Esta t�cnica busca la confirmaci�n por parte del usuario de que la acci�n seleccionada es su acci�n deseada. Utilice esta t�cnica en situaciones donde la acci�n no se puede deshacer despu�s de que se ha seguido. Esto ayudar� a los usuarios a evitar enviar un formulario o eliminar datos por error..",
				categoriaTecnica);
	}

	/**
	 * 1. Inicia la acci�n que no se puede revertir o cambiar.
	 * 2. Verifique que se presente una solicitud para confirmar la acci�n seleccionada.
	 * 3. Verifique que la acci�n se pueda confirmar y cancelar
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionConfirmacionAccionNoReversible = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Solicitud de confirmaci�n de acci�n seleccionada.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cuando se deba ejecutar una acci�n que no se pueda deshacer debe aparecer un dialogo de confirmaci�n al usuario para que este confirma la acci�n.",
				"Desarrolle el sitio para que cuando se deba realizar una acci�n que no se pueda deshacer siempre tenga la necesidad de ser confirmada por el usuario la misma.");
		comprobacionConfirmacionAccionNoReversible.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionConfirmacionAccionNoReversible);
		return resultadoEvaluacionTecnica;
	}

}