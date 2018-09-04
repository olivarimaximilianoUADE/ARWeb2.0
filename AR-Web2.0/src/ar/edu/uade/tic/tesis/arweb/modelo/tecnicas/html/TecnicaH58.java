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
				"El objetivo de esta t�cnica es identificar claramente cualquier cambio en el idioma de una p�gina mediante el uso del atributo lang o xml: lang, seg�n corresponda para la versi�n HTML o XHTML que use.\r\n" + 
				"\r\n" + 
				"HTML 4.01 usa el atributo lang en los elementos. XHTML sirve como texto / html utiliza el atributo lang y el atributo xml: lang en los elementos, a fin de cumplir con los requisitos de XHTML y proporcionar compatibilidad con HTML. XHTML servido como application / xhtml + xml usa el atributo xml: lang en los elementos." +
				"\r\n" +
				"Los valores permitidos para los atributos lang y xml: lang est�n indicados en los recursos a los que se hace referencia a continuaci�n. Las etiquetas de idioma usan un c�digo primario para indicar el idioma y subc�digos opcionales (separados por caracteres de gui�n) para indicar variantes del idioma. Por ejemplo, el ingl�s se indica con el c�digo primario \"en\"; El ingl�s brit�nico y el ingl�s americano se pueden distinguir mediante el uso de \"en-GB\" y \"en-US\", respectivamente. El uso del c�digo primario es importante para esta t�cnica. El uso de subc�digos es opcional, pero puede ser �til en determinadas circunstancias.",
				categoriaTecnica);
	}

	/**
	 * Para cada elemento en el documento:
	 *  1. Compruebe que el idioma humano del contenido del elemento sea el mismo que el idioma heredado para el elemento especificado en HTML 4.01, herencia de c�digos de idioma
	 * Para cada atributo lang en el documento:
	 *  1. Compruebe que el valor del atributo lang se ajuste a BCP 47: Etiquetas para la identificaci�n de idiomas o su sucesor
	 * Para cada atributo xml:lang en el documento:
	 *  1. Compruebe que el valor del atributo xml:lang se ajuste a BCP 47: Etiquetas para la identificaci�n de idiomas o su sucesor
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
				"Comprobaci�n valor atributo lang seg�n BCP 47.", 
				"Verificar que el valor del atributo \"lang\" se ajusta a BCP 47: Etiquetas para la identificaci�n del lenguaje o su sucesor y refleja el idioma principal utilizado por la p�gina web.",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la p�gina usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoXmlLang = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Comprobaci�n valor atributo xml:lang seg�n BCP 47.", 
				"Verificar que el valor del atributo \"xml:lang\" se ajusta a BCP 47: Etiquetas para la identificaci�n del lenguaje o su sucesor y refleja el idioma principal utilizado por la p�gina web.",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la p�gina usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
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