package JavaObject;
import java.sql.Date;

public class Commande {

    private Integer idCommande;
    private String libelle;
    private Integer poids;
    private Date dateCommande;
    private Date dateLimite;
    private Client Client;

    /**
    * Permet de r�cup�rer l'id de la commande.
    * @return idCommande
    */
    private Integer getIdCommande() {
        return this.idCommande;
    }
    
    /**
    * Permet de d�finir l'id de la commande.
    * @param commande
    */
    private void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }
    
    /**
    * Permet de r�cup�rer le lib�ll� de la commande.
    * @return libelle
    */
    private String getLibelle() {
        return this.libelle;
    }
    
    /**
    * Permet de d�finir le libelle de la commande.
    * @param libelle
    */
    private void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    /**
    * Permet de r�cup�rer la poids de la commande.
    * @return poids
    */
    private Integer getPoids() {
        return this.poids;
    }
    
    /**
    * Permet de d�finir le poids de la commande.
    * @param poids
    */
    private void setPoids(Integer poids) {
        this.poids = poids;
    }
    
    /**
    * Permet de r�cup�rer la date de la commande.
    * @return dateCommande
    */
    private Date getDateCommande() {
        return this.dateCommande;
    }
    
    /**
    * Permet de d�finir la date de la commande.
    * @param dateCommande
    */
    private void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    /**
    * Permet de r�cup�rer la date limite de la commande.
    * @return dateLimite
    */
    private Date getDateLimite() {
        return this.dateLimite;
    }
    
    /**
    * Permet de d�finir la date limite de la commande.
    * @param dateLimite
    */
    private void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
    
    /**
    * @generated
    */
    private Client getClient() {
        return this.Client;
    }
    
    /**
    * @generated
    */
    private void setClient(Client Client) {
        this.Client = Client;
    }
    
}
