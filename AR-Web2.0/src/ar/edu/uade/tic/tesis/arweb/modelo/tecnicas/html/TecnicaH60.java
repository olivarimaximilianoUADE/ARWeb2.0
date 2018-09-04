package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaH60 extends TecnicaHTML {

	public TecnicaH60(CategoriaTecnica categoriaTecnica) {
		super(
				"H60",
				"Usar el elemento de enlace para vincular a un glosario.",
				"El objetivo de esta técnica es proporcionar un mecanismo para localizar un glosario. Cuando los términos del contenido se definen en una página de glosario separada, se hace referencia al glosario utilizando un elemento de enlace en el elemento principal del documento que utiliza el glosario. El atributo rel del elemento de enlace se establece en \"glosario\", y el atributo href contiene el URI de la página del glosario. Los agentes de usuario pueden ayudar a los usuarios a acceder al glosario de forma rápida y sencilla.",
				categoriaTecnica);
	}

	/**
	 * Para cualquier conjunto de palabras y sus definiciones que deben servir como un glosario:
	 *  1. Compruebe que la sección principal de la página web que contiene palabras, frases o abreviaturas definidas en un glosario contiene un elemento de enlace
	 *  2. Verifique que el elemento de enlace tenga un atributo rel = "glosario"
	 *  3. Compruebe que el atributo href del elemento de enlace se refiere a la página del glosario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlancesAlGlosario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Enlaces para vincular al glosario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que aquellas palabras o abreviaciones que requieran una defición debe haber un enlace al glosario.",
				"En cada sección en donde se tengan palabras, conceptos y/o abreviaciones que requieran una definición se debe poner un enlace al glosario donde se encuentre la explicación de los mismos.");
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlancesAlGlosario);
		return resultadoEvaluacionTecnica;
	}
}