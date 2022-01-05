package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Permet de cr�e une tourn�e puis de lui ajouter/retirer des commandes ou de la
 * modifier.
 * 
 * @author Boisgard Julien
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
	 * Constructeur pour cr�er une tourn�e.
	 * 
	 * @param idTournee    -Integer
	 * @param date         -Date
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @param vehicule     -Vehicule
	 * 
	 * @author Mechin Amaury
	 */

	public Tournee(Integer idTournee, Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule) {
		this.idTournee = idTournee;
		this.date = date;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
		this.listCommande = d.listCommande(this.idTournee);
		this.vehicule = vehicule;
		this.poids = 0;
	}

	/**
	 * Permet de r�cup�rer l'id de la tourn�e.
	 * 
	 * @return idTournee -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getIdTournee() {
		return this.idTournee;
	}

	/**
	 * Permet de d�finir l'id de la tourn�e.
	 * 
	 * @param idTournee -Integer
	 *
	 * @author Mechin Amaury
	 */
	public void setIdTournee(Integer idTournee) {
		this.idTournee = idTournee;
	}

	/**
	 * Permet de r�cup�rer la date de la tourn�e.
	 * 
	 * @return date -Date
	 * 
	 * @author Mechin Amaury
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Permet de d�finir la date de la tourn�e.
	 * 
	 * @param date -Date
	 * 
	 * @author Mechin Amaury
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Permet de r�cup�rer l'horaire de d�but de la tourn�e.
	 * 
	 * @return horaireDebut -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHoraireDebut() {
		return this.horaireDebut;
	}

	/**
	 * Permet de d�finir l'horaire de d�but de la tourn�e.
	 * 
	 * @param horaireDebut -Time
	 * @author Mechin Amaury
	 */
	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	/**
	 * Permet de r�cup�rer l'horaire de fin de la tourn�e.
	 * 
	 * @return horaireFin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public Time getHoraireFin() {
		return this.horaireFin;
	}

	/**
	 * Permet de d�finir l'horaire de fin de la tourn�e.
	 * 
	 * @param horaireFin -Time
	 * 
	 * @author Mechin Amaury
	 */
	public void setHoraireFin(Time horaireFin) {
		this.horaireFin = horaireFin;
	}

	/**
	 * Permet de r�cup�rer la liste des commandes d'une tourn�e.
	 * 
	 * @return listCommande -ArrayList<Commande>
	 * 
	 * @author Mechin Amaury
	 */
	public ArrayList<Commande> getListCommande() {
		return this.listCommande;
	}

	/**
	 * Permet de d�finir la liste des commandes d'une tourn�e.
	 * 
	 * @param listCommande -ArrayList<Commande>
	 * 
	 * @author Mechin Amaury
	 */
	public void setListCommande(ArrayList<Commande> listCommande) {
		this.listCommande = listCommande;
	}

	/**
	 * Permet de r�cup�rer le v�hicule associ� � la tourn�e.
	 * 
	 * @return vehicule -Vehicule
	 * 
	 * @author Mechin Amaury
	 */
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de d�finir le v�hicule associ� � la tourn�e
	 * 
	 * @param vehicule -Vehicule
	 * 
	 * @author Mechin Amaury
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * Permet de r�cup�rer le poids de la tourn�e.
	 * 
	 * @return poids -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * Permet de d�finir le poid de la tourn�e.
	 * 
	 * @param poids -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * Permet de retourner toutes les informations sur la tourn�e.
	 * 
	 * @return idTournee -integer
	 * @return date -Date
	 * @return horaireDebut -Time
	 * @return horaireFin -Time
	 * @return listCommande -ArrayList<Commande>
	 * @return vehicule -Vehicule
	 * @return poids -Integer
	 *
	 * @author Mechin Amaury
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
	 * Permet l'ajout d'une commande dans une tournee si elle n'existe pas d�j� et
	 * retourne un boolean.
	 * 
	 * @param libelle      -String
	 * @param poids        -Integer
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @param client       -Client
	 * @param siret        -String
	 * @param tournee      -Tournee
	 * @see ajouterCommandeTournee() -DAO
	 * 
	 * @author Mechin Amaury
	 */
	public boolean addCommande(String libelle, Integer poids, Time horaireDebut, Time horaireFin, Client client,
			String siret) {
		Commande co = d.ajouterCommandeTournee(libelle, poids, horaireDebut, horaireFin, client, siret, this.idTournee);
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
	 * @param commande -Commande
	 * @see supprimerCommandeTournee() -DAO
	 * 
	 * @author Mechin Amaury
	 */
	public boolean delCommande(Commande commande) {
		boolean b = d.supprimerCommandeTournee(commande);
		if (b) {
			this.getListCommande().remove(commande);
			this.setPoids(this.getPoids() - commande.getPoids());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Permet de modifier uen commande de la liste des commandes de la tourn�e.
	 * 
	 * @param commande     -Commande
	 * @param libelle      -String
	 * @param poids        -Integer
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @see modifCommande() -DAO
	 * 
	 * @author Mechin Amaury
	 */
	public boolean modifCommande(Commande commande, String libelle, Integer poids, Time horaireDebut, Time horaireFin) {
		commande.setLibelle(libelle);
		commande.setPoids(poids);
		commande.setheuredebut(horaireDebut);
		commande.setheurefin(horaireFin);
		boolean b = d.modifCommande(commande);
		if (b) {
			this.setPoids(this.getPoids() - commande.getAncienpoids() + commande.getPoids());
			return true;
		} else {
			return false;
		}
	}
}
