package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC30 extends TecnicaCSS {

	public TecnicaC30(CategoriaTecnica categoriaTecnica) {
		super(
				"C30",
				"Usar CSS para reemplazar texto con im�genes de texto y proporcionar controles de interfaz de usuario para cambiar.",
				"El objetivo de esta t�cnica es demostrar c�mo se puede usar CSS para reemplazar el texto HTML estructurado con im�genes de texto de forma que los usuarios puedan ver el contenido de acuerdo con sus preferencias. Para usar esta t�cnica, un autor comienza creando una p�gina HTML que usa elementos sem�nticos para marcar la estructura de la p�gina. El autor luego dise�a dos o m�s hojas de estilo para esa p�gina. Una hoja de estilos presenta el texto HTML como texto y la segunda usa funciones CSS para reemplazar parte del texto HTML con im�genes de texto. Finalmente, mediante el uso de secuencias de comandos del lado del servidor o del lado del cliente, el autor proporciona un control que permite al usuario cambiar entre las vistas disponibles.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que la p�gina web incluya un control que permita a los usuarios seleccionar una presentaci�n alternativa.
	 * 2. Verifique que cuando el control est� activado, la p�gina resultante incluya texto (texto determinado por programaci�n) dondequiera que se hayan usado im�genes de texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el sitio web incluye un control que permita a los usuarios seleccionar una presentaci�n alternatica que reemplace imagenes por texto.",
						"Reemplazar el texto HTML estructurado con im�genes de texto de forma que los usuarios puedan ver el contenido de acuerdo con sus preferencias.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}