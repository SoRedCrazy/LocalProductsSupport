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
    * Permet de r�cup�rer l'immatriculation du v�hicule.
    * @return immatriculation
    */
    public String getImmatriculation() {
        return this.immatriculation;
    }
    
    /**
    * Permet de d�finir l'immatriculation du v�hicule.
    * @param immatriculation
    */
    public void setImmatriculation() {
        this.immatriculation = immatriculation;
    }
   

	/**
    * Permet de r�cup�rer le poids max du v�hicule.
    * @return poidsMax
    */
    public Integer getPoidsMax() {
        return this.poidsMax;
    }
    
    /**
    * Permet de d�finir le poids max du v�hicule.
    * @param poidsMax
    */
    public void setPoidsMax(Integer poidsMax) {
        this.poidsMax = poidsMax;
    }
    
}
