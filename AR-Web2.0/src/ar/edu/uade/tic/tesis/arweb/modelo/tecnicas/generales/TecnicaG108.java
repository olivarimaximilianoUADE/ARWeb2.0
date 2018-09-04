package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG108 extends TecnicaGeneral {

	public TecnicaG108(CategoriaTecnica categoriaTecnica) {
		super(
				"G108",
				"Uso de las funciones de marcado para exponer el nombre y función, permite propiedades configurables por el usuario para establecer directamente, e informar de los cambios.",
				"El objetivo de esta técnica es permitir que la tecnología de asistencia para comprender el contenido Web para que pueda transmitir información equivalente al usuario a través de una interfaz de usuario alternativo y permitirles operar los controles a través de la AT. Esta técnica implica el uso de características estándar, documentadas y apoyadas para exponer estas propiedades a AT. Se basa en el hecho de que estos controles estándar en los navegadores estándar cumplen los requisitos. Para HTML estos supuestos son buenas. También pueden ser apropiados para otras tecnologías. Incluso cuando los componentes de soporte accesibilidad, es esencial que cierta información se proporcionará por el autor. Por ejemplo, un control puede tener la capacidad de proporcionar un nombre, pero el autor todavía tiene que proporcionar el nombre. Sin embargo, el papel atributo ya puede proporcionarse ya que es un componente estándar con un papel fijo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccione visualmente el marcado o utilizar una herramienta.
	 * 2. Verificar que el marcado adecuado se utiliza de tal manera que el nombre y la función, para cada componente de la interfaz de usuario se puede determinar.
	 * 3. Verificar que el marcado adecuado se utiliza de tal manera que los componentes de la interfaz de usuario que acepten la entrada del usuario pueden ser operados de AT.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionNombreRolValor = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Nombre, rol y valor.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el marcado adecuado se utiliza de tal manera que el nombre y la función, para cada componente de la interfaz de usuario se puede determinar.",
				"Usa las características del marcado para exponer el nombre y la función. Permite al usuario fijar las propiedades directamente en los elementos que sea posible y avisa de los cambios mediante: 1) controles de formulario y enlaces en HTML, 2) elementos \"label\" para asociar etiquetas de texto a controles de formulario; o el atributo \"title\" para identificar los controles si no puedes usar el elemento \"label\" 3) el atributo \"title\" de los elemento \"iframe\" y  \"frame\".");
		comprobacionNombreRolValor.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionNombreRolValor);
		return resultadoEvaluacionTecnica;
	}

}