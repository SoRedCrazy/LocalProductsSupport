package JavaObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    
    
    private static Connection connect;
    
    /**
     * Ce constructeur permet de garantir une unique connexion à l'application cela evite 
     * les doublons de connexions en même temps.
     * @author gangn
     * @param connect -Connection
     */
    private Singleton() {
    	try {
    		connect = DriverManager.getConnection(
    		"jdbc:postgresql://localhost:5432/Ecole",
    		"postgres", "postgres");
    		} catch (SQLException e) { e.printStackTrace();}
    }
    
   
    //Operations                                  
    
    /**
     * Cette méthode permet de vérifier si une connexion existe avec la base de donnée.
     * @return Une connextion de type connection
     */
    public static Connection getInstance() {
    	if(connect == null){ new Singleton();}
    	return connect; 
        
    }
    
}
