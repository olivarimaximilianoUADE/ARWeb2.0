package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;


public class TecnicaC6 extends TecnicaCSS {

	public TecnicaC6(CategoriaTecnica categoriaTecnica) {
		super(
				"C6",
				"Posicionar el contenido basándose en marcado estructural.",
				"El objetivo de esta técnica es demostrar cómo la apariencia visual se puede mejorar a través de las hojas de estilo, manteniendo una presentación significativa cuando las hojas de estilo no se aplican. Usando las propiedades de posicionamiento de CSS2, el contenido puede aparecer en cualquier posición en la ventana gráfica del usuario. Usando elementos estructurales se asegura que el significado del contenido aun se pueda determinar cuando el estilo no está disponible.",
				categoriaTecnica);
	}

	/**
	 * En el contenido que utiliza CSS para posicionamiento:
	 * 1. Eliminar del documento la informacion sobre estilo o deshabilitar el uso de hojas de estilo en el agente usuario.
	 * 2. Verificar que se preservan las relaciones estructurales y el significado del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validación de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar  que se preservan las relaciones estructurales y el significado del contenido al eliminar del documento la información sobre estilo o deshabilitar el uso de hojas de estilo en el agente usuario.",
						"No cambies con CSS el sgnificado del contenido por la forma de ubicar la información.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}