package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG181 extends TecnicaGeneral {

	public TecnicaG181(CategoriaTecnica categoriaTecnica) {
		super(
				"G181",
				"Almacenar los datos codificación como datos ocultos o cifrados en una página de login.", 
				"Los servidores web que requieren autenticación de usuario a menudo finalizan la sesión después de un período de tiempo establecido si no hay actividad del usuario. Si el usuario no puede ingresar los datos lo suficientemente rápido y la sesión expira antes de que se envíen, el servidor requerirá una nueva autenticación antes de continuar. Cuando esto sucede, el servidor pasa (como datos ocultos) la información del formulario a la página que se utiliza para la reautenticación. Luego, cuando el usuario vuelve a autenticarse, el servidor puede usar la información transmitida desde la página de autenticación para enviar el formulario directamente o presentar una página que incluya los datos que se enviarán para su revisión. En esta técnica, el servidor no tiene que almacenar ningún dato enviado por el usuario en el servidor. Esta es una técnica importante para aquellos casos en que es ilegal o un riesgo de seguridad para el servidor almacenar información temporalmente. También es útil porque libera al servidor de tener que mantener la información almacenada y volver a conectarla con la nueva sesión autenticada.",
				categoriaTecnica);
	}

	/**
	 * En un sitio que requiere el inicio de sesión del usuario para enviar datos:
	 * 1. Inicie sesión y comience la actividad programada.
	 * 2. Permita que la sesión termine.
	 * 3. Envía los datos.
	 * 4. Volver a autenticarse
	 * 5. Compruebe que el proceso puede continuar y completarse sin pérdida de datos, incluidos los datos originales y cualquier cambio realizado después de la nueva autenticación.
	 * 6. Compruebe que el proceso utilizado para guardar la información presentada en el paso 3 no se almacena en el servidor. (Nota: Esto requiere el conocimiento de la tecnología y las características utilizadas para implementar la técnica).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDatosFormularioCifradosEnLogueo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Almacenar datos del formulario codificados como dato oculto o cifrados en página de login.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al finalizar el tiempo de la sesión los datos del formulario se guardan codificados como dato oculto o cifrados en la página del login para que al re-autenticarse el usuario vuelvan a aparecer en el formulario.",
				"Usar alguna técnica que permita almacenar los datos de los formularios ingresados por el usuario al finalizar el tiempo de la sesión codificados ocultos en el código o cifrados en la pantalla del login para que al reingresar el usario no necesite volver a cargarlos.");
		comprobacionDatosFormularioCifradosEnLogueo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDatosFormularioCifradosEnLogueo);
		return resultadoEvaluacionTecnica;
	}

}