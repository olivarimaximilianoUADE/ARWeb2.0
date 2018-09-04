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
				"El objetivo de esta técnica es ayudar a los usuarios con discapacidades cognitivas, ceguera y pérdida de visión a comprender qué sucederá cuando interactúen con una función en una página web. Si hay diferentes etiquetas en los componentes de la interfaz de usuario (es decir, elementos, enlaces, objetos JavaScript, etc.) que tienen la misma función, el usuario no sabrá que se encontró con un componente con la misma función y no sabrá qué esperar. Esto podría conducir a muchos errores innecesarios. También se recomienda aplicar este enfoque de etiquetado coherente en todo el sitio web.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que cada componente esté asociado con el texto que lo identifica (es decir, etiqueta, nombre o texto alternativo).
	 * 2. Compruebe que este texto asociado sea idéntico para cada componente de interfaz de usuario con la misma función.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEtiquetadoElementos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Etiquetado de elementos consistente para contenido de misma funcionalidad.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los controles con la misma funcionalidad tengan etiquetas, nombres y alternativas de texto consistentes.",
				"Usar etiquetas, nombres y alternativas de texto consistentes para elementos que tengan la misma funcionalidad y de esta forma hacer que las perdonas con visón reducida sepan que sucederá cuando interactuen con cada funcionalidad.");
		comprobacionEtiquetadoElementos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEtiquetadoElementos);
		return resultadoEvaluacionTecnica;
	}

}
