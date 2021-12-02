package JavaObject;
//test

/**
* @generated
* Cette classe va servir a gerer entierement les objets entreprise, qui representeron les entreprise des producteur, et donc les utilisateur du logiciel.
*/
public class Entreprise {
    
   
	private Integer siret;
    private Integer numeroDeRue;
    private String rue;
    private Integer codePostal;
    private String ville;
    private String pays;
    private String nom;
    private String prenom;
    private Integer numTelephone;
    private Vehicule ListVehicule;
    private Tournee ListTournee;
    private Client ListClient;
    private String password;
    private Vehicule vehicule;
    private Client client;
    private Tournee tournee;
    //BRO
    /**
     * CONSTRUCTEUR
     * Permet de creer une entreprise, seul un admin peut le faire.
     * @param siret -Integer
     * @param numeroDeRue -Integer
     * @param rue -String
     * @param codePostal -Integer
     * @param ville -String
     * @param pays -String
     * @param nom -String
     * @param prenom -String
     * @param numTelephone -Integer
     */
    public Entreprise (int siret, Integer numeroDeRue, String rue, Integer codePostal, String ville, String pays, String nom, String prenom, Integer numTelephone) {
    	this.siret=siret;
    	this.numeroDeRue=numeroDeRue;
    	this.rue=rue;
    	this.codePostal=codePostal;
    	this.ville=ville;
    	this.pays=pays;
    	this.nom=nom;
    	this.prenom=prenom;
    	this.numTelephone=numTelephone;
    	
    }
    
    
    //GETTERS AND SETTERS
    
    /**
    * @generated
    * Permet d'obtenir la valeur du siret.
    * @return siret -Integer
    */
    public Integer getSiret() {
        return this.siret;
    }
    
    /**
    * @generated
    * Permet de modifier la valeur du siret.
    * @param siret -Integer 
    */
    public void setSiret(Integer siret) {
        this.siret = siret;
    }
    
    /**
    * @generated
    * Permet d'obtenir le numero de rue.
    * @return numeroDeRue -Integer
    */
    public Integer getNumeroDeRue() {
        return this.numeroDeRue;
    }
    
    /**
    * @generated
    * Permet de modifier le numero de rue.
    * @param numeroDeRue -Integer
    */
    public void setNumeroDeRue(Integer numeroDeRue) {
        this.numeroDeRue = numeroDeRue;
    }
    
    /**
    * @generated
    * Permet d'obtenir le nom de la rue.
    * @return rue -String
    */
    public String getRue() {
        return this.rue;
    }
    
    /**
    * @generated
    * Permet de modifier le nom de rue.
    * @param rue -String
    */
    public void setRue(String rue) {
        this.rue = rue;
    }
    
    /**
    * @generated
    * Permet d'obtenir le code postal
    * @return codePostal -Integer
    */
    public Integer getCodePostal() {
        return this.codePostal;
    }
    
    /**
    * @generated
    * Permet de modifier le code postal
    * @param codePostal -Integer
    */
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
    
    /**
    * @generated
    * Permet d'obtenir le nom de la ville
    * @return ville -String
    */
    public String getVille() {
        return this.ville;
    }
    
    /**
    * @generated
    * Permet de modifier la ville 
    * @param ville -String
    */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
    * @generated
    * Permet d'obtenir le pays
    * @return pays -String
    */
    public String getPays() {
        return this.pays;
    }
    
    /**
    * @generated
    * Permet de modifier le pays
    * @param pays -String
    */
    public void setPays(String pays) {
        this.pays = pays;
    }
    
    /**
    * @generated
    * Permet d'obtenir le nom du proprietaire
    * @return nom -String
    */
    public String getNom() {
        return this.nom;
    }
    
    /**
    * @generated
    * Permet de modifier le nom du proprietaire
    * @param nom -String
    */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
    * @generated
    * Permet d'obtenir le prenom du propretaire
    * @return prenom -String
    */
    public String getPrenom() {
        return this.prenom;
    }
    
    /**
    * @generated
    * Permet de modifier le prenom du proprietaire
    * @param prenom -String
    */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
    * @generated
    * Permet d'obtenir le numero de telephone
    * @return numTelephone -Integer
    */
    public Integer getNumTelephone() {
        return this.numTelephone;
    }
    
    /**
    * @generated
    * Permet de modifier le numero de telephone 
    * @param Integer
    */
    public void setNumTelephone(Integer numTelephone) {
        this.numTelephone = numTelephone;
    }
    
