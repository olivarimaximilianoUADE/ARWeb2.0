package ar.edu.uade.tic.tesis.arweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import ar.edu.uade.tic.tesis.arweb.servicios.ValidarAccesibilidadService;

public class DbConnMySql {

	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public DbConnMySql() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class
					.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));

			connection = DriverManager.getConnection(properties.get("CONNECTION_STRING").toString());
		} catch (Exception e) {
			throw new Exception("No se pudo establecer la conexion: ".concat(e.getMessage()));
		}
		this.getConnection().setAutoCommit(false);
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

	public int execute(String query) throws Exception {
		int rows = -1;
		if (connection == null)
			return 0;
		try {
			PreparedStatement st = openStatement(query);
			rows = st.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			throw e;
		}
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

	public String Insert(String tabla, String pCampos, String pValues) throws Exception {
		execute("INSERT INTO " + tabla + " (" + pCampos + ")" + " VALUES (" + pValues + ")");
		return (getLastId());
	}

	/*** MySQL ***/
	public String getLastId() throws Exception {
		String ret;
		try {
			openCursor("SELECT max(Analisis_ID) from HISTORICO_ANALISIS");
			if (!resultSet.next())
				throw new Exception("Error obteniendo el ID insertado");
			ret = resultSet.getString(1);
		} finally {
			closeCursor();
		}
		return ret;
	}

	public void selectObjeto(String condId, String orderby, DAO cb) throws Exception {
		// boolean existe = false;
		String s1, s2, s3;
		s1 = "SELECT " + cb.listaCampos() + " FROM ";
		s2 = " WHERE " + condId;
		s3 = " ORDER BY " + orderby + " DESC";
		// existe =
		selectObjeto1(s1 + cb.listaTabla() + s2 + s3, cb);
		// if (!existe)
		// throw new Exception("El objeto no existe: Tabla::" + cb.listaTabla() + ",
		// Condicion::" + condId);
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
}
