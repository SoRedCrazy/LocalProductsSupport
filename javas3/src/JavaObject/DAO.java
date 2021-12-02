package JavaObject;

import java.util.ArrayList;

public class DAO {
    private String url;
    private int port;
    private String user;
    private String password;
    private String databaseName;

    /**
     * Consctructeur
     *
     * @param url
     * @param port
     * @param user
     * @param password
     * @param databaseName
     */
    public DAO(String url, int port, String user, String password, String databaseName) {
        this.url = url;
        this.port = port;
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;


    }




    /**
     * Permet de retounrner l'url.
     *
     * @return url
     */
    private String getUrl() {
        return this.url;
    }

    /**
     * Permet de set l'url.
     *
     * @param url
     */
    private void setUrl(String url) {
        this.url = url;
    }

    /**
     * Permet de retourner le port.
     *
     * @return port
     */
    private int getPort() {
        return this.port;
    }

    /**
     * Permet de set le port.
     *
     * @param port
     */
    private void setPort(int port) {
        this.port = port;
    }

    /**
     * Permet de retourner le User.
     *
     * @return user
     */
    private String getUser() {
        return this.user;
    }

    /**
     * Permet de set le User.
     *
     * @param user
     */
    private void setUser(String user) {
        this.user = user;
    }

    /**
     * Permet de retourner le password.
     *
     * @return password
     */
    private String getPassword() {
        return this.password;
    }

    /**
     * Permet de set le password.
     *
     * @param password
     */
    private void setPassword(String password) {
        this.password = password;
    }

    /**
     * Permet de retourner le databaseName
     *
     * @return databaseName
     */
    private String getDatabaseName() {
        return this.databaseName;
    }

    /**
     * Permet de set le databaseName.
     *
     * @param databaseName
     */
    private void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
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