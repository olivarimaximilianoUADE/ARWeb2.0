package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG64 extends TecnicaGeneral {

	public TecnicaG64(CategoriaTecnica categoriaTecnica) {
		super(
				"G64", 
				"Proporcionar una tabla de contenido.", 
				"Una tabla de contenido proporciona enlaces a secciones y subsecciones del mismo documento. La información en el documento generalmente se organiza jerárquicamente y está destinada a ser leída secuencialmente. Del mismo modo que podría haber muchos libros en una biblioteca, cada uno con su propia tabla de contenidos, un sitio web puede contener muchos documentos, cada uno con su propia tabla de contenidos.\r\n" + 
				"\r\n" + 
				"La tabla de contenido tiene dos propósitos:\r\n" + 
				"\r\n" + 
				"Ofrece a los usuarios una visión general de los contenidos y la organización del documento.\r\n" + 
				"\r\n" + 
				"Permite a los lectores ir directamente a una sección específica de un documento en línea.\r\n" + 
				"\r\n" + 
				"La tabla de contenido generalmente incluye solo las secciones principales del documento, aunque en algunos casos puede ser deseable una tabla de contenido ampliada que proporcione una vista más detallada de un documento complejo.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que exista una tabla de contenido o un enlace a una tabla de contenidos en el documento.
	 * 2. Compruebe que los valores y el orden de las entradas en la tabla de contenido correspondan a los nombres y el orden de las secciones del documento.
	 * 3. Verifique que las entradas en la tabla de contenido se vinculen con las secciones correctas del documento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablaDeContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Existencia de tabla de contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página web cuente con una tabla de contenido con los enlaces a las secciones y subsecciones del documento.",
				"Toda página web debe tener una tabla de contenido con los enlaces a las secciones y subsecciones del mismo para facilitar la navegación en la misma.");
		comprobacionTablaDeContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaDeContenido);
		return resultadoEvaluacionTecnica;
	}

}