package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG70 extends TecnicaGeneral {

	public TecnicaG70(CategoriaTecnica categoriaTecnica) {
		super(
				"G70",
				"Proporcionar una función para buscar un diccionario en línea.",
				"El objetivo de esta técnica es proporcionar la definición de palabras, frases, jerga o expansiones de abreviaciones mediante la adición de un mecanismo para acceder a un diccionario en línea de la página web. Esta técnica usa los recursos existentes en la Web para proporcionar la definición en lugar de requerir que el autor cree un glosario u otro mecanismo dentro del sitio. Al proporcionar acceso desde dentro de la página web, un usuario puede ubicar fácilmente la definición deseada. Esta técnica solo se puede usar si el diccionario en línea devuelve la definición correcta.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra, frase o abreviatura que se definirá:
	 * 1. Compruebe que exista un mecanismo dentro de la página web para buscar la palabra, frase o abreviatura a través de un diccionario en línea.
	 * 2. Verifique que el resultado de la búsqueda del diccionario para la palabra, frase o abreviatura sea la definición correcta.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDiccionarioEnLinea = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Presencia de un diccionario en línea.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un enlace a un diccionario en línea para la búsqueda de palabras, frases o abreviaturas.",
				"Asegúrate que el sitio cuente con un enlace a un diccionario en línea para la búsqueda de palabras, frases o abreviaturas.");
		comprobacionDiccionarioEnLinea.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDiccionarioEnLinea);
		return resultadoEvaluacionTecnica;
	}

}