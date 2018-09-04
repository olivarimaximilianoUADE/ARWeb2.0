package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG165 extends TecnicaGeneral {

	public TecnicaG165(CategoriaTecnica categoriaTecnica) {
		super(
				"G165", 
				"Usar el indicador de enfoque predeterminado para la plataforma para que los indicadores de enfoque por defecto de alta visibilidad se mantengan.", 
				"Los sistemas operativos tienen una indicación nativa de enfoque, que está disponible en muchos agentes de usuario. La representación predeterminada del indicador de enfoque no siempre es muy visible e incluso puede ser difícil de ver con ciertos fondos. Sin embargo, muchas plataformas permiten al usuario personalizar la representación de este indicador de enfoque. La tecnología de asistencia también puede cambiar la apariencia del indicador de enfoque nativo. Si usa el indicador de enfoque nativo, cualquier configuración de todo el sistema para su visibilidad se transferirá a la página web. Si dibuja su propio indicador de enfoque, por ejemplo, coloreando secciones de la página en respuesta a la acción del usuario, estas configuraciones no se transferirán, y AT generalmente no podrá encontrar su indicador de enfoque.",
				categoriaTecnica);
	}

	/**
	 * 1. Use las funciones de su plataforma para personalizar la apariencia del indicador de enfoque
	 * 2. Tab a través de la página, tomando nota de la ruta del foco
	 * 3. Verifique que el indicador de enfoque para cada control esté visible
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnfoqueDeControles = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Foco en cada elemento del sitio web al recorerlos con tab.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada campo de formulario en la página web: Verificar que el indicador para cada control esté visible.",
				"Ofrece enfoque visible para cada control del sitio web.");
		comprobacionEnfoqueDeControles.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnfoqueDeControles);
		
		return resultadoEvaluacionTecnica;
	}

}