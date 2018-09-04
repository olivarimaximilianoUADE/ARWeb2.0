package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC8 extends TecnicaCSS {

	public TecnicaC8(CategoriaTecnica categoriaTecnica) {
		super(
				"C8",
				"Usar la propiedad letter-spacing de CSS para controlar el espaciado dentro de una palabra.", 
				"El objetivo de esta técnica es demostrar cómo la apariencia visual del espaciado textual se puede mejorar a través de hojas de estilo, manteniendo la secuencia de texto significativo. El letter-spacing CSS ayuda a los desarrolladores controlar la cantidad de espacio en blanco entre caracteres. Esto se recomienda para controlar en lugar de un espacio en blanco, ya que los caracteres en blanco pueden cambiar el significado y la pronunciación de la palabra.",
				categoriaTecnica);
	}

	/**
	 * En cada palabra que no parece tener un espaciado estándar de sus caracteres:
	 * 1. Verificar que la propiedad letter-spacing de CSS fue utilizada para controlar el espaciado.
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
						"En cada palabra que no parece tener un espaciado estándar de sus caracteres: Verificar que la propiedad letter-spacing de CSS fue utilizada para controlar el espaciado.",
						"Ordena todos los contenidos de la página web en un orden que tenga sentido y maquétalos controlando el espacio entre letras mediante CSS.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}