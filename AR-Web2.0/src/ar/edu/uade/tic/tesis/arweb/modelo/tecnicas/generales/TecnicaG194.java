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
				"Proporcionar revisión ortográfica y sugerencias para la entrada de texto.", 
				"En esta técnica, se proporcionan revisión de ortografía y sugerencias para el texto. A menudo, las personas con discapacidades cognitivas tienen problemas para deletrear una palabra, pero es posible que la ortografía sea aproximadamente correcta. Un programa de revisión ortográfica les ahorrará una investigación que consume mucho tiempo sobre cómo deletrear la palabra. Esto también puede ser cierto para los usuarios ciegos y con baja visión que podrían cometer un error al escribir. También ayudará a las personas con discapacidades de destreza que pueden estar usando un puntero de cabeza, o que pueden tener un software de escaneo que hace que sea muy lento y difícil de escribir. Una solución de corrección ortográfica que proporciona sugerencia (s) de palabras y un mecanismo simple para seleccionar una e ingresarla en el campo de entrada de texto proporciona ayuda importante para estos y otros usuarios.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que haya un campo de formulario en la página.
	 * 2. Ingrese una palabra mal escrita.
	 * 3. Verifique que se presente una ortografía sugerida.
	 * 4. Verifique que haya un mecanismo disponible para ingresar la palabra sugerida en el formulario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRevisionOrtografica = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Revisión de ortografía y sugerencias para el texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al ingresar, en un formulario, palabras con errores ortográficos haya un revisión y le indique al usuario de la misma.",
				"Valida la página web para los campos del formulario en donde el usuario ingrese texto cuente con un correcto de ortografía y brinde sugerencias para el texto.");
		comprobacionRevisionOrtografica.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRevisionOrtografica);
		return resultadoEvaluacionTecnica;
	}

}