package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;


import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;


public class TecnicaG18 extends TecnicaGeneral {

	public TecnicaG18(CategoriaTecnica categoriaTecnica) {
		super(
				"G18",
				"Asegurar que exista una relaci�n de contraste de al menos 4.5: 1 entre el texto (y las im�genes de texto) y el fondo detr�s del texto.",
				"El objetivo de esta t�cnica es garantizar que los usuarios puedan leer el texto que se presenta sobre un fondo. Para el Criterio de Conformidad 1.4.3, esta t�cnica describe la relaci�n de contraste m�nima para el texto que es menor que 18 puntos (si no es en negrita) y menor que 14 puntos (si es negrita). Para el Criterio de Conformidad 1.4.5, esta t�cnica relaja el requisito de relaci�n de contraste de 7: 1 para textos de al menos 18 puntos (si no son negrita) o al menos 14 puntos (si son negrita).", 
				categoriaTecnica);
	}

	/**
	 * 1.	Mida la luminancia relativa de cada letra (a menos que sean todas uniformes) usando la f�rmula:
	 * 		L = 0.2126 * R + 0.7152 * G + 0.0722 * B donde R, G y B se definen como:
	 * 			if R sRGB <= 0.03928 then R = R sRGB /12.92 else R = ((R sRGB +0.055)/1.055) ^ 2.4
	 * 			if G sRGB <= 0.03928 then G = G sRGB /12.92 else G = ((G sRGB +0.055)/1.055) ^ 2.4
	 * 			if B sRGB <= 0.03928 then B = B sRGB /12.92 else B = ((B sRGB +0.055)/1.055) ^ 2.4 
	 * 		y R sRGB, G sRGB y B sRGB se definen como:
	 * 			R sRGB = R 8bit /255
	 * 			G sRGB = G 8bit /255
	 * 			B sRGB = B 8bit /255
	 * 2.	Mida la luminancia relativa de los p�xeles de fondo inmediatamente al lado de la letra usando la misma f�rmula.
	 * 3.	Calcule la relaci�n de contraste usando la siguiente f�rmula.
	 * 			(L1 + 0.05) / (L2 + 0.05), donde
	 * 				L1 es la luminancia relativa del encendedor de los colores de fondo o de primer plano, y
	 * 				L2 es la luminancia relativa del m�s oscuro de los colores de primer plano o de fondo.
	 * 4.	Compruebe que la relaci�n de contraste sea igual o superior a 4.5:1
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContrasteTextoFondo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Contraste entre texto e im�genes de texto y el fondo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"El contraste entre el texto o las im�genes de texto y el fondo debe ser de 5.4:1.",
				"Aseg�rate que el contraste entre los textos y el fondo mantenga la relaci�n de 5.4:1.");
		comprobacionContrasteTextoFondo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContrasteTextoFondo);
		return resultadoEvaluacionTecnica;
	}
	
}