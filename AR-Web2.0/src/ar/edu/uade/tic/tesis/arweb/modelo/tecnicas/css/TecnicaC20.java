package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC20 extends TecnicaCSS {

	public TecnicaC20(CategoriaTecnica categoriaTecnica) {
		super(
				"C20",
				"Usar medidas relativas para establecer el ancho de las columnas para que las líneas tengan un promedio de 80 caracteres o menos cuando se cambie el tamaño del navegador.",
				"El objetivo de esta técnica es garantizar que el CSS se use de forma tal que los usuarios puedan ver el contenido de tal forma que la longitud de la línea pueda tener un promedio de 80 caracteres o menos. Esto hace posible que los usuarios con ciertas discapacidades de lectura o visión tengan problemas para mantener su lugar al leer largas líneas de texto para ver e interactuar con el contenido de manera más eficiente. Esta técnica también permite que el ancho de la columna se ensanche a medida que aumenta el tamaño de la fuente, lo que reducirá la posibilidad de recorte a medida que aumente el tamaño del texto.", 
				categoriaTecnica);
	}

	/**
	 *1. Pruebe para ver que las columnas estén definidas en unidades relativas.
	 *2. Compruebe que la longitud de la línea se puede establecer en 80 caracteres o menos cambiando el tamaño de la ventana del navegador.
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
						"Verificar que el ancho de las columnas estan definidas con valores relativos y que la longitud de la línea de texto permite establecer 80 caracteres o menos independientemente del tamaño de la ventana del navegador.",
						"El CSS se debe usar de forma tal que los usuarios puedan ver el contenido de tal forma que la longitud de la línea pueda tener un promedio de 80 caracteres o menos.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}