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
				"Almacenar datos del formulario para que puedan ser usados luego de la re-autenticaci�n del usuario.", 
				"Los servidores web que requieren autenticaci�n de usuario a menudo finalizan la sesi�n despu�s de un per�odo de tiempo establecido si no hay actividad del usuario. Si el usuario no puede ingresar los datos lo suficientemente r�pido y la sesi�n expira antes de que se env�en, el servidor requerir� una nueva autenticaci�n antes de continuar. Cuando esto sucede, el servidor almacena los datos en un cach� temporal mientras el usuario inicia sesi�n, y cuando el usuario se ha vuelto a autenticar, los datos est�n disponibles desde el cach� y el formulario se procesa como si nunca hubiera habido una sesi�n -fuera. El servidor no conserva la memoria cach� de forma indefinida, simplemente el tiempo suficiente para garantizar el �xito despu�s de la nueva autenticaci�n en una sola sesi�n de usuario, como un d�a.",
				categoriaTecnica);
	}

	/**
	 * En un sitio que requiere el inicio de sesi�n del usuario para enviar datos,
	 * 1. Inicie sesi�n y comience la actividad programada.
	 * 2. Permita que la sesi�n termine.
	 * 3. Env�a los datos.
	 * 4. Volver a autenticarse
	 * 5. Compruebe que el proceso puede continuar y completarse sin p�rdida de datos, incluidos los datos originales y cualquier cambio realizado despu�s de la nueva autenticaci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCacheDatosFormulario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Cache de datos del formulario al requerir re-autenticaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al finalizar el tiempo de la sesi�n los datos del formulario se guardan en cache al re-autenticarse el usuario.",
				"Usar alguna t�cnica de cache que permita almacenar los datos de los formularios ingresados por si finaliza el tiempo de la sesi�n al reingresar el usario no necesite volver a cargarlos.");
		comprobacionCacheDatosFormulario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCacheDatosFormulario);
		return resultadoEvaluacionTecnica;
	}

}