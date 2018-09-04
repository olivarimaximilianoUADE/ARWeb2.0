package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR30 extends TecnicaSCR {

	public TecnicaSCR30(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR30",
				"Usar scripts para cambiar el texto del enlace.",
				"El objetivo de esta técnica es permitir a los usuarios elegir agregar información adicional al texto de los enlaces para que los enlaces se puedan entender fuera de contexto.\r\n" + 
				"\r\n" + 
				"Algunos usuarios prefieren tener enlaces que son independientes, donde no hay necesidad de explorar el contexto del enlace. Otros usuarios consideran que incluir la información de contexto en cada enlace es repetitiva y reducir su capacidad para usar un sitio. Entre los usuarios de tecnología de asistencia, los comentarios al grupo de trabajo sobre los cuales es preferible se han dividido. Esta técnica permite a los usuarios elegir el enfoque que mejor funcione para ellos.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que haya un enlace cerca del comienzo de la página para expandir los enlaces
	 * 2. Compruebe que el enlace identificado en el paso 1 se puede identificar solo a partir del texto del enlace
	 * 3. Encuentre cualquier enlace en la página que no se pueda identificar desde el texto del enlace solo
	 * 4. Activar el control identificado en el paso 1
	 * 5. Compruebe que el propósito de los enlaces identificados en el paso 3 ahora puede identificarse solo a partir del texto del enlace
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
						"Verificar que el sitio cuente con un enlace cerda del comienzo que permita expandir el texto de los enlaces para poder comprenderlos mejor.",
						"Cuando un enlace no pueda ser comprendido con el texto por default, debe existir un link al comienzo del sitio que permita expandir el texto del mismo mostrando una descripción más detallada al usuario.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}