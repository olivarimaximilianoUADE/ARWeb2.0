package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG17 extends TecnicaGeneral {

	public TecnicaG17(CategoriaTecnica categoriaTecnica) {
		super(
				"G17",
				"Asegurar que exista una relación de contraste de al menos 7:1 entre el texto (y las imágenes de texto) y el fondo detrás del texto.",
				"El objetivo de esta técnica es garantizar que los usuarios puedan leer el texto que se presenta sobre un fondo. Esta técnica va más allá de la técnica de contraste 4.5: 1 para proporcionar un mayor nivel de contraste y facilitar la lectura a las personas con baja visión. Si el fondo es de un color sólido (o todo negro o blanco), la relación de contraste del texto se puede mantener asegurándose de que cada una de las letras de texto tenga una relación de contraste de 7: 1 con el fondo. Si el fondo o las letras varían en luminancia relativa (o están modeladas), el fondo alrededor de las letras se puede elegir o sombrear para que las letras mantengan una relación de contraste de 7: 1 con el fondo detrás de ellas, incluso si no tienen esa relación de contraste con todo el fondo.", 
				categoriaTecnica);
	}

	/**
	 * 1.	Mida la luminancia relativa de cada letra (a menos que sean todas uniformes) usando la fórmula:
	 * 		L = 0.2126 * R + 0.7152 * G + 0.0722 * B donde R, G y B se definen como:
	 * 			if R sRGB <= 0.03928 then R = R sRGB /12.92 else R = ((R sRGB +0.055)/1.055) ^ 2.4
	 * 			if G sRGB <= 0.03928 then G = G sRGB /12.92 else G = ((G sRGB +0.055)/1.055) ^ 2.4
	 * 			if B sRGB <= 0.03928 then B = B sRGB /12.92 else B = ((B sRGB +0.055)/1.055) ^ 2.4 
	 * 		y R sRGB, G sRGB y B sRGB se definen como:
	 * 			R sRGB = R 8bit /255
	 * 			G sRGB = G 8bit /255
	 * 			B sRGB = B 8bit /255
	 * 2.	Mida la luminancia relativa de los píxeles de fondo inmediatamente al lado de la letra usando la misma fórmula.
	 * 3.	Calcule la relación de contraste usando la siguiente fórmula.
	 * 			(L1 + 0.05) / (L2 + 0.05), donde
	 * 				L1 es la luminancia relativa del encendedor de los colores de fondo o de primer plano, y
	 * 				L2 es la luminancia relativa del más oscuro de los colores de primer plano o de fondo.
	 * 4.	Compruebe que la relación de contraste sea igual o superior a 7:1
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContrasteTextoFondo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Contraste entre texto e imágenes de texto y el fondo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"El contraste entre el texto o las imágenes de texto y el fondo debe ser de 7:1.",
				"Asegúrate que el contraste entre los textos y el fondo mantenga la relación de 7:1.");
		comprobacionContrasteTextoFondo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContrasteTextoFondo);
		return resultadoEvaluacionTecnica;
	}
	
}