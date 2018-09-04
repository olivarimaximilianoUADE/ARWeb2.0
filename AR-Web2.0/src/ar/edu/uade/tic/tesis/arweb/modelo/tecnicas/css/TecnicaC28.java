package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC28 extends TecnicaCSS {

	public TecnicaC28(CategoriaTecnica categoriaTecnica) {
		super(
				"C28",
				"Especificar el tama�o de los contenedores de texto usando unidades em.",
				"El objetivo de esta t�cnica es especificar el ancho y / o altura de los contenedores, que contienen texto o que aceptar�n entrada de texto, en unidades em. Esto permitir� que los agentes de usuario que admiten el cambio de tama�o del texto redimensionen los contenedores de texto en l�nea con los cambios en la configuraci�n del tama�o del texto.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identifica los contenedores que contienen texto o permite la entrada de texto.
	 * 2. Compruebe que el ancho y / o la altura del contenedor est�n especificados en unidades em.
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
						"Verificar que el ancho de los contenedores que contienen texto est�n especificados en unidades \"em\".",
						"Especificar el ancho y/o altura de los contenedores en unidades \"em\", esto permite que los navegadores admitan el cambio de tama�o del texto al redimencionar el tama�o del navegador.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}