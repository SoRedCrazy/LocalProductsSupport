package JavaObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Permet la gestion de la base de donnee entre les objets.
 * 
 * @author Boisgard Julien
 *
 */
public class DAO {
	private Connection cn;

	/**
	 * Consctructeur ouvre la connection singleton.
	 *
	 * @author Boisgard Julien
	 */
	public DAO() {
		this.cn = Singleton.getInstance();
	}

	/**
	 * Permet l'ajout d'un client dans la DAO et retourne un Client null si ca c'est
	 * pas bien passer et si c'est bon le client est cree. Pour cela on insert le
	 * client en bdd puis on execute si le reusultat est superieur à -1 cela c'est
	 * bien passe donc on cherche sont id puis on le cree.
	 *
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @param mailAdmin    - String
	 * @return cl -Client
	 * @exception SQLExecption Exemple: numero de telephone existe deja...
	 * 
	 * @author Boisgard Julien
	 */
	public Client ajouterclient(String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone, String mailAdmin) {
		Client cl = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
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
			rs = stmt.executeUpdate();
			if (rs < 0) {
				throw new SQLException();
			} else {
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
		return cl;

	}

	/**
	 * Permet la suppression d'un client dans la DAO et retourne un boolean pour
	 * savoir si la requete s'est bien deroulee. Pour cela on envoie le la requete
	 * si le resultat et superieur à -1 le client est bien suprimer.
	 *
	 * @param client -Client
	 * @return boolean
	 * @exception SQLException si les information ne concorde pas.
	 * 
	 * @author Boisgard Julien
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
	 * Permet de modifier des informations client. Pour cela on recupere le client
	 * deja modifie et à partir de son id on modifie se qu'il lui correspond, si le
	 * resultat est superieur à -1 ca c'est bien passe.
	 * 
	 * @param client -Client
	 * @return boolean
	 * @exception SQLException si probleme d'informations.
	 * 
	 * @author Boisgard Julien
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
	 * Permet l'ajout d'une entreprise dans la DAO et retourne l'entreprise cree.
	 * Retourne null si cela ne c'est pas bien passer. On envoie la requete avec les
	 * informations de l'entreprise si le resultat et superieur à -1 ca c'est bien
	 * passe et on la cree.
	 *
	 * @param siret        -String
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @param motdepasses  -String
	 * @param mailAdmin    -String
	 * @return Entreprise
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public Entreprise ajouterEntreprise(String siret, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String motsdepasses, String mailAdmin) {

		Entreprise et = null;
		PreparedStatement stmt = null;
		int rs = -1;
		try {
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
			rs = stmt.executeUpdate();
			if (rs < 0) {
				throw new SQLException();
			} else {
				et = new Entreprise(siret, numeroDeRue, rue, codePostal, ville, pays, nom, prenom, numTelephone,
						motsdepasses);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return et;

	}

	/**
	 * Permet la suppression d'une entreprise dans la DAO et retourne un boolean
	 * pour savoir si la requete s'est bien deroulee. Pour cela on envoie la
	 * requette, si le resultat est superieur à -1 ca c'est bien passe.
	 * 
	 * @param siret -String
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */

	public boolean supprimerEntreprise(String siret) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement("DELETE FROM Commande WHERE siret= ?");
			stmt.setString(1, siret);
			rs = stmt.executeUpdate();

			stmt = this.cn.prepareStatement(
					" DELETE FROM Tournee WHERE Imaticulation in (SELECT Imaticulation FROM Vehicule WHERE SIRET= ? )");
			stmt.setString(1, siret);
			rs += stmt.executeUpdate();

			stmt = this.cn.prepareStatement(" DELETE FROM Vehicule WHERE SIRET= ? ");
			stmt.setString(1, siret);
			rs += stmt.executeUpdate();

			stmt = this.cn.prepareStatement("DELETE FROM Entreprise WHERE SIRET= ? ");
			stmt.setString(1, siret);
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
	 * Permet de modifier des informations entreprise. Pour cela à partir du siret
	 * on modifie les autres parametres si le resultat est superieur à -1 ca c'est
	 * bien passe.
	 *
	 * @param entreprise -Entreprise
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
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
	 * Permet l'ajout d'un vehicule dans la DAO et retourne un objet vehcilue cree.
	 * On ajoute à la bdd le vheicule si reultat superieurr à -1 on cree le
	 * vehicule.
	 * 
	 * @param Immatriculation -String
	 * @param poidmax         -int
	 * @param siret           -String
	 * @return ve -Vehicule
	 * @exception SQLException si erreur de paramettre
	 * 
	 * @author Boisgard Julien
	 */
	public Vehicule ajouterVehicule(String immatriculation, int poidmax, String siret) {
		// preparation
		Vehicule ve = null;
		PreparedStatement stmt = null;
		int rs = -1;
		try {
			stmt = this.cn.prepareStatement("INSERT INTO Vehicule VALUES(?,?,?)");
			stmt.setString(1, immatriculation);
			stmt.setInt(2, poidmax);
			stmt.setString(3, siret);
			rs = stmt.executeUpdate();

			if (rs < 0) {
				throw new SQLException();
			} else {
				ve = new Vehicule(immatriculation, poidmax);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ve;

	}

	/**
	 * Permet la suppression de vehicule dans la DAO et retourne un boolean pour
	 * savoir si la requete s'est bien deroulee. Pour cela on supprime toutes les
	 * commandes qui sont dans le vehicule, puis les tournees ou les vehivules sont
	 * affectes et enfin on supprime le vehicule.
	 *
	 * @param vehicule -Vehicule
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public boolean supprimerVehicule(Vehicule vehicule) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"DELETE FROM Commande WHERE idtournee in (SELECT idtournee FROM Tournee WHERE Imaticulation= ? ) ");
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
	 * Permet l'ajout d'une tournee et sa creation, on ajoute les valeurs puis si
	 * c'est bon on recupere l'id de la tournee et on la cree. Si l'objet est null
	 * cela c'est mal passe.
	 *
	 * @param date         -Date
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @param vehicule     -Vehicule
	 * @return to -Tournee
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public Tournee ajouterTournee(Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule) {
		Tournee to = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			stmt = this.cn.prepareStatement("INSERT INTO Tournee VALUES(0,?,?,?,?,?)");
			stmt.setTime(1, horaireDebut);
			stmt.setTime(2, horaireFin);
			stmt.setDate(3, date);
			stmt.setInt(4, 0);
			stmt.setString(5, vehicule.getImmatriculation());
			rs = stmt.executeUpdate();

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

		return to;

	}

	/**
	 * Permet de modifier des informations tournee. On recupere la tournee deja
	 * modifier et on update dans la bdd à partir de l'id.
	 *
	 * @param tournee -Tournee
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
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
	 * requete s'est bien deroulee. Pour cela il faut d'abord supprimer les
	 * commandes de la tournnee puis apres on suprimme la tournee.
	 *
	 * @param tournee -Tournee
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
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
	 * Permet l'ajout d'une commande dans une tournee et retourne un boolean pour
	 * savoir si la requete s'est bien deroulee on verifie d'abord si le poids de la
	 * tournee n'est pas depasse par rapport au vehicule, puis on ajoute les valeurs
	 * et on met à jour la valeur de la tournee.
	 *
	 * @param libelle    -String
	 * @param poids      -Integer
	 * @param Heuredebut -Time
	 * @param Heurefin   -Time
	 * @param client     -Client
	 * @param siret      -String
	 * @param idTournee  -int
	 * @return co -Commande
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public Commande ajouterCommandeTournee(String libelle, Integer poids, Time Heuredebut, Time Heurefin, Client client,
			String siret, int idTournee) {
		Commande co = null;
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement(
					"SELECT V.Poids_maximal, T.poid FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation WHERE idtournee=?");
			stmt.setInt(1, idTournee);
			result = stmt.executeQuery();
			result.next();
			int newpoids = result.getInt("poid") + poids;

			if (newpoids <= result.getInt("Poids_maximal")) {
				stmt = this.cn.prepareStatement("INSERT INTO Commande VALUES(0,?,?,?,?,?,?,?)");
				stmt.setString(1, libelle);
				stmt.setInt(2, poids);
				stmt.setTime(3, Heuredebut);
				stmt.setTime(4, Heurefin);
				stmt.setString(5, siret);
				stmt.setInt(6, client.getIdClient());
				stmt.setInt(7, idTournee);
				rs = stmt.executeUpdate();

				if (rs < 0) {
					throw new SQLException();
				} else {
					stmt = this.cn.prepareStatement(
							"SELECT idcommande FROM Commande WHERE idclient= ? AND idtournee= ? ORDER BY idcommande DESC");
					stmt.setInt(1, client.getIdClient());
					stmt.setInt(2, idTournee);
					result = stmt.executeQuery();
					result.next();
					co = new Commande(result.getInt("idcommande"), libelle, poids, Heuredebut, Heurefin, client);

					stmt = this.cn.prepareStatement("UPDATE Tournee SET poid=? WHERE idtournee= ?");
					stmt.setInt(1, newpoids);
					stmt.setInt(2, idTournee);
					rs = stmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return co;

	}

	/**
	 * Permet la suppression d'une commande dans une tournee et retourne un boolean
	 * pour savoir si la requete s'est bien deroulee elle supprime la commande
	 * d'abord puis met à jour le poids de la tournee.
	 * 
	 * @param commande -Commande
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public boolean supprimerCommandeTournee(Commande commande) {
		PreparedStatement stmt = null;
		int rs = -1;

		try {
			stmt = this.cn.prepareStatement(
					"UPDATE Tournee T INNER JOIN Commande C ON  C.idtournee=T.idtournee SET poid=poid-?  WHERE idcommande= ?");
			stmt.setInt(1, commande.getPoids());
			stmt.setInt(2, commande.getIdCommande());
			rs = stmt.executeUpdate();
			stmt = this.cn.prepareStatement("DELETE FROM Commande WHERE idcommande=?");
			stmt.setInt(1, commande.getIdCommande());
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
	 * Permet la modification d'une commande cela verifie le poids de la tournee et
	 * le poids max du vehicule si il n'est pas depasse, puis modifie la commande si
	 * ca c'est bien passe et met à jour le poids de la tournee.
	 * 
	 * @param commande -Commande
	 * @return boolean
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public boolean modifCommande(Commande commande) {
		PreparedStatement stmt = null;
		int rs = -1;
		ResultSet result;
		try {
			stmt = this.cn.prepareStatement(
					"SELECT V.Poids_maximal, T.poid FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation INNER JOIN Commande C ON  C.idtournee=T.idtournee WHERE idcommande=?");
			stmt.setInt(1, commande.getIdCommande());
			result = stmt.executeQuery();
			result.next();
			int newpoids = result.getInt("poid") + commande.getPoids() - commande.getAncienpoids();

			if (newpoids <= result.getInt("Poids_maximal")) {
				stmt = this.cn.prepareStatement(
						"UPDATE Commande SET Heure_de_debut=?,Heure_de_fin=?,libelle=? ,poids=? WHERE idcommande=?");

				stmt.setTime(1, commande.getHeuredebut());
				stmt.setTime(2, commande.getHeureFin());
				stmt.setString(3, commande.getLibelle());
				stmt.setInt(4, commande.getPoids());
				stmt.setInt(5, commande.getIdCommande());
				rs = stmt.executeUpdate();
				if (rs < 0) {
					throw new SQLException();
				} else {
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
	 * Permet de retourner la liste des tournees en fonction du numero de siret. On
	 * recupere les informations dans la bdd puis on les crees et on les ajoutes à
	 * la liste.
	 * 
	 * @param siret -String
	 * @return listTo -ArrayList<Tournee>
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */

	public ArrayList<Tournee> listTourneeentreprise(String siret) {
		ArrayList<Tournee> listTo = new ArrayList<Tournee>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement(
					"SELECT T.idtournee,T.Horaire_de_debut, T.Horaire_de_fin,T.Date,T.poid,T.Imaticulation, V.Poids_maximal FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation WHERE V.SIRET=?");
			stmt.setString(1, siret);
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
	 * Permet de retourner la liste des tournees en fonction du numero de siret. On
	 * recupere les informations dans la bdd puis on les crees et on les ajoutes à
	 * la liste.
	 * 
	 * @return listTo -ArrayList<Tournee>
	 * @exception SQLException si erreur de parametres
	 *
	 * @author Boisgard Julien
	 */

	public ArrayList<Tournee> listTournee() {
		ArrayList<Tournee> listTo = new ArrayList<Tournee>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement(
					"SELECT T.idtournee,T.Horaire_de_debut, T.Horaire_de_fin,T.Date,T.poid,T.Imaticulation, V.Poids_maximal FROM Vehicule V INNER JOIN Tournee T on  T.Imaticulation=V.Imaticulation ");
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
	 * Permet de retourner la liste de toute les tournees de la bases. On recupere
	 * les informations dans la bdd puis on les crees et on les ajoutes à la liste.
	 * 
	 * @return listTo -ArrrayList<Tournee>
	 * @exception SQLException si erreur deparamettres
	 * 
	 * @author Boisgard Julien
	 */

	public ArrayList<Tournee> TourneeAdmin() {
		ArrayList<Tournee> listTo = new ArrayList<Tournee>();
		PreparedStatement stmt = null;
		ResultSet result;
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
	 * Permet de recuperer tout les vehicules de la base de donnee. On recupere dans
	 * la bdd puis on cree tout les vehicules et on les ajoutes. Si la liste est
	 * vide il n'y a pas n'as pas de vehicule.
	 * 
	 * @return listVe -ArrayList<Vehicule>
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
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
	 * Permet de recuperer tout les vehicules de la base de donnee lier à une
	 * entreprise. On recupere dans la bdd puis on cree tout les vehicules et on les
	 * ajoutes. Si la liste est vide l'entreprise n'as pas de vehicule.
	 * 
	 * @return listVe -ArrayList<Vehicule>
	 * @exception SQLException si erreur de parametres
	 * 
	 * @author Boisgard Julien
	 */
	public ArrayList<Vehicule> listVehiculeEntreprise(String siret) {
		ArrayList<Vehicule> listVe = new ArrayList<Vehicule>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Vehicule WHERE SIRET=?");
			stmt.setString(1, siret);
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
	 * Permet de retouner la liste de toutes les commandes de la basse de donnee,
	 * apres on cree la commande et on l'ajoute à la liste. Si la liste est vide il
	 * n'y a pas de commande dans la tournee.
	 * 
	 * @param id -int
	 * @return listCo -ArrayList<Commande>
	 * 
	 * @author Boisgard Julien
	 */
	public ArrayList<Commande> listCommande(int id) {
		ArrayList<Commande> listCo = new ArrayList<Commande>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement(
					"Select * FROM Commande C INNER JOIN Client Cl ON C.idclient=Cl.idclient WHERE idtournee=?");
			stmt.setInt(1, id);
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
	 * Permet de recuperer tout les clients de la base de donnee, apres on cree le
	 * client et on l'ajoute à la liste. Si la liste est vide il n'y a pas de
	 * client.
	 *
	 * @return listCl -ArrayList<Client>
	 * 
	 * @author Boisgard Julien
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

	/**
	 * Permet de recuperer tout les admins qui esxiste dans la base. On recupere
	 * tout les admins dans la base pour ensuite les crees et les ajouter dans la
	 * liste. Si la liste est vide il n'existe pas admin.
	 * 
	 * @return listAd -ArrayList<Admin>
	 * 
	 * @author Boisgard Julien
	 */
	public ArrayList<Admin> listAdmin() {
		ArrayList<Admin> listAD = new ArrayList<Admin>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Admin ");
			result = stmt.executeQuery();

			while (result.next()) {
				Admin AD = new Admin(result.getString("Nom"), result.getString("Prenom"),
						result.getString("mots_de_passes"), result.getString("mail"));
				listAD.add(AD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listAD;
	}

	/**
	 * Permet de recuperer toutes les entreprises qui existe dans la base. On
	 * recupere toutes les entreprises dans la base pour ensuite les creer et les
	 * ajouter dans la liste. Si la liste est vide il n'existe pas d'entreprise.
	 * 
	 * @return listET -ArrayList<Entreprise>
	 * 
	 * @author Boisgard Julien
	 */
	public ArrayList<Entreprise> listEntreprise() {
		ArrayList<Entreprise> listET = new ArrayList<Entreprise>();
		PreparedStatement stmt = null;
		ResultSet result;
		try {

			stmt = this.cn.prepareStatement("SELECT * FROM Entreprise ");
			result = stmt.executeQuery();

			while (result.next()) {
				Entreprise ET = new Entreprise(result.getString("SIRET"), result.getInt("Numero_de_rue"),
						result.getString("rue"), result.getInt("code_postal"), result.getString("ville"),
						result.getString("pays"), result.getString("NOM"), result.getString("prenom"),
						result.getString("Numero_de_telephone"), result.getString("mots_de_passes"));
				listET.add(ET);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listET;
	}

	/**
	 * Permet de recuperer le siret lier à une tournée.
	 * 
	 * @param id -int
	 * @return s -String
	 * 
	 * @author Boisgard Julien
	 */
	public String getSiretTournee(int id) {
		String s = null;
		PreparedStatement stmt = null;
		ResultSet result;
		try {
			stmt = this.cn.prepareStatement(
					"SELECT E.SIRET FROM entreprise E INNER JOIN vehicule V ON E.SIRET=V.SIRET INNER JOIN tournee T ON T.Imaticulation=V.Imaticulation WHERE idtournee= ?");
			stmt.setInt(1, id);
			result = stmt.executeQuery();

			result.next();
			s = result.getString("SIRET");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}