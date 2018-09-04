package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG126 extends TecnicaGeneral {

	public TecnicaG126(CategoriaTecnica categoriaTecnica) {
		super(
				"G126",
				"Proporcionar una lista de enlaces a todas las dem�s p�ginas web.",
				"El objetivo de esta t�cnica es proporcionar una lista de enlaces a todas las p�ginas web en el conjunto de cada p�gina web. Esta t�cnica solo es efectiva para peque�os conjuntos de p�ginas web; si la lista de enlaces es m�s larga que el resto del contenido de la p�gina web, puede hacer que la p�gina web sea m�s dif�cil de entender y usar.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que cada p�gina web contenga una lista de enlaces a otras p�ginas web en el sitio.
	 * 2. Verifique que los enlaces en la lista conducen a las p�ginas web correspondientes.
	 * 3. Verifique que la lista contenga un enlace para cada p�gina web en el sitio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlacesPaginasSitioWeb = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Lista de enlaces a todas las p�ginas del sitio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe una lista con los enlaces a todas las p�ginas del sitio web.",
				"Al realizar un sitio web se deben incluir una lista con los enlaces a todas las p�ginas que forman el sitio a fin que le resulte mas c�modo al usuario navegar por el mismo.");
		comprobacionEnlacesPaginasSitioWeb.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlacesPaginasSitioWeb);
		return resultadoEvaluacionTecnica;
	}

}