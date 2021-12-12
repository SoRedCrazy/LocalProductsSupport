package JavaObject;

import java.util.ArrayList;

/**
 * La classe Admin , permet de cr�e un Administrateur.
 * Il pourra par la suite utiliser toute les m�thodes disponible dans cette classe.
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
	 * Ce constructeur permet de cr�er un administrateur , chaque administrateur est
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
	 * Ce getter permet de r�cup�rer le nom d'un administrateur
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
	 * Ce getter permet de r�cup�rer le pr�nom d'un administrateur
	 * 
	 * @return Un pr�nom de type String
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
	 * Ce getter permet de r�cup�rer le mot de passe d'un administrateur
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
	 * Cette m�thode permet l'ajout d'une Entreprise � la base de donn�e.
	 * L'entreprise ne doit pas exister dans la base de donn�e pour que l'ajout
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
	 * Cette m�thode permet la suppression d'une Entreprise sur la base de donn�e.
	 * L'entreprise doit exister dans la base de donn�e pour que la suppression
	 * fonctionne.
	 * 
	 * @param Entreprise � supprimer -Entreprise
	 * @return
	 * @see supprimerEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerEntreprise(Entreprise entreprise) {
		
		instance.supprimerEntreprise(entreprise);
	}

	/**
	 * Cette m�thode permet d'ajouter un Client � la base de donn�e. Le Client ne
	 * doit pas exister dans la base de donn�e pour que la m�thode fonctionne.
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
	 * Cette m�thode permet la suppression d'un Client sur la base de donn�e. Le
	 * client doit exister dans la base de donn�e pour que la suppression
	 * fonctionne.
	 * 
	 * @param Client � supprimer -Client
	 * @see delclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void supprimerClient(Client client) {
		
		instance.delclient(client);
		// blablatest
	}

	/**
	 * Cette m�thode permet de modifier les parametres d'un client.
	 * 
	 * @param Client a modifier -Client
	 * @see modifclient() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifClient(Client client) {
		
		instance.modifclient(client);
	}

	/**
	 * Cette m�thode permet de modifier les parametres d'une entreprise.
	 * 
	 * @param Entreprise � modifier -Entreprise
	 * @see modifEntreprise() -DAO
	 * @author Gangneux Alexis
	 */
	public void ModifEntreprise(Entreprise entreprise) {
		
		instance.modifEntreprise(entreprise);

	}

	/**
	 * Cette m�thode permet la connexion de l'administrateur au logiciel. La m�thode
	 * v�rifie que les parametres rentr�s corresponde au parametre sur la base de
	 * donn�e.
	 * 
	 * @param adresseMail (Concat�nation du Nom.Pr�nom@...fr) -String
	 * @param password    -String
	 * @see listAdmin() -DAO
	 * @author Gangneux Alexis
	 */
	public void connexion(Admin admin) {
		ArrayList<Admin> listAdmin = instance.listAdmin();
		for(Admin a : listAdmin) {
			if(admin == a) {
				System.out.println("Connexion r�ussie");
			}
		}
		System.out.println("Connexion �chouer, enregistrez-vous dans la base de donn�e");
	}

}
