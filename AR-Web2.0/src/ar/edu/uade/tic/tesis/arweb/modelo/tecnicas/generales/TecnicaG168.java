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
				"Solicitar confirmación para continuar con la acción seleccionada.", 
				"Esta técnica busca la confirmación por parte del usuario de que la acción seleccionada es su acción deseada. Utilice esta técnica en situaciones donde la acción no se puede deshacer después de que se ha seguido. Esto ayudará a los usuarios a evitar enviar un formulario o eliminar datos por error..",
				categoriaTecnica);
	}

	/**
	 * 1. Inicia la acción que no se puede revertir o cambiar.
	 * 2. Verifique que se presente una solicitud para confirmar la acción seleccionada.
	 * 3. Verifique que la acción se pueda confirmar y cancelar
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionConfirmacionAccionNoReversible = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Solicitud de confirmación de acción seleccionada.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cuando se deba ejecutar una acción que no se pueda deshacer debe aparecer un dialogo de confirmación al usuario para que este confirma la acción.",
				"Desarrolle el sitio para que cuando se deba realizar una acción que no se pueda deshacer siempre tenga la necesidad de ser confirmada por el usuario la misma.");
		comprobacionConfirmacionAccionNoReversible.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionConfirmacionAccionNoReversible);
		return resultadoEvaluacionTecnica;
	}

}