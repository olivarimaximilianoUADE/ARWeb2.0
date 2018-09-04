package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaG148 extends TecnicaGeneral {

	public TecnicaG148(CategoriaTecnica categoriaTecnica) {
		super(
				"G148",
				"No se especifica el color de fondo, no se especifica el color del texto y no se usan las funciones de tecnolog�a que cambian los valores predeterminados.",
				"El objetivo de esta t�cnica es garantizar que los usuarios puedan leer el texto que se presenta sobre un fondo. Con esta t�cnica, el autor evita tener que tomar medidas de contraste simplemente sin especificar el color del texto y sin especificar el fondo. Como resultado, los colores de ambos est�n completamente determinados por el agente de usuario. Algunas personas con discapacidades visuales configuran a su agente de usuario para anular ciertos colores que tienen problemas para ver. Esta t�cnica ayudar� a evitar una situaci�n en la que el agente de usuario y el sitio web entren en conflicto entre s� sobre el primer plano y / o colores de fondo, dando como resultado el mismo color para el texto y el fondo, lo que lo har�a invisible para el usuario que establezca sus propios colores en su navegador o tecnolog�a de asistencia.", 
				categoriaTecnica);
	}

	/**
	 * 1. Mire en todos los lugares que se puede especificar el color del texto.
	 * 2. Verificar que el color del texto no est� especificado.
	 * 3. Mire en todas las �reas que se puede especificar el color de fondo o la imagen utilizada como fondo.
	 * 4. Compruebe que no se especifique ning�n color de fondo o imagen utilizada como fondo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionColorTextos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"No espeficiar color del texto.", 
				"Revisar todo el contenido de la p�gina y verificar que los textos no tengan color especificado.",
				"Al no especficar el color de texto los mismos son aplicados por el agente del usuario.");
		ResultadoEvaluacionTecnicaItem comprobacionColorFondos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"No espeficiar color de fondo.", 
				"Revisar todo el contenido de la p�gina y verificar que los fondos no tengan color especificado.",
				"Al no especficar el color de fondo los mismos son aplicados por el agente del usuario.");
		for (Element elemento : this.getParseador().getElementos()) {
			String atributoStyle = elemento.getAttributeValue("style");
			if (atributoStyle != null && !atributoStyle.isEmpty()) {
				if(atributoStyle.indexOf("color") > 0)
					comprobacionColorTextos.procesar(elemento);
				if(atributoStyle.indexOf("background-color") > 0 || atributoStyle.indexOf("background-image") > 0)
					comprobacionColorFondos.procesar(elemento);
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionColorTextos);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionColorFondos);
		return resultadoEvaluacionTecnica;
	}
	
}