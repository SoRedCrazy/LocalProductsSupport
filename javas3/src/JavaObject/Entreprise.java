package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Cette classe va servir à gerer entierement les objets entreprise, qui
 * representeron les entreprises des producteurs, et donc les utilisateurs du
 * logiciel.
 * 
 * @author Bardel François
 */
public class Entreprise {

	private String siret;
	private Integer numeroDeRue;
	private String rue;
	private Integer codePostal;
	private String ville;
	private String pays;
	private String nom;
	private String prenom;
	private String numTelephone;
	private ArrayList<Vehicule> vehicule;
	private ArrayList<Tournee> tournee;
	private String mdp;
	DAO d = new DAO();

	/**
	 * CONSTRUCTEUR Permet de creer une entreprise, seul un admin peut le faire.
	 * 
	 * @param siret        -String
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param nom          -String
	 * @param prenom       -String
	 * @param numTelephone -String
	 * @param mdp          -String
	 * 
	 * @author Bardel François
	 */
	public Entreprise(String siret, Integer numeroDeRue, String rue, Integer codePostal, String ville, String pays,
			String nom, String prenom, String numTelephone, String mdp) {
		this.siret = siret;
		this.numeroDeRue = numeroDeRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.nom = nom;
		this.prenom = prenom;
		this.numTelephone = numTelephone;
		this.mdp = mdp;
		this.tournee = d.listTourneeentreprise(siret);
		this.vehicule = d.listVehiculeEntreprise(siret);

	}

	/**
	 * Permet d'avoir le mot de passe.
	 * 
	 * @return mdp -String
	 * 
	 * @author Bardel François
	 */

	public String getMdp() {
		return mdp;
	}

	/**
	 * Permet de modifier le mot de passe.
	 * 
	 * @param mdp -String
	 * 
	 * @author Bardel François
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Permet d'obtenir la valeur du siret.
	 * 
	 * @return siret -String
	 * 
	 * @author Bardel François
	 */
	public String getSiret() {
		return this.siret;
	}

	/**
	 * Permet de modifier la valeur du siret.
	 * 
	 * @param siret -String
	 * 
	 * @author Bardel François
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/**
	 * Permet d'obtenir le numero de rue.
	 * 
	 * @return numeroDeRue -Integer
	 * 
	 * @author Bardel François
	 */
	public Integer getNumeroDeRue() {
		return this.numeroDeRue;
	}

