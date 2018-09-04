package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG199 extends TecnicaGeneral {

	public TecnicaG199(CategoriaTecnica categoriaTecnica) {
		super(
				"G199", 
				"Proporcionar retroalimentación de éxito cuando los datos se presentaron con éxito.", 
				"El objetivo de esta técnica es reducir el esfuerzo necesario para que los usuarios confirmar que una acción, tales como la presentación de un formulario web, se completó con éxito. Esto se puede lograr proporcionando retroalimentación presentado consistentemente que indica explícitamente éxito de una acción, en lugar de requerir a un usuario navegar a través del contenido de descubrir si la acción se ha realizado correctamente. El esfuerzo significativo puede ser empleado por los usuarios que no se pueden escanear fácilmente a través de la información para confirmar su acción (por ejemplo, que los datos presentados se ha escrito correctamente en una base de datos, enviado a una persona, o añadido al contenido que se está editando).",
				categoriaTecnica);
	}

	/**
	 * 1. Rellenar los campos del formulario sin errores.
	 * 2. Enviar el formulario.
	 * 3. Verificar que un mensaje de retroalimentación en la pantalla confirma que la petición se ha realizado correctamente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMensajeExitoTrasEnvioFormulario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Mensaje de éxito tras una petición.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que un mensaje de retroalimentación en la pantalla confirma que la petición se ha realizado correctamente.",
				"Tanto si el formulario ha sido enviado con éxito como si no, házselo saber al usuario.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM))
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("submit")))
					comprobacionMensajeExitoTrasEnvioFormulario.procesar(elementoINPUT);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMensajeExitoTrasEnvioFormulario);
		return resultadoEvaluacionTecnica;
	}

}