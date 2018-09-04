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
				"Proporcionar un tiempo establecido dentro del cual una solicitud (o transacción) en línea puede ser enmendada o cancelada por el usuario después de realizar la solicitud.", 
				"El objetivo de esta técnica es permitir que los usuarios se recuperen de los errores cometidos al realizar un pedido al proporcionarles un período de tiempo durante el cual pueden cancelar o cambiar el orden. En general, un contrato o una orden es un compromiso legal y no puede ser cancelado. Sin embargo, un sitio web puede optar por ofrecer esta capacidad, y proporciona una manera para que los usuarios se recuperen de los errores. El contenido web necesitaría decirle al usuario cuánto tiempo es el período de cancelación después de enviar el formulario y cuál sería el procedimiento para cancelar el pedido. El procedimiento de cancelación puede no ser posible en línea. Por ejemplo, puede requerir que se envíe un aviso por escrito a la dirección que aparece en la página web.",
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la página web describa el período de tiempo para cancelar o cambiar una orden.
	 * 2. Verifique que la página web describa el proceso para cancelar o cambiar un pedido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTiempoParaCambiarCancelarOrden = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Período de tiempo para cancelar o cambiar una orden.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un período de tiempo para cancelar o cambiar una orden realizada en línea describiendo el proceso.",
				"Ofrece para aquedar ordenes realizadas en línea un período de tiempo para poder cancelarlar o cambiarlas. Se debe especificar cual es el procedimiento para realizar dicha acción.");
		comprobacionTiempoParaCambiarCancelarOrden.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTiempoParaCambiarCancelarOrden);
		return resultadoEvaluacionTecnica;
	}

}