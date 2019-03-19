package ar.edu.uade.tic.tesis.arweb.controlador;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.NivelAccesibilidad;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Contexto;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.ContextoClaves;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Utilidades;

public class GestorValidacionURL {

	public static ControlInformacion validarURL(String texto) {
		Parseador parseador = null;
		if (texto.equals("") || texto.equals("http://"))
			return new ControlInformacion(ControlInformacion.ERROR, "Complete el campo URL.", "", null);
		texto = Utilidades.completarURL(texto);
		try {
			parseador = new Parseador(new URL(texto), NivelAccesibilidad.A);
		} catch (MalformedURLException e) {
			return new ControlInformacion(ControlInformacion.ERROR, "La URL esta mal formada.", "", e);
		} catch (IOException e) {
			return new ControlInformacion(ControlInformacion.ERROR, "La URL es inexistente.", "", e);
		}
		Contexto.set(ContextoClaves.PARSEADOR, parseador);
		return new ControlInformacion();
	}

}