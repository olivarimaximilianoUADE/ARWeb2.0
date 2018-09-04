package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG19 extends TecnicaGeneral {

	public TecnicaG19(CategoriaTecnica categoriaTecnica) {
		super(
				"G19",
				"Asegurar que ningún componente del contenido parpadea más de tres veces en un periodo de 1 segundo.",
				"El objetivo de esta técnica es evitar parpadear a “rates” que son conocidos por causar convulsiones si los destellos son luminosas y lo suficientemente grande. Debido a que algunos usuarios pueden estar usando ampliadores de pantalla, esta técnica limita el parpadeo del contenido tamaño a no más de tres destellos en cualquier período de 1 segundo.", 
				categoriaTecnica);
	}

	/**
	 * 1.	Verificar que no hay más de tres destellos durante cualquier periodo de 1 segundo. 
	 * 2.	Si hay tres destellos, verificar que el estado de la luz / oscuridad al final del periodo de 1 segundo es el mismo que al principio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral límite.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si hay tres destellos, verificar que el estado de la luz / oscuridad al final del periodo de 1 segundo es el mismo que al principio.",
				"Asegúrate que ningún componente del contenido destellea más de 3 veces por segundo.");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}