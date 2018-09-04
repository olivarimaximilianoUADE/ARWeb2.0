package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG99 extends TecnicaGeneral {

	public TecnicaG99(CategoriaTecnica categoriaTecnica) {
		super(
				"G99",
				"Proporcionar la capacidad de recuperar información eliminada.",
				"Cuando una aplicación web ofrece la capacidad de eliminar información, el servidor puede proporcionar un medio para recuperar información que un usuario borró por error. Un enfoque es retrasar la eliminación de los datos simplemente marcándolos para su eliminación o moviéndolos a un área de retención (como un bote de basura) y esperando algún tiempo antes de eliminarlos realmente. Durante este período de tiempo, el usuario puede solicitar que se restauren los datos o puede recuperarlos del área de espera. Otro enfoque es registrar todas las transacciones de eliminación de tal forma que los datos se puedan restaurar si lo solicita el usuario, como en el historial de edición almacenado por wikis y aplicaciones de control de origen. La información recuperable que se almacena debe ser la que se necesitaría. para corregir la transacción.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar la funcionalidad que permite eliminar contenido.
	 * 2. Eliminar contenido e intentar recuperarlo.
	 * 3. Verifica si se puede recuperar la información eliminada.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRecuperarContenidoEliminado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Recuperar contenido eliminado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al eliminar contenido del sitio este se puede recuperar posteriormente por completo.",
				"Cuando una aplicación web ofrece la capacidad de eliminar información, el servidor debe proporcionar un medio para recuperar la información eliminada por el usuario.");
		comprobacionRecuperarContenidoEliminado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRecuperarContenidoEliminado);
		return resultadoEvaluacionTecnica;
	}

}