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
				"Almacenar los datos codificaci�n como datos ocultos o cifrados en una p�gina de login.", 
				"Los servidores web que requieren autenticaci�n de usuario a menudo finalizan la sesi�n despu�s de un per�odo de tiempo establecido si no hay actividad del usuario. Si el usuario no puede ingresar los datos lo suficientemente r�pido y la sesi�n expira antes de que se env�en, el servidor requerir� una nueva autenticaci�n antes de continuar. Cuando esto sucede, el servidor pasa (como datos ocultos) la informaci�n del formulario a la p�gina que se utiliza para la reautenticaci�n. Luego, cuando el usuario vuelve a autenticarse, el servidor puede usar la informaci�n transmitida desde la p�gina de autenticaci�n para enviar el formulario directamente o presentar una p�gina que incluya los datos que se enviar�n para su revisi�n. En esta t�cnica, el servidor no tiene que almacenar ning�n dato enviado por el usuario en el servidor. Esta es una t�cnica importante para aquellos casos en que es ilegal o un riesgo de seguridad para el servidor almacenar informaci�n temporalmente. Tambi�n es �til porque libera al servidor de tener que mantener la informaci�n almacenada y volver a conectarla con la nueva sesi�n autenticada.",
				categoriaTecnica);
	}

	/**
	 * En un sitio que requiere el inicio de sesi�n del usuario para enviar datos:
	 * 1. Inicie sesi�n y comience la actividad programada.
	 * 2. Permita que la sesi�n termine.
	 * 3. Env�a los datos.
	 * 4. Volver a autenticarse
	 * 5. Compruebe que el proceso puede continuar y completarse sin p�rdida de datos, incluidos los datos originales y cualquier cambio realizado despu�s de la nueva autenticaci�n.
	 * 6. Compruebe que el proceso utilizado para guardar la informaci�n presentada en el paso 3 no se almacena en el servidor. (Nota: Esto requiere el conocimiento de la tecnolog�a y las caracter�sticas utilizadas para implementar la t�cnica).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDatosFormularioCifradosEnLogueo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Almacenar datos del formulario codificados como dato oculto o cifrados en p�gina de login.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al finalizar el tiempo de la sesi�n los datos del formulario se guardan codificados como dato oculto o cifrados en la p�gina del login para que al re-autenticarse el usuario vuelvan a aparecer en el formulario.",
				"Usar alguna t�cnica que permita almacenar los datos de los formularios ingresados por el usuario al finalizar el tiempo de la sesi�n codificados ocultos en el c�digo o cifrados en la pantalla del login para que al reingresar el usario no necesite volver a cargarlos.");
		comprobacionDatosFormularioCifradosEnLogueo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDatosFormularioCifradosEnLogueo);
		return resultadoEvaluacionTecnica;
	}

}