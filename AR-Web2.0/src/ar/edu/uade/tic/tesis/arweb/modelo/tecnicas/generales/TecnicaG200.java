package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG200 extends TecnicaGeneral {

	public TecnicaG200(CategoriaTecnica categoriaTecnica) {
		super(
				"G200", 
				"La apertura de nuevas ventanas y pestañas de un enlace sólo cuando sea necesario.",
				"El objetivo de esta técnica es la de limitar el uso de enlaces o botones que abren nuevas ventanas o pestañas dentro del contenido Web. En general, es mejor no abrir las ventanas y pestañas nuevas, ya que pueden desorientar a las personas, especialmente las personas que tienen dificultades para percibir el contenido visual. Sin embargo, hay algunas situaciones en las que es preferible desde el punto de vista de accesibilidad abrir una nueva ventana o pestaña. Aquí hay dos tipos de situaciones: 1) •	La apertura de una página que contiene información contextual, como por ejemplo las instrucciones de ayuda, o un medio alternativo para completar un formulario, como un selector de fechas basado en el calendario, se interrumpiría considerablemente el flujo de trabajo de múltiples pasos, tales como rellenar y enviar un formulario, si la página se abre en la misma ventana o pestaña. 2) •	El usuario se registra en una zona de seguridad de un sitio, y siguiendo un enlace a una página que está afuera del área de seguridad terminaría con el inicio de sesión del usuario. En esta apertura de los enlaces externos en una ventana nueva que le permita al usuario acceder a tales referencias, manteniendo su nombre de usuario activo en la ventana original.", 
				categoriaTecnica);
	}

	/**
	 * Sin descripción!
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Apertura de nuevas ventanas y pestañas de un enlace sólo cuando sea necesario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la apertura de nuevas ventanas y pestañas de un enlace sólo cuando sea necesario.",
				"Abre ventanas nuevas sólo cuando sea la mejor alternativa.");
		comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario);
		return resultadoEvaluacionTecnica;
	}

}