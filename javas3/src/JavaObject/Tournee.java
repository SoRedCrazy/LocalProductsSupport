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
    * Permet de récupérer l'id de la tournée.
    * @return idTournee
    */
    private Integer getIdTournee() {
        return this.idTournee;
    }
    
    /**
    * Permet de définir l'id de la tournée.
    * @param idTournee
    */
    private void setIdTournee(Integer idTournee) {
        this.idTournee = idTournee;
    }
    
    /**
    * Permet de récupérer la date de la tournée.
    * @return date
    */
    private Date getDate() {
        return this.date;
    }
    
    /**
    * Permet de définir la date de la tournée.
    * @param date
    */
    private void setDate(Date date) {
        this.date = date;
    }
    
    /**
    * Permet de récupérer l'horaire de début de la tournée.
    * @return horaireDebut
    */
    private Time getHoraireDebut() {
        return this.horaireDebut;
    }
    
    /**
    * Permet de définir l'horaire de début de la tournée.
    * @param horaireDebut
    */
    private void setHoraireDebut(Time horaireDebut) {
        this.horaireDebut = horaireDebut;
    }
    
    /**
    * Permet de récupérer l'horaire de fin de la tournée.
    * @return horaireFin
    */
    private Time getHoraireFin() {
        return this.horaireFin;
    }
    
    /**
    * Permet de définir l'horaire de fin de la tournée.
    * @param horaireFin
    */
    private void setHoraireFin(Time horaireFin) {
        this.horaireFin = horaireFin;
    }
    
    /**
    * Permet de récupérer la liste des commandes d'une tournée.
    * @return listCommande
    */
    private ArrayList getListCommande() {
        return this.listCommande;
    }
    
    /**
    * Permet de récupérer la liste des commandes d'une tournée.
    * @param listCommande
    */
    private void setListCommande(ArrayList listCommande) {
        this.listCommande = listCommande;
    }
    
    /**
    * Permet de récupérer le véhicule associé à la tournée.
    * @return vehicule
    */
    private Vehicule getVehicule() {
        return this.vehicule;
    }
    
    /**
    * Permet de définir le véhicule associé à la tournée
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
    * Permet l'ajout d'une commande de la liste des commandes de la tournée.
    * @param commande
    */
    public void addCommande(Commande commande) {
    	
    }
    /**
    * Permet de supprimer une commande de la liste des commandes de la tournée.
    * @param commande
    */
    public void delCommande(Commande commande) {
    	
    }
    /**
    * Permet de modifier uen commande de la liste des commandes de la tournée.
    * @param commande
    */
    public void modifCommande(Commande commande) {
    	
    }
    
}
