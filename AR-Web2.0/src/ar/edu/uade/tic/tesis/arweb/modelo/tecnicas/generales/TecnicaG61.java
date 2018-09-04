package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG61 extends TecnicaGeneral {

	public TecnicaG61(CategoriaTecnica categoriaTecnica) {
		super(
				"G61", 
				"Presentar componentes repetidos en el mismo orden relativo cada vez que aparecen.", 
				"El objetivo de esta técnica es facilitar el uso del contenido haciendo que la ubicación de los componentes repetidos sea más predecible. Esta técnica ayuda a mantener un diseño o presentación consistente entre las páginas web al presentar los componentes que se repiten en estas unidades web en el mismo orden relativo cada vez que aparecen. Se pueden insertar otros componentes entre ellos, pero su orden relativo no se cambia. Esta técnica también se aplica a los componentes de navegación que se repiten. Las páginas web a menudo contienen un menú de navegación u otro componente de navegación que permite al usuario saltar a otras páginas web. Esta técnica hace que la ubicación de los componentes de navegación sea más predecible al presentar los enlaces o referencias programáticas dentro de un componente de navegación en el mismo orden relativo cada vez que se repite el componente de navegación. Se pueden eliminar o insertar otros enlaces entre los existentes, por ejemplo, para permitir la navegación dentro de una subsección de un conjunto de páginas web, pero el orden relativo no se cambia.",
				categoriaTecnica);
	}

	/**
	 * 1. Enumere los componentes que se repiten en cada página web en un conjunto de páginas web (por ejemplo, en cada página de un sitio web).
	 * 2. Para cada componente, verifique que aparezca en el mismo orden relativo con respecto a otros componentes repetidos en cada página web donde aparece.
	 * 3. Para cada componente de navegación, verifique que los enlaces o referencias programáticas estén siempre en el mismo orden relativo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenComponentesRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Componentes repetidos siempre en el mismo orden.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los componentes que se repetin en un sitio web aparezcan siempre en la misma posición en todas las páginas del sitio.",
				"Todos los componentes que se repetin en todo el sitio web como ser logos, barras de busquedas, menues; deben siempre aparecer en la misma posición en todos las páginas que lo componen.");
		comprobacionOrdenComponentesRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenComponentesRepetidos);
		return resultadoEvaluacionTecnica;
	}

}