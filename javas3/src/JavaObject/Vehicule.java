package JavaObject;
public class Vehicule {

    private String immatriculation;
    private Integer poidsMax;
    
   
    /**
    * Permet de récupérer l'immatriculation du véhicule.
    * @return immatriculation
    */
    private String getImmatriculation() {
        return this.immatriculation;
    }
    
    /**
    * Permet de définir l'immatriculation du véhicule.
    * @param immatriculation
    */
    private void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    /**
    * Permet de récupérer le poids max du véhicule.
    * @return poidsMax
    */
    private Integer getPoidsMax() {
        return this.poidsMax;
    }
    
    /**
    * Permet de définir le poids max du véhicule.
    * @param poidsMax
    */
    private void setPoidsMax(Integer poidsMax) {
        this.poidsMax = poidsMax;
    }
    
}
