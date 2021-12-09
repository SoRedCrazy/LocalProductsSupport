package JavaObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		Connection cn = Singleton.getInstance();

		// Execution de requetes
		Statement st = null;
		ResultSet rs = null;

		try {
			st = cn.createStatement();
			String sqlQuery = "SELECT * FROM Admin";
			rs = st.executeQuery(sqlQuery);
		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}

		// Affichage du resultat
		try {
			while (rs.next()) {
				String nom = rs.getString("Nom");
				System.out.println("Le nom est " + nom);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
	}

}
