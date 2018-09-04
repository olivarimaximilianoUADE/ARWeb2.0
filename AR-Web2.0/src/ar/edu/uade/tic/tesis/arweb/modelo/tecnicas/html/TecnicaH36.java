package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.FormControlType;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH36 extends TecnicaHTML {

	public TecnicaH36(CategoriaTecnica categoriaTecnica) {
		super(
				"H36", 
				"Usar atributos alt en las imágenes usadas como botones de envío.",	
				"Para los elementos input de tipo \"image\", el atributo alt se utiliza para proporcionar una etiqueta funcional. Esta etiqueta indica la función del botón, pero no trata de describir la imagen. La etiqueta es especialmente importante si hay varios botones de envío en la página que conducen, cada uno, a resultados diferentes. El elemento input se usa para crear muchos tipos de controles de formulario. A pesar de que las DTD de HTML y XHTML permiten el atributo alt en todos estos controles, debe ser usado sólo en los botones gráficos. El soporte de las aplicaciones de usuario a este atributo en otros tipos de controles de formulario no está bien definido y se usan otros mecanismos para etiquetar estos controles.",
				categoriaTecnica);
	}

	/**
	 * 1. Para todos los elementos 'input' que tienen un valor de atributo de tipo de 'image' , verificar la presencia de un atributo 'alt'. 
	 * 2. Verificar que el atributo alt indica la función del botón.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBotonGraficosSinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Botones gráficos sin atributo \"alt\".",
				"Para todos los elementos \"input\" que tienen un valor de atributo de tipo de \"image\", verificar la presencia de un atributo \"alt\".",
				"Utiliza el atributo \"alt\" en imágenes usada como botones.");
		ResultadoEvaluacionTecnicaItem comprobacionBotonGraficosConAltIndicandoFuncionBoton = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Atributo \"alt\" no indica función del botón.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"alt\" indica la función del botón.",
				"Asegúrate que la alternativa textual describe la función del botón.");
		for (Element elemento : this.getParseador().getElementos()) {
			if (elemento.getName().equals(HTMLElementName.INPUT))
				if (elemento.getFormControl() != null)
					if (elemento.getFormControl().getFormControlType().equals(FormControlType.IMAGE)) {
						String atributoAlt = elemento.getAttributeValue("alt");
						if (atributoAlt == null) 
							comprobacionBotonGraficosSinAlt.procesar(elemento);
						else
							if (atributoAlt.isEmpty()) 
								comprobacionBotonGraficosSinAlt.procesar(elemento);
						comprobacionBotonGraficosConAltIndicandoFuncionBoton.procesar(elemento);
					}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonGraficosSinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonGraficosConAltIndicandoFuncionBoton);
		return resultadoEvaluacionTecnica;
	}

}