package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR19 extends TecnicaSCR {

	public TecnicaSCR19(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR19",
				"Usar un evento onchange en un elemento seleccionado sin causar un cambio de contexto.", 
				"El objetivo de esta t�cnica es demostrar c�mo utilizar correctamente un evento onchange con un elemento seleccionado para actualizar otros elementos en la p�gina web. Esta t�cnica no causar� un cambio de contexto. Cuando hay uno o m�s elementos seleccionados en la p�gina web, un evento onchange en uno puede actualizar las opciones en otro elemento seleccionado en la p�gina web. Todos los datos requeridos por los elementos seleccionados se incluyen dentro de la p�gina web. Es importante tener en cuenta que el elemento seleccionado que se modifica es posterior al elemento de selecci�n del disparador en el orden de lectura de la p�gina web. Esto asegura que las tecnolog�as de asistencia recoger�n el cambio y los usuarios encontrar�n los nuevos datos cuando el elemento modificado reciba atenci�n. Esta t�cnica se basa en el soporte de JavaScript en el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Navegue hasta el elemento de selecci�n del disparador (en este ejemplo, el que selecciona continentes) y cambie el valor de la selecci�n.
	 * 2. Navegue hasta el elemento de selecci�n que se actualiza con el activador (en este ejemplo, el que se selecciona para los pa�ses).
	 * 3. Compruebe que los valores de las opciones coincidentes se muestran en el otro elemento de selecci�n.
	 * 4. Navegue hasta el elemento de selecci�n de disparador, navegue por las opciones pero no cambie el valor.
	 * 5. Compruebe que los valores de las opciones coincidentes a�n se muestran en el elemento asociado.
	 * Se recomienda que los elementos seleccionados se prueben con una tecnolog�a de asistencia para verificar que se reconozcan los cambios en el elemento asociado.
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
						"Validaci�n de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que al modificar el elemento que tiene el evento \"onchange\" no se produce un cambio de contexto sino que solo se actualizan otros elemento de la p�gina web.",
						"Cuando el sitio posea elementos que tengan asociado el evento \"onchange\" para actualizar otros elementos en la p�gina web, este no deberia generar un cambio de contexto ni perder el valor de los controles ya ingresados.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}