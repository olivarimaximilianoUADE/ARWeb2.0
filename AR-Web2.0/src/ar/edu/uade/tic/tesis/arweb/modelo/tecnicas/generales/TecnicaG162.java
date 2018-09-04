package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG162 extends TecnicaGeneral {

	public TecnicaG162(CategoriaTecnica categoriaTecnica) {
		super(
				"G162", 
				"Posicionar las etiquetas para optimizar las previsibilidad de las relaciones.", 
				"Cuando las etiquetas de los campos de formulario se colocan donde el usuario espera de ellos que visualmente, es más fácil de entender y de formas complejas para localizar campos específicos . Etiquetas para la mayoría de los campos están situados inmediatamente antes del campo , es decir, para los idiomas de izquierda a derecha , ya sea a la izquierda del campo o por encima de ella , así como los idiomas de derecha a izquierda , a la derecha del campo o por encima eso. Las etiquetas de los botones de opción y casillas de verificación están colocados después del campo. Estas posiciones se definen porque esa es la posición habitual ( y por lo tanto más predecible ) para el sello de campos, botones de radio y casillas de verificación. Las etiquetas se colocan antes de los campos de entrada desde los campos a veces varían en longitud . Posicionándolos antes permite que las etiquetas se alineen . También hace más fácil de localizar etiquetas con una lupa de la pantalla , ya que son inmediatamente antes del campo y también se pueden encontrar en una columna vertical ( cuando el inicio de los campos alineados de forma vertical ) . Por último , si el campo tiene datos en él , es más fácil de entender o verificar los datos si uno lee la etiqueta y luego el contenido en lugar de al revés. Casillas de verificación y botones de radio tienen una anchura uniforme, mientras que sus etiquetas a menudo no lo hacen. Tener el botón de opción o casilla de verificación primera , por tanto, permite que tanto los botones y las etiquetas que se alinean verticalmente.",
				categoriaTecnica);
	}

	/**
	 * Para cada campo de formulario en la página web:
	 * 1. Verificar que el campo de formulario tiene una etiqueta visible.
	 * 2. Si el campo de formulario es un botón de casilla o radio, verificar que la etiqueta es inmediatamente después del campo.
	 * 3. Si el campo de formulario no es un botón de casilla o radio, verificar que la etiqueta está inmediatamente antes del campo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCampoFormularioEtiquetaVisible = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Campo de formulario tiene etiqueta visible.",
				"Para cada campo de formulario en la página web: Verificar que el campo de formulario tiene una etiqueta visible.",
				"Ofrece etiquetas \"label\" descriptivas para asociar etiquetas de texto con controles de formulario y ubícalas para maximizar la predictibilidad de la relación.");
		for (Element elementoFORM: this.getParseador().getElementos(HTMLElementName.FORM))
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("hidden")))
					comprobacionCampoFormularioEtiquetaVisible.procesar(elementoINPUT);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCampoFormularioEtiquetaVisible);
		return resultadoEvaluacionTecnica;
	}

}