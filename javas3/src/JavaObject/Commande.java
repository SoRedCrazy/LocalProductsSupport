package JavaObject;

import java.sql.Time;

/**
 * Cette classe permet de gerer les objets commande, elle ne contient que le
 * constructeur de l'objet, ainsi que les getters et setters.
 * 
 * @author Mechin Amaury
 */

public class Commande implements Comparable<Commande> {

	private Integer idCommande;
	private String libelle;
	private Integer poids;
	private Time heuredebut;
	private Time heurefin;
	private Client client;
	private int ancienpoids;

	/**
	 * Constructeur permet de cr�er une commande.
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
		this.client = client;
	}

	/**
	 * Permet de r�cup�rer l'id de la commande.
	 * 
	 * @return idCommande -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getIdCommande() {
		return this.idCommande;
	}

	/**
	 * Permet de d�finir l'id de la commande.
	 * 
	 * @param idCommande -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * Permet de r�cup�rer le lib�ll� de la commande.
	 * 
	 * @return libelle -String
	 * 
	 * @author Mechin Amaury
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Permet de d�finir le libelle de la commande.
	 * 
	 * @param libelle -String
	 * 
	 * @author Mechin Amaury
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Permet de r�cup�rer le poids de la commande.
	 * 
	 * @return poids -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getPoids() {
		return this.poids;
	}

	/**
	 * Permet de d�finir le poids de la commande.
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
	 * Permet d'avoir l'ancien poids utiles � la base de donnee.
	 * 
	 * @param poids -int
	 * 
	 * @author Mechin Amaury
	 */
	public int getAncienpoids() {
		return ancienpoids;
	}

	/**
	 * Permet de r�cup�rer la date de la commande.
	 * 
	 * @return heuredebut -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHeuredebut() {
		return this.heuredebut;
	}

	/**
	 * Permet de d�finir la date de la commande.
	 * 
	 * @param heuredebut -Time
	 * 
	 * @author Mechin Amaury
	 */
	public void setheuredebut(Time heuredebut) {
		this.heuredebut = heuredebut;
	}

	/**
	 * Permet de r�cup�rer la date limite de la commande.
	 * 
	 * @return heurefin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHeureFin() {
		return this.heurefin;
	}

	/**
	 * Permet de d�finir la date limite de la commande.
	 * 
	 * @param heurefin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public void setheurefin(Time heurefin) {
		this.heurefin = heurefin;
	}

	/**
	 * Permet de r�cup�rer le client qui passe la commande.
	 * 
	 * @return client -Client
	 * 
	 * @author Mechin Amaury
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 * Permet de d�finir le client qui passe la commande.
	 * 
	 * @param client -Client
	 * 
	 * @author Mechin Amaury
	 */
	public void setClient(Client Client) {
		this.client = Client;
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
				+ heuredebut + ", heurefin=" + heurefin + ", Client=" + client + "]";
	}

	@Override
	public int compareTo(Commande c) {
		return this.poids.compareTo(c.getPoids());
	}

}
