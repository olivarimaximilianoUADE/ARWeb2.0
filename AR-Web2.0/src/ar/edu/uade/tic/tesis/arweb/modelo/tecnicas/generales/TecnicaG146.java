package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG146 extends TecnicaGeneral {

	public TecnicaG146(CategoriaTecnica categoriaTecnica) {
		super(
				"G146",
				"Usando dise�o l�quido.",
				"El objetivo de esta t�cnica es poder presentar el contenido sin introducir barras de desplazamiento horizontal mediante el uso de t�cnicas de dise�o que se adaptan al espacio horizontal disponible. Los dise�os de l�quidos definen regiones de dise�o que cambian de tama�o con el texto y vuelven a fluir seg�n sea necesario para mostrar la regi�n en la pantalla. Aunque el dise�o exacto var�a, la relaci�n de los elementos y el orden de lectura siguen siendo los mismos. Esta es una forma efectiva de crear dise�os que se presentan bien en diferentes dispositivos y para usuarios con diferentes preferencias de tama�o de fuente", 
				categoriaTecnica);
	}

	/**
	 * 1. Mostrar contenido en un agente de usuario.
	 * 2. Aumente el tama�o del texto al 200%.
	 * 3. Verifique si todo el contenido y la funcionalidad est�n disponibles sin desplazamiento horizontal.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBarraDesplazamientoHorizontal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Sin barras de desplazamiento horizontal si no entra todo el contenido.", 
				TipoResultadoEvaluacion.MANUAL,
				"Al variar la resoluci�n del navegador del usuario el contenido se debe readactar evitando la utilizaci�n de barras de desplazamiento horizontales.",
				"Defina el tama�o de las regiones de dise�o utilizando unidades que har�n que la regi�n se escale en relaci�n con el texto, por lo que se agrandan o disminuyen a medida que el texto se agranda o reduce; � Coloque las regiones de dise�o como una fila de recuadros flotantes adyacentes, que se envuelven en nuevas filas seg�n sea necesario de la misma manera que las palabras en un recuadro de p�rrafo.");
		comprobacionBarraDesplazamientoHorizontal.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBarraDesplazamientoHorizontal);
		return resultadoEvaluacionTecnica;
	}
	
}