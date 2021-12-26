package scene;

import java.io.IOException;

import JavaObject.Commande;
import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class CommandeClassPanel {
	DAO d = new DAO();
	private static Tournee tournee;
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
		this.modif.setOnAction((ActionEvent event) -> {
			for (Commande elemt : d.listCommande(tournee)) {
				if (id == elemt.getIdCommande()) {
					modifCommandeControl.setC(elemt);
					modifCommandeControl.setT(tournee);
				}
			}
			FXMLLoader loader = new FXMLLoader(getClass().getResource("modifCommande.fxml"));
			try {
				Pane mainpane = loader.load();
				infoTourneeControl.ChangeInterfaceModif(mainpane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		this.sup = new Button("supprimer");
		this.sup.setOnAction((ActionEvent event) -> {
			for (Commande elemt : d.listCommande(tournee)) {
				if (id == elemt.getIdCommande()) {
					tournee.delCommande(elemt);
				}
			}
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			try {
				Pane mainpane = loader.load();
				infoTourneeControl.ChangeInterfaceModif(mainpane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}

	public static Tournee getTournee() {
		return tournee;
	}

	public static void setTournee(Tournee tournee) {
		CommandeClassPanel.tournee = tournee;
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
