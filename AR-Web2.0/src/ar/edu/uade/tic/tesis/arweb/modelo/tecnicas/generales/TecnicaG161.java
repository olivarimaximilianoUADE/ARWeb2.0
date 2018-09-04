package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG161 extends TecnicaGeneral {

	public TecnicaG161(CategoriaTecnica categoriaTecnica) {
		super(
				"G161", 
				"Proporcionar una función de búsqueda para ayudar a los usuarios a encontrar contenido.", 
				"Proporcionar una función de búsqueda que busque en sus páginas web es una estrategia de diseño que ofrece a los usuarios una forma de encontrar contenido. Los usuarios pueden localizar el contenido buscando palabras o frases específicas, sin necesidad de comprender o navegar a través de la estructura del sitio web. Esta puede ser una forma más rápida o más fácil de encontrar contenido, particularmente en sitios grandes. La implementación de una función de búsqueda que verificará los términos de ortografía, incluirá diferentes finales para los términos (derivación) y permitirá el uso de terminología diferente (sinónimos) aumentará aún más el acceso a la función de búsqueda. La funcionalidad de búsqueda se agrega al incluir un formulario simple en la página web, generalmente un campo de texto para el término de búsqueda y un botón para activar la búsqueda o al agregar un enlace a una página que incluye un formulario de búsqueda. El formulario de búsqueda en sí debe ser accesible, por supuesto.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que la página web contiene un formulario de búsqueda o un enlace a una página de búsqueda
	 * 2. Escriba texto en el formulario de búsqueda que aparece en el conjunto de páginas web
	 * 3. Activar la búsqueda
	 * 4. Verifique que el usuario sea llevado a una página que contenga el término de búsqueda
	 * 5. Compruebe que el usuario vaya a una página que contiene una lista de enlaces a páginas que contienen el término de búsqueda.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFuncionDeBusqueda = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Buscador de contenido.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Proporcionar un buscador en el sitio que permita al usuario encontrar contenido facilmente.",
				"Ofrece un buscador en el sitio web para que el usuario puedo localizar el contenido que le interece de forma rápida sin necesidad de leer o navegar por toda la página.");
		comprobacionFuncionDeBusqueda.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFuncionDeBusqueda);
		return resultadoEvaluacionTecnica;
	}

}