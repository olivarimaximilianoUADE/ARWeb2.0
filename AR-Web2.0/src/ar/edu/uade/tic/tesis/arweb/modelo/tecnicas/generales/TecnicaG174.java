package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG174 extends TecnicaGeneral {

	public TecnicaG174(CategoriaTecnica categoriaTecnica) {
		super(
				"G174",
				"Proporcionar un control con una relaci�n de contraste suficiente que permita a los usuarios cambiar a una presentaci�n que use suficiente contraste.",
				"Cuando el contraste entre el texto y su fondo para una parte de la p�gina no se ha dise�ado para cumplir con el nivel de contraste para el Criterio de Conformidad 1.4.3 o 1.4.6, es posible cumplir estas pautas utilizando la cl�usula de \"Versi�n Alternativa\" en los requisitos de conformidad (Requisito de conformidad 1). Un enlace o control en la p�gina puede cambiar la p�gina para que todos los aspectos se ajusten, o podr�a llevar al espectador a una nueva versi�n de la p�gina que se ajuste al nivel deseado. Colocar el enlace o el control de forma destacada en la p�gina ayudar� a los usuarios a acceder f�cilmente al contenido conforme.\r\n Para que esta t�cnica se use con �xito, deben cumplirse tres cosas:\r\n" + 
				"\r\n" + 
				"1. El enlace o control en la p�gina original debe cumplir con los requisitos de contraste del SC deseado. (Si el usuario no puede ver el control, es posible que no pueda usarlo para ir a la nueva p�gina).\r\n" + 
				"\r\n" + 
				"2. La nueva p�gina debe contener la misma informaci�n y funcionalidad que la p�gina original.\r\n" + 
				"\r\n" + 
				"3. La nueva p�gina debe cumplir con todos los SC para el nivel deseado de conformidad. (es decir, la nueva p�gina no puede tener el nivel de contraste deseado, sino que no cumple).", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que exista un enlace o control en la p�gina original que proporciona acceso a la versi�n alternativa.
	 * 2. Verifique que el enlace o control en la p�gina original cumpla con todos los criterios de �xito para el nivel de conformidad que se est� probando.
	 * 3. Verifique que la versi�n alternativa cumpla con el contraste y todos los dem�s criterios de �xito para el nivel de conformidad que se est� probando.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVersionAlternativa = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"No existe link a versi�n alternativa cuando un control con una relaci�n de contraste insuficiente no le permite al usuario cambiar la misma.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Revisar todo el contenido de la p�gina y verificar que exista un enlace o control en la p�gina que proporcione acceso a la versi�n alternativa.",
				"Cuando haya un control que presente una relaci�n de contrataste insuficiente debe existir un acceso a la versi�n alternativa que tenga contraste adecuado y con la misma informaci�n y contenido que la versi�n original.");
		comprobacionVersionAlternativa.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVersionAlternativa);
		return resultadoEvaluacionTecnica;
	}
	
}
