package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG90  extends TecnicaGeneral {
	
	public TecnicaG90(CategoriaTecnica categoriaTecnica) {
		super(
				"G90", 
				"Proporcionar controladores de eventos activados por el teclado.", 
				"El objetivo de esta técnica es permitir que las personas que dependen de una interfaz de teclado o teclado accedan a la funcionalidad del contenido. Para ello, asegúrese de que  por otras funciones específicas del dispositivo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que se puede acceder a todas las funciones usando solo el teclado. 
	 */
	
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEventosTeclado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Validación todas las funcionalidad accesibles desde el teclado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verifique que todo el contenido del sitio puede recorrerse y ejecutarse usando el teclado.",
				"Todos los controladores de eventos del sitio activados por eventos de interfaz de usuario que no sean del teclado también deben estar asociados con un evento basado en teclado o proporcione mecanismos redundantes basados ​​en el teclado para lograr la funcionalidad proporcionada.");
		comprobacionEventosTeclado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEventosTeclado);
		return resultadoEvaluacionTecnica;
	}

}
