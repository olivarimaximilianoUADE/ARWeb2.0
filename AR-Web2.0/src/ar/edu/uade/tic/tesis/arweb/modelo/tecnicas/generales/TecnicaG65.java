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
				"Proporcionando un rastro de ruta de navegaci�n.", 
				"Una ruta de navegaci�n ayuda al usuario a visualizar c�mo se ha estructurado el contenido y c�mo navegar de vuelta a p�ginas web anteriores, y puede identificar la ubicaci�n actual dentro de una serie de p�ginas web. Un rastro de navegaci�n muestra ubicaciones en la ruta que el usuario tom� para llegar a la p�gina web, o muestra la ubicaci�n de la p�gina web actual dentro de la organizaci�n del sitio.\r\n" + 
				"\r\n" + 
				"Los recorridos Breadcrumb se implementan utilizando enlaces a las p�ginas web a las que se ha accedido en el proceso de navegaci�n a la p�gina web actual. Se colocan en el mismo lugar dentro de cada p�gina web del conjunto.",
				categoriaTecnica);
	}

	/**
	 * Cuando se han implementado rutas de navegaci�n en un conjunto de p�ginas web:
	 * 1. Navega a una p�gina web.
	 * 2. Verifique que se muestre una ruta de navegaci�n.
	 * 3. Compruebe que el rastro de navegaci�n muestre la secuencia de navegaci�n correcta para llegar a la ubicaci�n actual o la ruta jer�rquica correcta a la ubicaci�n actual dentro de la estructura del sitio.
	 * 4. Para un rastro de migas que no incluye la ubicaci�n actual:
	 * 		Verifique que todos los elementos en el rastro de navegaci�n est�n implementados como enlaces.
	 * 5. Para un rastro de migas de pan que incluye la ubicaci�n actual:
	 * 		Verifique que todos los elementos, excepto la ubicaci�n actual, est�n implementados como enlaces.
	 * 		Verifique que la ubicaci�n actual no est� implementada como un enlace.
	 * 6. Verifique que todos los enlaces naveguen a la p�gina web correcta seg�n lo especificado por el rastro de navegaci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRutaNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Existencia de rastro ruta de navegaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la p�gina web cuente con un rastre de la ruta de navegaci�n que fue realizando el usuario en la navegaci�n del sitio.",
				"Toda p�gina web debe tener un rastreo de ruta de navegaci�n del usuario para que sepa el recorrido que realizo y como llego a la p�gina que esta en ese momento.");
		comprobacionRutaNavegacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRutaNavegacion);
		return resultadoEvaluacionTecnica;
	}

}