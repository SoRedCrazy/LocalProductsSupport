package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @generated Cette classe va servir a gerer entierement les objets entreprise,
 *            qui representeron les entreprise des producteur, et donc les
 *            utilisateur du logiciel.
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
	 * @param siret        -Integer
	 * @param numeroDeRue  -Integer
	 * @param rue          -String
	 * @param codePostal   -Integer
	 * @param ville        -String
	 * @param pays         -String
	 * @param nom          -String
	 * @param prenom       -String
	 * @param numTelephone -Integer
	 * @param mdp-String
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
		this.tournee = new ArrayList<Tournee>();
		this.vehicule = new ArrayList<Vehicule>();

	}

	/**
	 * permet d'avoir le mots de passe
	 * 
	 * @return string
	 */

	public String getMdp() {
		return mdp;
	}

	/**
	 * permet de modifier le mots de passe
	 * 
	 * @param String- mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @generated Permet d'obtenir la valeur du siret.
	 * @return siret -Integer
	 */
	public String getSiret() {
		return this.siret;
	}

	/**
	 * @generated Permet de modifier la valeur du siret.
	 * @param siret -Integer
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/**
	 * @generated Permet d'obtenir le numero de rue.
	 * @return numeroDeRue -Integer
	 */
	public Integer getNumeroDeRue() {
		return this.numeroDeRue;
	}

	/**
	 * @generated Permet de modifier le numero de rue.
	 * @param numeroDeRue -Integer
	 */
	public void setNumeroDeRue(Integer numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	/**
	 * @generated Permet d'obtenir le nom de la rue.
	 * @return rue -String
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * @generated Permet de modifier le nom de rue.
	 * @param rue -String
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @generated Permet d'obtenir le code postal
	 * @return codePostal -Integer
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * @generated Permet de modifier le code postal
	 * @param codePostal -Integer
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @generated Permet d'obtenir le nom de la ville
	 * @return ville -String
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * @generated Permet de modifier la ville
	 * @param ville -String
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @generated Permet d'obtenir le pays
	 * @return pays -String
	 */
	public String getPays() {
		return this.pays;
	}

	/**
	 * @generated Permet de modifier le pays
	 * @param pays -String
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @generated Permet d'obtenir le nom du proprietaire
	 * @return nom -String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @generated Permet de modifier le nom du proprietaire
	 * @param nom -String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @generated Permet d'obtenir le prenom du propretaire
	 * @return prenom -String
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * @generated Permet de modifier le prenom du proprietaire
	 * @param prenom -String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @generated Permet d'obtenir le numero de telephone
	 * @return numTelephone -Integer
	 */
	public String getNumTelephone() {
		return this.numTelephone;
	}

	/**
	 * @generated Permet de modifier le numero de telephone
	 * @param Integer
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	/**
	 * @generated Permet d'obtenir une tournee
	 * @return tournee -Tournee
	 */
	public ArrayList<Tournee> getTournee() {
		return this.tournee;
	}

	/**
	 * @generated Permet de modifier une tournee
	 * @param tournee -Tournee
	 */
	public void setTournee(ArrayList<Tournee> tournee) {
		this.tournee = tournee;
	}

	/**
	 * @generated Permet d'obtenir un vehicule
	 * @return vehicule -Vehicule
	 */
	public ArrayList<Vehicule> getVehicule() {
		return this.vehicule;
	}

	/**
	 * @generated Permet de modifier un Vehicule
	 * @param vehicule -Vehicule
	 */
	/**
	 * @param vehicule
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule.add(vehicule);
	}

	@Override
	public String toString() {
		return "Entreprise [siret=" + siret + ", numeroDeRue=" + numeroDeRue + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", pays=" + pays + ", nom=" + nom + ", prenom=" + prenom
				+ ", numTelephone=" + numTelephone + ", vehicule=" + vehicule + ", tournee=" + tournee + ", mdp=" + mdp
				+ "]";
	}

	// Operations

	/**
	 * @generated Ajoute un vehicule a la liste de vehicules de l'entreprise
	 * @param Vehicule
	 * @return
	 * @return
	 * @author François Bardel
	 */
	public boolean ajouterVehicule(String immatriculation, int poidmax, String siret) {
		Vehicule ve = d.ajouterVehicule(immatriculation, poidmax, siret);
		if (ve != null) {
			vehicule.add(ve);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @generated Supprime un vehicule de la liste de vehicule de l'entreprise
	 * @param Vehicule
	 * @return
	 * @return
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
	 * @generated Ajoute une tournee a la liste de tournee de l'entreprise
	 * @param Tournee
	 * @return
	 * @return
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
	 * @generated Modifie les information d'une tournee
	 * @param Tournee
	 * @return
	 */
	public void modifierTournee(Date date, Time horaireDebut, Time horaireFin, Vehicule vehicule, Tournee t) {
		t.setDate(date);
		t.setHoraireDebut(horaireDebut);
		t.setHoraireFin(horaireFin);
		t.setVehicule(vehicule);
	}

	/**
	 * @generated Supprime une tournee de la liste de tournee de l'entreprise
	 * @param Tournee
	 * @return
	 * @return
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

	/**
	 * @generated Permet d'ajouter une commande a une tournee
	 * @param Tournee
	 * @param Commande
	 * @return
	 * @author François Bardel
	 */
	public void ajouterCommandeTournee(String libelle, Integer poids, Time Heuredebut, Time Heurefin, Client client,
			String siret, Tournee tournee) {
		Commande co = d.ajouterCommandeTournee(libelle, poids, Heuredebut, Heurefin, client, siret, tournee);
		if (co != null) {
			ArrayList listCo = tournee.getListCommande();
			listCo.add(co);
			tournee.setListCommande(listCo);
			tournee.setPoids(tournee.getPoids() + poids);
		}

	}

	/**
	 * @generated Permet de supprimer une commande d'une tournee
	 * @param Tournee
	 * @param Commande
	 * @return
	 * @author François Bardel
	 * @return
	 */
	public boolean supprimerCommandeTournee(Tournee t, Commande c) {
		if (t.getListCommande().contains(c)) {
			d.supprimerCommandeTournee(c);
			if (d.supprimerCommandeTournee(c) == true) {
				ArrayList listco = t.getListCommande();
				listco.remove(c);
				t.setListCommande(listco);
				t.setPoids(t.getPoids() - c.getPoids());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * @generated Permet a l'utilisateur de se connecter
	 * @param String
	 * @param String
	 * @author François Bardel
	 * @return
	 */
	public void connexion(String usr, String password) {
		// TODO
	}

}