	/**
	 * Permet de modifier le numero de rue.
	 * 
	 * @param numeroDeRue -Integer
	 * 
	 * @author Bardel François
	 */
	public void setNumeroDeRue(Integer numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	/**
	 * Permet d'obtenir le nom de la rue.
	 * 
	 * @return rue -String
	 * 
	 * @author Bardel François
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * Permet de modifier le nom de rue.
	 * 
	 * @param rue -String
	 * 
	 * @author Bardel François
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Permet d'obtenir le code postal.
	 * 
	 * @return codePostal -Integer
	 * 
	 * @author Bardel François
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Permet de modifier le code postal.
	 * 
	 * @param codePostal -Integer
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Permet d'obtenir le nom de la ville.
	 * 
	 * @return ville -String
	 * 
	 * @author Bardel François
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Permet de modifier la ville.
	 * 
	 * @param ville -String
	 * 
	 * @author Bardel François
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Permet d'obtenir le pays.
	 * 
	 * @return pays -String
	 * 
	 * @author Bardel François
	 */
	public String getPays() {
		return this.pays;
	}

	/**
	 * Permet de modifier le pays.
	 * 
	 * @param pays -String
	 * 
	 * @author Bardel François
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Permet d'obtenir le nom du proprietaire.
	 * 
	 * @return nom -String
	 * 
	 * @author Bardel François
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet de modifier le nom du proprietaire.
	 * 
	 * @param nom -String
	 * 
	 * @author Bardel François
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet d'obtenir le prenom du propretaire.
	 * 
	 * @return prenom -String
	 * 
	 * @author Bardel François
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Permet de modifier le prenom du proprietaire.
	 * 
	 * @param prenom -String
	 * 
	 * @author Bardel François
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet d'obtenir le numero de telephone.
	 * 
	 * @return numTelephone -Integer
	 * 
	 * @author Bardel François
	 */
	public String getNumTelephone() {
		return this.numTelephone;
	}

	/**
	 * Permet de modifier le numero de telephone.
	 * 
	 * @param numTelephone -Integer
	 * 
	 * @author Bardel François
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	/**
	 * Permet d'obtenir la liste des tournees.
	 * 
	 * @return tournee -ArrayList<Tournee>.
	 * 
	 * @author Bardel François
	 */
	public ArrayList<Tournee> getTournee() {
		return this.tournee;
	}

	/**
	 * Permet de modifier une tournee.
	 * 
	 * @param tournee -ArrayList<Tournee>
	 * 
	 * @author Bardel François
	 */
	public void setTournee(ArrayList<Tournee> tournee) {
		this.tournee = tournee;
	}

	/**
	 * Permet d'obtenir la liste des vehicules.
	 * 
	 * @return vehicule -ArrayList<Vehicule>
	 * 
	 * @author Bardel François
	 */
	public ArrayList<Vehicule> getVehicule() {
		return this.vehicule;
	}

	/**
	 * Permet de modifier un vehicule.
	 * 
	 * @param vehicule -Vehicule
	 * 
	 * @author Bardel François
	 */
	public void setVehicule(ArrayList<Vehicule> vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * Permet de retourner toutes les informations de l'entreprise.
	 * 
	 * @author Bardel François
	 */
	@Override
	public String toString() {
		return "Entreprise [siret=" + siret + ", numeroDeRue=" + numeroDeRue + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", pays=" + pays + ", nom=" + nom + ", prenom=" + prenom
				+ ", numTelephone=" + numTelephone + ", vehicule=" + vehicule + ", tournee=" + tournee + ", mdp=" + mdp
				+ "]";
	}

	// Operations

	/**
	 * Ajoute un vehicule à la liste des vehicules de l'entreprise, et verifie qu'il
	 * a bien été ajouté dans la base de donnée.
	 * 
	 * @param immatriculation -String
	 * @param poidmax         -Int
	 * @return boolean
	 * 
	 * @author François Bardel
	 */
	public boolean ajouterVehicule(String immatriculation, int poidmax) {
		Vehicule ve = d.ajouterVehicule(immatriculation, poidmax, this.siret);
		if (ve != null) {
			vehicule.add(ve);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Supprime un vehicule de la liste de vehicule de l'entreprise, et verifie
	 * qu'il a bien été supprimer de la base de donnée.
	 * 
	 * @param v -Vehicule
	 * @return boolean
	 * 
	 * @author François Bardel
	 */
	public boolean supprimerVehicule(Vehicule v) {
		if (vehicule.contains(v)) {
			d.supprimerVehicule(v);
			if (d.supprimerVehicule(v) == true) {
				vehicule.remove(v);
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	/**
	 * Ajoute une tournée, à la liste de tournee de l'entreprise, et verifie qu'elle
	 * est bien dans la base de donnée.
	 * 
	 * @param date         -Date
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @param vehicule     -Vehicule
	 * @return boolean
	 * 
	 * @author François Bardel
	 */
	public boolean ajouterTournee(Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule) {
		Tournee to = d.ajouterTournee(date, horaireDebut, horaireFin, vehicule);
		if (to != null) {
			tournee.add(to);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Modifie les informations d'une tournee grace aux setters de la classe
	 * Tournee.
	 * 
	 * @param date         -Date
	 * @param horaireDebut -Time
	 * @param horaireFin   -Time
	 * @param t            -Tournee
	 * @return boolean
	 * 
	 * @author François Bardel
	 */
	public boolean modifierTournee(Date date, Time horaireDebut, Time horaireFin, Tournee t) {
		t.setDate(date);
		t.setHoraireDebut(horaireDebut);
		t.setHoraireFin(horaireFin);
		boolean b = d.modifTournee(t);
		if (b) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Supprime une tournee de la liste de tournee de l'entreprise, et verifie sa
	 * suppression dans la base de donnée.
	 * 
	 * @param t -Tournee
	 * @return boolean
	 * 
	 * @author François Bardel
	 */
	public boolean supprimerTournee(Tournee t) {
		if (tournee.contains(t)) {
			d.supprimerTournee(t);
			if (d.supprimerTournee(t) == true) {
				tournee.remove(t);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
