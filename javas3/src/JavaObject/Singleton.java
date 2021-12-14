package JavaObject;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Cette classe sert a gerer la connection a la base de donnée, et faire en
 * sorte qu'il y ait une unique connexion.
 * 
 *
 */
public class Singleton {

	private static Connection connect;

	/**
	 * Ce constructeur permet de garantir une unique connexion à l'application cela
	 * evite les doublons de connexions en même temps.
	 * 
	 * @author gangn
	 * @param connect -Connection
	 * @exception SQLException for Access denied
	 */
	private Singleton() {

		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("u230559756_root");
		ds.setPassword("Azerty37");
		ds.setServerName("212.1.208.101");
		ds.setDatabaseName("u230559756_project");

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
