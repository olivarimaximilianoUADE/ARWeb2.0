package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG131 extends TecnicaGeneral {

	public TecnicaG131(CategoriaTecnica categoriaTecnica) {
		super(
				"G131", 
				"Proporcionar etiquetas descriptivas.", 
				"El objetivo de esta técnica es para asegurar que la etiqueta de cualquier componente interactivo dentro del contenido Web hace que el propósito del componente claro. Utilizando las técnicas a tecnologías apropiadas para las tecnologías para asociar etiquetas con controles interactivos permite la tecnología de asistencia para reconocer la etiqueta y la presentan al usuario, por lo tanto permitiendo al usuario identificar el propósito del control. La etiqueta también se puede usar para incluir texto o se requiere un símbolo de texto que indica que la entrada.", 
				categoriaTecnica);
	}

	/**
	 * Para cada componente de interfaz en el contenido:
	 * 1. Identificar el propósito del componente de interfaz.
	 * 2. Verificar que cualquier etiqueta necesaria está presente.
	 * 3. Verificar que cada etiqueta hace que el propósito del componente clara.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionComponentesConEtiquetasDescriptivas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Componentes con etiquetas descriptivas.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada componente de interfaz en el contenido: Verificar que cada etiqueta hace que el propósito del componente sea claro.",
				"Ofrece etiquetas \"label\" descriptivas a cada componente de interfaz en el contenido.");
		comprobacionComponentesConEtiquetasDescriptivas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionComponentesConEtiquetasDescriptivas);
		return resultadoEvaluacionTecnica;
	}

}