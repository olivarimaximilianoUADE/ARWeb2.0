package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG1 extends TecnicaGeneral {

	public TecnicaG1(CategoriaTecnica categoriaTecnica) {
		super(
				"G1", 
				"Agregar un enlace al principio de cada página que lleve directamente al área de contenido principal.", 
				"El objetivo de esta técnica es proporcionar un mecanismo para eludir bloques de material que se repiten en múltiples páginas web saltándose directamente al contenido principal de la página web. El primer elemento interactivo en la página web es un enlace al principio de la página principal. La activación de los conjuntos de enlaces se centran más allá del otro contenido a la página principal. Esta técnica es más útil cuando una página Web tiene un área de contenido principal, en lugar de un conjunto de áreas de contenido que son igualmente importantes, y cuando no hay varias secciones de navegación de la página.", 
				categoriaTecnica);
	}

	/**
	 * 1.  Verificar que el enlace corresponda a la página Web. 
	 * 2.  Verificar que la descripción del enlace comunique que vincula a la página principal. 
	 * 3.  Verificar que el enlace esté siempre visible o visible cuando tiene el foco del teclado. 
	 * 4.  Verificar que la activación del enlace mueve el foco a la página principal. 
	 * 5.  Verificar que después de activar el enlace, el foco del teclado se haya movido a la página principal.
	 * EX: Compruebe que el primer enlace sea visible siempre o cuando recibe el foco del teclado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la activación del enlace mueve el foco a la página principal.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el principio de la página para ir directamente al contenido principal o  a cada bloque de contenido.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}