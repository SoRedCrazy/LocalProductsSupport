package JavaObject;

/**
 * Cette classe permet de gerer les objets client, elle ne contient que le
 * constructeur de l'objet, ainsi que les getters et setters.
 */

public class Client {

	private Integer idClient;
	private String prenom;
	private String nom;
	private Integer numeroDeRue;
	private String rue;
	private Integer codePostal;
	private String ville;
	private String pays;
	private String numTelephone;

	/**
	 * Ce constructeur permet de créer un client avec de nombreux paramétres. Seul
	 * l'administrateur peut créer des clients. Chaque client est unique.
	 * 
	 * @param idClient     -Integer
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -Integer
	 * 
	 * @author Gangneux Alexis
	 */
	public Client(Integer idClient, String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone) {
		this.idClient = idClient;
		this.prenom = prenom;
		this.nom = nom;
		this.numeroDeRue = numeroDeRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.numTelephone = numTelephone;

	}

	/**
	 * Permet d'afficher tout les attibuts du client.
	 * 
	 * @author Gangneux Alexis
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", prenom=" + prenom + ", nom=" + nom + ", numeroDeRue=" + numeroDeRue
				+ ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays
				+ ", numTelephone=" + numTelephone + "]";
	}

	/**
	 * Permet de récupérer la valeur de l'id client.
	 * 
	 * @return idClient -Integer
	 * @author Gangenux Alexis
	 */
	public Integer getIdClient() {
		return this.idClient;
	}

	/**
	 * Permet de récupérer le prénom du client.
	 * 
	 * @return prenom -String
	 * 
	 * @author Gangenux Alexis
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Permet de modifier le prénom du client.
	 * 
	 * @param prenom -String
	 * 
	 * @author Gangenux Alexis
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet de récupérer le nom du client.
	 * 
	 * @return nom -String
	 * 
	 * @author Gangenux Alexis
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet de modifier le nom du client.
	 * 
	 * @param nom -String
	 * 
	 * @author Gangenux Alexis
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet de récupérer le numéro de rue du client.
	 * 
	 * @return numeroDeRue -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public Integer getNumeroDeRue() {
		return this.numeroDeRue;
	}

	/**
	 * Permet de modifier le numéro de rue du client.
	 * 
	 * @param numeroDeRue -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public void setNumeroDeRue(Integer numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	/**
	 * Permet de récupérer la rue du client.
	 * 
	 * @return rue -String
	 * 
	 * @author Gangenux Alexis
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * Permet de modifier la rue du client.
	 * 
	 * @param rue -String
	 * 
	 * @author Gangenux Alexis
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Permet de récupérer le code Postal du client.
	 * 
	 * @return codePostal -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Permet de modifier le code Postal du client.
	 * 
	 * @param codePostal -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Permet de récupérer la ville du client.
	 * 
	 * @return ville -String
	 * 
	 * @author Gangenux Alexis
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Permet de modifier la ville du client.
	 * 
	 * @param ville -String
	 * 
	 * @author Gangenux Alexis
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Permet de récupérer le Pays du client.
	 * 
	 * @return pays -String
	 * 
	 * @author Gangenux Alexis
	 */
	public String getPays() {
		return this.pays;
	}

	/**
	 * Permet de modifier le pays du client.
	 * 
	 * @param pays -String
	 * 
	 * @author Gangenux Alexis
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Permet de récupérer le numéro de téléphone du client.
	 * 
	 * @return numTelephone -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public String getNumTelephone() {
		return this.numTelephone;
	}

	/**
	 * Permet de modifier le numéro de téléphone du client.
	 * 
	 * @param numTelephone -Integer
	 * 
	 * @author Gangenux Alexis
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

}
