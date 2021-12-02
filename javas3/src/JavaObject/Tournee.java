package JavaObject;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Tournee {
    
    private Integer idTournee;
    private Date date;
    private Time horaireDebut;
    private Time horaireFin;
    private ArrayList listCommande;
    private Vehicule vehicule;

    /**
    * Permet de r�cup�rer l'id de la tourn�e.
    * @return idTournee
    */
    private Integer getIdTournee() {
        return this.idTournee;
    }
    
    /**
    * Permet de d�finir l'id de la tourn�e.
    * @param idTournee
    */
    private void setIdTournee(Integer idTournee) {
        this.idTournee = idTournee;
    }
    
    /**
    * Permet de r�cup�rer la date de la tourn�e.
    * @return date
    */
    private Date getDate() {
        return this.date;
    }
    
    /**
    * Permet de d�finir la date de la tourn�e.
    * @param date
    */
    private void setDate(Date date) {
        this.date = date;
    }
    
    /**
    * Permet de r�cup�rer l'horaire de d�but de la tourn�e.
    * @return horaireDebut
    */
    private Time getHoraireDebut() {
        return this.horaireDebut;
    }
    
    /**
    * Permet de d�finir l'horaire de d�but de la tourn�e.
    * @param horaireDebut
    */
    private void setHoraireDebut(Time horaireDebut) {
        this.horaireDebut = horaireDebut;
    }
    
    /**
    * Permet de r�cup�rer l'horaire de fin de la tourn�e.
    * @return horaireFin
    */
    private Time getHoraireFin() {
        return this.horaireFin;
    }
    
    /**
    * Permet de d�finir l'horaire de fin de la tourn�e.
    * @param horaireFin
    */
    private void setHoraireFin(Time horaireFin) {
        this.horaireFin = horaireFin;
    }
    
    /**
    * Permet de r�cup�rer la liste des commandes d'une tourn�e.
    * @return listCommande
    */
    private ArrayList getListCommande() {
        return this.listCommande;
    }
    
    /**
    * Permet de r�cup�rer la liste des commandes d'une tourn�e.
    * @param listCommande
    */
    private void setListCommande(ArrayList listCommande) {
        this.listCommande = listCommande;
    }
    
    /**
    * Permet de r�cup�rer le v�hicule associ� � la tourn�e.
    * @return vehicule
    */
    private Vehicule getVehicule() {
        return this.vehicule;
    }
    
    /**
    * Permet de d�finir le v�hicule associ� � la tourn�e
    * @param vehicule
    */
    private void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    //                          Operations                                  
    
    /**
    * ?
    */
    public void itineraire() {
        //TODO
    }
    /**
    * Permet l'ajout d'une commande de la liste des commandes de la tourn�e.
    * @param commande
    */
    public void addCommande(Commande commande) {
    	
    }
    /**
    * Permet de supprimer une commande de la liste des commandes de la tourn�e.
    * @param commande
    */
    public void delCommande(Commande commande) {
    	
    }
    /**
    * Permet de modifier uen commande de la liste des commandes de la tourn�e.
    * @param commande
    */
    public void modifCommande(Commande commande) {
    	
    }
    
}
