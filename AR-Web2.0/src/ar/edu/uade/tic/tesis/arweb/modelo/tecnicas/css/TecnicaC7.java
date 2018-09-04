package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC7 extends TecnicaCSS {

	public TecnicaC7(CategoriaTecnica categoriaTecnica) {
		super(
				"C7", 
				"Usar CSS para ocultar una parte del texto del enlace.", 
				"El objetivo de esta técnica es complementar el texto del enlace mediante la adición de texto adicional que describe la función única del link y el estilo del texto adicional de modo tal que no se muestra en  pantalla por los agentes de usuario que soporta CSS. Cuando la información en el contexto que lo rodea es necesaria para interpretar el texto del enlace que se muestra,esta técnica proporciona una descripción completa de la función del link de salida permitiendo al mismo tiempo el menor texto completo que se va a mostrar. Esta técnica funciona mediante la creación de un selector CSS para linkear al texto que va a ser oculto. El conjunto de reglas para el selector, coloca el texto que se oculta en una caja de 1 píxel de  overflow oculto, y posiciona el texto fuera de la ventana gráfica. Esto asegura que el texto no se muestre en pantalla, pero sigue siendo accesible para las ayudas técnicas tales como lectores de pantalla y pantallas braille.", 
				categoriaTecnica);
	}

	/**
	 * En cada elemento anchor que utiliza esta técnica:
	 * 1. Verificar que hay definido un elemento que delimita su exposición a un píxel y posiciona texto fuera de la exposición con rebosadero oculto.
	 * 2. Verificar que el elemento de esa clase está incluido en el contenido del anchor.
	 * 3. Verificar que el contenido combinado del anchor describe el propósito del enlace.
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
						"En cada elemento anchor que utiliza esta técnica: Verificar que hay definido un elemento que delimita su exposición a un píxel y posiciona texto fuera de la exposición con overflow oculto.",
						"Describe el objetivo de un enlace. Si necesitas ocultar un trozo del texto del enlace con CSS, hazlo.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}