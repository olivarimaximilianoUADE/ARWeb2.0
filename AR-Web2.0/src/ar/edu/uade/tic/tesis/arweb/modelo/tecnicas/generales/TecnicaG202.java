package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG202 extends TecnicaGeneral {

	public TecnicaG202(CategoriaTecnica categoriaTecnica) {
		super(
				"G202", 
				"Asegurar el control de teclado para todas las funciones.", 
				"El objetivo de esta técnica es proveer operaciones de teclado para todas las funcionalidades de la página. Cuando toda la funcionalidad de contenido puede ser operado a través de una interfaz de teclado o un teclado,  puede ser operado por los que no tienen visión, así como por los que deben utilizar teclados alternativos o dispositivos de entrada que actúan como emuladores de teclado como el software de entrada de voz o teclado en pantalla. Una interfaz de teclado permite proveer a los usuarios ingreso de pulsaciones de teclas a los programas, incluso si el dispositivo informático que está utilizando no contiene un teclado de hardware. Por ejemplo, muchos dispositivos móviles tienen interfaces de teclado dentro de su sistema operativo, a su vez la opción de conectar teclados inalámbricos externos. Las aplicaciones pueden utilizar la interfaz para obtener la entrada del teclado, ya sea desde un teclado externo o desde otros servicios que proporcionan salida de teclado simulado, tales como dispositivos de conmutación, intérpretes de escritura a mano o aplicaciones de voz a texto. Para poner en práctica esta técnica, determinar en primer lugar que funcionalidad está disponible para los usuarios en la página. En este paso, es importante tener en cuenta funciones realizadas usando el ratón y el teclado juntos. Ejemplos de funcionalidad incluyen el uso de controles físicos, tales como enlaces, menús, botones, casillas de verificación, botones de radio y campos de formulario, así como el uso de características como arrastrar y soltar, selección de texto, cambiar el tamaño de las regiones o traer los menús de contexto. Otros ejemplos de funcionalidad pueden estar basados en tareas tales como la adición o eliminación de un elemento de un carrito de compras o el inicio de una sesión de chat con un representante de ventas. Una vez se ha determinado la funcionalidad del contenido, el autor verifica que cada una de las funciones identificadas se puede realizar utilizando sólo el teclado.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar todas las funcionalidad del contenido.
	 * 2. Verificar que todas las funcionalidades puedan ser accedidas utilizando sólo el teclado o interfaz de teclado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Funcionalidades accedidas utilizando sólo el teclado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todas las funcionalidades puedan ser accedidas utilizando sólo el teclado o interfaz de teclado.",
				"Ofrece manejadores de eventos de teclado usando una de las siguientes opciones: 1) incluyendo funciones específicas de teclado y de otro dispositivo. 2) haciendo que el evento \"on click\" en enlaces y botones sea accesible por teclado. 3) haciendo redundantes los eventos de mouse y teclado.");
		comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado);
		return resultadoEvaluacionTecnica;
	}

}