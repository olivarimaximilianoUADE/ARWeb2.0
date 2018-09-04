package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG197 extends TecnicaGeneral {

	public TecnicaG197(CategoriaTecnica categoriaTecnica) {
		super(
				"G197",
				"Usar etiquetas, nombres y alternativas de texto consistentemente para contenido que tiene la misma funcionalidad.", 
				"El objetivo de esta t�cnica es ayudar a los usuarios con discapacidades cognitivas, ceguera y p�rdida de visi�n a comprender qu� suceder� cuando interact�en con una funci�n en una p�gina web. Si hay diferentes etiquetas en los componentes de la interfaz de usuario (es decir, elementos, enlaces, objetos JavaScript, etc.) que tienen la misma funci�n, el usuario no sabr� que se encontr� con un componente con la misma funci�n y no sabr� qu� esperar. Esto podr�a conducir a muchos errores innecesarios. Tambi�n se recomienda aplicar este enfoque de etiquetado coherente en todo el sitio web.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que cada componente est� asociado con el texto que lo identifica (es decir, etiqueta, nombre o texto alternativo).
	 * 2. Compruebe que este texto asociado sea id�ntico para cada componente de interfaz de usuario con la misma funci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEtiquetadoElementos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Etiquetado de elementos consistente para contenido de misma funcionalidad.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los controles con la misma funcionalidad tengan etiquetas, nombres y alternativas de texto consistentes.",
				"Usar etiquetas, nombres y alternativas de texto consistentes para elementos que tengan la misma funcionalidad y de esta forma hacer que las perdonas con vis�n reducida sepan que suceder� cuando interactuen con cada funcionalidad.");
		comprobacionEtiquetadoElementos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEtiquetadoElementos);
		return resultadoEvaluacionTecnica;
	}

}
