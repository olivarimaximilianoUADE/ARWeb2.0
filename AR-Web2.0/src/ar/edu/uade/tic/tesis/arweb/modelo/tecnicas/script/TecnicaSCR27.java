package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR27 extends TecnicaSCR {

	public TecnicaSCR27(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR27",
				"Reordenar secciones de página usando el Modelo de Objetos de Documento.",
				"El objetivo de esta técnica es proporcionar un mecanismo para reordenar componentes que sea altamente utilizable y accesible. Los dos mecanismos más comunes para reordenar son enviar a los usuarios a una página de configuración donde pueden numerar componentes o permitirles arrastrar y soltar componentes a la ubicación deseada. El método de arrastrar y soltar es mucho más útil, ya que permite al usuario organizar los elementos en su lugar, uno a la vez, y obtener una idea de los resultados. Desafortunadamente, arrastrar y soltar depende del uso de un mouse. Esta técnica permite a los usuarios interactuar con un menú en los componentes para reordenarlos en su lugar de una manera independiente del dispositivo. Se puede usar en lugar de, o junto con la funcionalidad de reordenar arrastrar y soltar.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encuentre todos los componentes en la Unidad Web que pueden reordenarse mediante arrastrar y soltar.
	 * 2. Compruebe que también hay un mecanismo para reordenarlos mediante el uso de menús en listas de enlaces.
	 * 3. Verifique que los menús estén dentro de los artículos pedidos en el DOM.
	 * 4. Compruebe que las secuencias de comandos para reordenar solo se activen desde el evento onclick de los enlaces.
	 * 5. Compruebe que los artículos se reordenan en DOM, no solo visualmente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/javascript"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validación de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que si el sitio cuenta con secciones que se pueden reordenar usando \"arrastrar y soltar\", también exista un mecanismo para reordenarlos mediante el uso de menús en listas de enlaces.",
						"Cuando el sitio posea la funcionalidad de ordenar las secciones del sitio mediante la técnica de \"arrastrar y soltar\", debe tener también un mecanismo para ordenarlos mediante el uso de menúes en lista de enlaces; de esta manera la función también se puede utilizar en dispositivos que no poseen mouse.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}