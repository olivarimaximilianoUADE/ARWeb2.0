package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public abstract class TecnicaHTML extends Tecnica {
	
	public TecnicaHTML(String numero, String nombre, String descripcion, CategoriaTecnica categoriaTecnica) {
		super(numero, nombre, descripcion, categoriaTecnica);
	}
	
}
