package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH76 extends TecnicaHTML {

	public TecnicaH76(CategoriaTecnica categoriaTecnica) {
		super(
				"H76",
				"Usar meta refresh para crear una redirecci�n instant�nea del lado del cliente.", 
				"El objetivo de esta t�cnica es habilitar las redirecciones en el lado del cliente sin confundir al usuario. Los redireccionamientos se implementan preferiblemente en el lado del servidor pero los autores no siempre tienen control sobre las tecnolog�as del lado del servidor.",
				categoriaTecnica);
	}

	/**
	 * 1. Encuentra todos los meta elementos en el documento.
	 * 2. Para cada meta elemento, compruebe si contiene el atributo http-equiv con el valor "refresh" (sin distinci�n de may�sculas y min�sculas) y el atributo de contenido con un n�mero mayor que 0 seguido por; 'URL = anyURL' (donde anyURL representa el URI que deber�a reemplazar la p�gina actual).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMetaRefresh = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Usar meta refresh para redirecci�n instant�nea.",
				"Verificar que si el sitio cuenta elementos meta contiene el atributo http-equiv con el valor \"refresh\".",
				"Aseg�rate que el sitio tiene en la etiqueta meta el atributo http-equiv con el valor \"refresh\" si se desea redireccionar.");
		for (Element elementoHEAD: this.getParseador().getElementos(HTMLElementName.HEAD)) 
			for (Element elementoMETA : elementoHEAD.getAllElements(HTMLElementName.META)) {
				String atributoHttpEquiv = elementoMETA.getAttributeValue("http-equiv");
				if ((atributoHttpEquiv != null) && (atributoHttpEquiv.toLowerCase() == "refresh"))
					comprobacionMetaRefresh.procesar(elementoMETA);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMetaRefresh);
		return resultadoEvaluacionTecnica;
	}
}