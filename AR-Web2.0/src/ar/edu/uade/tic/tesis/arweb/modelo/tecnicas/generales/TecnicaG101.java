package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG101 extends TecnicaGeneral {

	public TecnicaG101(CategoriaTecnica categoriaTecnica) {
		super(
				"G101",
				"Proporcionar la definición de una palabra o frase usada de una manera inusual o restringida.", 
				"\r\n" + 
				"El objetivo de esta técnica es proporcionar una definición para cualquier palabra utilizada de una manera inusual o restringida.\r\n" + 
				"\r\n" + 
				"Una palabra se usa de forma inusual o restringida cuando:\r\n" + 
				"\r\n" + 
				"los diccionarios dan varias definiciones de la palabra, pero se debe usar una definición específica para comprender el contenido;\r\n" + 
				"\r\n" + 
				"se debe usar una definición específica para comprender el contenido y los diccionarios que listan esa definición como rara, arcaica, obsoleta, etc .;\r\n" + 
				"\r\n" + 
				"el autor crea una nueva definición que debe usarse para comprender el contenido.\r\n" + 
				"\r\n" + 
				"Esta técnica también se puede utilizar para proporcionar definiciones para la jerga, es decir, el vocabulario especializado utilizado en una profesión o campo técnico en particular, y entendido por las personas en ese campo, pero no por personas ajenas al campo.",
				categoriaTecnica);
	}

	/**
	 * Para cada palabra o frase utilizada de forma inusual o restringida:
	 * 1. Compruebe que se proporciona una definición para la palabra o frase
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDefinicionesPalabrasInusualesRestringidas= new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Definición de palabras o frases inusuales o restringidas.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio posee definiciones para palabras que se usan de forma inusual o restringuida al ser espec+ifica de una tematica o jerga ó posee multiples significados.",
				"Se deben crear definiciones para palabras o frases inusuales o de multiple significado a fin de que el usuario pueda comprender correctamente el contenido del sitio.");
		comprobacionDefinicionesPalabrasInusualesRestringidas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDefinicionesPalabrasInusualesRestringidas);
		return resultadoEvaluacionTecnica;
	}

}