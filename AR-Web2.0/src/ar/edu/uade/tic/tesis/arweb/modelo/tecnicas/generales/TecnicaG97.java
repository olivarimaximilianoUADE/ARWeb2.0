package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG97 extends TecnicaGeneral {

	public TecnicaG97(CategoriaTecnica categoriaTecnica) {
		super(
				"G97",
				"Proporcionar la forma expandida de una abreviatura inmediatamente antes o despu�s de la abreviaci�n.",
				"El objetivo de esta t�cnica es hacer que la forma expandida de una abreviatura est� disponible la primera vez que aparece dentro de una p�gina web. La expansi�n de cualquier abreviatura se puede encontrar buscando en la p�gina web para el primer uso.", 
				categoriaTecnica);
	}

	/**
	 * Para cada abreviatura en el contenido:
	 *  1. Busque el primer uso de esa abreviatura en el componente creado.
	 *  2. Verifique que el primer uso est� precedido o seguido inmediatamente por la forma expandida de la abreviatura.
	 *  3. Compruebe que la forma expandida sea la forma expandida correcta para el uso de la abreviatura.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormaExpandidaDeAbreviacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Uso extendido de una abreviatura en la primera aparici�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que inmediatamente despues de una abreviatura aparezca la forma extendida la primera vez que esta abreviatura aparece en el sitio.",
				"Cuando se utilizan abreviaturas en el sitio se debe brindar la forma extenida de la misma la primera vez que esta se usa.");
		comprobacionFormaExpandidaDeAbreviacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormaExpandidaDeAbreviacion);
		return resultadoEvaluacionTecnica;
	}

}