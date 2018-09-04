package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG177 extends TecnicaGeneral {

	public TecnicaG177(CategoriaTecnica categoriaTecnica) {
		super(
				"G177", 
				"Proporcionar texto de corrección sugerido.", 
				"El objetivo de esta técnica es sugerir el texto correcto cuando la información suministrada por el usuario no es aceptada y el texto correcto es conocido. Las sugerencias pueden incluir ortografía correcta o texto similar de un conjunto conocido de posibles textos.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar campos de formulario donde el texto correcto se puede deducir del texto incorrecto.
	 * 2. Complete el formulario, rellenando deliberadamente los campos de formulario identificados con texto incorrecto.
	 * 3. Verifique que al usuario se le presenten sugerencias para el texto correcto.
	 * 4. Compruebe que las sugerencias se proporcionan junto al campo de formulario o que se proporciona un enlace a las sugerencias cerca del campo de formulario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTipoDeDatosEnFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Los campos de formulario con tipos de datos definidos deben mostrar mensaje de error si se ingresan datos de distinto tipo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al ingresar datos en campos de formularios con una tipificación definida deberia mostrar mensaje de error si se ingresan datos diferentes a los indicados.",
				"Debe existir una validación sobre los datos ingresados en los controles de formulario.");
		comprobacionTipoDeDatosEnFormularios.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTipoDeDatosEnFormularios);
		return resultadoEvaluacionTecnica;
	}

}