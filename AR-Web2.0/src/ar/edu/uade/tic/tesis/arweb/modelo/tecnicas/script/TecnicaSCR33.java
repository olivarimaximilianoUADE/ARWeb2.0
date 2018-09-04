package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR33 extends TecnicaSCR {

	public TecnicaSCR33(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR33",
				"Usar script para desplazar contenido y proporcionar un mecanismo para pausarlo.",
				"El objetivo de esta técnica es proporcionar una forma para que los usuarios dejen de desplazar el contenido cuando el desplazamiento se crea mediante un script. El contenido de desplazamiento puede ser difícil o imposible de leer para usuarios con baja visión o con discapacidades cognitivas. El movimiento también puede distraer a algunas personas, lo que dificulta su concentración en otras partes de la página web.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que se proporciona un mecanismo para pausar el contenido de desplazamiento.
	 * 2. Use el mecanismo de pausa para pausar el contenido de desplazamiento.
	 * 3. Compruebe que el desplazamiento se haya detenido y no se reinicie por sí mismo.
	 * 4. Compruebe que se proporciona un mecanismo para reiniciar el contenido detenido.
	 * 5. Use el mecanismo de reinicio proporcionado para reiniciar el contenido de desplazamiento.
	 * 6. Compruebe que el desplazamiento se haya reanudado desde el punto donde se detuvo.
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
						"Verificar que si el sitio tiene un mecanismo para desplazar el contenido automaticamente este se puede pausar.",
						"Para aquellos sitios en donde tengan un mecanismo para desplazar el contenido de manera automática, debe tener también la posibilidad de pausarlo par que le resulte mas sencillo a los usuarios leer el contenido.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}