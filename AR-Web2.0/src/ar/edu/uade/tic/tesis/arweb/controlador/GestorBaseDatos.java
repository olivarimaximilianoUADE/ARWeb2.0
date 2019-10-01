package ar.edu.uade.tic.tesis.arweb.controlador;

import ar.edu.uade.tic.tesis.arweb.db.AnalisisDAO;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Contexto;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.ContextoClaves;

public class GestorBaseDatos {

	public static ControlInformacion insertar(TipoValidacion tipoValidacion, String recurso, String principios,
			String nivelAccesibilidad, Integer umbral, Integer problemas, Integer advertencias, Integer noVerificados,
			Integer accesibilidad, String version) {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			try {
				new AnalisisDAO(recurso, principios, nivelAccesibilidad, umbral, problemas, advertencias, noVerificados,
						accesibilidad, version).insertHistorico();
			} catch (Exception e) {
				return new ControlInformacion(ControlInformacion.ERROR,
						"Error en la conexión con la base de datos o inserción del recurso.", "", e);
			}
		}
		return new ControlInformacion();
	}

	public static Long insertarHistorico(TipoValidacion tipoValidacion, String recurso, String principios,
			String nivelAccesibilidad, Integer umbral, Integer problemas, Integer advertencias, Integer noVerificados,
			Integer accesibilidad, String version) throws Exception {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			AnalisisDAO analisisDAO = new AnalisisDAO(recurso, principios, nivelAccesibilidad, umbral, problemas,
					advertencias, noVerificados, accesibilidad, version);
			analisisDAO.insertHistorico();
			return analisisDAO.getId();
		}
		return (long) 0;
	}

	public static void insertarAnexo(TipoValidacion tipoValidacion, String tabla, String base64, Long analisisId)
			throws Exception {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			new AnalisisDAO().insertAnexo(tabla, base64, analisisId);
		}
	}

	/*
	 * public static void insertarResultadoCriterioTecnica(TipoValidacion
	 * tipoValidacion, Long analisisId, String criterioNumero, String nivel, String
	 * tecnicaNumero, String resultado) { if (tipoValidacion ==
	 * TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) { try
	 * { new AnalisisDAO().insertarResultadoCriterioTecnica(analisisId,
	 * criterioNumero, nivel, tecnicaNumero, resultado); } catch (Exception e) {
	 * //return new ControlInformacion(ControlInformacion.ERROR,
	 * "Error en la conexión con la base de datos o inserción del recurso.", "", e);
	 * } } }
	 */

	public static void insertarResultadoCriterioTecnica(TipoValidacion tipoValidacion, String script) throws Exception {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			new AnalisisDAO().insertarResultadoCriterioTecnica(script);
		}
	}

	public static ControlInformacion seleccionar(TipoValidacion tipoValidacion, String recurso) {
		AnalisisDAO analisisDAO = null;
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			analisisDAO = new AnalisisDAO();
			analisisDAO.setUrl(recurso);
			try {
				analisisDAO.select();
			} catch (Exception e) {
				return new ControlInformacion(ControlInformacion.ERROR,
						"Error en la conexión con la base de datos o selección del recurso.", "", e);
			}
		}
		Contexto.set(ContextoClaves.ANALISIS_DAO, analisisDAO);
		return new ControlInformacion();
	}

	public static AnalisisDAO seleccionarDB(TipoValidacion tipoValidacion, String recurso) throws Exception {
		AnalisisDAO analisisDAO = null;
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			analisisDAO = new AnalisisDAO();
			analisisDAO.setUrl(recurso);
			analisisDAO.select();
		}
		return analisisDAO;
	}

	public static String seleccionarAnexo(String tabla, Long analisisId) throws Exception {
		return new AnalisisDAO().selectAnexo(tabla, analisisId);
	}
}