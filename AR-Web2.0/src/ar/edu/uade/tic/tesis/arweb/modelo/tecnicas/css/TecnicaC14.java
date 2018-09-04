package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC14 extends TecnicaCSS {

	public TecnicaC14(CategoriaTecnica categoriaTecnica) {
		super(
				"C14",
				"Uso de unidades em para tamaños de fuente.",
				"El objetivo de esta técnica es especificar el tamaño de letra del texto en unidades em para que los agentes de usuario puedan escalar contenido de manera efectiva. Como el em es una propiedad de la fuente, se amplía a medida que la fuente cambia de tamaño. Si se especifica un tamaño de letra para el elemento del cuerpo, todos los demás elementos heredan ese valor, a menos que sea anulado por un selector más específico.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que el valor de la propiedad CSS que define el tamaño de la fuente se expresa en unidades em.
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
						"Verificar que el valor de la propiedad CSS que define el tamaño de la fuente este expresado en unidades \"em\".",
						"Especificar el tamaño de la fuente del texto en unidades \"em\" permite que el contenido se escale a los navegadores de manera efectiva.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}