package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH98 extends TecnicaHTML {

	public TecnicaH98(CategoriaTecnica categoriaTecnica) {
		super(
				"H98", 
				"Usando atributos HTML 5.2 de autocompletar.", 
				"El objetivo de esta técnica es vincular mediante programación un término taxonómico predefinido y publicado a la entrada, de modo que las entradas también se puedan interpretar a máquina. De esta manera, la entrada siempre tendrá un valor común, referible e identificable asociado, sin importar qué idioma se use, o qué término visible en pantalla se usa para etiquetar la entrada. Luego, puede personalizarse aún más o manipularse por la máquina para ayudar a los usuarios."
				+ "\r\n" +
				"La técnica funciona al agregar el token de autocompletar apropiado a cada campo de formulario en el formulario para hacer que las entradas identificadas puedan determinarse mediante programación. Esto ayudará a las personas con discapacidades cognitivas que no conozcan de inmediato el propósito del campo porque la etiqueta utilizada por el autor no les es familiar. Cuando los insumos se han asignado mediante programación, los complementos y el software de terceros pueden manipular estos campos de formulario para que sean más accesibles para las personas con discapacidades cognitivas."
				+ "\r\n" +
				"El atributo autocompletar también mejora la capacidad del navegador para rellenar previamente los campos de formulario con los valores preferidos por el usuario. Cuando la entrada se ha \"etiquetado\" correctamente con el valor del token conocido, el valor ingresado por el usuario se almacena localmente en la máquina host y se asocia con el valor del token para su reutilización. Ayuda a las personas con discapacidades de destreza que tienen problemas para escribir, a las que pueden necesitar más tiempo y a cualquier persona que desee reducir el esfuerzo para completar un formulario."
				+ "\r\n" +
				"El atributo autocompletar permite que el navegador haga una comparación de patrones con una lista de valores almacenados localmente con el navegador, y proporciona el valor correspondiente apropiado cuando la entrada se etiqueta mediante programación. Esta es una configuración de usuario que puede ser activada o desactivada, o modificada por el usuario final. Esto reduce la escritura y la dependencia en la memoria porque utiliza valores almacenados para completar los campos.",
				categoriaTecnica);
	}

	/**
	 * Para cada campo de formulario que recopila información sobre el usuario y corresponde a un campo de autocompletado verifique lo siguiente:
	 * 1. El campo de formulario tiene un atributo de autocompletar válido y bien formado y un par de valores.
	 * 2. El propósito del campo de formulario indicado por la etiqueta corresponde con el token de autocompletado en la entrada.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAutocompleteEnElementoInput = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Elementos \"input\" con atributo autocomplete.",
				"Verificar que los elementos input de un form contengan el atributo autocomplete.",
				"El atributo autocomplete en los elementos input permite que el navegador rellene los campos previamente en los formularios con los valores preferidos del usuario.");
		ResultadoEvaluacionTecnicaItem comprobacionAutocompleteCorrespondaConPropositoDeCampo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"El propósito de los atributos autocomplete en los elementos input deben corresponder con la etiqueta del mismo.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que los elementos inputs que tengan el atributo autocomplete, el token de autocompletado corresponda con la etiqueta del elemento.",
				"El atributo autocomplete en los elementos input permite que el navegador rellene los campos previamente en los formularios con los valores preferidos del usuario.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for (Element elementosINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
			String atributoAutocomplete = elementosINPUT.getAttributeValue("autocomplete");
			if (atributoAutocomplete == null) 
				comprobacionAutocompleteEnElementoInput.procesar(elementosINPUT);
			}
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAutocompleteEnElementoInput);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAutocompleteCorrespondaConPropositoDeCampo);
		return resultadoEvaluacionTecnica;
	}
	
}
