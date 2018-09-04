package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG164 extends TecnicaGeneral {

	public TecnicaG164(CategoriaTecnica categoriaTecnica) {
		super(
				"G164", 
				"Proporcionar un tiempo establecido dentro del cual una solicitud (o transacci�n) en l�nea puede ser enmendada o cancelada por el usuario despu�s de realizar la solicitud.", 
				"El objetivo de esta t�cnica es permitir que los usuarios se recuperen de los errores cometidos al realizar un pedido al proporcionarles un per�odo de tiempo durante el cual pueden cancelar o cambiar el orden. En general, un contrato o una orden es un compromiso legal y no puede ser cancelado. Sin embargo, un sitio web puede optar por ofrecer esta capacidad, y proporciona una manera para que los usuarios se recuperen de los errores. El contenido web necesitar�a decirle al usuario cu�nto tiempo es el per�odo de cancelaci�n despu�s de enviar el formulario y cu�l ser�a el procedimiento para cancelar el pedido. El procedimiento de cancelaci�n puede no ser posible en l�nea. Por ejemplo, puede requerir que se env�e un aviso por escrito a la direcci�n que aparece en la p�gina web.",
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la p�gina web describa el per�odo de tiempo para cancelar o cambiar una orden.
	 * 2. Verifique que la p�gina web describa el proceso para cancelar o cambiar un pedido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTiempoParaCambiarCancelarOrden = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Per�odo de tiempo para cancelar o cambiar una orden.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un per�odo de tiempo para cancelar o cambiar una orden realizada en l�nea describiendo el proceso.",
				"Ofrece para aquedar ordenes realizadas en l�nea un per�odo de tiempo para poder cancelarlar o cambiarlas. Se debe especificar cual es el procedimiento para realizar dicha acci�n.");
		comprobacionTiempoParaCambiarCancelarOrden.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTiempoParaCambiarCancelarOrden);
		return resultadoEvaluacionTecnica;
	}

}