package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH70 extends TecnicaHTML {

	public TecnicaH70(CategoriaTecnica categoriaTecnica) {
		super(
				"H70",
				"Usar el elemento frame para agrupar bloques de material repetido.", 
				"",
				categoriaTecnica);
	}

	/**
	 * Si la página web utiliza elementos frame para organizar el contenido:
	 * 1. Verificar que bloques de contenido repetido se organizan en elementos frame separados.
	 * 2. Verificar que los elementos frame con contenido repetido aparecen en la misma ubicación dentro de cada elemento frameset.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBloquesContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Bloques de contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si la página web utiliza elementos \"frame\" para organizar el contenido: Verificar que bloques de contenido repetidos se organizan en elementos \"frame\" separados.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos \"frame\".");
		List<Element> listaFrame = this.getParseador().getElementos(HTMLElementName.FRAME);
		if (listaFrame.size()>0)
			comprobacionBloquesContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBloquesContenido);
		return resultadoEvaluacionTecnica;
	}

}
