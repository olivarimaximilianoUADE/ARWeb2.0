package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG63 extends TecnicaGeneral {

	public TecnicaG63(CategoriaTecnica categoriaTecnica) {
		super(
				"G63", 
				"Proporcionar un mapa del sitio.", 
				"Un mapa del sitio es una página web que proporciona enlaces a diferentes secciones del sitio. Para que el mapa del sitio esté disponible dentro del sitio, como mínimo, cada página que figura en el mapa del sitio contiene un enlace al mapa del sitio. El mapa del sitio sirve para varios propósitos.\r\n" + 
				"\r\n" + 
				"Proporciona una descripción general de todo el sitio.\r\n" + 
				"\r\n" + 
				"Ayuda a los usuarios a comprender qué contiene el sitio y cómo se organiza el contenido.\r\n" + 
				"\r\n" + 
				"Ofrece una alternativa a barras de navegación complejas que pueden ser diferentes en diferentes partes del sitio." +
				"\r\n" + 
				"Hay diferentes tipos de mapas del sitio. El tipo de mapa de sitio más simple y común es un esquema que muestra enlaces a cada sección o subsitio. Dichas vistas de esquema no muestran relaciones más complejas dentro del sitio, como enlaces entre páginas en diferentes secciones del sitio. Los mapas del sitio para algunos sitios grandes usan encabezados que se expanden para mostrar detalles adicionales sobre cada sección.",
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que el sitio contenga un mapa del sitio.
	 * 2. Verifique que los enlaces en el mapa del sitio conducen a las secciones correspondientes del sitio.
	 * 3. Para cada enlace en el mapa del sitio, verifique que la página de destino contenga un enlace al mapa del sitio.
	 * 4. Para cada página del sitio, verifique que se pueda llegar a la página siguiendo un conjunto de enlaces que comienzan en el mapa del sitio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExistenciaMapaDelSitio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Existencia de mapa del sitio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un mapa en donde estan todos los enlaces a las diferentes secciones del mismo.",
				"Ofrecer un mapa del sitio con todos los enlaces a las diferentes secciones del sitio web.");
		comprobacionExistenciaMapaDelSitio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExistenciaMapaDelSitio);
		return resultadoEvaluacionTecnica;
	}

}