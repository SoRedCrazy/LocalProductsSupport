package JavaObject;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Cette classe sert à gerer la connection à la base de donnée, et faire en
 * sorte qu'il y ait une unique connexion.
 * 
 * @author Boisgard Julien
 */
public class Singleton {

	private static Connection connect;

	/**
	 * Ce constructeur permet de garantir une unique connexion à l'application cela
	 * evite les doublons de connexions en même temps.
	 * 
	 * @param connect -Connection
	 * @exception SQLException for Access denied
	 * 
	 * @author Gangneux Alexis
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
	 * Cette méthode permet de vérifier si une connexion existe avec la base de
	 * donnée.
	 * 
	 * @return connect -Connection
	 * @throws ClassNotFoundException
	 * 
	 * @author Gangneux Alexis
	 */
	public static Connection getInstance() {
		if (connect == null) {
			new Singleton();
		}
		return connect;

	}

}
