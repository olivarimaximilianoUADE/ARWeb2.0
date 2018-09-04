package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG178 extends TecnicaGeneral {

	public TecnicaG178(CategoriaTecnica categoriaTecnica) {
		super(
				"G178", 
				"Proporciona controles en la p�gina web que permiten a los usuarios cambiar incrementalmente el tama�o de todo el texto en la p�gina hasta en un 200 por ciento.", 
				"El objetivo de esta t�cnica es proporcionar un mecanismo en la p�gina web para aumentar gradualmente el tama�o del texto. Muchas personas con baja visi�n no usan software de ampliaci�n y es posible que no est�n familiarizados con los ajustes de tama�o de texto de su navegador. Esto puede ser particularmente cierto en el caso de las personas mayores que est�n aprendiendo a usar la computadora y que pueden estar experimentando p�rdida de la visi�n relacionada con la edad. Tambi�n puede ser cierto para algunas personas con discapacidades cognitivas que requieren un mayor tama�o de fuente. Esta t�cnica proporciona un mecanismo que algunos usuarios encontrar�n m�s f�cil de usar. El mecanismo puede incluir enlaces o botones que cambiar�n la presentaci�n visual a una hoja de estilos diferente o utilizar�n secuencias de comandos para cambiar el tama�o del texto de forma din�mica.", 
				categoriaTecnica);
	}

	/**
	 * 1. Establezca el tama�o de la ventana gr�fica en 1024 px por 768 px o superior.
	 * 2. Aumente el tama�o del texto y verifique si el tama�o del texto aument�.
	 * 3. Verifique que el tama�o del texto se pueda aumentar al 200% del tama�o original.
	 * 4. Compruebe que despu�s de aumentar el tama�o del texto al 200% del tama�o original, no hay p�rdida de contenido o funcionalidad (por ejemplo: no se recortan partes del texto, los cuadros no se superponen, los controles no se oscurecen o se separan de sus etiquetas, etc. )
	 * 5. Disminuya el tama�o del texto a su valor predeterminado y verifique si de hecho volvi� al tama�o predeterminado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAumentoTama�oTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"El sitio web proporciona un control para aumentar el tama�o del texto hasta un 200 por ciento.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la p�gina web tenga un control que permita al usuario aumentar el tama�o de los textos hasta un 200 por ciento.",
				"Debe existir dentro del sitio un control que permita que los usuarios puedan aumentar gradualmente el tama�i del texto hasta un 200 por ciento.");
		comprobacionAumentoTama�oTexto.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAumentoTama�oTexto);
		return resultadoEvaluacionTecnica;
	}
	
}