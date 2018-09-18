package ar.edu.uade.tic.tesis.arweb.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnalisisDAO extends Analisis implements DAO {

	private static String tablaSQL = "";
	private static String camposSQL = "";
	private static String prefSQL = "";
	private static String idSQL = "";
	private static String urlSQL = "";
	private static String fechaSQL = "";
	private static String principiosSQL = "";
	private static String nivelSQL = "";
	private static String umbralSQL = "";
	private static String problemasSQL = "";
	private static String advertenciasSQL = "";
	private static String noVerificadosSQL = "";
	private static String accesibilidadSQL = "";

	private void registrar() {
		AnalisisDAO.tablaSQL = "HISTORICO_ANALISIS";
		AnalisisDAO.prefSQL = "Analisis_";
		AnalisisDAO.idSQL = AnalisisDAO.prefSQL + "ID";
		AnalisisDAO.urlSQL = AnalisisDAO.prefSQL + "URL";
		AnalisisDAO.fechaSQL = AnalisisDAO.prefSQL + "Fecha";
		AnalisisDAO.principiosSQL = AnalisisDAO.prefSQL + "Principios";
		AnalisisDAO.nivelSQL = AnalisisDAO.prefSQL + "Nivel";
		AnalisisDAO.umbralSQL = AnalisisDAO.prefSQL + "Umbral";
		AnalisisDAO.problemasSQL = AnalisisDAO.prefSQL + "Problemas";
		AnalisisDAO.advertenciasSQL = AnalisisDAO.prefSQL + "Advertencias";
		AnalisisDAO.noVerificadosSQL = AnalisisDAO.prefSQL + "NoVerificados";
		AnalisisDAO.accesibilidadSQL = AnalisisDAO.prefSQL + "Accesibilidad";
		AnalisisDAO.camposSQL = AnalisisDAO.idSQL + " , " + AnalisisDAO.urlSQL + " , " + AnalisisDAO.fechaSQL + " , "
				+ AnalisisDAO.principiosSQL + " , " + AnalisisDAO.nivelSQL + " , " + AnalisisDAO.umbralSQL + " , "
				+ AnalisisDAO.problemasSQL + " , " + AnalisisDAO.advertenciasSQL + " , " + AnalisisDAO.noVerificadosSQL
				+ " , " + AnalisisDAO.accesibilidadSQL;
	}

	public AnalisisDAO() {
		super();
		this.registrar();
	}

	public AnalisisDAO(String url) {
		super(url);
		this.registrar();
	}

	public AnalisisDAO(String url, String principios, String nivelAccesibilidad, Integer umbral, Integer problemas,
			Integer advertencias, Integer noVerificados, Integer accesibilidad) {
		super(0L, url, principios, nivelAccesibilidad, umbral, problemas, advertencias, noVerificados, accesibilidad);
		this.registrar();
	}

	private void completarObjetoAnalisis(Analisis analisis, ResultSet resultSet) throws Exception {
		analisis.setId(resultSet.getLong(1));
		analisis.setUrl(resultSet.getString(2));
		analisis.setFechaHora(resultSet.getString(3));
		analisis.setPrincipios(resultSet.getString(4));
		analisis.setNivelAccesibilidad(resultSet.getString(5));
		analisis.setUmbral(resultSet.getInt(6));
		analisis.setProblemas(resultSet.getInt(7));
		analisis.setAdvertencias(resultSet.getInt(8));
		analisis.setNoVerificados(resultSet.getInt(9));
		analisis.setAccesibilidad(resultSet.getInt(10));
	}

	public void select() throws Exception {
		DbConnMySql db = new DbConnMySql();
		try {
			db.selectObjeto(AnalisisDAO.urlSQL + " = '" + this.getUrl() + "'", AnalisisDAO.idSQL, this);
		} finally {
			db.closeConnection();
		}
	}

	public String listaTabla() {
		return AnalisisDAO.tablaSQL;
	}

	public String listaCampos() {
		return AnalisisDAO.camposSQL;
	}

	public void listaFill(ResultSet resultSet) throws Exception {
		this.completarObjetoAnalisis(this, resultSet);
	}

	public Object listaCallback(ResultSet resultSet) throws Exception {
		Analisis analisis = new Analisis();
		this.completarObjetoAnalisis(analisis, resultSet);
		return analisis;
	}

	public void insertHistorico() throws Exception {
		DbConnMySql db = new DbConnMySql();
		try {
			this.setId(Long.parseLong(
					db.Insert(this.listaTabla(), this.listaCampos().substring(this.listaCampos().indexOf(',') + 1),
							"'" + this.getUrl() + "' , '" + this.getFechaHora() + "' , '"
									+ this.getPrincipios() + "' , '" + this.getNivelAccesibilidad() + "' , "
									+ this.getUmbral() + " , " + this.getProblemas() + " , " + this.getAdvertencias()
									+ " , " + this.getNoVerificados() + " , " + this.getAccesibilidad())));
			db.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			db.closeConnection();
		}
	}

	public void insertAnexo(String tabla, String base64, Long analisisId) throws Exception {
		DbConnMySql db = new DbConnMySql();
		try {
			String q = "INSERT INTO " + tabla + " (Analisis_Id, Base64) VALUES (?, ?)";
			PreparedStatement st = db.openStatement(q);
			st.setString(1, analisisId.toString());
			st.setString(2, base64);
			st.executeUpdate();

			db.commit();
		}catch (Exception e) {
			throw e;
		} finally {
			db.closeConnection();
		}
	}

	public void insertarResultadoCriterioTecnica(String script) throws Exception {
		DbConnMySql db = new DbConnMySql();
		try {
			PreparedStatement st = db.openStatement(script);
			st.executeUpdate();

			db.commit();
		}catch (Exception e) {
			throw e;
		}
		finally {
			db.closeConnection();
		}
	}

	public String selectAnexo(String tabla, Long analisisId) throws Exception {
		DbConnMySql db = new DbConnMySql();
		String base64 = "";
		try {
			String q = "SELECT Base64 FROM " + tabla + " WHERE Analisis_Id = " + analisisId.toString();
			ResultSet rs = db.openCursor(q);

			if (rs.next())
				base64 = rs.getString("Base64");
			db.closeCursor();
			return base64;
		} catch(Exception e) {
			throw e;
		}finally {
			db.closeConnection();
		}
	}
}