package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC25 extends TecnicaCSS {

	public TecnicaC25(CategoriaTecnica categoriaTecnica) {
		super(
				"C25",
				"Especificación de bordes y diseño en CSS para delinear áreas de una página web sin especificar texto y colores de fondo de texto.",
				"El objetivo de esta técnica es especificar los bordes y el diseño mediante CSS y dejar texto y colores de fondo para representar de acuerdo con el navegador del usuario y / o la configuración del sistema operativo (consulte la nota anterior en relación con Safari). Esto permite a los usuarios ver el texto en los colores que necesitan mientras mantienen otros aspectos del diseño y el diseño de la página, como columnas de texto, bordes alrededor de secciones o líneas verticales entre un menú y el área de contenido principal. También evitará algunos problemas de visualización en algunos navegadores cuando las páginas contengan cuadros emergentes de JavaScript o menús desplegables y tienen los colores anulados.\r\n" + 
				"\r\n" + 
				"Los bordes y los indicadores de diseño ayudan a muchas personas con discapacidades cognitivas, al igual que la flexibilidad sobre el texto y los colores de fondo. A veces, estas dos necesidades entran en conflicto cuando el usuario tiene que anular la selección de texto y el fondo del autor en el navegador y el navegador también elimina los bordes y el diseño previsto. Esto puede significar que la página se muestra en una sola columna con un bloque de contenido debajo del otro, lo que puede ocasionar espacios en blanco innecesarios y largas líneas de texto. También puede significar que los cuadros emergentes obtienen un fondo transparente, superponiendo el texto del cuadro en el texto de la página, y los menús desplegables se vuelven transparentes o adquieren un fondo gris oscuro. Cuando un autor web no especifica los colores de ningún texto y fondo, al especificar colores y diseño de bordes, es posible, en la mayoría de navegadores populares, cambiar el texto y los colores de fondo sin afectar las otras declaraciones de CSS (especificadas por el autor).", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra la página web en un navegador que permita a los usuarios cambiar los colores del contenido HTML.
	 * 2. Cambie el texto, el enlace y los colores de fondo en la configuración del navegador para que sean diferentes de los configurados actualmente en el navegador.
	 *    Nota: asegúrese de no seleccionar la opción que le indique al navegador que ignore los colores especificados en la página.
	 * 3. Regrese a la página y verifique que esté mostrando la página en el nuevo texto, enlace y colores de fondo.
	 * 4. Compruebe que aún se muestran los bordes y que se conserva el diseño.
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
						"Verificar que al cambiar la configuración de navegador para los textos, enlaces y colores de fondo estos se apliquen a la página pero que se muestran los bordes y se conserva el diseño.",
						"Especificar los bordes y el diseño mediante CSS y dejar texto y colores de fondo para representar de acuerdo con el navegador del usuario. Esto permite a los usuarios ver el texto en los colores que necesitan mientras mantienen otros aspectos del diseño y el diseño de la página.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}