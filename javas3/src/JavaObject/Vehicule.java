package JavaObject;

/**
 * Permet de gerer les vehicules.
 * 
 * @author Boisgard Julien
 *
 */

public class Vehicule {

	private String immatriculation;
	private Integer poidsMax;

	/**
	 * Constructeur d'un vehicule.
	 * 
	 * @param immatriculation -String
	 * @param poidsMax        -int
	 * 
	 * @author Mechin Amaury
	 */
	public Vehicule(String immatriculation, Integer poidsMax) {
		this.immatriculation = immatriculation;
		this.poidsMax = poidsMax;
	}

	/**
	 * Permet de récupérer l'immatriculation du véhicule.
	 * 
	 * @return immatriculation -String
	 * 
	 * @author Mechin Amaury
	 */
	public String getImmatriculation() {
		return this.immatriculation;
	}

	/**
	 * Permet de définir l'immatriculation du véhicule.
	 * 
	 * @param immatriculation -String
	 * 
	 * @author Mechin Amaury
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * Permet de récupérer le poids max du véhicule.
	 * 
	 * @return poidsMax -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getPoidsMax() {
		return this.poidsMax;
	}

	/**
	 * Permet de définir le poids max du véhicule.
	 * 
	 * @param poidsMax -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setPoidsMax(Integer poidsMax) {
		this.poidsMax = poidsMax;
	}

	/**
	 * Permet de retouner toutes les informations du véhicule.
	 */
	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", poidsMax=" + poidsMax + "]";
	}
}
