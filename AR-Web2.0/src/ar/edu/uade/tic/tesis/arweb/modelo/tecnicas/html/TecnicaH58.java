package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.Locale;
import org.apache.commons.lang.LocaleUtils;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH58 extends TecnicaHTML {

	public TecnicaH58(CategoriaTecnica categoriaTecnica) {
		super(
				"H58",
				"Usar atributos de lenguaje para identificar cambios en el lenguaje humano.",
				"El objetivo de esta técnica es identificar claramente cualquier cambio en el idioma de una página mediante el uso del atributo lang o xml: lang, según corresponda para la versión HTML o XHTML que use.\r\n" + 
				"\r\n" + 
				"HTML 4.01 usa el atributo lang en los elementos. XHTML sirve como texto / html utiliza el atributo lang y el atributo xml: lang en los elementos, a fin de cumplir con los requisitos de XHTML y proporcionar compatibilidad con HTML. XHTML servido como application / xhtml + xml usa el atributo xml: lang en los elementos." +
				"\r\n" +
				"Los valores permitidos para los atributos lang y xml: lang están indicados en los recursos a los que se hace referencia a continuación. Las etiquetas de idioma usan un código primario para indicar el idioma y subcódigos opcionales (separados por caracteres de guión) para indicar variantes del idioma. Por ejemplo, el inglés se indica con el código primario \"en\"; El inglés británico y el inglés americano se pueden distinguir mediante el uso de \"en-GB\" y \"en-US\", respectivamente. El uso del código primario es importante para esta técnica. El uso de subcódigos es opcional, pero puede ser útil en determinadas circunstancias.",
				categoriaTecnica);
	}

	/**
	 * Para cada elemento en el documento:
	 *  1. Compruebe que el idioma humano del contenido del elemento sea el mismo que el idioma heredado para el elemento especificado en HTML 4.01, herencia de códigos de idioma
	 * Para cada atributo lang en el documento:
	 *  1. Compruebe que el valor del atributo lang se ajuste a BCP 47: Etiquetas para la identificación de idiomas o su sucesor
	 * Para cada atributo xml:lang en el documento:
	 *  1. Compruebe que el valor del atributo xml:lang se ajuste a BCP 47: Etiquetas para la identificación de idiomas o su sucesor
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionIdiomaElementoIgualIdiomaReal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Idioma humano del contenidode de cada elemento sea igual al idioma definido en los atributos.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el idioma definido en los atributos \"lang\" y \"xml:lang\" en cada elemento del sitio es igual al idioma humano del contenido del mismo.",
				"Para cada elemento en el documento, el idioma humano del contenido del mismo debe ser el mismo que el idioma definido en los atributos \"lang\" y \"xml:lang\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoLang = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Comprobación valor atributo lang según BCP 47.", 
				"Verificar que el valor del atributo \"lang\" se ajusta a BCP 47: Etiquetas para la identificación del lenguaje o su sucesor y refleja el idioma principal utilizado por la página web.",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la página usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoXmlLang = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Comprobación valor atributo xml:lang según BCP 47.", 
				"Verificar que el valor del atributo \"xml:lang\" se ajusta a BCP 47: Etiquetas para la identificación del lenguaje o su sucesor y refleja el idioma principal utilizado por la página web.",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la página usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
		for (Element elemento : this.getParseador().getElementos()) {
			if ((elemento.getAttributeValue("lang") != null) && (!elemento.getAttributeValue("lang").isEmpty())) {
				String atributoLang = elemento.getAttributeValue("lang");
				Locale locale = Locale.forLanguageTag(atributoLang);
				//Si esta dentro de la lista de culturas disponibles
				if(!LocaleUtils.isAvailableLocale(locale)) {
					comprobacionAtributoLang.procesar(elemento);
				}
			}
			if ((elemento.getAttributeValue("xml:lang") != null) && (!elemento.getAttributeValue("xml:lang").isEmpty())) {
				String atributoXmlLang = elemento.getAttributeValue("xml:lang");
				Locale locale = Locale.forLanguageTag(atributoXmlLang);
				//Si esta dentro de la lista de culturas disponibles
				if(!LocaleUtils.isAvailableLocale(locale)) {
					comprobacionAtributoXmlLang.procesar(elemento);
				}
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdiomaElementoIgualIdiomaReal);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoLang);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoXmlLang);
		return resultadoEvaluacionTecnica;
	}

}