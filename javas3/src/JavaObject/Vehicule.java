package JavaObject;
public class Vehicule {

    private String immatriculation;
    private Integer poidsMax;
    
   
    /**
    * Permet de r�cup�rer l'immatriculation du v�hicule.
    * @return immatriculation
    */
    private String getImmatriculation() {
        return this.immatriculation;
    }
    
    /**
    * Permet de d�finir l'immatriculation du v�hicule.
    * @param immatriculation
    */
    private void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    /**
    * Permet de r�cup�rer le poids max du v�hicule.
    * @return poidsMax
    */
    private Integer getPoidsMax() {
        return this.poidsMax;
    }
    
    /**
    * Permet de d�finir le poids max du v�hicule.
    * @param poidsMax
    */
    private void setPoidsMax(Integer poidsMax) {
        this.poidsMax = poidsMax;
    }
    
}
