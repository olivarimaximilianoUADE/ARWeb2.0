package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG161 extends TecnicaGeneral {

	public TecnicaG161(CategoriaTecnica categoriaTecnica) {
		super(
				"G161", 
				"Proporcionar una funci�n de b�squeda para ayudar a los usuarios a encontrar contenido.", 
				"Proporcionar una funci�n de b�squeda que busque en sus p�ginas web es una estrategia de dise�o que ofrece a los usuarios una forma de encontrar contenido. Los usuarios pueden localizar el contenido buscando palabras o frases espec�ficas, sin necesidad de comprender o navegar a trav�s de la estructura del sitio web. Esta puede ser una forma m�s r�pida o m�s f�cil de encontrar contenido, particularmente en sitios grandes. La implementaci�n de una funci�n de b�squeda que verificar� los t�rminos de ortograf�a, incluir� diferentes finales para los t�rminos (derivaci�n) y permitir� el uso de terminolog�a diferente (sin�nimos) aumentar� a�n m�s el acceso a la funci�n de b�squeda. La funcionalidad de b�squeda se agrega al incluir un formulario simple en la p�gina web, generalmente un campo de texto para el t�rmino de b�squeda y un bot�n para activar la b�squeda o al agregar un enlace a una p�gina que incluye un formulario de b�squeda. El formulario de b�squeda en s� debe ser accesible, por supuesto.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que la p�gina web contiene un formulario de b�squeda o un enlace a una p�gina de b�squeda
	 * 2. Escriba texto en el formulario de b�squeda que aparece en el conjunto de p�ginas web
	 * 3. Activar la b�squeda
	 * 4. Verifique que el usuario sea llevado a una p�gina que contenga el t�rmino de b�squeda
	 * 5. Compruebe que el usuario vaya a una p�gina que contiene una lista de enlaces a p�ginas que contienen el t�rmino de b�squeda.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFuncionDeBusqueda = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Buscador de contenido.",
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Proporcionar un buscador en el sitio que permita al usuario encontrar contenido facilmente.",
				"Ofrece un buscador en el sitio web para que el usuario puedo localizar el contenido que le interece de forma r�pida sin necesidad de leer o navegar por toda la p�gina.");
		comprobacionFuncionDeBusqueda.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFuncionDeBusqueda);
		return resultadoEvaluacionTecnica;
	}

}