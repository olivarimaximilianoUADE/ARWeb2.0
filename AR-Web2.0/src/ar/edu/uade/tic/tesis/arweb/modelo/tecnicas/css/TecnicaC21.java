package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC21 extends TecnicaCSS {

	public TecnicaC21(CategoriaTecnica categoriaTecnica) {
		super(
				"C21",
				"Especificar el espaciado de l�nea en CSS.",
				"Muchas personas con discapacidades cognitivas tienen problemas para rastrear l�neas de texto cuando un bloque de texto tiene un solo espacio. Proporcionar un espaciado entre 1.5 y 2 les permite comenzar una nueva l�nea m�s f�cilmente una vez que hayan terminado la anterior.", 
				categoriaTecnica);
	}

	/**
	 * 1. Abrir contenido en un navegador.
	 * 2. Compruebe que el espacio entre las l�neas en bloques de texto est� entre 1.5 y 2.
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
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el el espacio en las l�neas de bloques de texto est� entre 1.5 y 2.",
						"Especificar el esp�cio entre los bloques de texto entre 1.5 y 2 para que las personas con discapacidades cognitivas no tengan problemas para raterar l�neas de texto.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}