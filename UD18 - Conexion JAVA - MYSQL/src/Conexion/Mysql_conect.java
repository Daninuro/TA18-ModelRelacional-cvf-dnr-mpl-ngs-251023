package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Mysql_conect 
{

	Connection conect;

	// ABRIR CONEXION
	public void connect(String m_server, String m_port, String m_user, String m_password) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conect = DriverManager.getConnection("jdbc:mysql://" + m_server + ":" + m_port + "?useTimezone=true&serverTimezone=UTC", m_user, m_password);
			System.out.println("Server Connected");

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}

	// CERRAR CONEXION
	public void closeConnection() {
		try {
			conect.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(Mysql_conect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// CREAR DB
	public void createDB(String name) {
		try {
			String query = "CREATE DATABASE IF NOT EXISTS " + name + ";";
			Statement at = conect.createStatement();
			at.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " exitosamente.");
		} catch (SQLException ex) {
			Logger.getLogger(Mysql_conect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	// USAR DB
	public void useDB(String m_database) {

		try {
			String db_usa_query = "USE " + m_database + ";";
			Statement select_db;
			select_db = conect.createStatement();
			select_db.executeUpdate(db_usa_query);
			System.out.println("Se esta usando " + m_database);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("No se a podido utilizar la base de datos " + m_database);
		}

	}

	// CREAT TABLA
	public void createTable(String query) {
		try {
			Statement st = conect.createStatement();
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando table.");
		}
	}


	// INSERT REGISTRO
	public void insertData(String query) {
		try {

			Statement st = conect.createStatement();
			st.executeUpdate(query);
			System.out.println("Registro introducido con éxito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error introduciendo registro.");
		}
	}
	
}