package JavaObject;

import java.sql.Time;

/**
 * Cette classe permet de gerer les objets commande, elle ne contient que le
 * constructeur de l'objet, ainsi que les getters et setters.
 * 
 * @author Mechin Amaury
 */

public class Commande {

	private Integer idCommande;
	private String libelle;
	private Integer poids;
	private Time heuredebut;
	private Time heurefin;
	private Client Client;
	private int ancienpoids;

	/**
	 * Constructeur permet de créer une commande.
	 * 
	 * @param idCommande -Integer
	 * @param libelle    -String
	 * @param poids      -Integer
	 * @param heuredebut -Time
	 * @param heurefin   -Time
	 * @param client     -Client
	 * 
	 * @author Mechin Amaury
	 */

	public Commande(Integer idCommande, String libelle, Integer poids, Time heuredebut, Time heurefin, Client client) {
		this.idCommande = idCommande;
		this.libelle = libelle;
		this.poids = poids;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		Client = client;
	}

	/**
	 * Permet de récupérer l'id de la commande.
	 * 
	 * @return idCommande -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getIdCommande() {
		return this.idCommande;
	}

	/**
	 * Permet de définir l'id de la commande.
	 * 
	 * @param idCommande -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * Permet de récupérer le libéllé de la commande.
	 * 
	 * @return libelle -String
	 * 
	 * @author Mechin Amaury
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Permet de définir le libelle de la commande.
	 * 
	 * @param libelle -String
	 * 
	 * @author Mechin Amaury
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Permet de récupérer le poids de la commande.
	 * 
	 * @return poids -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getPoids() {
		return this.poids;
	}

	/**
	 * Permet de définir le poids de la commande.
	 * 
	 * @param poids -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setPoids(int poids) {
		this.ancienpoids = this.poids;
		this.poids = poids;
	}

	/**
	 * Permet d'avoir l'ancien poids utiles à la base de donnee.
	 * 
	 * @param poids -int
	 * 
	 * @author Mechin Amaury
	 */
	public int getAncienpoids() {
		return ancienpoids;
	}

	/**
	 * Permet de récupérer la date de la commande.
	 * 
	 * @return heuredebut -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHeuredebut() {
		return this.heuredebut;
	}

	/**
	 * Permet de définir la date de la commande.
	 * 
	 * @param heuredebut -Time
	 * 
	 * @author Mechin Amaury
	 */
	public void setheuredebut(Time heuredebut) {
		this.heuredebut = heuredebut;
	}

	/**
	 * Permet de récupérer la date limite de la commande.
	 * 
	 * @return heurefin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHeureFin() {
		return this.heurefin;
	}

	/**
	 * Permet de définir la date limite de la commande.
	 * 
	 * @param heurefin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public void setheurefin(Time heurefin) {
		this.heurefin = heurefin;
	}

	/**
	 * Permet de récupérer le client qui passe la commande.
	 * 
	 * @return client -Client
	 * 
	 * @author Mechin Amaury
	 */
	public Client getClient() {
		return this.Client;
	}

	/**
	 * Permet de définir le client qui passe la commande.
	 * 
	 * @param client -Client
	 * 
	 * @author Mechin Amaury
	 */
	public void setClient(Client Client) {
		this.Client = Client;
	}

	/**
	 * Permet de retourner les informations sur la commande.
	 * 
	 * @return integer idCommande - String libelle - int poids - Time heuredebut -
	 *         Time heurefin - Client client - int ancienpoids
	 * @author AmauryMechin
	 */
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", libelle=" + libelle + ", poids=" + poids + ", heuredebut="
				+ heuredebut + ", heurefin=" + heurefin + ", Client=" + Client + "]";
	}

}
