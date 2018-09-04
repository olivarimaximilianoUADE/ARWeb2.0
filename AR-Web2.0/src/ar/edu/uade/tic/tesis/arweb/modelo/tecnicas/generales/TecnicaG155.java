package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG155 extends TecnicaGeneral {

	public TecnicaG155(CategoriaTecnica categoriaTecnica) {
		super(
				"G155",
				"Proporcionar una casilla de verificación además de un botón de enviar.",
				"El objetivo de esta técnica es proporcionar una casilla de verificación que los usuarios deben seleccionar para indicar que han revisado su información y que están listos para comprometerse. Esto es importante cuando la naturaleza de la transacción es tal que puede no ser reversible si los errores de entrada se descubren posteriormente o cuando el resultado de una acción es que los datos se eliminan. El autor proporciona una casilla de verificación que no se selecciona cuando se carga la página, con una etiqueta como \"Confirmo que la entrada es correcta y estoy listo para enviar\" o \"Confirmo que deseo eliminar estos datos\". La casilla de verificación debe ubicarse cerca del botón de enviar para ayudar al usuario a notarlo durante el proceso de envío. Si la casilla de verificación no se selecciona cuando se envía el formulario, la entrada se rechaza y se le solicita al usuario que revise su entrada, seleccione la casilla de verificación y vuelva a enviarla. Solo si se selecciona la casilla de verificación se aceptará la entrada y se procesará la transacción.", 
				categoriaTecnica);
	}

	/**
	 * Para páginas de entrada de usuario que causan transacciones irreversibles:
	 *  1. Compruebe que se proporciona una casilla de verificación que indica la confirmación del usuario de la entrada o acción, además del botón Enviar.
	 *  2. Compruebe que si la casilla de verificación no está seleccionada cuando se envía el formulario, la entrada se rechaza y se le solicita al usuario que revise su entrada, seleccione la casilla de verificación y vuelva a enviarla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCasillaDeVerificacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Casilla de verificación para que el usuario confirme la entrada o acción.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que además de un botón de enviar cambios el sistema cuente con una casilla de verificación para aquellos casos en donde la transacción no sea reversible.",
				"Diseñe la página web teniendo en cuenta que si la transacción que realiza es irreversible se debe colocar una casilla de verificación junto al botón enviar de forma tal que si esta no esta chequeada no se pueda terminar la transacción.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for(Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if(atributoType != null && atributoType == "submit") {
					comprobacionCasillaDeVerificacion.procesar(elementoINPUT);			
				}
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCasillaDeVerificacion);
		return resultadoEvaluacionTecnica;
	}
}