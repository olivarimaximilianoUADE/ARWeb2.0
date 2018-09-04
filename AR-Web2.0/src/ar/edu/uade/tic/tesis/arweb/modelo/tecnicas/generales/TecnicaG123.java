package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG123 extends TecnicaGeneral {

	public TecnicaG123(CategoriaTecnica categoriaTecnica) {
		super(
				"G123",
				"Agregar un enlace al principio de un bloque de contenido repetitivo que dirija al final del bloque.",
				"El objetivo de esta técnica es proporcionar un mecanismo para pasar por alto un bloque de material saltando hasta el final del bloque. El primer eslabón de la manzana o el enlace anterior directamente el bloque se mueve el enfoque para el contenido inmediatamente después del bloque. Activando el enlace avanza el foco del teclado más allá del bloque. Cuando hay varios bloques a ser omitidos, el usuario se salta de un bloque a través de estos enlaces.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que un enlace es el último control enfocable antes de que el bloque de contenido repetitivo o el primer eslabón de la manzana.
	 * 2. Verificar que la descripción del enlace se comunica que se salta el bloque.
	 * 3. Verificar que el enlace está bien siempre visible o visible cuando tiene el foco del teclado.
	 * 4. Verificar que después de activar el enlace, el foco del teclado se ha movido al contenido inmediatamente después del bloque.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripción del enlace se comunica que se salta el bloque.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el inicio de cada bloque repetido para ir al final de ese bloque.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}