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
				"Proporcionar un control con una relación de contraste suficiente que permita a los usuarios cambiar a una presentación que use suficiente contraste.",
				"Cuando el contraste entre el texto y su fondo para una parte de la página no se ha diseñado para cumplir con el nivel de contraste para el Criterio de Conformidad 1.4.3 o 1.4.6, es posible cumplir estas pautas utilizando la cláusula de \"Versión Alternativa\" en los requisitos de conformidad (Requisito de conformidad 1). Un enlace o control en la página puede cambiar la página para que todos los aspectos se ajusten, o podría llevar al espectador a una nueva versión de la página que se ajuste al nivel deseado. Colocar el enlace o el control de forma destacada en la página ayudará a los usuarios a acceder fácilmente al contenido conforme.\r\n Para que esta técnica se use con éxito, deben cumplirse tres cosas:\r\n" + 
				"\r\n" + 
				"1. El enlace o control en la página original debe cumplir con los requisitos de contraste del SC deseado. (Si el usuario no puede ver el control, es posible que no pueda usarlo para ir a la nueva página).\r\n" + 
				"\r\n" + 
				"2. La nueva página debe contener la misma información y funcionalidad que la página original.\r\n" + 
				"\r\n" + 
				"3. La nueva página debe cumplir con todos los SC para el nivel deseado de conformidad. (es decir, la nueva página no puede tener el nivel de contraste deseado, sino que no cumple).", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que exista un enlace o control en la página original que proporciona acceso a la versión alternativa.
	 * 2. Verifique que el enlace o control en la página original cumpla con todos los criterios de éxito para el nivel de conformidad que se está probando.
	 * 3. Verifique que la versión alternativa cumpla con el contraste y todos los demás criterios de éxito para el nivel de conformidad que se está probando.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVersionAlternativa = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"No existe link a versión alternativa cuando un control con una relación de contraste insuficiente no le permite al usuario cambiar la misma.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Revisar todo el contenido de la página y verificar que exista un enlace o control en la página que proporcione acceso a la versión alternativa.",
				"Cuando haya un control que presente una relación de contrataste insuficiente debe existir un acceso a la versión alternativa que tenga contraste adecuado y con la misma información y contenido que la versión original.");
		comprobacionVersionAlternativa.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVersionAlternativa);
		return resultadoEvaluacionTecnica;
	}
	
}
