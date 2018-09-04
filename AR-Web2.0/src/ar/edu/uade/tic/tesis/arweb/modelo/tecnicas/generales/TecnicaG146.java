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
				"Usando diseño líquido.",
				"El objetivo de esta técnica es poder presentar el contenido sin introducir barras de desplazamiento horizontal mediante el uso de técnicas de diseño que se adaptan al espacio horizontal disponible. Los diseños de líquidos definen regiones de diseño que cambian de tamaño con el texto y vuelven a fluir según sea necesario para mostrar la región en la pantalla. Aunque el diseño exacto varía, la relación de los elementos y el orden de lectura siguen siendo los mismos. Esta es una forma efectiva de crear diseños que se presentan bien en diferentes dispositivos y para usuarios con diferentes preferencias de tamaño de fuente", 
				categoriaTecnica);
	}

	/**
	 * 1. Mostrar contenido en un agente de usuario.
	 * 2. Aumente el tamaño del texto al 200%.
	 * 3. Verifique si todo el contenido y la funcionalidad están disponibles sin desplazamiento horizontal.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBarraDesplazamientoHorizontal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Sin barras de desplazamiento horizontal si no entra todo el contenido.", 
				TipoResultadoEvaluacion.MANUAL,
				"Al variar la resolución del navegador del usuario el contenido se debe readactar evitando la utilización de barras de desplazamiento horizontales.",
				"Defina el tamaño de las regiones de diseño utilizando unidades que harán que la región se escale en relación con el texto, por lo que se agrandan o disminuyen a medida que el texto se agranda o reduce; ó Coloque las regiones de diseño como una fila de recuadros flotantes adyacentes, que se envuelven en nuevas filas según sea necesario de la misma manera que las palabras en un recuadro de párrafo.");
		comprobacionBarraDesplazamientoHorizontal.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBarraDesplazamientoHorizontal);
		return resultadoEvaluacionTecnica;
	}
	
}