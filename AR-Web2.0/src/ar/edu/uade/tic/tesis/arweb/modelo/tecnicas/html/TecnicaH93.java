package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH93 extends TecnicaHTML {

	public TecnicaH93(CategoriaTecnica categoriaTecnica) {
		super(
				"H93",
				"Asegurarse de que los atributos id sean únicos en una página web.", 
				"El objetivo de esta técnica es evitar errores clave que se sabe que causan problemas de las tecnologías de apoyo cuando están tratando de analizar el contenido que tiene el mismo atributo id en los diferentes elementos. Estos errores se pueden evitar asegurándose de que la página web no tiene valores de ID duplicados. Esto se puede hacer manualmente o mediante el uso de mecanismo de HTML para especificar la versión de tecnología y de la tecnología, y la validación del documento para esta condición. Hay varios validadores que el desarrollador puede utilizar; informes de validación general mencionan este tipo de error. La declaración de tipo de documento no es estrictamente necesario para este tipo de evaluación, pero especificando la declaración de tipo de documento hace que sea más fácil de usar un validador.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que todos los valores del atributo id son único en la página Web.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAtributoIDUnico = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Atributos \"id\" con valores duplicados.",
				"Verificar que todos los valores del atributo id son únicos en la página Web.",
				"Asegúrate que cada atributo \"id\" tiene un valor diferente en la página web.");
		List<String> listaID = new LinkedList<String>();
		for (Element elemento : this.getParseador().getElementos()) {
			String atributoId = elemento.getAttributeValue("id");
			if (atributoId != null) 
				if (listaID.contains(atributoId)) 
					comprobacionAtributoIDUnico.procesar(elemento);
				else
					listaID.add(atributoId);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoIDUnico);
		return resultadoEvaluacionTecnica;
	}

}