package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Tournee {

	private Integer idTournee;
	private Date date;
	private Time horaireDebut;
	private Time horaireFin;
	private ArrayList<Commande> listCommande;
	private Vehicule vehicule;
	private int poids;

	public Tournee(Integer idTournee, Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule) {
		super();
		this.idTournee = idTournee;
		this.date = date;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
		this.listCommande = new ArrayList<Commande>();
		this.vehicule = vehicule;
		this.poids = 0;
	}

	/**
	 * Permet de récupérer l'id de la tournée.
	 * 
	 * @return idTournee
	 */
	public Integer getIdTournee() {
		return this.idTournee;
	}

	/**
	 * Permet de définir l'id de la tournée.
	 * 
	 * @param idTournee
	 */
	public void setIdTournee(Integer idTournee) {
		this.idTournee = idTournee;
	}

	/**
	 * Permet de récupérer la date de la tournée.
	 * 
	 * @return date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Permet de définir la date de la tournée.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Permet de récupérer l'horaire de début de la tournée.
	 * 
	 * @return horaireDebut
	 */
	public Time getHoraireDebut() {
		return this.horaireDebut;
	}

	/**
	 * Permet de définir l'horaire de début de la tournée.
	 * 
	 * @param horaireDebut
	 */
	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	/**
	 * Permet de récupérer l'horaire de fin de la tournée.
	 * 
	 * @return horaireFin
	 */
	public Time getHoraireFin() {
		return this.horaireFin;
	}

	/**
	 * Permet de définir l'horaire de fin de la tournée.
	 * 
	 * @param horaireFin
	 */
	public void setHoraireFin(Time horaireFin) {
		this.horaireFin = horaireFin;
	}

	/**
	 * Permet de récupérer la liste des commandes d'une tournée.
	 * 
	 * @return listCommande
	 */
	public ArrayList getListCommande() {
		return this.listCommande;
	}

	/**
	 * Permet de récupérer la liste des commandes d'une tournée.
	 * 
	 * @param listCommande
	 */
	public void setListCommande(ArrayList listCommande) {
		this.listCommande = listCommande;
	}

	/**
	 * Permet de récupérer le véhicule associé à la tournée.
	 * 
	 * @return vehicule
	 */
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de définir le véhicule associé à la tournée
	 * 
	 * @param vehicule
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	// Operations

	/**
	 * ?
	 */
	public void itineraire() {
		// TODO
	}

	/**
	 * permet de recuperer le poids de la tournee
	 * 
	 * @return int poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * permet de sette le poid
	 * 
	 * @param poids
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * Permet l'ajout d'une commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 */
	public void addCommande(Commande commande) {

	}

	/**
	 * Permet de supprimer une commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 */
	public void delCommande(Commande commande) {

	}

	/**
	 * Permet de modifier uen commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 */
	public void modifCommande(Commande commande) {

	}

}
