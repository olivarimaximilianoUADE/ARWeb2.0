package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC18 extends TecnicaCSS {

	public TecnicaC18(CategoriaTecnica categoriaTecnica) {
		super(
				"C18",
				"Usar reglas de margen CSS y de relleno en lugar de imágenes de espaciador de diseño de la disposición.",
				"A veces los diseñadores Web utilizan las imágenes de espaciado (generalmente de 1x1 píxeles, GIF transparentes) para un mejor control sobre el diseño, por ejemplo, en tablas o para indentar un párrafo. Sin embargo, Cascading Style Sheets (CSS) permiten un control suficiente sobre el diseño para sustituir las imágenes de espaciado. Las propiedades CSS para márgenes y el relleno se pueden utilizar solos o en combinación para controlar la disposición. Las propiedades del margen (‘margin- top ' , ' margin-right ' , ' margin-bottom ' , 'margin- left' , y la abreviatura «margin» ) se puede utilizar en cualquier elemento que se muestra como un bloque; que añaden espacio en la parte exterior de un elemento. Las propiedades de relleno ( 'padding -top ' , ' padding-right ' , ' padding-bottom ' , 'padding - left' y la abreviatura 'padding ' ) se pueden utilizar en cualquier elemento; ellos agregan el espacio interior del elemento.", 
				categoriaTecnica);
	}

	/**
	 *
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
						"Verificar que se usan reglas de margen CSS y de relleno en lugar de imágenes de espaciador de diseño de la disposición.",
						"Formatea la página con las reglas de caja de CSS en lugar de con imágenes.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}