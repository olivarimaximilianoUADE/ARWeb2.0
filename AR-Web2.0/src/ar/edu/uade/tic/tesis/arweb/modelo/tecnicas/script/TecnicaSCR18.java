package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR18 extends TecnicaSCR {

	public TecnicaSCR18(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR18",
				"Proporcionar validaci�n y alerta del lado del cliente.",
				"El objetivo de esta t�cnica es validar la entrada del usuario a medida que se ingresan los valores para cada campo, por medio de secuencias de comandos del lado del cliente. Si se encuentran errores, un di�logo de alerta describe la naturaleza del error en el texto. Una vez que el usuario cierra el cuadro de di�logo de alerta, es �til si el script coloca el foco del teclado en el campo donde ocurri� el error.", 
				categoriaTecnica);
	}

	/**
	 * Para campos de formulario que requieren una entrada espec�fica:
	 * 	1. ingrese datos inv�lidos
	 *  2. determinar si se proporciona una alerta que describe el error.
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
						"Validaci�n de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que para los campos de formularios el sitio valida la entrada de los datos por parte del usuario e indica si el valor ingresado es erroneo.",
						"Cuando el sitio posea un formulario con campos que requieran datos espec�ficos como ser fechas, solo n�meros, etc; se debe validar a medida que el usuario ingresa la informaci�n que la misma es correcta y en caso contrario indicarlos mediante un di�logo de alerta describiendo la naturaleza del error.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}