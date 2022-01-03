package scene;

import java.io.IOException;

import JavaObject.Client;
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
	private String nom;
	private String adress;
	private Button modif;

	public CommandeClassPanel(int id, String libelle, int poids, Client c) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.poids = poids;
		this.modif = new Button("modifier");
		this.modif.setOnAction((ActionEvent event) -> {
			for (Commande elemt : tournee.getListCommande()) {
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

		this.nom = c.getNom() + " " + c.getPrenom();
		this.adress = c.getNumeroDeRue() + " " + c.getRue() + " " + c.getCodePostal() + " " + c.getVille();
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
}
