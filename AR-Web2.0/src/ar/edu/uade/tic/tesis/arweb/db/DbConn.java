package ar.edu.uade.tic.tesis.arweb.db;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DbConn {

	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private int dbType = 3;
	private long valorDesde = -1;
	private long valorHasta = -1;
	private long valorActual = 0;
	private final int MYSQL = 0x0002;
	private final int ACCESS = 0x0003;

	public DbConn() throws Exception {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//Properties properties = new Properties();
			//properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			//connection=DriverManager.getConnection("jdbc:ucanaccess:/" + this.getPathAbsoluto(properties.get("URL_DATA_BASE").toString()));//"/ar/edu/uade/tic/tesis/arweb/db/ARWeb.mdb"));//Constantes.URL_DATA_BASE));
			
			connection=DriverManager.getConnection("jdbc:ucanaccess:/" + this.getPathAbsoluto("/ar/edu/uade/tic/tesis/arweb/db/ARWeb.mdb"));
		} 
		catch (Exception e) {
			throw new Exception("No se pudo establecer la conexion: ".concat(e.getMessage()));
		}
		this.getConnection().setAutoCommit(false);
	}

	private String getPathAbsoluto(String pathRelativo) {
		URL res = getClass().getResource(pathRelativo);
		if (res.toString().startsWith("file:/C:"))
			return res.getPath();
		return "/" + System.getenv("APPDATA").replaceAll("\\\\", "/") + "/ARWeb/ARWeb.mdb";
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		try {
			this.getConnection().close();
		} catch (Exception e) {
		}
	}

	public PreparedStatement openStatement(String s) throws Exception {
		if (connection == null)
			return null;
		try {
			preparedStatement = connection.prepareStatement(s);
		} catch (Exception e) {
			throw e;
		}
		return preparedStatement;
	}

	public void execStatement() throws Exception {
		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			preparedStatement.close();
		}
	}

	public ResultSet openCursor(String query) throws Exception {
		if (connection == null)
			return null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			throw e;
		}
		return resultSet;
	}

	public void closeCursor() throws Exception {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			throw e;
		} finally {
			resultSet = null;
			statement = null;
		}
	}

	public ArrayList<Object> Query(String query) throws Exception {
		ArrayList<Object> result, row;
		Statement stmt;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int numCols, i;
		if (connection == null)
			return null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			rsmd = rs.getMetaData();
			numCols = rsmd.getColumnCount();
		} catch (Exception e) {
			throw e;
		}
		result = new ArrayList<Object>();
		try {
			while (rs.next()) {
				row = new ArrayList<Object>();
				for (i = 1; i <= numCols; i++)
					row.add(rs.getString(i));
				result.add(row);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public String Query1(String query) throws Exception {
		ArrayList<Object> l, f;
		int i;
		String s;
		if (connection == null)
			return null;
		l = Query(query);
		if (l.size() < 1)
			return ("");
		f = ((ArrayList<Object>) l.get(0));
		if (f.size() < 1)
			return ("");
		s = "";
		for (i = 0; i < f.size(); i++) {
			if (i > 0)
				s = s + " ";
			s = s + (String) f.get(i);
		}
		return s;
	}

	public int Call(String query) throws Exception {
		Statement stmt = null;
		int rows = -1;
		if (connection == null)
			return 0;
		try {
			stmt = connection.createStatement();
			rows = stmt.executeUpdate("BEGIN " + query + "END;");
		} catch (Exception e) {
			throw e;
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
		};
		return rows;
	}

	public int execute(String query) throws Exception {
		Statement stmt = null;
		int rows = -1;
		if (connection == null)
			return 0;
		try {
			stmt = connection.createStatement();
			rows = stmt.executeUpdate(query);
		} catch (Exception e) {
			throw e;
		}
		try {
			if (stmt != null)
				stmt.close();
		} 
		catch (Exception e) {
			throw e;
		};
		return rows;
	}

	public void commit() throws Exception {
		if (connection == null)
			return;
		try {
			connection.commit();
		} catch (Exception e) {
			throw e;
		}
	}

	private void addV(ArrayList<Object> vector, DAO cb, ResultSet rs) throws Exception {
		Object o;
		if (valorDesde == -1 || (valorActual < valorHasta && valorActual >= valorDesde))
			if ((o = cb.listaCallback(rs)) != null)
				vector.add(o);
		valorActual++;
	}

	private boolean listaObjetos1(String consulta, ArrayList<Object> vector, DAO cb) throws Exception {
		ResultSet rs;
		boolean existe = false;
		if (valorDesde >= 0 && valorActual >= valorHasta)
			return true;
		try {
			rs = openCursor(consulta);
			if (rs.next()) {
				existe = true;
				addV(vector, cb, rs);
			}
			while (rs.next() && (valorDesde == -1 || valorActual < valorHasta))
				addV(vector, cb, rs);
		} finally {
			closeCursor();
		}
		return existe;
	}

	public ArrayList<Object> listaObjetosUnion(String borrado, String filtro, String orden,
			boolean ordenInverso, long desde, long cant, DAO cb) throws Exception {
		return listaObjetos(borrado, filtro, orden, ordenInverso, desde, cant, cb);
	}

	public ArrayList<Object> listaObjetos(String borrado, String filtro, String orden, boolean ordenInverso,
			long desde, long cant, DAO cb) throws Exception {
		String orderBy = "";
		String filterBy = "";
		String limitBy = "";
		if (orden != null) {
			if (orden != null) {
				orderBy = "ORDER BY " + orden;
				if (ordenInverso)
					orderBy += " DESC";
			}
		}
		if (borrado != null || filtro != null)
			filterBy = " WHERE ";
		if (borrado != null)
			filterBy = filterBy + borrado + " is null ";
		if (filtro != null) {
			if (borrado != null)
				filterBy = filterBy + " AND (" + filtro + ")";
			else
				filterBy = filterBy + filtro;
		}
		valorDesde = -1;
		valorHasta = -1;
		valorActual = 0;
		if (cant > 0 && desde >= 0)
			limitBy = limite(desde, cant);
		return (doFirst(cb, filterBy, orderBy, limitBy));
	}

	private ArrayList<Object> doFirst(DAO cb, String filterBy, String orderBy, String limitBy)
			throws Exception {
		ArrayList<Object> vector = new ArrayList<Object>();
		String s1, s2;
		s1 = " " + filterBy;
		s2 = s1 + " " + orderBy + " " + limitBy;
		try {
			listaObjetos1("SELECT " + cb.listaCampos() + " FROM " + cb.listaTabla() + s2, vector, cb);
		} finally {
			closeCursor();
		}
		if (vector.size() > 0)
			return vector;
		return vector;
	}

	private boolean selectObjeto1(String consulta, DAO cb) throws Exception {
		ResultSet rs;
		boolean existe = false;
		try {
			rs = openCursor(consulta);
			if (rs.next()) {
				existe = true;
				cb.listaFill(rs);
			}
		} finally {
			closeCursor();
		}
		return existe;
	}

	public void selectObjeto(String condId, String orderby, DAO cb) throws Exception {
		boolean existe = false;
		String s1, s2, s3;
		s1 = "SELECT " + cb.listaCampos() + " FROM ";
		s2 = " WHERE " + condId;
		s3 = " ORDER BY " + orderby + " DESC";
		existe = selectObjeto1(s1 + cb.listaTabla() + s2 + s3, cb);
		if (!existe)
			throw new Exception("El objeto no existe: Tabla::" + cb.listaTabla() + ", Condicion::" + condId);
	}

	public String Insert(String tabla, String pCampos, String pValues) throws Exception {
		int i;
		String values;
		String id = "";
		boolean auto_id = false;
		
		if ((i = pValues.indexOf("@ID@")) >= 0) {
			auto_id = true;
			values = pValues.substring(0, i);
			switch (dbType) {
			case MYSQL:
				values += "null";
				break;
			case ACCESS:
				values += "";
				break;
			default:
				throw new Exception("Base de Datos desconocida" + dbType);
			}
			values += pValues.substring(i + "@ID@".length() + 1);
		} else
			values = pValues;
		execute("INSERT INTO " + tabla + " (" + pCampos + ")" + " VALUES (" + values + ")");
		if (auto_id) {
			switch (dbType) {
			case MYSQL:
				return (getLastId());
			case ACCESS:
				return (getLastId(tabla));
			}
		}
		return id;
	}

	/*** MySQL ***/
	public String getLastId() throws Exception {
		String ret;
		try {
			openCursor("SELECT LAST_INSERT_ID()");
			if (!resultSet.next())
				throw new Exception("Error obteniendo el ID insertado");
			ret = resultSet.getString(1);
		} finally {
			closeCursor();
		}
		return ret;
	}

	/*** ACCESS ***/
	public String getLastId(String tabla) throws Exception {
		String ret;
		try {
			openCursor("SELECT MAX(Analisis_ID) FROM ".concat(tabla));
			if (!resultSet.next())
				throw new Exception("Error obteniendo el ID insertado");
			ret = resultSet.getString(1);
		} finally {
			closeCursor();
		}
		return ret;
	}

	private String limite(long desde, long cant) throws Exception {
		switch (dbType) {
		case MYSQL:
			return "LIMIT " + desde + "," + cant;
		case ACCESS:
			valorDesde = desde;
			valorHasta = desde + cant;
			valorActual = 0;
			return "";
		default:
			throw new Exception("Base de Datos desconocida" + dbType);
		}

	}

}