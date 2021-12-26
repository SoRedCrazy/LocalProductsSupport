package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Permet de cr�e une tourn�e puis de lui ajouter/retirer des commande ou
 * modifier
 * 
 * @author JulienBoisgard
 *
 */
public class Tournee {

	private Integer idTournee;
	private Date date;
	private Time horaireDebut;
	private Time horaireFin;
	private ArrayList<Commande> listCommande;
	private Vehicule vehicule;
	private Integer poids;
	DAO d = new DAO();

	/**
	 * Constructeur pour cr�er une tourn�e
	 * 
	 * @param idTournee
	 * @param date
	 * @param horaireDebut
	 * @param horaireFin
	 * @param vehicule
	 * @author AmauryMechin
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
	 * @author AmauryMechin
	 */
	public Integer getIdTournee() {
		return this.idTournee;
	}

	/**
	 * Permet de d�finir l'id de la tourn�e.
	 * 
	 * @param idTournee
	 * @author AmauryMechin
	 */
	public void setIdTournee(Integer idTournee) {
		this.idTournee = idTournee;
	}

	/**
	 * Permet de r�cup�rer la date de la tourn�e.
	 * 
	 * @return date
	 * @author AmauryMechin
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Permet de d�finir la date de la tourn�e.
	 * 
	 * @param date
	 * @author AmauryMechin
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Permet de r�cup�rer l'horaire de d�but de la tourn�e.
	 * 
	 * @return horaireDebut
	 * @author AmauryMechin
	 */
	public Time getHoraireDebut() {
		return this.horaireDebut;
	}

	/**
	 * Permet de d�finir l'horaire de d�but de la tourn�e.
	 * 
	 * @param horaireDebut
	 * @author AmauryMechin
	 */
	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	/**
	 * Permet de r�cup�rer l'horaire de fin de la tourn�e.
	 * 
	 * @return horaireFin
	 * @author AmauryMechin
	 */
	public Time getHoraireFin() {
		return this.horaireFin;
	}

	/**
	 * Permet de d�finir l'horaire de fin de la tourn�e.
	 * 
	 * @param horaireFin
	 * @author AmauryMechin
	 */
	public void setHoraireFin(Time horaireFin) {
		this.horaireFin = horaireFin;
	}

	/**
	 * Permet de r�cup�rer la liste des commandes d'une tourn�e.
	 * 
	 * @return listCommande
	 * @author AmauryMechin
	 */
	public ArrayList<Commande> getListCommande() {
		return this.listCommande;
	}

	/**
	 * Permet de r�cup�rer la liste des commandes d'une tourn�e.
	 * 
	 * @param listCommande
	 * @author AmauryMechin
	 */
	public void setListCommande(ArrayList<Commande> listCommande) {
		this.listCommande = listCommande;
	}

	/**
	 * Permet de r�cup�rer le v�hicule associ� � la tourn�e.
	 * 
	 * @return vehicule
	 * @author AmauryMechin
	 */
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de d�finir le v�hicule associ� � la tourn�e
	 * 
	 * @param vehicule
	 * @author AmauryMechin
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * Permet de recuperer le poids de la tournee.
	 * 
	 * @return int poids
	 * @author AmauryMechin
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * permet de set le poid
	 * 
	 * @param poids
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * permet de retourner les informations sur la tourn�e.
	 * 
	 * @return integer idTournee - Date date - Time horaireDebut - Time horaireFin -
	 *         ArrayList<Commande> listCommande - Vehicule vehicule - int poids
	 * @author AmauryMechin
	 */
	@Override
	public String toString() {
		return "Tournee [idTournee=" + idTournee + ", date=" + date + ", horaireDebut=" + horaireDebut + ", horaireFin="
				+ horaireFin + ", listCommande=" + listCommande + ", vehicule=" + vehicule + ", poids=" + poids + "]";
	}

	/**
	 * ?
	 */
	public void itineraire() {
		// TODO
	}

	/**
	 * Permet l'ajout d'une commande dans une tournee et retourne un boolean
	 * 
	 * @param libelle
	 * @param poids
	 * @param Heuredebut
	 * @param Heurefin
	 * @param client
	 * @param siret
	 * @param tournee
	 * @see ajouterCommandeTournee -DAO
	 * @author AmauryMechin
	 */
	public boolean addCommande(String libelle, Integer poids, Time Heuredebut, Time Heurefin, Client client,
			String siret) {
		Commande co = d.ajouterCommandeTournee(libelle, poids, Heuredebut, Heurefin, client, siret, this.idTournee);
		if (co != null) {
			this.getListCommande().add(co);
			this.setPoids(this.getPoids() + poids);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Permet de supprimer une commande d'une tournee, en verifiant qu'elle etait
	 * bien dans la liste de commande, et en verrifiant que le changement se fait
	 * bien dans la base de donn�e. De plus, le poids de la tournee se met a jour.
	 * 
	 * @param tournee  -Tournee
	 * @param commande -Commande
	 * @see supprimerCommandeTournee -DAO
	 * @author AmauryMechin
	 */
	public boolean delCommande(Commande commande) {
		if (this.getListCommande().contains(commande)) {
			boolean b = d.supprimerCommandeTournee(commande);
			if (b) {
				this.getListCommande().remove(commande);
				this.setPoids(this.getPoids() - commande.getPoids());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Permet de modifier uen commande de la liste des commandes de la tourn�e.
	 * 
	 * @param commande   -Commande
	 * @param libelle    -String
	 * @param poids      -Integer
	 * @param heuredebut -Time
	 * @param heurefin   -Time
	 * @author AmauryMechin
	 */
	public boolean modifCommande(Commande commande, String libelle, Integer poids, Time heuredebut, Time heurefin) {
		commande.setLibelle(libelle);
		commande.setPoids(poids);
		commande.setheuredebut(heuredebut);
		commande.setheurefin(heurefin);
		boolean b = d.modifCommande(commande);
		if (b) {
			this.setPoids(this.getPoids() - commande.getAncienpoids() + commande.getPoids());
			return true;
		} else {
			return false;
		}
	}
}
