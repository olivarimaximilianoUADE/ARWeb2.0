package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public abstract class TecnicaSCR  extends Tecnica {
	
	public TecnicaSCR(String numero, String nombre, String descripcion, CategoriaTecnica categoriaTecnica) {
		super(numero, nombre, descripcion, categoriaTecnica);
	}
	
}