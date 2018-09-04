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
				"Uso de marcas diacríticas estándar que se pueden desactivar.", 
				"El objetivo de esta técnica es proporcionar a los usuarios un mecanismo para activar o desactivar las marcas diacríticas estándar. Muchos idiomas usan signos diacríticos o signos diacríticos para indicar la pronunciación de las palabras o para ayudar a distinguir entre palabras. Algunos lenguajes pueden usar diacríticos para indicar vocales, para indicar el doble de consonantes, para indicar la ausencia de una vocal o una consonante, o para otros fines. Aunque el texto sin tales signos diacríticos puede ser legible, la adición de signos diacríticos puede mejorar la legibilidad.",
				categoriaTecnica);
	}

	/**
	 * Para cualquier página web en un lenguaje humano que use signos diacríticos para distinguir entre los significados:
	 *  1. Verifique que la versión predeterminada del contenido use signos diacríticos.
	 *  2. Verifique que haya un mecanismo para activar o desactivar las marcas diacríticas.
	 *  3. Compruebe que el uso del mecanismo para desactivar las marcas diacríticas da como resultado un contenido que no muestra signos diacríticos.
	 *  4. Compruebe que el uso del mecanismo para activar las marcas diacríticas dé como resultado un contenido que muestre una marca diacrítica
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMarcasDiacriticas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Desactivar marcas diacríticas.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que exista un mecanismo que permita desactivar el uso de marcar diacríticas.",
				"Ofrece un mecanísmo que permita desactivar las marcas diacríticas del sitio web.");
		comprobacionMarcasDiacriticas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcasDiacriticas);
		return resultadoEvaluacionTecnica;
	}

}