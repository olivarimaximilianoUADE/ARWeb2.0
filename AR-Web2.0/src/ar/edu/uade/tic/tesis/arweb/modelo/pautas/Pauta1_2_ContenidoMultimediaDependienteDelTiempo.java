package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_1_SoloAudioYSoloVideoPregrabado;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_2_SubtitulosPregrabados;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_4_SubtitulosEnDirecto;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_5_AudiodescripcionPregrabada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_6_LeguaDeSeñasPregrabada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_7_AudiodescripcionExtendidaPregrabada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_8_AlternativasMultimediaPregrabada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_2_9_SoloAudioEnDirecto;

public class Pauta1_2_ContenidoMultimediaDependienteDelTiempo extends Pauta {

	public Pauta1_2_ContenidoMultimediaDependienteDelTiempo() {
		super(
				"1.2", 
				"Contenido multimedia dependiente del tiempo.", 
				"Proporcione alternativas sincronizadas para contenidos multimedia sincronizados dependientes del tiempo.");
	} 

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_2_1_SoloAudioYSoloVideoPregrabado());
		listaCriterios.add(new Criterio1_2_2_SubtitulosPregrabados()); 
		listaCriterios.add(new Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada());
		listaCriterios.add(new Criterio1_2_4_SubtitulosEnDirecto());
		listaCriterios.add(new Criterio1_2_5_AudiodescripcionPregrabada());
		listaCriterios.add(new Criterio1_2_6_LeguaDeSeñasPregrabada());
		listaCriterios.add(new Criterio1_2_7_AudiodescripcionExtendidaPregrabada());
		listaCriterios.add(new Criterio1_2_8_AlternativasMultimediaPregrabada());
		listaCriterios.add(new Criterio1_2_9_SoloAudioEnDirecto());
		
		return listaCriterios;
	}

}