package JavaObject;

/**
 * La classe Admin , permet de crée un Administrateur, l'administrateur a tout
 * les droits de suppression, d'ajout et de modification sur les autres
 * utilisateurs (Entreprise et Client).
 * 
 * @see DAO
 * 
 * @author Gangneux Alexis
 *
 */

public class Admin {

	private String nom;

	private String prenom;

	private String password;

	private String email;

	private DAO instance = new DAO();

	/**
	 * Ce constructeur permet de creer un administrateur , chaque administrateur est
	 * unique et prend en parametre un nom,prenom et mot de passe pour son
	 * identification.
	 * 
	 * @param nom    -String
	 * @param prenom -String
	 * @param email  -String
	 * 
	 * @author Gangneux Alexis
	 */
	public Admin(String nom, String prenom, String password, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
	}

	/**
	 * Ce getter permet de recuperer le nom d'un administrateur.
	 * 
	 * @return nom -String
	 * 
	 * @author Gangneux Alexis
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Ce setter permet de modifier le nom de l'administrateur.
	 * 
	 * @param nom -String
	 * 
	 * @author Gangneux Alexis
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ce getter permet de recuperer le prenom d'un administrateur.
	 * 
	 * @return prenom -String
	 * 
	 * @author Gangneux Alexis
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Ce setter permet de modifier le Prenom d'un administrateur.
	 * 
	 * @param prenom -String
	 * 
	 * @author Gangneux Alexis
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Ce getter permet de recuperer le mot de passe d'un administrateur.
	 * 
	 * @return password -String
	 * 
	 * @author Gangneux Alexis
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Ce setter permet de modifier le mot de passe d'un administrateur.
	 * 
	 * @param password -String
	 * 
	 * @author Gangneux Alexis
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Ce getter permet de recuperer l'email d'un administrateur.
	 * 
	 * @return email -String
	 *
	 * @author Gangneux Alexis
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Ce setter permet de modifier l'email d'un administrateur.
	 * 
	 * @param email -String
	 * 
	 * @author Gangneux Alexis
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// Operations

	/**
	 * Cette methode permet l'ajout d'une Entreprise à la base de donnee.
	 * L'entreprise ne doit pas exister dans la base de donnee pour que l'ajout
	 * fonctionne.
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
	 * @param password     -String
	 * @return boolean
	 * @see ajouterEntreprise() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean ajouterEntreprise(String siret, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String password) {
		Entreprise ent = instance.ajouterEntreprise(siret, prenom, nom, numeroDeRue, rue, codePostal, ville, pays,
				numTelephone, password, this.email);
		if (ent != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cette methode permet la suppression d'une Entreprise sur la base de donnee.
	 * L'entreprise doit exister dans la base de donnee pour que la suppression
	 * fonctionne.
	 * 
	 * @param siret -String
	 * @return boolean
	 * @see supprimerEntreprise() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean supprimerEntreprise(String siret) {

		boolean b = instance.supprimerEntreprise(siret);

		if (b == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cette methode permet d'ajouter un Client à la base de donnee. Le Client ne
	 * doit pas exister dans la base de donnee pour que la methode fonctionne.
	 * 
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @return boolean
	 * @see ajouterclient() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean ajouterClient(String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone) {

		Client c = instance.ajouterclient(prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone,
				this.email);
		if (c != null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Cette methode permet la suppression d'un Client sur la base de donnee. Le
	 * client doit exister dans la base de donnee pour que la suppression
	 * fonctionne.
	 * 
	 * @param client -Client
	 * @return boolean
	 * @see delclient() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean supprimerClient(Client client) {

		boolean b = instance.delclient(client);
		if (b) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Cette methode permet de modifier les parametres d'un client.
	 * 
	 * @param client       -Client
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @return boolean
	 * @see modifclient() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean ModifClient(Client client, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone) {
		client.setPrenom(prenom);
		client.setNom(nom);
		client.setNumeroDeRue(numeroDeRue);
		client.setRue(rue);
		client.setCodePostal(codePostal);
		client.setVille(ville);
		client.setPays(pays);
		client.setNumTelephone(numTelephone);
		boolean b = instance.modifclient(client);

		if (b) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cette methode permet de modifier les parametres d'une entreprise.
	 * 
	 * @param entreprise   -Entreprise
	 * @param prenom       -String
	 * @param nom          -String
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @param password     -String
	 * @return boolean
	 * @see modifEntreprise() -DAO
	 * 
	 * @author Gangneux Alexis
	 */
	public boolean ModifEntreprise(Entreprise entreprise, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String password) {
		entreprise.setRue(rue);
		entreprise.setPrenom(prenom);
		entreprise.setNom(nom);
		entreprise.setNumeroDeRue(numeroDeRue);
		entreprise.setRue(rue);
		entreprise.setCodePostal(codePostal);
		entreprise.setVille(ville);
		entreprise.setPays(pays);
		entreprise.setNumTelephone(numTelephone);
		entreprise.setMdp(password);
		boolean b = instance.modifEntreprise(entreprise);

		if (b) {
			return true;
		} else {
			return false;
		}

	}

}
