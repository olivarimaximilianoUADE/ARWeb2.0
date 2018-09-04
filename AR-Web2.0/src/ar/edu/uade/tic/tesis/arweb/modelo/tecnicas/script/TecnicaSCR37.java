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
				"Crear cuadros de diálogo personalizados de una manera independiente del dispositivo.",
				"\r\n" + 
				"Los diseñadores de sitios a menudo desean crear cuadros de diálogo que no usen las ventanas emergentes provistas por el navegador. Esto se logra generalmente encerrando los contenidos del diálogo en un div y colocando el div encima del contenido de la página usando z-order y posicionamiento absoluto en CSS.\r\n" + 
				"\r\n" + 
				"Para ser accesible, estos diálogos deben seguir unas pocas reglas simples.\r\n" + 
				"\r\n" + 
				"Dispare la secuencia de comandos que inicia el diálogo desde el evento onclick de un enlace o botón.\r\n" + 
				"\r\n" + 
				"Coloque el cuadro de diálogo en el Modelo de objetos de documento (DOM) inmediatamente después del elemento que lo desencadenó. El elemento desencadenante mantendrá el foco, e insertando el contenido del diálogo después de ese elemento hará que el contenido dentro del diálogo siga en el orden de lectura del lector de pantalla y luego en el orden de tabulación. El cuadro de diálogo aún puede estar posicionado en forma absoluta para estar en otra parte de la página visualmente. Esto se puede hacer creando el diálogo en el HTML y ocultándolo con CSS, como en el siguiente ejemplo, o insertándolo inmediatamente después del elemento desencadenante con script.\r\n" + 
				"\r\n" + 
				"Asegúrese de que el HTML dentro del diálogo div cumple con el mismo estándar de accesibilidad que otro contenido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Busque todas las áreas de la página que activan diálogos que no son ventanas emergentes.
	 * 2. Verifique que los cuadros de diálogo se puedan abrir tabulando en el área y presionando enter.
	 * 3. Verifique que, una vez abierto, el cuadro de diálogo sea el siguiente en el orden de tabulación.
	 * 4. Compruebe que los cuadros de diálogo se activan desde el clic de un botón o un enlace.
	 * 5. Usando una herramienta que le permite inspeccionar el DOM generado por el script, verifique que el cuadro de diálogo sea el siguiente en el DOM.
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
						"Validación de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que los cuadros de dialogos que no son ventanas emergentes del navegador pueden abrirse al posicionarse sobre los links o botones y presionando \"enter\".",
						"Cuando el sitio posea  ventanas modales propias del sitios que son creadas usando elementos \"div\", las mismas tienen que poder ser abiertas usando el \"tab\" del teclado para posicionarse y la tecla \"enter\".");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}