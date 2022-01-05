package JavaObject;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Cette classe sert � gerer la connection � la base de donn�e, et faire en
 * sorte qu'il y ait une unique connexion.
 * 
 * @author Boisgard Julien
 */
public class Singleton {

	private static Connection connect;

	/**
	 * Ce constructeur permet de garantir une unique connexion � l'application cela
	 * evite les doublons de connexions en m�me temps.
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
	 * Cette m�thode permet de v�rifier si une connexion existe avec la base de
	 * donn�e.
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
