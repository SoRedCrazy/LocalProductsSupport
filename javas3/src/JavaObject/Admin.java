package JavaObject;

import java.util.ArrayList;

/**
 * La classe Admin , permet de crée un Administrateur, l'administrateur aura
 * tout les droits de suppression, d'ajout et de modification sur les autres
 * utilisateurs (Entreprise et Client).
 * 
 * @see DAO
 * @author gangn
 *
 */

public class Admin {

	private String nom;

	private String prenom;

	private String password;

	private String email;

	private DAO instance = new DAO();

	/**
	 * Ce constructeur permet de crï¿½er un administrateur , chaque administrateur est
	 * unique et prend en parametre un nom,prenom et mot de passe pour son
	 * identification.
	 * 
	 * @param nom    -String
	 * @param prenom -String
	 * @param email  -String
	 * @author Gangneux Alexis
	 */
	public Admin(String nom, String prenom, String password, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
	}

	/**
	 * Ce getter permet de rï¿½cupï¿½rer le nom d'un administrateur
	 * 
	 * @return Un nom de type String
	 * @author Gangneux Alexis
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Ce setter permet de modifier le nom de l'administrateur
	 * 
	 * @param nom -String
	 * @author Gangneux Alexis
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ce getter permet de rï¿½cupï¿½rer le prï¿½nom d'un administrateur
	 * 
	 * @return Un prï¿½nom de type String
	 * @author Gangneux Alexis
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Ce setter permet de modifier le Prenom d'un administrateur
	 * 
	 * @param prenom -String
	 * @author Gangneux Alexis
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Ce getter permet de rï¿½cupï¿½rer le mot de passe d'un administrateur
	 * 
	 * @return Un mot de passe de type String
	 * @author Gangneux Alexis
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Ce setter permet de modifier le mot de passe d'un administrateur
	 * 
	 * @param password -String
	 * @author Gangneux Alexis
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Ce getter permet de rï¿½cupï¿½rer l'email d'un administrateur
	 * 
	 * @return Un email de type String
	 * @author Gangneux Alexis
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Ce setter permet de modifier l'email d'un administrateur
	 * 
	 * @param email -String
	 * @author Gangneux Alexis
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// Operations

	/**
	 * Cette mï¿½thode permet l'ajout d'une Entreprise ï¿½ la base de donnï¿½e.
	 * L'entreprise ne doit pas exister dans la base de donnï¿½e pour que l'ajout
	 * fonctionne.
	 * 
	 * @param siret          -Integer
	 * @param numeroDeRue    -Integer
	 * @param rue            -String
	 * @param codePostal     -Integer
	 * @param ville          -String
	 * @param pays           -String
	 * @param nom            -String
	 * @param prenom         -String
	 * @param numTelephone   -String
	 * @param ListVehicule[] -Vehicule
	 * @param ListTournee[]  -Tournee
	 * @param ListClient[]   -Client
	 * @param password       -String
	 * @param vehicule       -Vehicule
	 * @see ajouterEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void ajouterEntreprise(String siret, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String motsdepasses) {
		instance.ajouterEntreprise(siret, prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone,
				motsdepasses, this.email);
	}

	/**
	 * Cette mï¿½thode permet la suppression d'une Entreprise sur la base de donnï¿½e.
	 * L'entreprise doit exister dans la base de donnï¿½e pour que la suppression
	 * fonctionne.
	 * 
	 * @param Entreprise ï¿½ supprimer -Entreprise
	 * @return
	 * @see supprimerEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerEntreprise(Entreprise entreprise) {

		instance.supprimerEntreprise(entreprise);
	}

	/**
	 * Cette mï¿½thode permet d'ajouter un Client ï¿½ la base de donnï¿½e. Le Client ne
	 * doit pas exister dans la base de donnï¿½e pour que la mï¿½thode fonctionne.
	 * 
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @param entreprise   -Entreprise
	 * @author Gangneux Alexis
	 * @see ajouterclient() -DAO
	 */
	public void ajouterClient(String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone) {
		
		instance.ajouterclient(prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone, this.email);

	}

	/**
	 * Cette mï¿½thode permet la suppression d'un Client sur la base de donnï¿½e. Le
	 * client doit exister dans la base de donnï¿½e pour que la suppression
	 * fonctionne.
	 * 
	 * @param Client ï¿½ supprimer -Client
	 * @see delclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerClient(Client client) {

		instance.delclient(client);
		
	}

	/**
	 * Cette mï¿½thode permet de modifier les parametres d'un client.
	 * 
	 * @param Client       a modifier -Client
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @see modifclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifClient(Client client, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone) {
		client.setPrenom(prenom);
		client.setNom(nom);
		client.setNumeroDeRue(numeroDeRue);
		client.setRue(rue);
		client.setCodePostal(codePostal);
		client.setVille(ville);
		client.setPays(pays);
		client.setNumTelephone(numTelephone);
		instance.modifclient(client);
	}

	/**
	 * Cette mï¿½thode permet de modifier les parametres d'une entreprise.
	 * 
	 * @param Entreprise     ï¿½ modifier -Entreprise
	 * @param rue            -String
	 * @param codePostal     -Integer
	 * @param ville          -String
	 * @param pays           -String
	 * @param nom            -String
	 * @param prenom         -String
	 * @param numTelephone   -String
	 * @param password       -String
	 * @see modifEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifEntreprise(Entreprise entreprise, String prenom, String nom, Integer numeroDeRue, String rue,
			Integer codePostal, String ville, String pays, String numTelephone, String motsdepasses) {
		entreprise.setRue(rue);
		entreprise.setPrenom(prenom);
		entreprise.setNom(nom);
		entreprise.setNumeroDeRue(numeroDeRue);
		entreprise.setRue(rue);
		entreprise.setCodePostal(codePostal);
		entreprise.setVille(ville);
		entreprise.setPays(pays);
		entreprise.setNumTelephone(numTelephone);
		entreprise.setMdp(motsdepasses);
		instance.modifEntreprise(entreprise);

	}

	/**
	 * Cette mï¿½thode permet la connexion de l'administrateur au logiciel. La mï¿½thode
	 * vï¿½rifie que les parametres rentrï¿½s corresponde au parametre sur la base de
	 * donnï¿½e.
	 * 
	 * @param adresseMail (Concatï¿½nation du Nom.Prï¿½nom@...fr) -String
	 * @param password    -String
	 * @see listAdmin() -DAO
	 * @author Gangneux Alexis
	 */
	public static Admin connexion(String email, String password) {
		DAO d = new DAO();
		ArrayList<Admin> listAdmin = d.listAdmin();
		for (Admin a : listAdmin) {
			if (a.getEmail() == email) {
				if (a.getPassword() == password) {
					return a;
				}
			}
		}
		return null;

	}

}
