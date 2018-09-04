package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG180 extends TecnicaGeneral {

	public TecnicaG180(CategoriaTecnica categoriaTecnica) {
		super(
				"G180",
				"Proporcionar al usuario un medio para establecer el límite de tiempo de 10 veces el límite de tiempo predeterminado.",
				"El objetivo de esta técnica es dar a las personas con discapacidad suficiente tiempo para completar las tareas que pueden tardar más tiempo que alguien sin esas dificultades. Algunos mecanismos, como una opción de preferencias o un control de la página  permite al usuario cambiar los límites de tiempo de al menos 10 veces el límite de tiempo predeterminado. Preferentemente, el mecanismo tendría un ajuste variable que permite al usuario cambiar el límite de tiempo para cualquier valor en su rango, pero también podría proporcionar formas de cambiar el límite de tiempo en incrementos discretos. El usuario cambia el límite de tiempo al inicio de su sesión, antes de cualquier actividad que tiene un límite de tiempo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar para ver si hay un mecanismo para establecer el límite de tiempo de 10 veces el límite de tiempo predeterminado.
	 * 2. Cambiar el límite de tiempo para un nuevo valor que es 10 veces el límite de tiempo predeterminado.
	 * 3. Realizar una acción que tiene un límite de tiempo.
	 * 4. Espere hasta que haya transcurrido el plazo predeterminado.
	 * 5. Verificar que el plazo no expira hasta el límite especificado en el paso 2 ha pasado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoControladoPorScript = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Límite de tiempo controlado mediante un script.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar para ver si hay un mecanismo para establecer el límite de tiempo de 10 veces el límite de tiempo predeterminado.",
				"Si el límite de tiempo es controlado por la programación de la página: Ofrece un medio para aumentar el límite de tiempo 10 veces al límite predefinido. Avisa al usuario cuando el límite de tiempo esté próximo a expirar: y permite que el usuario pueda aumentar el límite predefinido.");
		comprobacionLimiteTiempoControladoPorScript.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoControladoPorScript);
		return resultadoEvaluacionTecnica;
	}

}