    /**
    * @generated
    * permet de d'obtenir un liste de vehicule
    * @return ListVehicule -Vehicule
    */
    public Vehicule getListVehicule() {
        return this.ListVehicule;
    }
    
    /**
    * @generated
    * Permet de modifier une liste de vehicule 
    * @param ListVehicule -Vehicule
    */
    public void setListVehicule(Vehicule ListVehicule) {
        this.ListVehicule = ListVehicule;
    }
    
    /**
    * @generated
    * Permet d'obtenir la liste de tournee
    * @return ListTournee -Tournee
    */
    public Tournee getListTournee() {
        return this.ListTournee;
    }
    
    /**
    * @generated
    * Permet de modifier lez liste de tournee
    * @param ListTournee -Tournee
    */
    public void setListTournee(Tournee ListTournee) {
        this.ListTournee = ListTournee;
    }
    
    /**
    * @generated
    * Permet d'obtenir la liste de client
    * @return ListClient -Client
    */
    public Client getListClient() {
        return this.ListClient;
    }
    
    /**
    * @generated
    * Permet de modifier la liste de client
    * @param ListClient -Client
    */
    public void setListClient(Client ListClient) {
        this.ListClient = ListClient;
    }
    
    /**
    * @generated
    * Permet d'obtenir le mot de passe
    * @return password -String
    */
    public String getPassword() {
        return this.password;
    }
    
    /**
    * @generated
    * Permet de modifier le mot de passe
    * @param password -String
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
    * @generated
    * Permet d'obtenir une tournee
    * @return tournee -Tournee
    */
    public Tournee getTournee() {
        return this.tournee;
    }
    
    /**
    * @generated
    * Permet de modifier une tournee
    * @param tournee -Tournee
    */
    public void setTournee(Tournee tournee) {
        this.tournee = tournee;
    }
    
    /**
    * @generated
    * Permet d'obtenir un vehicule
    * @return vehicule -Vehicule
    */
    public Vehicule getVehicule() {
        return this.vehicule;
    }
    
    /**
    * @generated
    * Permet de modifier un Vehicule
    * @param vehicule -Vehicule
    */
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    
    /**
    * @generated
    * Permet d'obtenir un client 
    * @return client -Client
    */
    public Client getClient() {
        return this.client;
    }
    
    /**
    * @generated
    * Permet de modifiuer un client
    * @param client -Client
    */
    public void setClient(Client client) {
        this.client = client;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    * Ajoute un vehicule a la liste de vehicules de l'entreprise
    * @param Vehicule
     * @return 
    */
    public void ajouterVehicule(Vehicule v) {
        //TODO
    }
    /**
    * @generated
    * Supprime un vehicule de la liste de vehicule de l'entreprise
    * @param Vehicule
     * @return 
    */
    public void supprimerVehicule(Vehicule v) {
        //TODO
    }
    /**
    * @generated
    * Ajoute une tournee a la liste de tournee de l'entreprise
    * @param Tournee
     * @return 
    */
    public void ajouterTournee(Tournee t) {
        //TODO
    }
    /**
    * @generated
    * Modifie les information d'une tournee
    * @param Tournee
     * @return 
    */
    public void modifierTournee(Tournee t) {
        //TODO
    }
    /**
    * @generated
    * Supprime une tournee de la liste de tournee de l'entreprise
    * @param Tournee
     * @return 
    */
    public void supprimerTournee(Tournee t) {
        //TODO
    }
    /**
    * @generated
    * Permet d'obtenir toutes les information d'une commande
    * @param Commande
     * @return 
    */
    public void consulterCommande(Commande c) {
        //TODO
    }
    /**
    * @generated
    * Permet d'obtenir toutes les information d'une tournee
    * @param Tournee
     * @return 
    */
    public void consulterTournee(Tournee t) {
        //TODO
    }
    /**
    * @generated
    * Permet d'ajouter une commande a une tournee
    * @param Tournee
    * @param Commande
     * @return 
    */
    public void ajouterCommandeTournee(Tournee t, Commande c) {
        //TODO
    }
    /**
    * @generated
    * Permet de supprimer une commande d'une tournee
    * @param Tournee
    * @param Commande
     * @return 
    */
    public void supprimerCommandeTournee(Tournee t, Commande c) {
        //TODO
    }
    /**
    * @generated
    * Permet a l'utilisateur de se connecter
    * @param String
    * @param String
     * @return 
    */
    public void connexion(String usr, String password) {
        //TODO
    }
    
}
