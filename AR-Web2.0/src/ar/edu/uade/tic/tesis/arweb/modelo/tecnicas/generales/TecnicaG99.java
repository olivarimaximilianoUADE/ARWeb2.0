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
				"Proporcionar la capacidad de recuperar informaci�n eliminada.",
				"Cuando una aplicaci�n web ofrece la capacidad de eliminar informaci�n, el servidor puede proporcionar un medio para recuperar informaci�n que un usuario borr� por error. Un enfoque es retrasar la eliminaci�n de los datos simplemente marc�ndolos para su eliminaci�n o movi�ndolos a un �rea de retenci�n (como un bote de basura) y esperando alg�n tiempo antes de eliminarlos realmente. Durante este per�odo de tiempo, el usuario puede solicitar que se restauren los datos o puede recuperarlos del �rea de espera. Otro enfoque es registrar todas las transacciones de eliminaci�n de tal forma que los datos se puedan restaurar si lo solicita el usuario, como en el historial de edici�n almacenado por wikis y aplicaciones de control de origen. La informaci�n recuperable que se almacena debe ser la que se necesitar�a. para corregir la transacci�n.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar la funcionalidad que permite eliminar contenido.
	 * 2. Eliminar contenido e intentar recuperarlo.
	 * 3. Verifica si se puede recuperar la informaci�n eliminada.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRecuperarContenidoEliminado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Recuperar contenido eliminado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al eliminar contenido del sitio este se puede recuperar posteriormente por completo.",
				"Cuando una aplicaci�n web ofrece la capacidad de eliminar informaci�n, el servidor debe proporcionar un medio para recuperar la informaci�n eliminada por el usuario.");
		comprobacionRecuperarContenidoEliminado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRecuperarContenidoEliminado);
		return resultadoEvaluacionTecnica;
	}

}