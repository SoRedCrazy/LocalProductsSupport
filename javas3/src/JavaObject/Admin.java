package JavaObject;

import java.util.ArrayList;

/**
 * La classe Admin , permet de crée un Administrateur.
 * Il pourra par la suite utiliser toute les méthodes disponible dans cette classe.
 * Administrateur aura tout les droits de suppression, d'ajout et de modification sur les autres utilisateurs (Entreprise et Client).
 * @see DAO
 * @author gangn
 *
 */

public class Admin {

	private String nom;

	private String prenom;

	private String password;
	private DAO instance = new DAO();

	/**
	 * Ce constructeur permet de créer un administrateur , chaque administrateur est
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
		this.password = email;
	}

	/**
	 * Ce getter permet de récupérer le nom d'un administrateur
	 * 
	 * @return Un nom de type String
	 * @author Gangneux Alexis
	 */
	private String getNom() {
		return this.nom;
	}

	/**
	 * Ce setter permet de modifier le nom de l'administrateur
	 * 
	 * @param nom -String
	 * @author Gangneux Alexis
	 */
	private void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ce getter permet de récupérer le prénom d'un administrateur
	 * 
	 * @return Un prénom de type String
	 * @author Gangneux Alexis
	 */
	private String getPrenom() {
		return this.prenom;
	}

	/**
	 * Ce setter permet de modifier le Prenom d'un administrateur
	 * 
	 * @param prenom -String
	 * @author Gangneux Alexis
	 */
	private void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Ce getter permet de récupérer le mot de passe d'un administrateur
	 * 
	 * @return Un mot de passe de type String
	 * @author Gangneux Alexis
	 */
	private String getPassword() {
		return this.password;
	}

	/**
	 * Ce setter permet de modifier le mot de passe d'un administrateur
	 * 
	 * @param password -String
	 * @author Gangneux Alexis
	 */
	private void setPassword(String password) {
		this.password = password;
	}

	// Operations

	/**
	 * Cette méthode permet l'ajout d'une Entreprise à la base de donnée.
	 * L'entreprise ne doit pas exister dans la base de donnée pour que l'ajout
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
			Integer codePostal, String ville, String pays, String numTelephone, String motsdepasses, String mailAdmin) {
		instance.ajouterEntreprise(siret, prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone,
				motsdepasses, mailAdmin);
	}

	/**
	 * Cette méthode permet la suppression d'une Entreprise sur la base de donnée.
	 * L'entreprise doit exister dans la base de donnée pour que la suppression
	 * fonctionne.
	 * 
	 * @param Entreprise à supprimer -Entreprise
	 * @return
	 * @see supprimerEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerEntreprise(Entreprise entreprise) {
		
		instance.supprimerEntreprise(entreprise);
	}

	/**
	 * Cette méthode permet d'ajouter un Client à la base de donnée. Le Client ne
	 * doit pas exister dans la base de donnée pour que la méthode fonctionne.
	 * 
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -String
	 * @param numTelephone -Long
	 * @param entreprise   -Entreprise
	 * @author Gangneux Alexis
	 * @see ajouterclient() -DAO
	 */
	public void ajouterClient(String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone, String mailAdmin) {
		
		instance.ajouterclient(prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone, mailAdmin);

	}

	/**
	 * Cette méthode permet la suppression d'un Client sur la base de donnée. Le
	 * client doit exister dans la base de donnée pour que la suppression
	 * fonctionne.
	 * 
	 * @param Client à supprimer -Client
	 * @see delclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerClient(Client client) {
		
		instance.delclient(client);
		// blablatest
	}

	/**
	 * Cette méthode permet de modifier les parametres d'un client.
	 * 
	 * @param Client a modifier -Client
	 * @see modifclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifClient(Client client) {
		
		instance.modifclient(client);
	}

	/**
	 * Cette méthode permet de modifier les parametres d'une entreprise.
	 * 
	 * @param Entreprise à modifier -Entreprise
	 * @see modifEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifEntreprise(Entreprise entreprise) {
		
		instance.modifEntreprise(entreprise);

	}

	/**
	 * Cette méthode permet la connexion de l'administrateur au logiciel. La méthode
	 * vérifie que les parametres rentrés corresponde au parametre sur la base de
	 * donnée.
	 * 
	 * @param adresseMail (Concaténation du Nom.Prénom@...fr) -String
	 * @param password    -String
	 * @see listAdmin() -DAO
	 * @author Gangneux Alexis
	 */
	public void connexion(Admin admin) {
		ArrayList<Admin> listAdmin = instance.listAdmin();
		for(Admin a : listAdmin) {
			if(admin == a) {
				System.out.println("Connexion réussie");
			}
		}
		System.out.println("Connexion échouer, enregistrez-vous dans la base de donnée");
	}

}
