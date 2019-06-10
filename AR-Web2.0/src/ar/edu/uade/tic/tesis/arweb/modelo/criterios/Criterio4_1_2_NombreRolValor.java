package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG108;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH44;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH64;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH65;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH88;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH91;

public class Criterio4_1_2_NombreRolValor extends Criterio {

	public Criterio4_1_2_NombreRolValor() {
		super(
				"4.1.2",
				"Nombre, rol, valor.",
				"Para todo componente de interfaz de usuario (incluidos, pero no limitados a: elementos de formulario, vínculos y componentes generados por medio de scripts), el nombre y el rol pueden ser programablemente determinados, los estados, propiedades y valores que pueden ser establecidos por el usuario pueden ser programablemente establecidos, y los cambios en tales ítems se notifican a los agentes de usuario, incluidas las ayudas técnicas.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG108(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH91(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH64(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH88(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}