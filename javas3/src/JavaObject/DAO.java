package JavaObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DAO {
	private Connection cn;

	/**
	 * Consctructeur
	 *
	 */
	public DAO() {
		this.cn = Singleton.getInstance();
	}

	/**
	 * Permet l'ajout d'un client dans la DAO et retourne un Client null si ca ca
	 * c'est pas bien passer et le client bien crée si c'est bon.
	 *
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -Integer
	 * @param mailAdmin    - String
	 * @return Client
	 * @exception SQLExecption pour tel que le numero de telephone existe deja...
	 */
	public Client ajouterclient(String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone, String mailAdmin) {
		// preparation
		Client cl = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			// sql
			stmt = this.cn.prepareStatement("INSERT INTO Client VALUES(0,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, prenom);
			stmt.setString(2, nom);
			stmt.setInt(3, numeroDeRue);
			stmt.setString(4, rue);
			stmt.setInt(5, codePostal);
			stmt.setString(6, ville);
			stmt.setString(7, pays);
			stmt.setString(8, numTelephone);
			stmt.setString(9, mailAdmin);
			// on recupere le deroulement et excute
			rs = stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs < 0) {
				throw new SQLException();
			} else {
				// on cherche l'idée a ttribut dans la base de donne est le numero de telephone
				// est unique
				stmt = this.cn.prepareStatement("SELECT idclient FROM Client WHERE numero_de_telephone= ? ");
				stmt.setString(1, numTelephone);
				stmt.execute();
				result = stmt.executeQuery();
				result.next();
				cl = new Client(result.getInt("idclient"), prenom, nom, numeroDeRue, rue, codePostal, ville, pays,
						numTelephone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// si l'objet est null sa c'est pas bien passer
		return cl;

	}

	/**
	 * Permet la suppression d'un client dans la DAO et retourne un boolean pour
	 * savoir si la requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param client
	 * @return boolean
	 * @exception SQLException si les information ne concorde pas
	 */
	public boolean delclient(Client client) {

		// test
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement("DELETE FROM Client WHERE idclient=? ");
			stmt.setInt(1, client.getIdClient());
			rs = stmt.executeUpdate();
		} catch (SQLException e) {

		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet de modifier des informations client.
	 *
	 * @param client
	 * @return boolean
	 * @exception SQLException si probleme d'information.
	 */

	public boolean modifclient(Client client) {

		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"UPDATE Client SET prenom=?, nom=?, numero_de_rue=?,rue=?, code_postal=?, ville=?, pays=? ,numero_de_telephone=?  WHERE idclient=? ");
			stmt.setString(1, client.getPrenom());
			stmt.setString(2, client.getNom());
			stmt.setInt(3, client.getNumeroDeRue());
			stmt.setString(4, client.getRue());
			stmt.setInt(5, client.getCodePostal());
			stmt.setString(6, client.getVille());
			stmt.setString(7, client.getPays());
			stmt.setString(8, client.getNumTelephone());
			stmt.setInt(9, client.getIdClient());
			rs = stmt.executeUpdate();
		} catch (SQLException e) {

		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet l'ajout d'une entreprise dans la DAO et retourne un boolean pour
	 * savoir si la requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param siret        -Integer
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param nom          -String
	 * @param prenom       -String
	 * @param numTelephone -Integer
	 * @param mdp-String
	 * @param mailAdmin    - String
	 * @return Entreprise
	 * @exception SQLException si erreur de paramettre
	 */
	public Entreprise ajouterEntreprise(String siret, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String motsdepasses, String mailAdmin) {

		// preparation
		Entreprise et = null;
		PreparedStatement stmt = null;
		int rs = -1;
		try {
			// sql
			stmt = this.cn.prepareStatement("INSERT INTO Entreprise VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, siret);
			stmt.setInt(2, numeroDeRue);
			stmt.setString(3, rue);
			stmt.setInt(4, codePostal);
			stmt.setString(5, ville);
			stmt.setString(6, pays);
			stmt.setString(7, nom);
			stmt.setString(8, prenom);
			stmt.setString(9, numTelephone);
			stmt.setString(10, motsdepasses);
			stmt.setString(11, mailAdmin);
			// on recupere le deroulement et excute
			rs = stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs < 0) {
				throw new SQLException();
			} else {
				et = new Entreprise(siret, numeroDeRue, rue, codePostal, ville, pays, nom, prenom, numTelephone,
						motsdepasses);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// si l'objet est null sa c'est pas bien passer
		return et;

	}

	/**
	 * Permet la suppression d'une entreprise dans la DAO et retourne un boolean
	 * pour savoir si la requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param entreprise
	 * @return boolean
	 * @exception SQLException si erreur de paramettre
	 */

	public boolean supprimerEntreprise(Entreprise entreprise) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"DELETE FROM Commande WHERE siret= ? ; DELETE FROM Tournee WHERE Imaticulation=(SELECT Imaticulation FROM Vehicule WHERE SIRET= ? ) ; DELETE FROM Vehicule WHERE SIRET= ? ; DELETE FROM Entreprise WHERE SIRET= ? ");
			stmt.setString(1, entreprise.getSiret());
			stmt.setString(2, entreprise.getSiret());
			stmt.setString(3, entreprise.getSiret());
			stmt.setString(4, entreprise.getSiret());
			rs = stmt.executeUpdate();
		} catch (SQLException e) {

		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet de modifier des informations entreprise.
	 *
	 * @param entreprise
	 * @return boolean
	 * @exception SQLException si erreur de paramettre
	 */
	public boolean modifEntreprise(Entreprise entreprise) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"UPDATE Entreprise SET Numero_de_rue= ? ,rue= ? , code_postal= ? , ville= ? , pays= ? , NOM= ? , prenom= ? , Numero_de_telephone = ?, mots_de_passes= ? WHERE SIRET= ? ");
			stmt.setInt(1, entreprise.getNumeroDeRue());
			stmt.setString(2, entreprise.getRue());
			stmt.setInt(3, entreprise.getCodePostal());
			stmt.setString(4, entreprise.getVille());
			stmt.setString(5, entreprise.getPays());
			stmt.setString(6, entreprise.getNom());
			stmt.setString(7, entreprise.getPrenom());
			stmt.setString(8, entreprise.getNumTelephone());
			stmt.setString(9, entreprise.getMdp());
			stmt.setString(10, entreprise.getSiret());
			rs = stmt.executeUpdate();
		} catch (SQLException e) {

		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet l'ajout d'un vÃ©hicule dans la DAO et retourne un boolean pour savoir
	 * si la requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param Immatriculation String
	 * @param poidmax         int
	 * @param siret           int
	 * @return vehicule
	 * @exception SQLException si erreur de paramettre
	 */
	public Vehicule ajouterVehicule(String immatriculation, int poidmax, Entreprise entreprise) {
		// preparation
		Vehicule ve = null;
		PreparedStatement stmt = null;
		int rs = -1;
		try {
			// sql
			stmt = this.cn.prepareStatement("INSERT INTO Vehicule VALUES(?,?,?)");
			stmt.setString(1, immatriculation);
			stmt.setInt(2, poidmax);
			stmt.setString(3, entreprise.getSiret());
			// on recupere le deroulement et excute
			rs = stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs < 0) {
				throw new SQLException();
			} else {
				ve = new Vehicule(immatriculation, poidmax);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// si l'objet est null sa c'est pas bien passer
		return ve;

	}

	/**
	 * Permet la suppression de vehicule dans la DAO et retourne un boolean pour
	 * savoir si la requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param vehicule
	 * @return boolean
	 * @exception SQLException si erreur de paramettre
	 */
	public boolean supprimerVehicule(Vehicule vehicule) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"DELETE FROM Commande WHERE idtournee=(SELECT idtournee FROM Tournee WHERE Imaticulation= ? ) ");
			stmt.setString(1, vehicule.getImmatriculation());
			rs = stmt.executeUpdate();

			stmt = this.cn.prepareStatement("DELETE FROM Tournee WHERE Imaticulation= ? ");
			stmt.setString(1, vehicule.getImmatriculation());
			rs += stmt.executeUpdate();

			stmt = this.cn.prepareStatement("DELETE FROM Vehicule WHERE Imaticulation= ? ");
			stmt.setString(1, vehicule.getImmatriculation());
			rs += stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet l'ajout de d'une tournée et ca creation
	 *
	 * @param Integer
	 * @param Date
	 * @param Time
	 * @param Time
	 * @param Vehicule
	 * @return Tournée
	 * @exception SQLException si erreur de paramettres
	 */
	public Tournee ajouterTournee(Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule) {
		Tournee to = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			// sql
			stmt = this.cn.prepareStatement("INSERT INTO Tournee VALUES(0,?,?,?,?,?)");
			stmt.setTime(1, horaireDebut);
			stmt.setTime(2, horaireFin);
			stmt.setDate(3, date);
			stmt.setInt(4, 0);
			stmt.setString(5, vehicule.getImmatriculation());
			// on recupere le deroulement et excute
			rs = stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs < 0) {
				throw new SQLException();
			} else {
				stmt = this.cn.prepareStatement(
						"SELECT idtournee FROM Tournee WHERE Horaire_de_debut= ? AND Horaire_de_fin= ? AND poid=0 AND  Imaticulation= ? ORDER BY idtournee DESC");
				stmt.setTime(1, horaireDebut);
				stmt.setTime(2, horaireFin);
				stmt.setString(3, vehicule.getImmatriculation());
				result = stmt.executeQuery();
				result.next();
				to = new Tournee(result.getInt("idtournee"), date, horaireDebut, horaireFin, vehicule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// si l'objet est null sa c'est pas bien passer
		return to;

	}

	/**
	 * Permet de modifier des informations tournee.
	 *
	 * @param tournee
	 * @return boolean
	 * @exception SQLException si erreur de paramettre
	 */
	public boolean modifTournee(Tournee tournee) {

		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"UPDATE Tournee SET Horaire_de_debut= ?,	Horaire_de_fin=?, Date=? WHERE idtournee=?");
			stmt.setTime(1, tournee.getHoraireDebut());
			stmt.setTime(2, tournee.getHoraireFin());
			stmt.setDate(3, tournee.getDate());
			stmt.setInt(4, tournee.getIdTournee());
			rs = stmt.executeUpdate();
		} catch (SQLException e) {

		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet la suppression dans la DAO et retourne un boolean pour savoir si la
	 * requete s'est bien dÃ©roulÃ©e.
	 *
	 * @param tournee
	 * @return boolean
	 * @exception SQLException si erreur de paramettre
	 */
	public boolean supprimerTournee(Tournee tournee) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement("DELETE FROM Commande WHERE idtournee=?");
			stmt.setInt(1, tournee.getIdTournee());
			rs = stmt.executeUpdate();

			stmt = this.cn.prepareStatement("DELETE FROM Tournee WHERE idtournee= ? ");
			stmt.setInt(1, tournee.getIdTournee());
			rs += stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet l'ajout d'une commande dans une tournÃ©e et retourne un boolean pour
	 * savoir si la requete s'est bien dÃ©roulÃ©e on verifie d'aboir si le poid de
	 * la tournée n'est pas depasser par rapport au camion puis on ajoute les
	 * valeurs et on mets a jours la valeur de la tourné
	 *
	 * @param tournee
	 * @param commande
	 * @return Commande
	 * @exception SQLException si erreur de paramettres
	 */
	public Commande ajouterCommandeTournee(String libelle, Integer poids, Time Heuredebut, Time Heurefin, Client client,
			Entreprise entreprise, Tournee tournee) {
		Commande co = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			// sql
			// on recuperles in du camiOn et et le poids de la tournée
			stmt = this.cn.prepareStatement(
					"SELECT V.Poids_maximal, T.poid FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation WHERE idtournee=?");
			stmt.setInt(1, tournee.getIdTournee());
			result = stmt.executeQuery();
			result.next();
			int newpoids = result.getInt("poid") + poids;

			// on verifie si le poids du camion n'est pas depasser
			if (newpoids < result.getInt("Poids_maximal")) {
				stmt = this.cn.prepareStatement("INSERT INTO Commande VALUES(0,?,?,?,?,?,?,?)");
				stmt.setString(1, libelle);
				stmt.setInt(2, poids);
				stmt.setTime(3, Heuredebut);
				stmt.setTime(4, Heurefin);
				stmt.setString(5, entreprise.getSiret());
				stmt.setInt(6, client.getIdClient());
				stmt.setInt(7, tournee.getIdTournee());
				// on recupere le deroulement et excute
				rs = stmt.executeUpdate();
				// si infrieur a 0 ca c'est pas bien passer
				if (rs < 0) {
					throw new SQLException();
				} else {
					// on vas chercher l'id de la commande
					stmt = this.cn.prepareStatement(
							"SELECT idcommande FROM Commande WHERE idclient= ? AND idtournee= ? ORDER BY idcommande DESC");
					stmt.setInt(1, client.getIdClient());
					stmt.setInt(2, tournee.getIdTournee());
					result = stmt.executeQuery();
					result.next();
					co = new Commande(result.getInt("idcommande"), libelle, poids, Heuredebut, Heurefin, client);

					// on mets a jours le poid
					stmt = this.cn.prepareStatement("UPDATE Tournee SET poid=? WHERE idtournee= ?");
					stmt.setInt(1, newpoids);
					stmt.setInt(2, tournee.getIdTournee());
					rs = stmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// si l'objet est null sa c'est pas bien passer
		return co;

	}

	/**
	 * Permet la suppression d'une commande dans une tournee et retourne un boolean
	 * pour savoir si la requete s'est bien deroulee elle supprimer la commande
	 * d'abord puis mets a jours le poids de la tournee
	 * 
	 * @param commande
	 * @return boolean
	 * @exception SQLException si erreur de paramettres
	 */
	public boolean supprimerCommandeTournee(Commande commande) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement("DELETE FROM Commande WHERE idcommande=?");
			stmt.setInt(1, commande.getIdCommande());
			rs = stmt.executeUpdate();
			stmt = this.cn.prepareStatement(
					"UPDATE Tournee T INNER JOIN Commande C ON  C.idtournee=T.idtournee SET poid=poid-?  WHERE idcommande= ?");
			stmt.setInt(1, commande.getPoids());
			stmt.setInt(2, commande.getIdCommande());
			rs = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet la modification d'une commande cela verif le poids de la tournée et le
	 * poids max du camion si il n'est pas depasser avant puis modifie la commande
	 * si sa c'est bien passer mets a jour le poid de la tournée.
	 * 
	 * @param Commande
	 * @return boolean
	 * @exception SQLException si erreur de paramettres
	 */
	public boolean modifCommande(Commande commande) {
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			// sql

			// on recuperles in du camiOn et et le poids de la tournée
			stmt = this.cn.prepareStatement(
					"SELECT V.Poids_maximal, T.poid FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation INNER JOIN Commande C ON  C.idtournee=T.idtournee WHERE idcommande=?");
			stmt.setInt(1, commande.getIdCommande());
			result = stmt.executeQuery();
			result.next();
			int newpoids = result.getInt("poid") + commande.getPoids() - commande.getAncienpoids();
			System.out.println(commande.getPoids());
			// on verifie si le poids du camion n'est pas depasser
			if (newpoids < result.getInt("Poids_maximal")) {
				stmt = this.cn.prepareStatement(
						"UPDATE Commande SET Heure_de_debut=?,Heure_de_fin=?,libelle=? ,poids=? WHERE idcommande=?");

				stmt.setTime(1, commande.getHeuredebut());
				stmt.setTime(2, commande.getHeureFin());
				stmt.setString(3, commande.getLibelle());
				stmt.setInt(4, commande.getPoids());
				stmt.setInt(5, commande.getIdCommande());
				// on recupere le deroulement et excute
				rs = stmt.executeUpdate();
				// si infrieur a 0 ca c'est pas bien passer
				if (rs < 0) {
					throw new SQLException();
				} else {
					// on mets a jours le poid
					stmt = this.cn.prepareStatement(
							"UPDATE Tournee T INNER JOIN Commande C ON  C.idtournee=T.idtournee SET poid=? WHERE idcommande= ?");
					stmt.setInt(1, newpoids);
					stmt.setInt(2, commande.getIdCommande());
					rs = stmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permet de retourner la liste des Tournee en fonction du numero de siret.
	 * 
	 * @param Entreprise entreprise
	 * @return ArrayList<Tournee>
	 * @SQLException
	 */

	public ArrayList<Tournee> listTournee(Entreprise entreprise) {
		ArrayList<Tournee> listTo = new ArrayList<Tournee>();
		PreparedStatement stmt = null;
		ResultSet result;
		Vehicule v = null;
		try {

			stmt = this.cn.prepareStatement(
					"SELECT T.idtournee,T.Horaire_de_debut, T.Horaire_de_fin,T.Date,T.poid,T.Imaticulation FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation WHERE V.SIRET=?");
			stmt.setString(1, entreprise.getSiret());
			result = stmt.executeQuery();

			while (result.next()) {
				Tournee T = new Tournee(result.getInt("idtournee"), result.getDate("Date"),
						result.getTime("Horaire_de_debut"), result.getTime("Horaire_de_fin"),
						new Vehicule(result.getString("Imaticulation"), result.getInt("Poids_maximal")));
				T.setPoids(result.getInt("poid"));
				listTo.add(T);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTo;

	}

	/**
	 * Permet de retourner la liste de toute les Tournees de la bases.
	 * 
	 * @return ArrrayList<Tournee>
	 */

	public ArrayList<Tournee> TourneeAdmin() {
		ArrayList<Tournee> listTo = new ArrayList<Tournee>();
		PreparedStatement stmt = null;
		ResultSet result;
		Vehicule v = null;
		try {

			stmt = this.cn.prepareStatement(
					"SELECT T.idtournee,T.Horaire_de_debut, T.Horaire_de_fin,T.Date,T.poid,T.Imaticulation,V.Poids_maximal FROM Tournee T INNER JOIN Vehicule V ON T.Imaticulation=V.Imaticulation");
			result = stmt.executeQuery();

			while (result.next()) {
				Tournee T = new Tournee(result.getInt("idtournee"), result.getDate("Date"),
						result.getTime("Horaire_de_debut"), result.getTime("Horaire_de_fin"),
						new Vehicule(result.getString("Imaticulation"), result.getInt("Poids_maximal")));
				T.setPoids(result.getInt("poid"));
				listTo.add(T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTo;
	}

	/**
	 * Permet de recuperer tout les vehicule de la base de donnée
	 * 
	 * @return ArrayList<Vehicule>
	 */
	public ArrayList<Vehicule> listVehicule() {
		ArrayList<Vehicule> listVe = new ArrayList<Vehicule>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Vehicule ");
			result = stmt.executeQuery();

			while (result.next()) {
				Vehicule V = new Vehicule(result.getString("Imaticulation"), result.getInt("Poids_maximal"));
				listVe.add(V);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVe;
	}

	/**
	 * Permet de recuperer tout les vehicule de la base de donnée
	 * 
	 * @return ArrayList<Vehicule>
	 */
	public ArrayList<Vehicule> listVehiculeEntreprise(Entreprise entreprise) {
		ArrayList<Vehicule> listVe = new ArrayList<Vehicule>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Vehicule WHERE SIRET=?");
			stmt.setString(1, entreprise.getSiret());
			result = stmt.executeQuery();

			while (result.next()) {
				Vehicule V = new Vehicule(result.getString("Imaticulation"), result.getInt("Poids_maximal"));
				listVe.add(V);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVe;
	}

	/**
	 * Permet de retouner la liste de toutes les commandes.
	 * 
	 * @param Tournee tournee
	 * @return ArrayList<Commande>
	 */
	public ArrayList<Commande> listCommande(Tournee tournee) {
		ArrayList<Commande> listCo = new ArrayList<Commande>();
		PreparedStatement stmt = null;
		ResultSet result;
		Vehicule v = null;
		try {

			stmt = this.cn.prepareStatement(
					"Select * FROM Commande C INNER JOIN Client Cl ON C.idclient=Cl.idclient WHERE idtournee=?");
			stmt.setInt(1, tournee.getIdTournee());
			result = stmt.executeQuery();

			while (result.next()) {
				Client cl = new Client(result.getInt("idclient"), result.getString("prenom"), result.getString("nom"),
						result.getInt("numero_de_rue"), result.getString("rue"), result.getInt("code_postal"),
						result.getString("ville"), result.getString("pays"), result.getString("numero_de_telephone"));
				Commande C = new Commande(result.getInt("idcommande"), result.getString("libelle"),
						result.getInt("poids"), result.getTime("Heure_de_debut"), result.getTime("Heure_de_fin"), cl);
				listCo.add(C);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listCo;
	}

	/**
	 * Permet de recuperer tout les client de la base de donnée
	 * 
	 * @return ArrayList<Client>
	 */
	public ArrayList<Client> listClient() {
		ArrayList<Client> listCl = new ArrayList<Client>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Client ");
			result = stmt.executeQuery();

			while (result.next()) {
				Client cl = new Client(result.getInt("idclient"), result.getString("prenom"), result.getString("nom"),
						result.getInt("numero_de_rue"), result.getString("rue"), result.getInt("code_postal"),
						result.getString("ville"), result.getString("pays"), result.getString("numero_de_telephone"));
				listCl.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listCl;
	}

}