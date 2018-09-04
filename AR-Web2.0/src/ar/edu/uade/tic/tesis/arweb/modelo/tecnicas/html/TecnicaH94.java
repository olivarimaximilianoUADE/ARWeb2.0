package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.StartTag;

public class TecnicaH94 extends TecnicaHTML {

	public TecnicaH94(CategoriaTecnica categoriaTecnica) {
		super(
				"H94",
				"Asegurarse de que los elementos no contienen atributos duplicados.", 
				"El objetivo de esta técnica es evitar errores clave que se sabe que causan problemas de las tecnologías de apoyo cuando están tratando de analizar el contenido que tiene atributos duplicados en el mismo elemento. Esto se puede comprobar de forma manual, o utilizando el mecanismo del HTML para especificar la versión de la tecnología y la tecnología y la validación del documento para esta condición. Hay varios validadores que el desarrollador puede utilizar; informes de validación general mencionan este tipo de error. La declaración de tipo de documento no es estrictamente necesario para este tipo de evaluación, pero especificando la declaración de tipo de documento hace que sea más fácil de usar un validador.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que ningún atributo aparece más de una vez en cualquier elemento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionElementosConAtributosDuplicados = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elementos con atributos duplicados.",
				"Verificar que ningún atributo aparece más de una vez en cualquier elemento.",
				"Asegúrate que los elementos no tienen atributos repetidos.");
		List<String> listaAtributos = new LinkedList<String>();
		for (StartTag elemento : this.getParseador().getEtiquetasInicio()) {
			if (elemento.getAttributes() != null) {
				for (Attribute atributo : elemento.getAttributes()) {
					if (listaAtributos.contains(atributo.getKey())) 
						comprobacionElementosConAtributosDuplicados.procesar(atributo);
					else
						listaAtributos.add(atributo.getKey());
				}
				listaAtributos.clear();
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionElementosConAtributosDuplicados);
		return resultadoEvaluacionTecnica;
	}

}