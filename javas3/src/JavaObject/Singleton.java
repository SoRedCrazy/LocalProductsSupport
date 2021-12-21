package JavaObject;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Cette classe sert a gerer la connection a la base de donn�e, et faire en
 * sorte qu'il y ait une unique connexion.
 * 
 *
 */
public class Singleton {

	private static Connection connect;

	/**
	 * Ce constructeur permet de garantir une unique connexion � l'application cela
	 * evite les doublons de connexions en m�me temps.
	 * 
	 * @author gangn
	 * @param connect -Connection
	 * @exception SQLException for Access denied
	 */
	private Singleton() {

		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword("");
		ds.setServerName("127.0.0.1");
		ds.setDatabaseName("projet");

		try {
			connect = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Operations

	/**
	 * Cette m�thode permet de v�rifier si une connexion existe avec la base de
	 * donn�e.
	 * 
	 * @return Une connextion de type connection
	 * @throws ClassNotFoundException
	 */
	public static Connection getInstance() {
		if (connect == null) {
			new Singleton();
		}
		return connect;

	}

}
