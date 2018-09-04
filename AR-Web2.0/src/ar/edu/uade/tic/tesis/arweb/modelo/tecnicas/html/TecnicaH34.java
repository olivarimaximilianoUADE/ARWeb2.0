package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH34 extends TecnicaHTML {

	public TecnicaH34(CategoriaTecnica categoriaTecnica) {
		super(
				"H34",
				"Usar una marca derecha a izquierda (RLM) o izquierda a derecha (LRM) para mezclar direcciones de texto en una misma línea.",
				"El objetivo de esta técnica es el uso de marcas Unicode derecha a izquierda e izquierda a derecha para sobreescribir el algoritmo bidireccional HTML cuando produce resultados no deseados. Esto puede ser necesario, por ejemplo, al colocar caracteres neutros como espacios o puntuación entre las diferentes ejecuciones de texto direccionales.",
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccionar el código fuente para encontrar lugares donde el texto cambia de dirección.
	 * 2. Cuando el texto cambia de dirección verificar que los caracteres neutros como espacios o puntuación son adyacentes al texto que se presenta en la dirección no predeterminada.
	 * 3. Cuando #2 es verdadera y el algoritmo bidireccional HTML produciría la ubicación incorrecta de los caracteres neutros verificar que los caracteres neutros están seguidos por marcas de Unicode derecha-a-izquierda o izquierda-a-derecha que ubican a los caracteres neutros como parte de los caracteres que los preceden.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Caracteres neutros no son adyacentes al texto que se presentan en la dirección no predeterminada.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cuando el texto cambia de dirección verificar que los caracteres neutros como espacios o puntuación son adyacentes al texto que se presenta en la dirección no predeterminada.",
				"Ordena todos los contenidos de la página web en un orden que tenga sentido y máquetalos usando marcas de Unicode para mezclar texto \"de derecha a izquierda\" y \"de izquierda a derecha\".");
		for (Element elemento: this.getParseador().getElementos()) {
			String atributoDir = elemento.getAttributeValue("dir");
			if ((atributoDir != null) && (!atributoDir.isEmpty())) 
				comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada.procesar(elemento);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada);	
		return resultadoEvaluacionTecnica;
	}

}