package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG9 extends TecnicaGeneral {
	
	public TecnicaG9(CategoriaTecnica categoriaTecnica) {
		super(
				"G9", 
				"Crear subt�tulos para medios sincronizados en vivo.", 
				"El objetivo de esta t�cnica es permitir que los usuarios que no pueden escuchar puedan acceder a transmisiones de medios sincronizados en tiempo real. Es m�s dif�cil crear t�tulos precisos en tiempo real porque hay poco tiempo para corregir errores o para escuchar por segunda vez o consultar a alguien para asegurarse de que las palabras se reproduzcan con precisi�n. Tambi�n es m�s dif�cil simplificar o parafrasear informaci�n si fluye demasiado r�pido.", 
				categoriaTecnica);
	}

	/**
	 * 1.Verifique que haya un procedimiento y una pol�tica establecida para garantizar que los subt�tulos se entreguen en tiempo real. 
	 */
	
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subt�tulos para medios sincronizados en vivo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verifique que haya un procedimiento y una pol�tica establecidos para garantizar que los subt�tulos se entreguen en tiempo real.",
				"Ofrece sub�tulos para sordos de forma cerrada  (disponibles en un archivo externo, un programa auxiliar los presenta junto al v�deo).");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}

}
