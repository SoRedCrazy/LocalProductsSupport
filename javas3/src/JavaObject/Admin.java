package JavaObject;

public class Admin {
  
    private String nom;
 
    private String prenom;
   
    private String password;
    
    /**
     * Ce constructeur permet de cr�er un administrateur , chaque administrateur est unique et prend en 
     * parametre un nom,prenom et mot de passe pour son identification.
     * @param nom -String
     * @param prenom -String
     * @param password -String
     */
    public Admin(String nom,String prenom,String password) {
    	this.nom = nom;
    	this.prenom = prenom;
    	this.password = password;
    }
    
    
   /**
    * Ce getter permet de r�cup�rer le nom d'un administrateur
    * @return Un nom de type String
    */
    private String getNom() {
        return this.nom;
    }
    
    /**
     * Ce setter permet de modifier le nom de l'administrateur
     * @param nom -String
     */
    private void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Ce getter permet de r�cup�rer le pr�nom d'un administrateur
     * @return Un pr�nom de type String
     */
    private String getPrenom() {
        return this.prenom;
    }
    
    /**
     * Ce setter permet de modifier le Prenom d'un administrateur
     * @param prenom -String
     */
    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * Ce getter permet de r�cup�rer le mot de passe d'un administrateur
     * @return Un mot de passe de type String
     */
    private String getPassword() {
        return this.password;
    }
    
    /**
     * Ce setter permet de modifier le mot de passe d'un administrateur
     * @param password -String
     */
    private void setPassword(String password) {
        this.password = password;
    }
    
    

    //Operations                                  
    
    /**
     * Cette m�thode permet l'ajout d'une Entreprise � la base de donn�e.
     * L'entreprise ne doit pas exister dans la base de donn�e pour que l'ajout fonctionne.
     * @param siret -Integer
     * @param numeroDeRue -Integer
     * @param rue -String
     * @param codePostal -Integer
     * @param ville -String
     * @param pays -String
     * @param nom -String
     * @param prenom -String
     * @param numTelephone -String
     * @param ListVehicule[] -Vehicule
     * @param ListTournee[] -Tournee
     * @param ListClient[] -Client
     * @param password -String
     * @param vehicule -Vehicule
     */
    public void ajouterEntreprise() {
        //TODO
    }
    /**
    * Cette m�thode permet la suppression d'une Entreprise sur la base de donn�e.
    * L'entreprise doit exister dans la base de donn�e pour que la suppression fonctionne.
    * @param siret de l'entreprise � supprimer -Integer
     * @return 
    */
    public void supprimerEntreprise() {
        //TODO
    }
    /**
    * Cette m�thode permet d'ajouter un Client � la base de donn�e.
    * Le Client ne doit pas exister dans la base de donn�e pour que la m�thode fonctionne.
    * @param prenom -String
    * @param nom -String
    * @param numeroDeRue -Integer
    * @param rue -String
    * @param codePostal -Integer
    * @param ville -String
    * @param pays -String
    * @param numTelephone -String
    * @param numTelephone -Long
    * @param entreprise -Entreprise
    * @author gangn
     * @return 
    */
    public void ajouterClient(String prenom,String nom,Integer numeroDeRue,String rue,Integer codePostal,String ville,String pays,String  numTelephone,String mailAdmin) {
        DAO instance = new DAO();
        instance.ajouterclient(prenom, nom, numeroDeRue, rue, codePostal, ville, pays, numTelephone, mailAdmin);
        
    }
    /**
    * Cette m�thode permet la suppression d'un Client sur la base de donn�e.
    * Le client doit exister dans la base de donn�e pour que la suppression fonctionne.
    * @param Client � supprimer -Client
     * @return 
    */
    public void supprimerClient(Client client) {
    	DAO instance = new DAO();
    	instance.delclient(client);
    	//blablatest
    }
    /**
    * Cette m�thode permet de modifier les parametres d'un client.
    * @param parametre � changer -F
    * @param nouvelle valeur -F 
     * @return 
    */
    public void ModifClient() {
        //TODO
    }
    /**
    * Cette m�thode permet de modifier les parametres d'une entreprise.
    * @param parametre � changer -F
    * @param nouvelle valeur -F
     * @return 
    */
    public void ModifEntreprise() {
        //TODO
    }
    /**
    * Cette m�thode permet la connexion de l'administrateur au logiciel.
    * La m�thode v�rifie que les parametres rentr�s corresponde au parametre sur la base de donn�e.
    * @param adresseMail (Concat�nation du Nom.Pr�nom@...fr) -String
    * @param password -String
     * @return 
    */
    public void connexion() {
        //TODO
    }
    
}
