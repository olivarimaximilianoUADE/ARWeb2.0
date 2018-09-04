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

public class TecnicaH97 extends TecnicaHTML {

	public TecnicaH97(CategoriaTecnica categoriaTecnica) {
		super(
				"H97", 
				"La agrupación de enlaces relacionados utilizando el elemento nav.", 
				"El objetivo de esta técnica es agrupar los enlaces de navegación usando el elemento nav. El elemento nav es uno de los varios elementos de seccionamiento en HTML5. El uso de esta marca puede hacer grupos de enlaces mas fáciles de localizar y pasar de largo por los usuarios de tecnología de asistencia tales como los lectores de pantalla. Utilizando las estructuras semánticas permiten que las hojas de estilo personalizado que se utilizan para cambiar la presentación de los grupos de enlaces preservando al mismo tiempo su relación. Cuando el elemento nav se emplea mas de una vez en una página, distinguir los grupos de navegación mediante el uso del atributo aria-label o aria-labelledby. No todos los grupos de enlaces necesitan utilizar el elemento nav parra el marcado. Por ejemplo, los enlaces pueden ser agrupados en otra estructura, tales como listas.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que los enlaces que se agrupan visualmente y representan una sección de la página están encerrados en un elemento nav.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionNavConMenos2Enlaces = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Elementos \"nav\" con menos de dos enlaces.",
				"Verificar que los enlaces que se agrupan visualmente y representan una sección de la página están encerrados en un elemento \"nav\".",
				"Comunica la información y sus relaciones mediantes la estructura de la página web: elemento \"nav\" para agrupar enlaces relacionados.");
		ResultadoEvaluacionTecnicaItem comprobacionNavAgrupanEnlaces = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Elementos \"nav\" agrupan enlaces relacionados.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que los enlaces que se agrupan visualmente y representan una sección de la página están encerrados en un elemento \"nav\".",
				"Comunica la información y sus relaciones mediantes la estructura de la página web: elemento \"nav\" para agrupar enlaces relacionados.");
		for (Element elementoNAV : this.getParseador().getElementos(HTMLElementName.NAV)) {
			List<Element> listaElementosA = elementoNAV.getAllElements(HTMLElementName.A);
			if (listaElementosA.size() < 2)
				comprobacionNavConMenos2Enlaces.procesar(elementoNAV);
			for (Element elementoA : listaElementosA)
				comprobacionNavAgrupanEnlaces.procesar(elementoA);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionNavConMenos2Enlaces);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionNavAgrupanEnlaces);
		return resultadoEvaluacionTecnica;
	}

}