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
				"El objetivo de esta técnica es demostrar cómo utilizar correctamente un evento onchange con un elemento seleccionado para actualizar otros elementos en la página web. Esta técnica no causará un cambio de contexto. Cuando hay uno o más elementos seleccionados en la página web, un evento onchange en uno puede actualizar las opciones en otro elemento seleccionado en la página web. Todos los datos requeridos por los elementos seleccionados se incluyen dentro de la página web. Es importante tener en cuenta que el elemento seleccionado que se modifica es posterior al elemento de selección del disparador en el orden de lectura de la página web. Esto asegura que las tecnologías de asistencia recogerán el cambio y los usuarios encontrarán los nuevos datos cuando el elemento modificado reciba atención. Esta técnica se basa en el soporte de JavaScript en el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Navegue hasta el elemento de selección del disparador (en este ejemplo, el que selecciona continentes) y cambie el valor de la selección.
	 * 2. Navegue hasta el elemento de selección que se actualiza con el activador (en este ejemplo, el que se selecciona para los países).
	 * 3. Compruebe que los valores de las opciones coincidentes se muestran en el otro elemento de selección.
	 * 4. Navegue hasta el elemento de selección de disparador, navegue por las opciones pero no cambie el valor.
	 * 5. Compruebe que los valores de las opciones coincidentes aún se muestran en el elemento asociado.
	 * Se recomienda que los elementos seleccionados se prueben con una tecnología de asistencia para verificar que se reconozcan los cambios en el elemento asociado.
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
						"Verificar que al modificar el elemento que tiene el evento \"onchange\" no se produce un cambio de contexto sino que solo se actualizan otros elemento de la página web.",
						"Cuando el sitio posea elementos que tengan asociado el evento \"onchange\" para actualizar otros elementos en la página web, este no deberia generar un cambio de contexto ni perder el valor de los controles ya ingresados.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}