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
				"Proporcionar una casilla de verificaci�n adem�s de un bot�n de enviar.",
				"El objetivo de esta t�cnica es proporcionar una casilla de verificaci�n que los usuarios deben seleccionar para indicar que han revisado su informaci�n y que est�n listos para comprometerse. Esto es importante cuando la naturaleza de la transacci�n es tal que puede no ser reversible si los errores de entrada se descubren posteriormente o cuando el resultado de una acci�n es que los datos se eliminan. El autor proporciona una casilla de verificaci�n que no se selecciona cuando se carga la p�gina, con una etiqueta como \"Confirmo que la entrada es correcta y estoy listo para enviar\" o \"Confirmo que deseo eliminar estos datos\". La casilla de verificaci�n debe ubicarse cerca del bot�n de enviar para ayudar al usuario a notarlo durante el proceso de env�o. Si la casilla de verificaci�n no se selecciona cuando se env�a el formulario, la entrada se rechaza y se le solicita al usuario que revise su entrada, seleccione la casilla de verificaci�n y vuelva a enviarla. Solo si se selecciona la casilla de verificaci�n se aceptar� la entrada y se procesar� la transacci�n.", 
				categoriaTecnica);
	}

	/**
	 * Para p�ginas de entrada de usuario que causan transacciones irreversibles:
	 *  1. Compruebe que se proporciona una casilla de verificaci�n que indica la confirmaci�n del usuario de la entrada o acci�n, adem�s del bot�n Enviar.
	 *  2. Compruebe que si la casilla de verificaci�n no est� seleccionada cuando se env�a el formulario, la entrada se rechaza y se le solicita al usuario que revise su entrada, seleccione la casilla de verificaci�n y vuelva a enviarla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCasillaDeVerificacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Casilla de verificaci�n para que el usuario confirme la entrada o acci�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que adem�s de un bot�n de enviar cambios el sistema cuente con una casilla de verificaci�n para aquellos casos en donde la transacci�n no sea reversible.",
				"Dise�e la p�gina web teniendo en cuenta que si la transacci�n que realiza es irreversible se debe colocar una casilla de verificaci�n junto al bot�n enviar de forma tal que si esta no esta chequeada no se pueda terminar la transacci�n.");
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