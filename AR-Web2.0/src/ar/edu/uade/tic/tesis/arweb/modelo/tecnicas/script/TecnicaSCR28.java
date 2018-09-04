package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR28 extends TecnicaSCR {

	public TecnicaSCR28(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR28",
				"Usar un men� expandible y plegable para eludir el bloque de contenido.",
				"Esta t�cnica permite a los usuarios omitir material repetido colocando ese material en un men� que se puede expandir o contraer bajo el control del usuario. El usuario puede omitir el material repetido al colapsar el men�. El usuario invoca un control de interfaz de usuario para ocultar o eliminar los elementos del men�. La secci�n de recursos enumera varias t�cnicas para men�s, barras de herramientas y �rboles, cualquiera de las cuales se puede usar para proporcionar un mecanismo para omitir la navegaci�n.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que alg�n control de interfaz de usuario permita expandir o contraer el contenido repetido.
	 * 2. Compruebe que cuando el contenido se expande, se incluye en el contenido determinado por programaci�n en un lugar l�gico en el orden de lectura.
	 * 3. Compruebe que cuando el contenido se contrae, no es parte del contenido determinado por programaci�n.
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
						"Verificar que el contenido repetido del sitio se puede ocultar o eludir usando un men� expandible y plegable.",
						"Cuando el sitio tenga material repetido, debe tener un men� con la posibilidad de omitar esta repetici�n, de esta manera el usuario puede omitir el material repetido al colapsar el men�.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}