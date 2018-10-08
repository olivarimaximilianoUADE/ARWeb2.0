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
				"El objetivo de esta t�cnica es vincular mediante programaci�n un t�rmino taxon�mico predefinido y publicado a la entrada, de modo que las entradas tambi�n se puedan interpretar a m�quina. De esta manera, la entrada siempre tendr� un valor com�n, referible e identificable asociado, sin importar qu� idioma se use, o qu� t�rmino visible en pantalla se usa para etiquetar la entrada. Luego, puede personalizarse a�n m�s o manipularse por la m�quina para ayudar a los usuarios."
				+ "\r\n" +
				"La t�cnica funciona al agregar el token de autocompletar apropiado a cada campo de formulario en el formulario para hacer que las entradas identificadas puedan determinarse mediante programaci�n. Esto ayudar� a las personas con discapacidades cognitivas que no conozcan de inmediato el prop�sito del campo porque la etiqueta utilizada por el autor no les es familiar. Cuando los insumos se han asignado mediante programaci�n, los complementos y el software de terceros pueden manipular estos campos de formulario para que sean m�s accesibles para las personas con discapacidades cognitivas."
				+ "\r\n" +
				"El atributo autocompletar tambi�n mejora la capacidad del navegador para rellenar previamente los campos de formulario con los valores preferidos por el usuario. Cuando la entrada se ha \"etiquetado\" correctamente con el valor del token conocido, el valor ingresado por el usuario se almacena localmente en la m�quina host y se asocia con el valor del token para su reutilizaci�n. Ayuda a las personas con discapacidades de destreza que tienen problemas para escribir, a las que pueden necesitar m�s tiempo y a cualquier persona que desee reducir el esfuerzo para completar un formulario."
				+ "\r\n" +
				"El atributo autocompletar permite que el navegador haga una comparaci�n de patrones con una lista de valores almacenados localmente con el navegador, y proporciona el valor correspondiente apropiado cuando la entrada se etiqueta mediante programaci�n. Esta es una configuraci�n de usuario que puede ser activada o desactivada, o modificada por el usuario final. Esto reduce la escritura y la dependencia en la memoria porque utiliza valores almacenados para completar los campos.",
				categoriaTecnica);
	}

	/**
	 * Para cada campo de formulario que recopila informaci�n sobre el usuario y corresponde a un campo de autocompletado verifique lo siguiente:
	 * 1. El campo de formulario tiene un atributo de autocompletar v�lido y bien formado y un par de valores.
	 * 2. El prop�sito del campo de formulario indicado por la etiqueta corresponde con el token de autocompletado en la entrada.
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
				"El prop�sito de los atributos autocomplete en los elementos input deben corresponder con la etiqueta del mismo.", 
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
