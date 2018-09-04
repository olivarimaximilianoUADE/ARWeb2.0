package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG156 extends TecnicaGeneral {

	public TecnicaG156(CategoriaTecnica categoriaTecnica) {
		super(
				"G156",
				"Usar una tecnología que tenga agentes de usuario comúnmente disponibles que puedan cambiar el primer plano y el fondo de los bloques de texto.",
				"Algunas personas con discapacidades cognitivas requieren combinaciones de colores específicos de texto y fondo en primer plano para ayudarlos a comprender con éxito los contenidos de la página web. Los navegadores más populares ofrecen la opción de cambiar la configuración de colores de forma global en el navegador. En este caso, los colores seleccionados por el usuario anulan los colores de fondo y primer plano especificados por el autor web. Para cumplir con estos criterios de éxito, el autor web diseñaría la página para que funcione con los navegadores que tienen estos controles, y el autor no anula estos controles..", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra la página web en un navegador que permita a los usuarios cambiar los colores del contenido HTML.
	 * 2. Cambie los colores de primer plano y de fondo en la configuración del navegador para que sean diferentes a los especificados en el contenido.
	 * 3. Regrese a la página y verifique que los nuevos colores de fondo y texto de primer plano especificados en el navegador anulen los colores especificados en el contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambioColorTextoYFondo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Cambio de combinación de colores de texto y fondos en primer plano.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que al abrir el navegador y se cambie los colores del contenido HTML estos se apliquen.",
				"Diseñe la página web teniendo en cuenta que al modificar los colores de textos y fondos el sitio tiene que seguir conservando su forma y tiene que seguir siendo comprensible para el usuario.");
		comprobacionCambioColorTextoYFondo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambioColorTextoYFondo);
		return resultadoEvaluacionTecnica;
	}
	
}