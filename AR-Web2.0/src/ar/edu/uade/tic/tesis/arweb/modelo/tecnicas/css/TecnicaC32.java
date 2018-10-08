package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC32 extends TecnicaCSS {

	public TecnicaC32(CategoriaTecnica categoriaTecnica) {
		super(
				"C32",
				"Uso de consultas de medios y CSS de tabla para reagrupar columnas.",
				"El objetivo de esta t�cnica es poder presentar el contenido sin introducir una barra de desplazamiento horizontal en un ancho equivalente a 320 p�xeles CSS, o una barra de desplazamiento vertical a una altura equivalente a 256 p�xeles CSS para texto destinado a desplazarse horizontalmente. Esto se hace utilizando t�cnicas de dise�o que se adaptan al espacio de la ventana gr�fica disponible.\r\n" + 
				"\r\n" + 
				"Los dise�os de tabla definen las regiones de dise�o que se reproducen seg�n sea necesario para mostrar la regi�n en la pantalla. Aunque el dise�o exacto var�a, la relaci�n de los elementos y el orden de lectura siguen siendo los mismos cuando se hacen correctamente. Esta es una forma efectiva de crear dise�os que se presentan bien en diferentes dispositivos y para usuarios con diferentes preferencias de tama�o de contenido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Muestre la p�gina web en un agente de usuario con un 400% de zoom y configure las dimensiones de la ventana gr�fica (en p�xeles CSS) a 1280 de ancho y 1024 de alto.
	 * 2. Acercar en un 400%. 
	 * 3. Para leer el contenido horizontalmente, verifique que todo el contenido y la funcionalidad est�n disponibles sin desplazamiento horizontal.
	 * 4. Para leer el contenido verticalmente, verifique que todo el contenido y la funcionalidad est�n disponibles sin desplazamiento vertical.
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
						"Verificar que el sitio web se pueda leer el contenido sin barras de desplazamiento horizontal y vertical cuando se tenga un zoom de 400% y la ventana gr�fica este configurada en 1280 p�xeles de ancho y 1024 de alto.", 
						"Defina el tama�o de las regiones de dise�o utilizando las propiedades de la cuadr�cula y las consultas de medios para tama�os de ventana gr�fica espec�ficos, de modo que aumenten, reduzcan o ajusten el espacio disponible y respondan a los niveles de zoom." +
						"\r\n" + 
						"Coloque las regiones de dise�o en el contenedor de la cuadr�cula como una fila de elementos de cuadr�cula adyacentes, que pueden ajustarse a nuevas filas seg�n sea necesario de la misma manera que las palabras en un ajuste de p�rrafo.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
	
}
