package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG194 extends TecnicaGeneral {

	public TecnicaG194(CategoriaTecnica categoriaTecnica) {
		super(
				"G194", 
				"Proporcionar revisi�n ortogr�fica y sugerencias para la entrada de texto.", 
				"En esta t�cnica, se proporcionan revisi�n de ortograf�a y sugerencias para el texto. A menudo, las personas con discapacidades cognitivas tienen problemas para deletrear una palabra, pero es posible que la ortograf�a sea aproximadamente correcta. Un programa de revisi�n ortogr�fica les ahorrar� una investigaci�n que consume mucho tiempo sobre c�mo deletrear la palabra. Esto tambi�n puede ser cierto para los usuarios ciegos y con baja visi�n que podr�an cometer un error al escribir. Tambi�n ayudar� a las personas con discapacidades de destreza que pueden estar usando un puntero de cabeza, o que pueden tener un software de escaneo que hace que sea muy lento y dif�cil de escribir. Una soluci�n de correcci�n ortogr�fica que proporciona sugerencia (s) de palabras y un mecanismo simple para seleccionar una e ingresarla en el campo de entrada de texto proporciona ayuda importante para estos y otros usuarios.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que haya un campo de formulario en la p�gina.
	 * 2. Ingrese una palabra mal escrita.
	 * 3. Verifique que se presente una ortograf�a sugerida.
	 * 4. Verifique que haya un mecanismo disponible para ingresar la palabra sugerida en el formulario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRevisionOrtografica = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Revisi�n de ortograf�a y sugerencias para el texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al ingresar, en un formulario, palabras con errores ortogr�ficos haya un revisi�n y le indique al usuario de la misma.",
				"Valida la p�gina web para los campos del formulario en donde el usuario ingrese texto cuente con un correcto de ortograf�a y brinde sugerencias para el texto.");
		comprobacionRevisionOrtografica.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRevisionOrtografica);
		return resultadoEvaluacionTecnica;
	}

}