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
				"Proporcionar un enlace de ayuda en cada página web.",
				"El objetivo de esta técnica es proporcionar ayuda sensible al contexto para los usuarios a medida que ingresan datos en formularios al proporcionar al menos un enlace a la información de ayuda en cada página web. El enlace se dirige a una página de ayuda con información específica para esa página web. Otro enfoque es proporcionar un enlace de ayuda para cada control interactivo. Posicionar este enlace inmediatamente antes o después del control permite a los usuarios ubicarlo fácilmente si tienen problemas en el control. Mostrar la información de ayuda en una nueva ventana del navegador garantiza que los datos que ya se hayan ingresado en el formulario no se perderán. NOTA: Un enlace no es el único medio para proporcionar ayuda.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identifica una página web que contiene formularios.
	 * 2. Determine si hay al menos un enlace para ayudar a la información que explica cómo completar el formulario en esta página web.
	 * 3. Determine si hay enlaces antes o después de cada control interactivo a la información específica de ese control.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceParaAyuda = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Presencia de un enlace de ayuda en cada formulario del sitio.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar la presencia de un enlace para ayudar a los usuarios en el ingreso de datos en cada formulario del sitio.",
				"Asegúrate que el sitio cuente con un enlace a un sitio de ayuda para facilitarle la carga de datos al usuario.");
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