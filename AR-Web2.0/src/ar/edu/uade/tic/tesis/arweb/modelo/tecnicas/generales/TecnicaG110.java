package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG110 extends TecnicaGeneral {

	public TecnicaG110(CategoriaTecnica categoriaTecnica) {
		super(
				"G110", 
				"Usar una redirección instantánea del lado del cliente.", 
				"El objetivo de esta técnica es habilitar las redirecciones en el lado del cliente sin confundir al usuario. Los redireccionamientos se implementan preferiblemente en el lado del servidor porque un redireccionamiento del lado del servidor no hace que se visualice contenido nuevo antes de que el servidor envíe el contenido ubicado en el nuevo URI. Sin embargo, los autores no siempre tienen control sobre las tecnologías del lado del servidor; en ese caso, pueden usar un redireccionamiento del lado del cliente. Una redirección del lado del cliente se implementa mediante código dentro del contenido que instruye al agente de usuario para recuperar contenido de un URI diferente. Es importante que la página de redireccionamiento o la página web solo contenga información relacionada con el redireccionamiento.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encuentre cada enlace o referencia programática a otra página o página web.
	 * 2. Para cada enlace o referencia programática, compruebe si la página web referenciada contiene código (por ejemplo, metaelemento o secuencia de comandos) que causa un redireccionamiento del lado del cliente.
	 * 3. Para cada enlace o referencia programática que causa un redireccionamiento del lado del cliente, compruebe si el redireccionamiento se implementa sin un límite de tiempo o retraso y que la página solo contiene información relacionada con el redireccionamiento. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRedireccionamientoAutomaticoLadoCliente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Redireccionamiento instantaneo del lado del cliente.", 
				"Verificar que no exista un campo meta en el head que realice una redirección.",
				"Se debe indicar el elemento meta en la sección head del sitio con http-equiv=\"refresh\".");
		for (Element elementoHEAD: this.getParseador().getElementos(HTMLElementName.HEAD)) 
			for (Element elementoMETA : elementoHEAD.getAllElements(HTMLElementName.META)) {
				String atributoHttpEquiv = elementoMETA.getAttributeValue("http-equiv");
				if ((atributoHttpEquiv != null) && (atributoHttpEquiv.toLowerCase() == "refresh"))
					comprobacionRedireccionamientoAutomaticoLadoCliente.procesar(elementoMETA);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRedireccionamientoAutomaticoLadoCliente);
		return resultadoEvaluacionTecnica;
	}

}