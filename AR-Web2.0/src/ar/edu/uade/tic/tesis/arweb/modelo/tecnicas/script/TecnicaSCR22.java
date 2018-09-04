package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR22 extends TecnicaSCR {

	public TecnicaSCR22(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR22",
				"Usar scripts para controlar el parpadeo y detenerlo en cinco segundos o menos.", 
				"El objetivo de esta técnica es controlar el parpadeo con el script para que el script pueda detenerlo en menos de cinco segundos. La secuencia de comandos se usa para iniciar el efecto de parpadeo del contenido, controlar el alternar entre estados visibles y ocultos, y también detener el efecto en cinco segundos o menos. La función setTimeout () se puede utilizar para alternar el contenido parpadeante entre los estados ocultos y visibles, y detener cuando el número de iteraciones por el tiempo entre ellos se suma a casi cinco segundos.", 
				categoriaTecnica);
	}

	/**
	 * Para cada instancia de contenido parpadeante:
	 *  1. Inicie un temporizador durante 5 segundos al comienzo del efecto de parpadeo.
	 *  2. Cuando el temporizador expira, determine si el parpadeo se detuvo.
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
						"Verificar que 5 segunos luego de que comience el temporizador el efecto de parpadeo inicio y que este finaliza cuando expira el tiempo.",
						"Cuando el sitio requiera que el contenido parpadee, esta debe contar con un script que permita controlar el parpadeo y detenerlo en cinco segundos o menos según requerimiento del usuario..");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}