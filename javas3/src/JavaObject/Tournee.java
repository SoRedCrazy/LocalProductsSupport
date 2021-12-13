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
	DAO d = new DAO();

	/**
	 * Constructeur pour créer une tournée
	 * 
	 * @param idTournee
	 * @param date
	 * @param horaireDebut
	 * @param horaireFin
	 * @param vehicule
	 */
	
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
	 * @author amaurymechin
	 */
	public Integer getIdTournee() {
		return this.idTournee;
	}

	/**
	 * Permet de définir l'id de la tournée.
	 * 
	 * @param idTournee
	 * @author amaurymechin
	 */
	public void setIdTournee(Integer idTournee) {
		this.idTournee = idTournee;
	}

	/**
	 * Permet de récupérer la date de la tournée.
	 * 
	 * @return date
	 * @author amaurymechin
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Permet de définir la date de la tournée.
	 * 
	 * @param date
	 * @author amaurymechin
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Permet de récupérer l'horaire de début de la tournée.
	 * 
	 * @return horaireDebut
	 * @author amaurymechin
	 */
	public Time getHoraireDebut() {
		return this.horaireDebut;
	}

	/**
	 * Permet de définir l'horaire de début de la tournée.
	 * 
	 * @param horaireDebut
	 * @author amaurymechin
	 */
	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	/**
	 * Permet de récupérer l'horaire de fin de la tournée.
	 * 
	 * @return horaireFin
	 * @author amaurymechin
	 */
	public Time getHoraireFin() {
		return this.horaireFin;
	}

	/**
	 * Permet de définir l'horaire de fin de la tournée.
	 * 
	 * @param horaireFin
	 * @author amaurymechin
	 */
	public void setHoraireFin(Time horaireFin) {
		this.horaireFin = horaireFin;
	}

	/**
	 * Permet de récupérer la liste des commandes d'une tournée.
	 * 
	 * @return listCommande
	 * @author amaurymechin
	 */
	public ArrayList getListCommande() {
		return this.listCommande;
	}

	/**
	 * Permet de récupérer la liste des commandes d'une tournée.
	 * 
	 * @param listCommande
	 * @author amaurymechin
	 */
	public void setListCommande(ArrayList listCommande) {
		this.listCommande = listCommande;
	}

	/**
	 * Permet de récupérer le véhicule associé à la tournée.
	 * 
	 * @return vehicule
	 * @author amaurymechin
	 */
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de définir le véhicule associé à la tournée
	 * 
	 * @param vehicule
	 * @author amaurymechin
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

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
	 * ?
	 */
	public void itineraire() {
		// TODO
	}

	/**
	 * Permet de recuperer le poids de la tournee
	 * 
	 * @return int poids
	 * @exception 
	 * @author amaurymechin
	 */

	/**
	 * Permet l'ajout d'une commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 * @exception
	 * @author amaurymechin
	 */
	public void addCommande(Commande commande) {
		try {
			listCommande.add(commande);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet de supprimer une commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 * @exception
	 * @author amaurymechin
	 */
	public void delCommande(Commande commande) {
		try {
			listCommande.remove(commande);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet de modifier uen commande de la liste des commandes de la tournée.
	 * 
	 * @param commande
	 * @exception
	 * @author amaurymechin
	 */
	public boolean modifCommande(Commande commande) {
		d.modifCommande(commande);
		if (d.modifCommande(commande) == true) {
			return true;
		} else {
			return false;
		}
	}
}
