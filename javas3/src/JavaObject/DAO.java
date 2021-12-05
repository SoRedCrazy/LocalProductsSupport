package JavaObject;

import java.util.ArrayList;

public class DAO {

    /**
     * Consctructeur
     *
     * @param url
     * @param port
     * @param user
     * @param password
     * @param databaseName
     */
    public DAO() {

    }

    /**
     * Permet l'ajout d'un client dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param client
     * @return boolean
     */
    public boolean ajouterclient(Client client) {
        //Todo
        return true;
    }

    /**
     * Permet la suppression d'un client dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param client
     * @return boolean
     */
    public boolean delcient(Client client) {

        return true;

    }

    /**
     * Permet de modifier des informations client.
     *
     * @param client
     * @return boolean
     */

    public boolean modifclient(Client client) {

        return true;

    }

    /**
     * Permet l'ajout d'une entreprise dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param entreprise
     * @return boolean
     */
    public boolean ajouterEntreprise(Entreprise entreprise) {

        return true;
    }

    /**
     * Permet la suppression d'une entreprise dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param entreprise
     * @return boolean
     */

    public boolean supprimerEntreprise(Entreprise entreprise) {

        return true;

    }

    /**
     * Permet de modifier des informations entreprise.
     *
     * @param entreprise
     * @return boolean
     */
    public boolean modifEntreprise(Entreprise entreprise) {

        return true;

    }

    /**
     * Permet l'ajout d'un véhicule dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param vehicule
     * @return boolean
     */
    public boolean ajouterVehicule(Vehicule vehicule) {
        return true;

    }

    /**
     * Permet la suppression dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param vehicule
     * @return boolean
     */
    public boolean supprimerVehicule(Vehicule vehicule) {
        return true;

    }

    /**
     * Permet l'ajout d'un véhicule dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param tournee
     * @return boolean
     */
    public boolean ajouterTournee(Tournee tournee) {
        return true;

    }

    /**
     * Permet de modifier des informations tournee.
     *
     * @param tournee
     * @return boolean
     */
    public boolean modifEntreprise(Tournee tournee) {

        return true;

    }

    /**
     * Permet la suppression dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param tournee
     * @return boolean
     */
    public boolean supprimerTournee(Tournee tournee) {
        return true;

    }

    /**
     * Permet l'ajout d'une commande dans une tournée et retourne un boolean pour savoir si la requete s'est bien déroulée
     *
     * @param tournee
     * @param commande
     * @return boolean
     */
    public boolean ajouterCommandeTournee(Tournee tournee, Commande commande) {
        return true;

    }

    /** Permet la suppression d'une commande dans une tournee et retourne un boolean pour savoir si la requete s'est bien deroulee
     * @param tournee
     * @param commande
     * @return boolean
     */
    public boolean supprimerCommandeTournee(Tournee tournee, Commande commande) {
        return true;


    }

    /** Permet la modification d'une commande.
     * @param tournee
     * @return boolean
     */
    public boolean modifCommande(Tournee tournee) {
        return true;

    }

    /** Permet de retourner la liste des Tournee en fonction du numero de siret.
     * @param int Siret
     * @return ArrrayList<Tournee>
     */

    public ArrayList<Tournee> listTournee(int siret){
        return null;

    }

    /** Permet de retourner la liste de toute les  Tournees.
     * @return ArrrayList<Tournee>
     */

    public ArrayList<Tournee> TourneeAdmin(){
        return null;
    }

    /** Permet de retouner la liste de toutes les commandes.
     * @return ArrayList<Commande>
     */
    public ArrayList<Commande> listCommande(){
        return null;
    }
}