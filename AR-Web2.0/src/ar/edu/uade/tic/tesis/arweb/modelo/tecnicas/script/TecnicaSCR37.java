package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR37 extends TecnicaSCR {

	public TecnicaSCR37(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR37",
				"Crear cuadros de di�logo personalizados de una manera independiente del dispositivo.",
				"\r\n" + 
				"Los dise�adores de sitios a menudo desean crear cuadros de di�logo que no usen las ventanas emergentes provistas por el navegador. Esto se logra generalmente encerrando los contenidos del di�logo en un div y colocando el div encima del contenido de la p�gina usando z-order y posicionamiento absoluto en CSS.\r\n" + 
				"\r\n" + 
				"Para ser accesible, estos di�logos deben seguir unas pocas reglas simples.\r\n" + 
				"\r\n" + 
				"Dispare la secuencia de comandos que inicia el di�logo desde el evento onclick de un enlace o bot�n.\r\n" + 
				"\r\n" + 
				"Coloque el cuadro de di�logo en el Modelo de objetos de documento (DOM) inmediatamente despu�s del elemento que lo desencaden�. El elemento desencadenante mantendr� el foco, e insertando el contenido del di�logo despu�s de ese elemento har� que el contenido dentro del di�logo siga en el orden de lectura del lector de pantalla y luego en el orden de tabulaci�n. El cuadro de di�logo a�n puede estar posicionado en forma absoluta para estar en otra parte de la p�gina visualmente. Esto se puede hacer creando el di�logo en el HTML y ocult�ndolo con CSS, como en el siguiente ejemplo, o insert�ndolo inmediatamente despu�s del elemento desencadenante con script.\r\n" + 
				"\r\n" + 
				"Aseg�rese de que el HTML dentro del di�logo div cumple con el mismo est�ndar de accesibilidad que otro contenido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Busque todas las �reas de la p�gina que activan di�logos que no son ventanas emergentes.
	 * 2. Verifique que los cuadros de di�logo se puedan abrir tabulando en el �rea y presionando enter.
	 * 3. Verifique que, una vez abierto, el cuadro de di�logo sea el siguiente en el orden de tabulaci�n.
	 * 4. Compruebe que los cuadros de di�logo se activan desde el clic de un bot�n o un enlace.
	 * 5. Usando una herramienta que le permite inspeccionar el DOM generado por el script, verifique que el cuadro de di�logo sea el siguiente en el DOM.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/javascript"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que los cuadros de dialogos que no son ventanas emergentes del navegador pueden abrirse al posicionarse sobre los links o botones y presionando \"enter\".",
						"Cuando el sitio posea  ventanas modales propias del sitios que son creadas usando elementos \"div\", las mismas tienen que poder ser abiertas usando el \"tab\" del teclado para posicionarse y la tecla \"enter\".");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}