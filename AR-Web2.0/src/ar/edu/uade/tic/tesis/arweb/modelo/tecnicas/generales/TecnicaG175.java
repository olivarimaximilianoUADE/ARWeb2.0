package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG175 extends TecnicaGeneral {

	public TecnicaG175(CategoriaTecnica categoriaTecnica) {
		super(
				"G175", 
				"Proporcionar una herramienta de selecci�n de m�ltiples colores en la p�gina para colores de primer plano y fondo.", 
				"El objetivo de esta t�cnica es incluir un control en una p�gina web o un conjunto de p�ginas web que permita a los usuarios especificar los colores preferidos de primer plano y de fondo para el contenido. Esta t�cnica puede implementarse utilizando cualquier tecnolog�a que permita a los usuarios almacenar preferencias que puedan usarse en todas las p�ginas. Usando esta t�cnica, un autor incluye un control de selecci�n de color en el sitio que permite a los usuarios seleccionar y guardar las preferencias de color de primer plano y de fondo para usar en otras p�ginas de un sitio. Las p�ginas est�n dise�adas para buscar estas preferencias y adaptarse en consecuencia cuando se encuentran las configuraciones guardadas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que haya un control en la p�gina que se identifica como una herramienta de selecci�n de color.
	 * 2. Compruebe que la herramienta de selecci�n de color ofrece una variedad de opciones de colores para el texto y el fondo.
	 * 3. Seleccione nuevos colores para el texto y el fondo con la herramienta.
	 * 4. Verifique que el contenido est� actualizado para usar las combinaciones de colores seleccionadas.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlSeleccionColores = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"La p�gina debe tener una herramienta de selecci�n de m�ltiples colores de primer plano y fondo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con una herramienta de selecci�n de colores de primer plano y fondo.",
				"Debe existir un control que permita a los usuarios seleccionar los colores de primer plano y fondo para el contenido.");
		comprobacionControlSeleccionColores.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlSeleccionColores);
		return resultadoEvaluacionTecnica;
	}

}