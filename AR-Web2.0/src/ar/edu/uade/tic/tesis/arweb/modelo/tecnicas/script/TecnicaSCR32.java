package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR32 extends TecnicaSCR {

	public TecnicaSCR32(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR32",
				"Proporcionar validación del lado del cliente y agregar texto de error a través del DOM.",
				"El objetivo de esta técnica es demostrar la visualización de un mensaje de error cuando la validación del lado del cliente de un campo de formulario ha fallado. Los elementos de anclaje se usan para mostrar los mensajes de error en una lista y se insertan sobre los campos para validar. Los elementos de anclaje se utilizan en los mensajes de error para que el foco se pueda colocar en el (los) mensaje (s) de error, atrayendo la atención del usuario hacia él. El href de los elementos de anclaje contiene un enlace in-page que hace referencia a los campos donde se han encontrado errores.", 
				categoriaTecnica);
	}

	/**
	 * Cree mensajes de error utilizando etiquetas de anclaje y secuencias de comandos apropiadas a través de la técnica anterior.
	 * 	1. Cargue la página.
	 *  2. Ingrese un valor válido en los campos asociados con un mensaje de error y verifique que no se muestren mensajes de error.
	 *  3. Ingrese un valor no válido en los campos asociados con un mensaje de error y verifique que se muestre el mensaje de error correcto para el campo.
	 *  4. Verifique que los mensajes de error reciban enfoque.
	 *  5. Ingrese un valor válido en el (los) campo (s) asociado (s) con el mensaje de error mostrado y verifique que el mensaje de error se elimine.
	 *  6. Repita para todos los campos con mensajes de error asociados creados a través de etiquetas de anclaje.
	 *  Nota: Se recomienda que también ejecute el procedimiento anterior utilizando una tecnología de asistencia.
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
						"Validación de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que al completar los campos del formulario con valores inválidos se muestre un mensaje de error indicando que los valores son incorrectos y hay que corregirlos.",
						"Cuando el sitio tenga un formulario con campos para completar se debe validar el ingreso de datos en los mismos a fin que los valores ingresados sean correctos y caso contrario mostrar un mensaje de error al usuario.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}