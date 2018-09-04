package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC17 extends TecnicaCSS {

	public TecnicaC17(CategoriaTecnica categoriaTecnica) {
		super(
				"C17",
				"Escalar elementos de formulario que contienen texto.",
				"El objetivo de esta técnica es garantizar que los controles de formulario basados ​​en texto cambien de tamaño cuando se cambie el tamaño del texto en el agente de usuario. Esto permitirá a los usuarios ingresar texto y leer lo que han ingresado en los cuadros de entrada porque el texto se muestra en el tamaño requerido por el usuario. Los controles de formulario basados ​​en texto incluyen cuadros de entrada (texto y área de texto) así como también botones.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ingrese texto en controles de formulario basados ​​en texto que reciben texto ingresado por el usuario.
	 * 2. Aumenta el tamaño del texto del contenido en un 200%.
	 * 3. Verifique que el texto en los controles de formulario basados ​​en texto haya aumentado en un 200%.
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
						"Verificar que el tamaño del contenido de un control de formulario basado en texto aumenta el tamaño al aumentar el zoom tamaño de navegador.",
						"El zoom del navegador debe ajustar tambien el texto de los controles de formularios como las cajas de texto.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}