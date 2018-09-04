package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC23 extends TecnicaCSS {

	public TecnicaC23(CategoriaTecnica categoriaTecnica) {
		super(
				"C23", 
				"Especificación de texto y colores de fondo del contenido secundario, como pancartas, funciones y navegación en CSS, sin especificar el texto y los colores de fondo del contenido principal.",
				"Algunas páginas web usan colores para identificar diferentes agrupaciones. El objetivo de esta técnica es permitir a los usuarios seleccionar combinaciones de colores específicos para el texto y el fondo del contenido principal, al tiempo que conservan pistas visuales para las agrupaciones y la organización de la página web. Cuando un usuario anula los colores de primer plano y de fondo de todo el texto de una página, es posible que se pierdan las pistas visuales sobre la agrupación y la organización de la página web, lo que dificulta su comprensión y uso.Cuando un autor no especifica los colores del texto y el fondo del contenido principal, es posible cambiar los colores de esas regiones en el navegador sin la necesidad de anular los colores con una hoja de estilo del usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Cambie el texto, el enlace y los colores de fondo en la configuración del navegador para que sean diferentes del color predeterminado y diferentes de los especificados en el contenido secundario.
	 * Nota: No seleccione la opción que le indica al navegador que ignore los colores especificados en la página.
	 * 2. Verifique que el contenido principal use el nuevo texto, el enlace y los colores de fondo.
	 * 3. Verifique que los colores del texto, enlaces y fondos en el contenido secundario no hayan cambiado.
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
						"Verificar que al cambiar los colores de fondo, del texto y del enlace en la configuración del navegador y constate que este se aplique correctamente.",
						"Permitir a los usuarios seleccionar combinaciones de colores específicos para el texto y el fondo del contenido principal.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}