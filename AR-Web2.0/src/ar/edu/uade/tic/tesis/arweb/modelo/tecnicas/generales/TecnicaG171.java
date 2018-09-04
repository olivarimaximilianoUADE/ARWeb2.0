package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG171 extends TecnicaGeneral {

	public TecnicaG171(CategoriaTecnica categoriaTecnica) {
		super(
				"G171", 
				"Reproducción de sonidos sólo a petición del usuario.", 
				"La intención de esta técnica es permitir a un usuario controlar el uso de sonidos en el contenido Web. Alguien que utiliza un lector de pantalla puede resultar muy molesto y difícil de escuchar a su lector de pantalla si hay también sonidos procedentes de contenido Web. Proporcionando una manera de reproducir sonidos únicamente a petición dará a un usuario el control necesario para escuchar sonidos o otros archivos de audio sin interferir con la salida de un lector de pantalla.", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar una página Web que se conoce que contiene sonidos que se reproducen por 3 segundos o mas.
	 * 2. Verificar que los sonidos no se reproduzcan automáticamente.
	 * 3. Verificar que haya un forma para que el usuario inicie los sonidos manualmente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormaUsuarioInicieSonidosManualmente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Forma para que el usuario inicie los sonidos manualmente.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cargar una página Web que se conoce que contiene sonidos que se reproducen por 3 segundos o mas: Verificar que haya un forma para que el usuario inicie los sonidos manualmente.",
				"Reproduce los sonidos sólo a petición del usuario.");
		comprobacionFormaUsuarioInicieSonidosManualmente.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormaUsuarioInicieSonidosManualmente);
		return resultadoEvaluacionTecnica;
	}

}