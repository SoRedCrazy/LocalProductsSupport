package JavaObject;
//ratatouille
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    
    
    private static Connection connect;
    
    /**
     * Ce constructeur permet de garantir une unique connexion � l'application cela evite 
     * les doublons de connexions en m�me temps.
     * @author gangn
     * @param connect -Connection
     */
    private Singleton() {
    	try {
    		connect = DriverManager.getConnection(
    		"jdbc:postgresql://212.1.208.101/u230559756_project",
    		"u230559756_root", "Azerty37");
    		} catch (SQLException e) { e.printStackTrace();}
    }
    
   
    //Operations                                  
    
    /**
     * Cette m�thode permet de v�rifier si une connexion existe avec la base de donn�e.
     * @return Une connextion de type connection
     */
    public static Connection getInstance() {
    	if(connect == null){ new Singleton();}
    	return connect; 
        
    }
    
}