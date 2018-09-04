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
				"Proporcionar una lista de enlaces a todas las demás páginas web.",
				"El objetivo de esta técnica es proporcionar una lista de enlaces a todas las páginas web en el conjunto de cada página web. Esta técnica solo es efectiva para pequeños conjuntos de páginas web; si la lista de enlaces es más larga que el resto del contenido de la página web, puede hacer que la página web sea más difícil de entender y usar.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que cada página web contenga una lista de enlaces a otras páginas web en el sitio.
	 * 2. Verifique que los enlaces en la lista conducen a las páginas web correspondientes.
	 * 3. Verifique que la lista contenga un enlace para cada página web en el sitio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlacesPaginasSitioWeb = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Lista de enlaces a todas las páginas del sitio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe una lista con los enlaces a todas las páginas del sitio web.",
				"Al realizar un sitio web se deben incluir una lista con los enlaces a todas las páginas que forman el sitio a fin que le resulte mas cómodo al usuario navegar por el mismo.");
		comprobacionEnlacesPaginasSitioWeb.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlacesPaginasSitioWeb);
		return resultadoEvaluacionTecnica;
	}

}