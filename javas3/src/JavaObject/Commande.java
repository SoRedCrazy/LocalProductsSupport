package JavaObject;
import java.sql.Date;
import java.sql.Time;

public class Commande {

    private Integer idCommande;
    private String libelle;
    private Integer poids;
    private Time heuredebut;
    private Time heurefin;
    private Client Client;
    private int ancienpoids;

    public Commande(Integer idCommande, String libelle, Integer poids, Time heuredebut, Time heurefin, Client client) {
		this.idCommande = idCommande;
		this.libelle = libelle;
		this.poids = poids;
		this.heuredebut = heuredebut;
		this.heurefin=heurefin;
		Client = client;
	}

	/**
    * Permet de récupérer l'id de la commande.
    * @return idCommande
    */
    public Integer getIdCommande() {
        return this.idCommande;
    }
    
    /**
    * Permet de définir l'id de la commande.
    * @param commande
    */
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }
    
    /**
    * Permet de récupérer le libéllé de la commande.
    * @return libelle
    */
    public String getLibelle() {
        return this.libelle;
    }
    
    /**
    * Permet de définir le libelle de la commande.
    * @param libelle
    */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    /**
    * Permet de récupérer la poids de la commande.
    * @return poids
    */
    public Integer getPoids() {
        return this.poids;
    }
    
    /**
     * permet de sette le poid 
     * @param poids
     */
	public void setPoids(int poids) {
		this.ancienpoids=this.poids;
		this.poids = poids;
	}
	 /**
     * permet d'avoir l'ancien poids utiles a la base de donnee
     * @param poids
     */
	public int getAncienpoids() {
		return ancienpoids;
	}
    /**
    * Permet de récupérer la date de la commande.
    * @return dateCommande
    */
    public Time getHeuredebut() {
        return this.heuredebut;
    }
    
    /**
    * Permet de définir la date de la commande.
    * @param dateCommande
    */
    public void setheuredebut(Time heuredebut) {
        this.heuredebut = heuredebut;
    }
    
    /**
    * Permet de récupérer la date limite de la commande.
    * @return dateLimite
    */
    public Time getHeureFin() {
        return this.heurefin;
    }
    
    /**
    * Permet de définir la date limite de la commande.
    * @param dateLimite
    */
    public void setheurefin(Time heurefin) {
        this.heurefin = heurefin;
    }
    
    /**
    * @generated
    */
    public Client getClient() {
        return this.Client;
    }
    
    /**
    * @generated
    */
    public void setClient(Client Client) {
        this.Client = Client;
    }
    
}
