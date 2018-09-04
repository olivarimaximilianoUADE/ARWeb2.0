package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG98 extends TecnicaGeneral {

	public TecnicaG98(CategoriaTecnica categoriaTecnica) {
		super(
				"G98",
				"Brindar la capacidad para que el usuario revise y corrija las respuestas antes de enviar.",
				"El objetivo de esta técnica es proporcionar a los usuarios una forma de garantizar que su entrada sea correcta antes de completar una transacción irreversible. Las aplicaciones de prueba, financieras y legales permiten que ocurran transacciones que no se pueden \"deshacer\". Por lo tanto, es importante que no haya errores en el envío de datos, ya que el usuario no tendrá la oportunidad de corregir el error una vez que se haya comprometido la transacción.", 
				categoriaTecnica);
	}

	/**
	 * En una aplicación de prueba o una que produce transacciones financieras o legales y que también recopila datos de los usuarios en varios pasos:
	 *  1. Verifique que se le pida al usuario que revise y confirme los datos.
	 *  2. Si los datos del usuario se recopilan en varios pasos, el usuario puede volver a los pasos anteriores para revisar y cambiar los datos.
	 *  3. Determine si se proporciona un resumen de todos los datos ingresados ​​por el usuario antes de confirmar la transacción y se proporciona un método para corregir los errores si es necesario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionConfirmacionDatosAntesDeEnviar = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Comprobación de datos por parte del usuario antes de enviar.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que antes de enviar los datos ingresador por el usuario aparezca la opción de revisar y corregir por si alguno esta mal.",
				"Cuando un sitio web realiza transacciones que no se pueden cancelar y son delicadas el mismo debe mostrar la información ingresada por el usuario antes de enviarla pidiendo confirmación a fin de que si existe un error este pueda ser corregido por el usuario antes.");
		comprobacionConfirmacionDatosAntesDeEnviar.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionConfirmacionDatosAntesDeEnviar);
		return resultadoEvaluacionTecnica;
	}

}