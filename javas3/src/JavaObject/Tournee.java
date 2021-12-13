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
	 * Constructeur pour cr�er une tourn�e
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
	 * Permet de r�cup�rer l'id de la tourn�e.
	 * 
	 * @return idTournee
	 * @author amaurymechin
	 */
	public Integer getIdTournee() {
		return this.idTournee;
	}

	/**
	 * Permet de d�finir l'id de la tourn�e.
	 * 
	 * @param idTournee
	 * @author amaurymechin
	 */
	public void setIdTournee(Integer idTournee) {
		this.idTournee = idTournee;
	}

	/**
	 * Permet de r�cup�rer la date de la tourn�e.
	 * 
	 * @return date
	 * @author amaurymechin
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Permet de d�finir la date de la tourn�e.
	 * 
	 * @param date
	 * @author amaurymechin
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Permet de r�cup�rer l'horaire de d�but de la tourn�e.
	 * 
	 * @return horaireDebut
	 * @author amaurymechin
	 */
	public Time getHoraireDebut() {
		return this.horaireDebut;
	}

	/**
	 * Permet de d�finir l'horaire de d�but de la tourn�e.
	 * 
	 * @param horaireDebut
	 * @author amaurymechin
	 */
	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	/**
	 * Permet de r�cup�rer l'horaire de fin de la tourn�e.
	 * 
	 * @return horaireFin
	 * @author amaurymechin
	 */
	public Time getHoraireFin() {
		return this.horaireFin;
	}

	/**
	 * Permet de d�finir l'horaire de fin de la tourn�e.
	 * 
	 * @param horaireFin
	 * @author amaurymechin
	 */
	public void setHoraireFin(Time horaireFin) {
		this.horaireFin = horaireFin;
	}

	/**
	 * Permet de r�cup�rer la liste des commandes d'une tourn�e.
	 * 
	 * @return listCommande
	 * @author amaurymechin
	 */
	public ArrayList getListCommande() {
		return this.listCommande;
	}

	/**
	 * Permet de r�cup�rer la liste des commandes d'une tourn�e.
	 * 
	 * @param listCommande
	 * @author amaurymechin
	 */
	public void setListCommande(ArrayList listCommande) {
		this.listCommande = listCommande;
	}

	/**
	 * Permet de r�cup�rer le v�hicule associ� � la tourn�e.
	 * 
	 * @return vehicule
	 * @author amaurymechin
	 */
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de d�finir le v�hicule associ� � la tourn�e
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
	 * Permet l'ajout d'une commande de la liste des commandes de la tourn�e.
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
	 * Permet de supprimer une commande de la liste des commandes de la tourn�e.
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
	 * Permet de modifier uen commande de la liste des commandes de la tourn�e.
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
