package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public abstract class TecnicaGeneral extends Tecnica {

	public TecnicaGeneral(String numero, String nombre, String descripcion, CategoriaTecnica categoriaTecnica) {
		super(numero, nombre, descripcion, categoriaTecnica);
	}

}