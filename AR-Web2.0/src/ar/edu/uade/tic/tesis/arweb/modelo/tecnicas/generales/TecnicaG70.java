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
				"Proporcionar una funci�n para buscar un diccionario en l�nea.",
				"El objetivo de esta t�cnica es proporcionar la definici�n de palabras, frases, jerga o expansiones de abreviaciones mediante la adici�n de un mecanismo para acceder a un diccionario en l�nea de la p�gina web. Esta t�cnica usa los recursos existentes en la Web para proporcionar la definici�n en lugar de requerir que el autor cree un glosario u otro mecanismo dentro del sitio. Al proporcionar acceso desde dentro de la p�gina web, un usuario puede ubicar f�cilmente la definici�n deseada. Esta t�cnica solo se puede usar si el diccionario en l�nea devuelve la definici�n correcta.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra, frase o abreviatura que se definir�:
	 * 1. Compruebe que exista un mecanismo dentro de la p�gina web para buscar la palabra, frase o abreviatura a trav�s de un diccionario en l�nea.
	 * 2. Verifique que el resultado de la b�squeda del diccionario para la palabra, frase o abreviatura sea la definici�n correcta.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDiccionarioEnLinea = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Presencia de un diccionario en l�nea.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un enlace a un diccionario en l�nea para la b�squeda de palabras, frases o abreviaturas.",
				"Aseg�rate que el sitio cuente con un enlace a un diccionario en l�nea para la b�squeda de palabras, frases o abreviaturas.");
		comprobacionDiccionarioEnLinea.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDiccionarioEnLinea);
		return resultadoEvaluacionTecnica;
	}

}