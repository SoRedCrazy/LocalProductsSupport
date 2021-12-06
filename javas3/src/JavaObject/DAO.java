package JavaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;




public class DAO {
	private Connection cn;
    /**
     * Consctructeur
     *
     */
    public DAO() {
    	this.cn= Singleton.getInstance();
    }

    /**
     * Permet l'ajout d'un client dans la DAO et retourne un Client null si ca ca c'est pas bien passer et le client bien cr�e si c'est bon.
     *
     * @param prenom -String
     * @param nom -String
     * @param numeroDeRue -Integer
     * @param rue -String
     * @param codePostal -Integer
     * @param ville -String
     * @param pays -String
     * @param numTelephone -Integer
     * @param mailAdmin - String
     * @return Client
     * @exception SQLExecption pour tel que le numero de telephone existe deja... 
     */
    public Client ajouterclient(String prenom,String nom,Integer numeroDeRue,String rue,Integer codePostal,String ville,String pays,Integer numTelephone,String mailAdmin) {
    	//preparation 
    	Client cl = null;
    	PreparedStatement stmt=null;
    	int rs=-1;
    	ResultSet result;
        try {
        	//sql 
        	stmt= this.cn.prepareStatement("INSERT INTO Client VALUES(0,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, prenom);
			stmt.setString(2, nom);
			stmt.setInt(3, numeroDeRue);
			stmt.setString(4, rue);
			stmt.setInt(5, codePostal);
			stmt.setString(6, ville);
			stmt.setString(7, pays);
			stmt.setInt(8, numTelephone);
			stmt.setString(9, mailAdmin);
			//on recupere le deroulement et excute
			rs= stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs<0) {
		        throw new SQLException();
		    }
		    else { 
		    	//on cherche l'id�e a ttribut dans la base de donne est le numero de telephone est unique
				stmt= this.cn.prepareStatement("SELECT idclient FROM Client WHERE numero_de_telephone= ? ");
				stmt.setInt(1, numTelephone);
				stmt.execute();
				result= stmt.executeQuery();
				result.next();
				cl=new Client(result.getInt("idclient"),prenom,nom,numeroDeRue,rue,codePostal,ville,pays,numTelephone);
		    }
        } catch(SQLException e) {
        	e.printStackTrace();
        }
       
        // si l'objet est null sa c'est pas bien passer
        return cl;
        	
			
  
    }

    /**
     * Permet la suppression d'un client dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param client
     * @return boolean
     * @exception SQLException si les information en concorde pas
     */
    public boolean delclient(Client client) {

    	//test
    	PreparedStatement stmt=null;
    	int rs=-1;
    	
        try {
        	stmt= this.cn.prepareStatement("DELETE FROM Client WHERE idclient=? ");
			stmt.setInt(1, client.getIdClient());
			rs= stmt.executeUpdate();	
        } catch(SQLException e) {
        	
        }
        
        if(rs<0) {
        	return false;
        }
        else {
        	return true;
        }

    }

    /**
     * Permet de modifier des informations client.
     *
     * @param client
     * @return boolean
     * @exception SQLException si probleme d'information.
     */

    public boolean modifclient(Client client) {
    	
    	PreparedStatement stmt=null;
    	int rs=-1;
    	
        try {
        	stmt= this.cn.prepareStatement("UPDATE Client SET prenom=?, nom=?, numero_de_rue=?,rue=?, code_postal=?, ville=?, pays=? ,numero_de_telephone=?  WHERE idclient=? ");
			stmt.setString(1, client.getPrenom());
			stmt.setString(2, client.getNom());
			stmt.setInt(3, client.getNumeroDeRue());
			stmt.setString(4, client.getRue());
			stmt.setInt(5, client.getCodePostal());
			stmt.setString(6, client.getVille());
			stmt.setString(7, client.getPays());
			stmt.setInt(8, client.getNumTelephone());
			stmt.setInt(9, client.getIdClient());
			rs= stmt.executeUpdate();	
        } catch(SQLException e) {
        	
        }
        
        if(rs<0) {
        	return false;
        }
        else {
        	return true;
        }

    }

