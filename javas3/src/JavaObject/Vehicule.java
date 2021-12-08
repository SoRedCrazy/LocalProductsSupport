package JavaObject;
public class Vehicule {

    private String immatriculation;
    private Integer poidsMax;
    
    /**
     * Constructeur d'unvehicule
     * @param immatriculation String
     * @param poidsMax int
     */
    public Vehicule(String immatriculation, Integer poidsMax) {
		this.immatriculation = immatriculation;
		this.poidsMax = poidsMax;
	}
    
    @Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", poidsMax=" + poidsMax + "]";
	}

	/**
    * Permet de récupérer l'immatriculation du véhicule.
    * @return immatriculation
    */
    public String getImmatriculation() {
        return this.immatriculation;
    }
    
    /**
    * Permet de définir l'immatriculation du véhicule.
    * @param immatriculation
    */
    public void setImmatriculation() {
        this.immatriculation = immatriculation;
    }
   

	/**
    * Permet de récupérer le poids max du véhicule.
    * @return poidsMax
    */
    public Integer getPoidsMax() {
        return this.poidsMax;
    }
    
    /**
    * Permet de définir le poids max du véhicule.
    * @param poidsMax
    */
    public void setPoidsMax(Integer poidsMax) {
        this.poidsMax = poidsMax;
    }
    
}
