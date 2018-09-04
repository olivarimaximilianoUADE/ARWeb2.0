package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG179 extends TecnicaGeneral {

	public TecnicaG179(CategoriaTecnica categoriaTecnica) {
		super(
				"G179", 
				"Garantizar que no haya p�rdida de contenido o funcionalidad cuando el texto cambia de tama�o y los contenedores de texto no cambian su ancho.", 
				"Algunos agentes de usuario admiten cambiar el tama�o del texto sin cambiar otras dimensiones del contenedor de texto. La p�rdida de contenido o funcionalidad puede ocurrir cuando el texto sobrepasa el espacio que se le asign�. Sin embargo, las propiedades de dise�o pueden proporcionar una forma de continuar mostrando el contenido de manera efectiva. Los tama�os de bloque se pueden definir lo suficientemente amplios como para que el texto no se desborde al cambiar el tama�o en un 200%. El texto se puede ajustar cuando ya no cabe dentro del bloque, y el bloque puede ser lo suficientemente alto para que todo el texto siga encajando en el bloque. El bloque puede proporcionar barras de desplazamiento cuando el texto redimensionado ya no se ajusta.", 
				categoriaTecnica);
	}

	/**
	 * 1. Aumente el tama�o del texto al 200%.
	 * 2. Verifique si todo el contenido y la funcionalidad est�n disponibles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAumentoTama�oTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Se debe poder aumentar el tama�o del texto sin perder contenido o funcionalidad.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todo el contenido de la p�gina web este presente y no se pierda funcionalidad al aumentar el tama�o del mismo desde el agente de usuario.",
				"El sitio debe permitir que al aumentar el tama�o del texto por medio del agente de usuario todo el contenido se ajuste para no perder nada de vista y tampoco se vea afectada la funcionalidad.");
		comprobacionAumentoTama�oTexto.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAumentoTama�oTexto);
		return resultadoEvaluacionTecnica;
	}
	
}