    /**
     * Permet l'ajout d'une entreprise dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param siret -Integer
     * @param numeroDeRue -Integer
     * @param rue -String
     * @param codePostal -Integer
     * @param ville -String
     * @param pays -String
     * @param nom -String
     * @param prenom -String
     * @param numTelephone -Integer
     * @param mdp-String
     * @param mailAdmin - String
     * @return Entreprise
     * @exception SQLException si erreur de paramettre
     */
    public Entreprise ajouterEntreprise(int siret,String prenom,String nom,Integer numeroDeRue,String rue,Integer codePostal,String ville,String pays,Integer numTelephone,String motsdepasses,String mailAdmin) {

    	//preparation 
    	Entreprise et = null;
    	PreparedStatement stmt=null;
    	int rs=-1;
    	ResultSet result;
        try {
        	//sql 
        	stmt= this.cn.prepareStatement("INSERT INTO Entreprise VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, siret);
			stmt.setInt(2, numeroDeRue);
			stmt.setString(3,rue);
			stmt.setInt(4, codePostal);
			stmt.setString(5, ville);
			stmt.setString(6, pays);
			stmt.setString(7, nom);
			stmt.setString(8, prenom);
			stmt.setInt(9, numTelephone);
			stmt.setString(10, motsdepasses);
			stmt.setString(11, mailAdmin);
			//on recupere le deroulement et excute
			rs= stmt.executeUpdate();
			// si infrieur a 0 ca c'est pas bien passer
			if (rs<0) {
		        throw new SQLException();
		    }
		    else {
				et=new Entreprise(siret,numeroDeRue,rue,codePostal, ville,pays,nom,prenom,numTelephone,motsdepasses);
		    }
        } catch(SQLException e) {
        	e.printStackTrace();
        }
       
        // si l'objet est null sa c'est pas bien passer
        return et;
        	
    }

    /**
     * Permet la suppression d'une entreprise dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param entreprise
     * @return boolean
     * @exception SQLException si erreur de paramettre
     */

    public boolean supprimerEntreprise(Entreprise entreprise) {
    	PreparedStatement stmt=null;
    	int rs=-1;
    	
        try {
        	stmt= this.cn.prepareStatement("DELETE FROM Commande WHERE siret= ? ; DELETE FROM Tournee WHERE Imaticulation=(SELECT Imaticulation FROM Vehicule WHERE SIRET= ? ) ; DELETE FROM Vehicule WHERE SIRET= ? ; DELETE FROM Entreprise WHERE SIRET= ? ");
			stmt.setInt(1, entreprise.getSiret());
			stmt.setInt(2, entreprise.getSiret());
			stmt.setInt(3, entreprise.getSiret());
			stmt.setInt(4, entreprise.getSiret());
			rs= stmt.executeUpdate();	
        } catch(SQLException e) {
        	
        }
        
        if(rs<0) {
        	return false;
        }
        else {
        	return true;
        }

    }

    /**
     * Permet de modifier des informations entreprise.
     *
     * @param entreprise
     * @return boolean
     * @exception SQLException si erreur de paramettre
     */
    public boolean modifEntreprise(Entreprise entreprise) {
    	PreparedStatement stmt=null;
    	int rs=-1;
    	
        try {
        	stmt= this.cn.prepareStatement("UPDATE Entreprise SET Numero_de_rue= ? ,rue= ? , code_postal= ? , ville= ? , pays= ? , NOM= ? , prenom= ? , Numero_de_telephone = ?, mots_de_passes= ? WHERE SIRET= ? ");
			stmt.setInt(1, entreprise.getNumeroDeRue());
			stmt.setString(2, entreprise.getRue());
			stmt.setInt(3, entreprise.getCodePostal());
			stmt.setString(4, entreprise.getVille());
			stmt.setString(5, entreprise.getPays());
			stmt.setString(6, entreprise.getNom());
			stmt.setString(7, entreprise.getPrenom());
			stmt.setInt(8, entreprise.getNumTelephone());
			stmt.setString(9, entreprise.getMdp());
			stmt.setInt(10, entreprise.getSiret());
			rs= stmt.executeUpdate();	
        } catch(SQLException e) {
        	
        }
        
        if(rs<0) {
        	return false;
        }
        else {
        	return true;
        }


    }

    /**
     * Permet l'ajout d'un véhicule dans la DAO et retourne un boolean pour savoir si la requete s'est bien déroulée.
     *
     * @param Immatriculation String
     * @param poidmax int
     * @param siret int
     * @return vehicule
     */
    public boolean ajouterVehicule(String immatriculation,int poidmax, int siret) {
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