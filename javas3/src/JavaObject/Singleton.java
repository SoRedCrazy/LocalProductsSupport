package JavaObject;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

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
