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
    private Integer numTelephone;
    private Commande commande;
    
    /**
     * Ce constructeur permet de créer un client avec de nombreux paramétres 
     * seul l'administrateur peut créer des clients.
     * Chaque client est unique.
     * @param prenom -String
     * @param nom -String
     * @param numeroDeRue -Integer
     * @param rue -String
     * @param codePostal -Integer
     * @param ville -String
     * @param pays -String
     * @param numTelephone -Integer
     * @param entreprise -Entreprise
     * @author gangn
     */
    public Client(String prenom,String nom,Integer numeroDeRue,String rue,Integer codePostal,String ville,String pays,Integer numTelephone,Commande commande) {
    	this.prenom = prenom;
    	this.nom = nom;
    	this.numeroDeRue = numeroDeRue;
    	this.rue = rue;
    	this.codePostal = codePostal;
    	this.ville = ville;
    	this.pays = pays;
    	this.numTelephone = numTelephone;
    	this.commande = commande;
 
    }
    
    /**
     * Ce getteur permet de récupérer la valeur de l'id client
     * @return l'id du client de type Integer
     * @author gangn
     */
    private Integer getIdClient() {
        return this.idClient;
    }
    
    /**
     * Ce getteur permet de récupérer le prénom du client
     * @return le prénom du client de type String
     */
    private String getPrenom() {
        return this.prenom;
    }
    
    /**
     * Ce setteur permet de modifier le prénom du client
     * @param prenom -String
     */
    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
   /**
    * Ce getteur permet de récupérer le nom du client
    * @return le nom du client de type String
    */
    private String getNom() {
        return this.nom;
    }
    
    /**
     * Ce setteur permet de modifier le nom du client
     * @param nom -String
     */
    private void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Ce getteur permet de récupérer le numéro de rue du client 
     * @return le numéro de rue du client de type Integer
     */
    private Integer getNumeroDeRue() {
        return this.numeroDeRue;
    }
    
    /**
     * Ce setteur permet de modifier le numéro de rue du client
     * @param numeroDeRue -Integer
     */
    private void setNumeroDeRue(Integer numeroDeRue) {
        this.numeroDeRue = numeroDeRue;
    }
    
    /**
     * Ce getteur permet de récupérer la rue du client
     * @return le nom de rue du client de type String
     */
    private String getRue() {
        return this.rue;
    }
    
    /**
     * Ce setteur permet de modifier la rue du client 
     * @param rue -String
     */
    private void setRue(String rue) {
        this.rue = rue;
    }
    
    /**
     * Ce getteur permet de récupérer le code Postal du client
     * @return le code Postal de type Integer
     */
    private Integer getCodePostal() {
        return this.codePostal;
    }
    
    /**
     * Ce setteur permet de modifier le code Postal du client
     * @param codePostal -Integer
     */
    private void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
    
    /**
     * Ce getteur permet de récupérer la ville du client
     * @return le nom de la ville de type String
     */
    private String getVille() {
        return this.ville;
    }
    
    /**
     * Ce setteur permet de modifier la ville du client
     * @param ville -String
     */
    private void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
     * Ce getteur permet de récupérer le Pays du client
     * @return le nom du pays de type String
     */
    private String getPays() {
        return this.pays;
    }
    
    /**
     * Ce setteur permet de modifier le pays du client
     * @param pays -String
     */
    private void setPays(String pays) {
        this.pays = pays;
    }
    
    /**
     * Ce getteur permet de récupérer le numéro de téléphone du client
     * @return le numéro de téléphone de type Integer
     */
    private Integer getNumTelephone() {
        return this.numTelephone;
    }
    
    /**
     * Ce setteur permet de modifier le numéro de téléphone du client
     * @param numTelephone -Integer
     */
    private void setNumTelephone(Integer numTelephone) {
        this.numTelephone = numTelephone;
    }
    
    
    /**
     * Ce getteur permet de récupérer la commande faite par le client
     * @return la commande faite par le client de type Commande
     */
    public Commande getCommande() {
        return this.commande;
    }
    
    /**
     * Ce setteur permet de modifier la commande éffectuer par le client
     * @param commande -Commande
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
}
