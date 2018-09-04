package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG105 extends TecnicaGeneral {

	public TecnicaG105(CategoriaTecnica categoriaTecnica) {
		super(
				"G105",
				"Almacenar datos del formulario para que puedan ser usados luego de la re-autenticación del usuario.", 
				"Los servidores web que requieren autenticación de usuario a menudo finalizan la sesión después de un período de tiempo establecido si no hay actividad del usuario. Si el usuario no puede ingresar los datos lo suficientemente rápido y la sesión expira antes de que se envíen, el servidor requerirá una nueva autenticación antes de continuar. Cuando esto sucede, el servidor almacena los datos en un caché temporal mientras el usuario inicia sesión, y cuando el usuario se ha vuelto a autenticar, los datos están disponibles desde el caché y el formulario se procesa como si nunca hubiera habido una sesión -fuera. El servidor no conserva la memoria caché de forma indefinida, simplemente el tiempo suficiente para garantizar el éxito después de la nueva autenticación en una sola sesión de usuario, como un día.",
				categoriaTecnica);
	}

	/**
	 * En un sitio que requiere el inicio de sesión del usuario para enviar datos,
	 * 1. Inicie sesión y comience la actividad programada.
	 * 2. Permita que la sesión termine.
	 * 3. Envía los datos.
	 * 4. Volver a autenticarse
	 * 5. Compruebe que el proceso puede continuar y completarse sin pérdida de datos, incluidos los datos originales y cualquier cambio realizado después de la nueva autenticación.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCacheDatosFormulario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Cache de datos del formulario al requerir re-autenticación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al finalizar el tiempo de la sesión los datos del formulario se guardan en cache al re-autenticarse el usuario.",
				"Usar alguna técnica de cache que permita almacenar los datos de los formularios ingresados por si finaliza el tiempo de la sesión al reingresar el usario no necesite volver a cargarlos.");
		comprobacionCacheDatosFormulario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCacheDatosFormulario);
		return resultadoEvaluacionTecnica;
	}

}