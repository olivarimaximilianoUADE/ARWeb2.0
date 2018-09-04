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
				"El objetivo de esta t�cnica es facilitar el uso del contenido haciendo que la ubicaci�n de los componentes repetidos sea m�s predecible. Esta t�cnica ayuda a mantener un dise�o o presentaci�n consistente entre las p�ginas web al presentar los componentes que se repiten en estas unidades web en el mismo orden relativo cada vez que aparecen. Se pueden insertar otros componentes entre ellos, pero su orden relativo no se cambia. Esta t�cnica tambi�n se aplica a los componentes de navegaci�n que se repiten. Las p�ginas web a menudo contienen un men� de navegaci�n u otro componente de navegaci�n que permite al usuario saltar a otras p�ginas web. Esta t�cnica hace que la ubicaci�n de los componentes de navegaci�n sea m�s predecible al presentar los enlaces o referencias program�ticas dentro de un componente de navegaci�n en el mismo orden relativo cada vez que se repite el componente de navegaci�n. Se pueden eliminar o insertar otros enlaces entre los existentes, por ejemplo, para permitir la navegaci�n dentro de una subsecci�n de un conjunto de p�ginas web, pero el orden relativo no se cambia.",
				categoriaTecnica);
	}

	/**
	 * 1. Enumere los componentes que se repiten en cada p�gina web en un conjunto de p�ginas web (por ejemplo, en cada p�gina de un sitio web).
	 * 2. Para cada componente, verifique que aparezca en el mismo orden relativo con respecto a otros componentes repetidos en cada p�gina web donde aparece.
	 * 3. Para cada componente de navegaci�n, verifique que los enlaces o referencias program�ticas est�n siempre en el mismo orden relativo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenComponentesRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Componentes repetidos siempre en el mismo orden.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los componentes que se repetin en un sitio web aparezcan siempre en la misma posici�n en todas las p�ginas del sitio.",
				"Todos los componentes que se repetin en todo el sitio web como ser logos, barras de busquedas, menues; deben siempre aparecer en la misma posici�n en todos las p�ginas que lo componen.");
		comprobacionOrdenComponentesRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenComponentesRepetidos);
		return resultadoEvaluacionTecnica;
	}

}