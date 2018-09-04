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
				"Especificaci�n de bordes y dise�o en CSS para delinear �reas de una p�gina web sin especificar texto y colores de fondo de texto.",
				"El objetivo de esta t�cnica es especificar los bordes y el dise�o mediante CSS y dejar texto y colores de fondo para representar de acuerdo con el navegador del usuario y / o la configuraci�n del sistema operativo (consulte la nota anterior en relaci�n con Safari). Esto permite a los usuarios ver el texto en los colores que necesitan mientras mantienen otros aspectos del dise�o y el dise�o de la p�gina, como columnas de texto, bordes alrededor de secciones o l�neas verticales entre un men� y el �rea de contenido principal. Tambi�n evitar� algunos problemas de visualizaci�n en algunos navegadores cuando las p�ginas contengan cuadros emergentes de JavaScript o men�s desplegables y tienen los colores anulados.\r\n" + 
				"\r\n" + 
				"Los bordes y los indicadores de dise�o ayudan a muchas personas con discapacidades cognitivas, al igual que la flexibilidad sobre el texto y los colores de fondo. A veces, estas dos necesidades entran en conflicto cuando el usuario tiene que anular la selecci�n de texto y el fondo del autor en el navegador y el navegador tambi�n elimina los bordes y el dise�o previsto. Esto puede significar que la p�gina se muestra en una sola columna con un bloque de contenido debajo del otro, lo que puede ocasionar espacios en blanco innecesarios y largas l�neas de texto. Tambi�n puede significar que los cuadros emergentes obtienen un fondo transparente, superponiendo el texto del cuadro en el texto de la p�gina, y los men�s desplegables se vuelven transparentes o adquieren un fondo gris oscuro. Cuando un autor web no especifica los colores de ning�n texto y fondo, al especificar colores y dise�o de bordes, es posible, en la mayor�a de navegadores populares, cambiar el texto y los colores de fondo sin afectar las otras declaraciones de CSS (especificadas por el autor).", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra la p�gina web en un navegador que permita a los usuarios cambiar los colores del contenido HTML.
	 * 2. Cambie el texto, el enlace y los colores de fondo en la configuraci�n del navegador para que sean diferentes de los configurados actualmente en el navegador.
	 *    Nota: aseg�rese de no seleccionar la opci�n que le indique al navegador que ignore los colores especificados en la p�gina.
	 * 3. Regrese a la p�gina y verifique que est� mostrando la p�gina en el nuevo texto, enlace y colores de fondo.
	 * 4. Compruebe que a�n se muestran los bordes y que se conserva el dise�o.
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
						"Verificar que al cambiar la configuraci�n de navegador para los textos, enlaces y colores de fondo estos se apliquen a la p�gina pero que se muestran los bordes y se conserva el dise�o.",
						"Especificar los bordes y el dise�o mediante CSS y dejar texto y colores de fondo para representar de acuerdo con el navegador del usuario. Esto permite a los usuarios ver el texto en los colores que necesitan mientras mantienen otros aspectos del dise�o y el dise�o de la p�gina.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}