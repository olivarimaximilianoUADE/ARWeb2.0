package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG71 extends TecnicaGeneral {

	public TecnicaG71(CategoriaTecnica categoriaTecnica) {
		super(
				"G71",
				"Proporcionar un enlace de ayuda en cada p�gina web.",
				"El objetivo de esta t�cnica es proporcionar ayuda sensible al contexto para los usuarios a medida que ingresan datos en formularios al proporcionar al menos un enlace a la informaci�n de ayuda en cada p�gina web. El enlace se dirige a una p�gina de ayuda con informaci�n espec�fica para esa p�gina web. Otro enfoque es proporcionar un enlace de ayuda para cada control interactivo. Posicionar este enlace inmediatamente antes o despu�s del control permite a los usuarios ubicarlo f�cilmente si tienen problemas en el control. Mostrar la informaci�n de ayuda en una nueva ventana del navegador garantiza que los datos que ya se hayan ingresado en el formulario no se perder�n. NOTA: Un enlace no es el �nico medio para proporcionar ayuda.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identifica una p�gina web que contiene formularios.
	 * 2. Determine si hay al menos un enlace para ayudar a la informaci�n que explica c�mo completar el formulario en esta p�gina web.
	 * 3. Determine si hay enlaces antes o despu�s de cada control interactivo a la informaci�n espec�fica de ese control.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceParaAyuda = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Presencia de un enlace de ayuda en cada formulario del sitio.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar la presencia de un enlace para ayudar a los usuarios en el ingreso de datos en cada formulario del sitio.",
				"Aseg�rate que el sitio cuente con un enlace a un sitio de ayuda para facilitarle la carga de datos al usuario.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for (Element elementoA : elementoFORM.getAllElements(HTMLElementName.A))
			{
				comprobacionEnlaceParaAyuda.procesar(elementoA);
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceParaAyuda);
		return resultadoEvaluacionTecnica;
	}

}