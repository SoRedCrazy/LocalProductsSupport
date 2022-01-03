package scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import JavaObject.Commande;
import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class itineraireControl {
	private static Tournee tournee;
	@FXML
	private AnchorPane itineraire;
	@FXML
	private TableView<CommandeClassPanel> tableCommande;
	@FXML
	public TableColumn<CommandeClassPanel, Integer> idcommande;
	@FXML
	public TableColumn<CommandeClassPanel, String> libelle;
	@FXML
	public TableColumn<CommandeClassPanel, Integer> poids;
	@FXML
	public TableColumn<CommandeClassPanel, String> nom;
	@FXML
	public TableColumn<CommandeClassPanel, String> adresse;

	DAO d = new DAO();

	@FXML
	public void initialize() {
		TreeSet<Commande> tclist = new TreeSet<Commande>();
		tclist.addAll(d.listCommande(tournee.getIdTournee()));

		idcommande.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Integer>("id"));
		libelle.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, String>("libelle"));
		poids.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Integer>("poids"));
		nom.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, String>("nom"));
		adresse.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, String>("adress"));

		ArrayList<CommandeClassPanel> commandeList = new ArrayList<CommandeClassPanel>();
		for (Commande elemt : tclist) {
			commandeList.add(new CommandeClassPanel(elemt.getIdCommande(), elemt.getLibelle(), elemt.getPoids(),
					elemt.getClient()));
		}
		ObservableList<CommandeClassPanel> Ovehi = FXCollections.observableArrayList(commandeList);
		tableCommande.setItems(Ovehi);

	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
		Pane mainpane = loader.load();
		itineraire.getChildren().setAll(mainpane);
	}

	public static Tournee getTournee() {
		return itineraireControl.tournee;
	}

	public static void setTournee(Tournee tournee) {
		itineraireControl.tournee = tournee;
	}

}
