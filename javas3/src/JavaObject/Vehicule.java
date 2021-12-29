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
	 * Permet de r�cup�rer l'immatriculation du v�hicule.
	 * 
	 * @return immatriculation -String
	 * 
	 * @author Mechin Amaury
	 */
	public String getImmatriculation() {
		return this.immatriculation;
	}

	/**
	 * Permet de d�finir l'immatriculation du v�hicule.
	 * 
	 * @param immatriculation -String
	 * 
	 * @author Mechin Amaury
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * Permet de r�cup�rer le poids max du v�hicule.
	 * 
	 * @return poidsMax -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public Integer getPoidsMax() {
		return this.poidsMax;
	}

	/**
	 * Permet de d�finir le poids max du v�hicule.
	 * 
	 * @param poidsMax -Integer
	 * 
	 * @author Mechin Amaury
	 */
	public void setPoidsMax(Integer poidsMax) {
		this.poidsMax = poidsMax;
	}

	/**
	 * Permet de retouner toutes les informations du v�hicule.
	 */
	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", poidsMax=" + poidsMax + "]";
	}
}
