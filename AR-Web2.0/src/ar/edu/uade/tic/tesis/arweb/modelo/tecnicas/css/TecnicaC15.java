package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC15 extends TecnicaCSS {

	public TecnicaC15(CategoriaTecnica categoriaTecnica) {
		super(
				"C15",
				"Usar CSS para cambiar la presentación de un componente de interfaz de usuario cuando recibe el foco.",
				"El objetivo de esta técnica es demostrar cómo las apariencias visuales pueden mejorarse mediante hojas de estilo para proporcionar feedback visual cuando un elemento interactivo tenga el foco o cuando un usuario se desplaza sobre ella mediante un dispositivo señalador. Resaltando los elemento que tiene el foco o son señalados puede proporcionar información tal como el hecho de que el elemento es interactivo o el alcance del elemento interactivo.Proporcionar feedback visual puede ser posible a través de más de un modo. Por lo general, se logra mediante el uso del mouse para colocar el cursor sobre el elemento o por teclado mediante el uso del Tab.", 
				categoriaTecnica);
	}

	/**
	 * Para cada elemento capaz de alcanzar el foco:
	 * 1. Usando el mouse, coloque el cursor sobre el elemento.
	 * 2. Verifique que el fondo o borde cambia de color.
	 * 3. Mover el ratón fuera del objeto antes de intentar el foco con el teclado.
	 * 4. Usando el teclado, Tab al elemento.
	 * 5. Verifique que el fondo o borde cambia de color.
	 * 6. Verifique que los cambios del fondo o de la frontera en el color se eliminan cuando el elemento pierde el foco.
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
						"Validación de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el fondo o borde cambia de color cuando una componente gana o pierde el foco.",
						"Cambia la presentación de los componentes de la interfaz usuario cuando recibe el foco mediante CSS.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}