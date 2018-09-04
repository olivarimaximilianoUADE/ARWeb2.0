package ar.edu.uade.tic.tesis.arweb.controlador;

import ar.edu.uade.tic.tesis.arweb.db.AnalisisDAO;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Contexto;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.ContextoClaves;

public class GestorBaseDatos {

	public static ControlInformacion insertar(TipoValidacion tipoValidacion, String recurso, String principios, String nivelAccesibilidad, Integer umbral, Integer problemas, Integer advertencias, Integer noVerificados, Integer accesibilidad) {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			try {
				new AnalisisDAO(recurso, principios, nivelAccesibilidad, umbral, problemas, advertencias, noVerificados, accesibilidad).insertHistorico();
			} catch (Exception e) {
				return new ControlInformacion(ControlInformacion.ERROR, "Error en la conexión con la base de datos o inserción del recurso.", "", e);
			}
		}
		return new ControlInformacion();
	}
	
	public static Long insertarHistorico(TipoValidacion tipoValidacion, String recurso, String principios, String nivelAccesibilidad, Integer umbral, Integer problemas, Integer advertencias, Integer noVerificados, Integer accesibilidad) {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			try {
				AnalisisDAO analisisDAO = new AnalisisDAO(recurso, principios, nivelAccesibilidad, umbral, problemas, advertencias, noVerificados, accesibilidad);
				analisisDAO.insertHistorico();
				return analisisDAO.getId();
			} catch (Exception e) {
				return (long) 0;
				//return new ControlInformacion(ControlInformacion.ERROR, "Error en la conexión con la base de datos o inserción del recurso.", "", e);
			}
		}
		return (long) 0;		
	}
	
	public static void insertarAnexo(TipoValidacion tipoValidacion, String tabla, String base64, Long analisisId) {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			try {
				new AnalisisDAO().insertAnexo(tabla, base64, analisisId);
			} catch (Exception e) {
				//return new ControlInformacion(ControlInformacion.ERROR, "Error en la conexión con la base de datos o inserción del recurso.", "", e);
			}
		}
	}
	
	public static void insertarResultadoCriterioTecnica(TipoValidacion tipoValidacion, Long analisisId, String criterioNumero, String nivel, String tecnicaNumero, String resultado) {
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			try {
				new AnalisisDAO().insertarResultadoCriterioTecnica(analisisId, criterioNumero, nivel, tecnicaNumero, resultado);
			} catch (Exception e) {
				//return new ControlInformacion(ControlInformacion.ERROR, "Error en la conexión con la base de datos o inserción del recurso.", "", e);
			}
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
				return new ControlInformacion(ControlInformacion.ERROR, "Error en la conexión con la base de datos o selección del recurso.", "", e);
			}
		}
		Contexto.set(ContextoClaves.ANALISIS_DAO, analisisDAO);
		return new ControlInformacion();
	}
	public static AnalisisDAO seleccionarDB(TipoValidacion tipoValidacion, String recurso) {
		AnalisisDAO analisisDAO = null;
		if (tipoValidacion == TipoValidacion.PAGINA_WEB || tipoValidacion == TipoValidacion.ARCHIVO) {
			analisisDAO = new AnalisisDAO();
			analisisDAO.setUrl(recurso);
			try {
				analisisDAO.select();
			} catch (Exception e) {
			 
			}
		}
		return analisisDAO;
	}
	public static String seleccionarAnexo(String tabla, Long analisisId) {
		try {
			return new AnalisisDAO().selectAnexo(tabla, analisisId);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}