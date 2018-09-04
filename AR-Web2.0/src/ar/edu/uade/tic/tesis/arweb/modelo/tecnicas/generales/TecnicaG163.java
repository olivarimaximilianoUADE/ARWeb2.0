package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG163 extends TecnicaGeneral {

	public TecnicaG163(CategoriaTecnica categoriaTecnica) {
		super(
				"G163", 
				"Uso de marcas diacr�ticas est�ndar que se pueden desactivar.", 
				"El objetivo de esta t�cnica es proporcionar a los usuarios un mecanismo para activar o desactivar las marcas diacr�ticas est�ndar. Muchos idiomas usan signos diacr�ticos o signos diacr�ticos para indicar la pronunciaci�n de las palabras o para ayudar a distinguir entre palabras. Algunos lenguajes pueden usar diacr�ticos para indicar vocales, para indicar el doble de consonantes, para indicar la ausencia de una vocal o una consonante, o para otros fines. Aunque el texto sin tales signos diacr�ticos puede ser legible, la adici�n de signos diacr�ticos puede mejorar la legibilidad.",
				categoriaTecnica);
	}

	/**
	 * Para cualquier p�gina web en un lenguaje humano que use signos diacr�ticos para distinguir entre los significados:
	 *  1. Verifique que la versi�n predeterminada del contenido use signos diacr�ticos.
	 *  2. Verifique que haya un mecanismo para activar o desactivar las marcas diacr�ticas.
	 *  3. Compruebe que el uso del mecanismo para desactivar las marcas diacr�ticas da como resultado un contenido que no muestra signos diacr�ticos.
	 *  4. Compruebe que el uso del mecanismo para activar las marcas diacr�ticas d� como resultado un contenido que muestre una marca diacr�tica
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMarcasDiacriticas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Desactivar marcas diacr�ticas.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que exista un mecanismo que permita desactivar el uso de marcar diacr�ticas.",
				"Ofrece un mecan�smo que permita desactivar las marcas diacr�ticas del sitio web.");
		comprobacionMarcasDiacriticas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcasDiacriticas);
		return resultadoEvaluacionTecnica;
	}

}