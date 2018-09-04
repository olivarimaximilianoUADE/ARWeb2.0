package ar.edu.uade.tic.tesis.arweb.db;

import java.sql.ResultSet;

public interface DAO {
	Object listaCallback(ResultSet rs) throws Exception;
	void listaFill(ResultSet rs) throws Exception;
	String listaTabla();
	String listaCampos();
}