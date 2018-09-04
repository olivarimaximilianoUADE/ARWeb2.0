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
				"Usar una tecnolog�a que tenga agentes de usuario com�nmente disponibles que puedan cambiar el primer plano y el fondo de los bloques de texto.",
				"Algunas personas con discapacidades cognitivas requieren combinaciones de colores espec�ficos de texto y fondo en primer plano para ayudarlos a comprender con �xito los contenidos de la p�gina web. Los navegadores m�s populares ofrecen la opci�n de cambiar la configuraci�n de colores de forma global en el navegador. En este caso, los colores seleccionados por el usuario anulan los colores de fondo y primer plano especificados por el autor web. Para cumplir con estos criterios de �xito, el autor web dise�ar�a la p�gina para que funcione con los navegadores que tienen estos controles, y el autor no anula estos controles..", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra la p�gina web en un navegador que permita a los usuarios cambiar los colores del contenido HTML.
	 * 2. Cambie los colores de primer plano y de fondo en la configuraci�n del navegador para que sean diferentes a los especificados en el contenido.
	 * 3. Regrese a la p�gina y verifique que los nuevos colores de fondo y texto de primer plano especificados en el navegador anulen los colores especificados en el contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambioColorTextoYFondo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Cambio de combinaci�n de colores de texto y fondos en primer plano.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que al abrir el navegador y se cambie los colores del contenido HTML estos se apliquen.",
				"Dise�e la p�gina web teniendo en cuenta que al modificar los colores de textos y fondos el sitio tiene que seguir conservando su forma y tiene que seguir siendo comprensible para el usuario.");
		comprobacionCambioColorTextoYFondo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambioColorTextoYFondo);
		return resultadoEvaluacionTecnica;
	}
	
}