package scene;

import javafx.scene.control.Button;

public class CommandeClassPanel {
	private int id;
	private String libelle;
	private int poids;
	private Button modif;
	private Button sup;

	public CommandeClassPanel(int id, String libelle, int poids) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.poids = poids;
		this.modif = new Button("modifier");
		this.sup = new Button("supprimer");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public Button getModif() {
		return modif;
	}

	public void setModif(Button modif) {
		this.modif = modif;
	}

	public Button getSup() {
		return sup;
	}

	public void setSup(Button sup) {
		this.sup = sup;
	}

}
