package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG65 extends TecnicaGeneral {

	public TecnicaG65(CategoriaTecnica categoriaTecnica) {
		super(
				"G65", 
				"Proporcionando un rastro de ruta de navegación.", 
				"Una ruta de navegación ayuda al usuario a visualizar cómo se ha estructurado el contenido y cómo navegar de vuelta a páginas web anteriores, y puede identificar la ubicación actual dentro de una serie de páginas web. Un rastro de navegación muestra ubicaciones en la ruta que el usuario tomó para llegar a la página web, o muestra la ubicación de la página web actual dentro de la organización del sitio.\r\n" + 
				"\r\n" + 
				"Los recorridos Breadcrumb se implementan utilizando enlaces a las páginas web a las que se ha accedido en el proceso de navegación a la página web actual. Se colocan en el mismo lugar dentro de cada página web del conjunto.",
				categoriaTecnica);
	}

	/**
	 * Cuando se han implementado rutas de navegación en un conjunto de páginas web:
	 * 1. Navega a una página web.
	 * 2. Verifique que se muestre una ruta de navegación.
	 * 3. Compruebe que el rastro de navegación muestre la secuencia de navegación correcta para llegar a la ubicación actual o la ruta jerárquica correcta a la ubicación actual dentro de la estructura del sitio.
	 * 4. Para un rastro de migas que no incluye la ubicación actual:
	 * 		Verifique que todos los elementos en el rastro de navegación estén implementados como enlaces.
	 * 5. Para un rastro de migas de pan que incluye la ubicación actual:
	 * 		Verifique que todos los elementos, excepto la ubicación actual, estén implementados como enlaces.
	 * 		Verifique que la ubicación actual no esté implementada como un enlace.
	 * 6. Verifique que todos los enlaces naveguen a la página web correcta según lo especificado por el rastro de navegación.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRutaNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Existencia de rastro ruta de navegación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página web cuente con un rastre de la ruta de navegación que fue realizando el usuario en la navegación del sitio.",
				"Toda página web debe tener un rastreo de ruta de navegación del usuario para que sepa el recorrido que realizo y como llego a la página que esta en ese momento.");
		comprobacionRutaNavegacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRutaNavegacion);
		return resultadoEvaluacionTecnica;
	}

}