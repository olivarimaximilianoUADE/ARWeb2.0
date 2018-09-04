package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR31 extends TecnicaSCR {

	public TecnicaSCR31(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR31",
				"Usar script para cambiar el color de fondo o el borde del elemento con foco.", 
				"El propósito de esta técnica es permitir que el autor use JavaScript para aplicar CSS, a fin de que el indicador de enfoque sea más visible de lo que normalmente sería. Cuando un elemento recibe el foco, el color de fondo o el borde se cambia para hacerlo visualmente distinto. Cuando el elemento pierde el foco, vuelve a su estilo normal. Esta técnica se puede utilizar en cualquier agente de usuario HTML que admita secuencias de comandos y CSS, independientemente de si es compatible con: pseudoclass de enfoque.", 
				categoriaTecnica);
	}

	/**
	 * 1. Tab para cada elemento en la página
	 * 2. Verifique que el indicador de enfoque esté visible
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
						"Verificar que al hacer foco en un elemento cambia el color de fondo o el borde del mismo.",
						"Cuando se enfoque un elemento con la tecla \"tab\" o se lo seleccione con el mouse debe aplicarse el foco sobre el mismo cambiando el color de fondo o el borde.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}