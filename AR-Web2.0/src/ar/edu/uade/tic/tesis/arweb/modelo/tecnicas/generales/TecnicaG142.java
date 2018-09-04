package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG142 extends TecnicaGeneral {

	public TecnicaG142(CategoriaTecnica categoriaTecnica) {
		super(
				"G142", 
				"Usar una tecnología que tiene agentes de usuario comúnmente disponibles que admiten zoom.",
				"El objetivo de esta técnica es garantizar que el contenido se pueda escalar uniformemente utilizando una tecnología web respaldada por agentes de usuario que cambian el tamaño del texto a través de una herramienta de Zoom. El contenido creado en tecnologías respaldadas por agentes de usuarios que pueden escalar el contenido de manera uniforme (es decir, ampliar el contenido) cumple este Criterio de Conformidad. Debido a que esta técnica depende completamente de la funcionalidad del agente de usuario, es fundamental probarla con una amplia variedad de agentes de usuario. Esta técnica requiere que la función de zoom preserve todas las relaciones espaciales en la página y que toda la funcionalidad continúe disponible.", 
				categoriaTecnica);
	}

	/**
	 * 1. Mostrar contenido en un agente de usuario
	 * 2. Zoom de contenido al 200%
	 * 3. Verifique si todo el contenido y la funcionalidad están disponibles
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEscalabilidadDelSitio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Comprobación de escalabilidad del sitio usando el zoom de agentes de usuario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al cambiar el zoom del navegador todo el contenido se escale y no se pierda contenido.",
				"Diseñar el sitio de forma tal que todo el contenido se puede escalar al cambiar el zoom del navegador y que todo el contenido sea visible siempre.");
		comprobacionEscalabilidadDelSitio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEscalabilidadDelSitio);
		return resultadoEvaluacionTecnica;
	}
	
}