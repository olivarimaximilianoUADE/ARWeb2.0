package ar.edu.uade.tic.tesis.arweb.modelo.tecnica;

import com.owlike.genson.annotation.JsonIgnore;
import com.owlike.genson.annotation.JsonProperty;

import ar.edu.uade.tic.tesis.arweb.modelo.base.Estructura;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public abstract class Tecnica extends Estructura {

	private CategoriaTecnica categoriaTecnica;
	private Parseador parseador;
	private String url;
	private static final String URL_TECNICA = "https://www.w3.org/TR/WCAG20-TECHS/";//Constantes.URL_TECNICAS_WCAG20;

	public Tecnica(String numero, String nombre, String descripcion, CategoriaTecnica categoriaTecnica) {
		super(numero, nombre, descripcion);
		this.setCategoriaTecnica(categoriaTecnica);
		this.setUrl(URL_TECNICA + this.getNumero());
	}

	public abstract ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador);

	public Boolean isCategoriaTecnicaSuficiente() {
		return this.getCategoriaTecnica().getRepresentacionNumerica() == CategoriaTecnica.SUFICIENTE.getRepresentacionNumerica();
	}

	public Boolean isCategoriaTecnicaRecomendable() {
		return this.getCategoriaTecnica().getRepresentacionNumerica() == CategoriaTecnica.RECOMENDABLE.getRepresentacionNumerica();
	}

	public CategoriaTecnica getCategoriaTecnica() {
		return this.categoriaTecnica;
	}

	public void setCategoriaTecnica(CategoriaTecnica categoriaTecnica) {
		this.categoriaTecnica = categoriaTecnica;
	}
	@JsonIgnore
	public Parseador getParseador() {
		return this.parseador;
	}
	@JsonProperty
	public void setParseador(Parseador parseador) {
		this.parseador = parseador;
	}

	public String getUrl() {
		return this.url;
	}

	private void setUrl(String url) {
		this.url = url;
	}
	
	public String getPackageClassName() {
		return this.getClass().getCanonicalName();
	}

	public String toString() {
		return this.getCategoriaTecnica().getRepresentacionSimbolica() + ": " + this.getNumero();
	}

}