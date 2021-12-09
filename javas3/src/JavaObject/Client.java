package JavaObject;

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
	 * Ce constructeur permet de créer un client avec de nombreux paramétres seul
	 * l'administrateur peut créer des clients. Chaque client est unique.
	 * 
	 * @param prenom       -String
	 * @param nom          -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param numTelephone -Integer
	 * @param entreprise   -Entreprise
	 * @author gangn
	 */
	public Client(int idclient, String prenom, String nom, Integer numeroDeRue, String rue, Integer codePostal,
			String ville, String pays, String numTelephone) {
		this.idClient = idclient;
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
	 * Permet d'afficher tout les attibut Client
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", prenom=" + prenom + ", nom=" + nom + ", numeroDeRue=" + numeroDeRue
				+ ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays
				+ ", numTelephone=" + numTelephone + "]";
	}

	/**
	 * Ce getteur permet de récupérer la valeur de l'id client
	 * 
	 * @return l'id du client de type Integer
	 * @author gangn
	 */
	public Integer getIdClient() {
		return this.idClient;
	}

	/**
	 * Ce getteur permet de récupérer le prénom du client
	 * 
	 * @return le prénom du client de type String
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Ce setteur permet de modifier le prénom du client
	 * 
	 * @param prenom -String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Ce getteur permet de récupérer le nom du client
	 * 
	 * @return le nom du client de type String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Ce setteur permet de modifier le nom du client
	 * 
	 * @param nom -String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ce getteur permet de récupérer le numéro de rue du client
	 * 
	 * @return le numéro de rue du client de type Integer
	 */
	public Integer getNumeroDeRue() {
		return this.numeroDeRue;
	}

	/**
	 * Ce setteur permet de modifier le numéro de rue du client
	 * 
	 * @param numeroDeRue -Integer
	 */
	public void setNumeroDeRue(Integer numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	/**
	 * Ce getteur permet de récupérer la rue du client
	 * 
	 * @return le nom de rue du client de type String
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * Ce setteur permet de modifier la rue du client
	 * 
	 * @param rue -String
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Ce getteur permet de récupérer le code Postal du client
	 * 
	 * @return le code Postal de type Integer
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Ce setteur permet de modifier le code Postal du client
	 * 
	 * @param codePostal -Integer
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Ce getteur permet de récupérer la ville du client
	 * 
	 * @return le nom de la ville de type String
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Ce setteur permet de modifier la ville du client
	 * 
	 * @param ville -String
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Ce getteur permet de récupérer le Pays du client
	 * 
	 * @return le nom du pays de type String
	 */
	public String getPays() {
		return this.pays;
	}

	/**
	 * Ce setteur permet de modifier le pays du client
	 * 
	 * @param pays -String
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Ce getteur permet de récupérer le numéro de téléphone du client
	 * 
	 * @return le numéro de téléphone de type Integer
	 */
	public String getNumTelephone() {
		return this.numTelephone;
	}

	/**
	 * Ce setteur permet de modifier le numéro de téléphone du client
	 * 
	 * @param numTelephone -Integer
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

}
