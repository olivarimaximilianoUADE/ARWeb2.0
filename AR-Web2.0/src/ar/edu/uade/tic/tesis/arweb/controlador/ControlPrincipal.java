package ar.edu.uade.tic.tesis.arweb.controlador;

import java.io.IOException;
import java.util.Properties;

import ar.edu.uade.tic.tesis.arweb.util.utilidades.Constantes;
//Comentado porque al ser un servicio web no hay pantalla, no hay paquete de vista
//import ar.edu.uade.tic.tesis.arweb.vista.Index;

public class ControlPrincipal {

	public static void main(String[] args) throws IOException {
		try {
			Properties properties = new Properties();
			properties.load(ControlPrincipal.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			Constantes.cargarVariables(properties);
		} catch (IOException e) {
			throw new IOException("No se pudo leer el archivo de Configuraciones: ".concat("Config.properties").concat(" : ").concat(e.getMessage()));
		}
		//new Index();
	}

}