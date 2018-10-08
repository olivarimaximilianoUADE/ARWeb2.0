package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC31 extends TecnicaCSS {

	public TecnicaC31(CategoriaTecnica categoriaTecnica) {
		super(
				"C31",
				"Usando CSS Flexbox para hacer reflujo de contenido	.",
				"El objetivo de esta técnica es poder presentar el contenido sin introducir una barra de desplazamiento horizontal en un ancho equivalente a 320 píxeles CSS, o una barra de desplazamiento vertical a una altura equivalente a 256 píxeles CSS para texto destinado a desplazarse horizontalmente. Esto se hace utilizando técnicas de diseño que se adaptan al espacio de la ventana gráfica disponible." +
				"\r\n" + 
				"Los diseños de Flexbox definen regiones de diseño que se reproducen según sea necesario para mostrar la región en la pantalla. Aunque el diseño exacto varía, la relación de los elementos y el orden de lectura siguen siendo los mismos cuando se hacen correctamente. Esta es una forma efectiva de crear diseños que se presentan bien en diferentes dispositivos y para usuarios con diferentes preferencias de zoom.", 
				categoriaTecnica);
	}

	/**
	 * 1. Muestre la página web en un agente de usuario con un 400% de zoom y configure las dimensiones de la ventana gráfica (en píxeles CSS) a 1280 de ancho y 1024 de alto.
	 * 2. Acercar en un 400%.
	 * 3. Para leer el contenido horizontalmente, verifique que todo el contenido y la funcionalidad estén disponibles sin desplazamiento horizontal.
	 * 4. Para leer el contenido verticalmente, verifique que todo el contenido y la funcionalidad estén disponibles sin desplazamiento vertical.
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
						"Verificar que el sitio web se pueda leer el contenido sin barras de desplazamiento horizontal y vertical cuando se tenga un zoom de 400% y la ventana gráfica este configurada en 1280 píxeles de ancho y 1024 de alto.",
						"Utilizar la técnica css de Flexbox para hacer un reflujo del contenido de modo de poder presentarlo sin introducir una barra de desplazamiento horrizontal en un ancho de 320 píxeles, o una barra de desplazamiento vertical a una altura de 256 píxeles.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
	
}
