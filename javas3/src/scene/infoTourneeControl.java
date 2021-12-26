package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.Commande;
import JavaObject.DAO;
import JavaObject.Tournee;
import JavaObject.Vehicule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class infoTourneeControl {
	private static int idTournee;
	private static boolean admin;
	private Tournee tournee;

	@FXML
	private AnchorPane infoTournee;

	@FXML
	private Text id, date, heureDebut, heureFin, poid, imma, poidCamion;

	@FXML
	private TableView<CommandeClassPanel> tableCommande;
	@FXML
	public TableColumn<CommandeClassPanel, Integer> idcommande;
	@FXML
	public TableColumn<CommandeClassPanel, String> libelle;
	@FXML
	public TableColumn<CommandeClassPanel, Integer> poids;
	@FXML
	public TableColumn<CommandeClassPanel, Button> modifier;
	@FXML
	public TableColumn<CommandeClassPanel, Button> supprimer;

	DAO d = new DAO();

	@FXML
	public void initialize() {
		for (Tournee elemt : d.listTournee()) {
			if (idTournee == elemt.getIdTournee())
				this.tournee = elemt;
		}

		id.setText(id.getText().replace("$ID", Integer.toString(idTournee)));
		date.setText(date.getText().replace("$DATE", tournee.getDate().toString()));
		heureDebut.setText(heureDebut.getText().replace("$HEUREDEBUT", tournee.getHoraireDebut().toString()));
		heureFin.setText(heureFin.getText().replace("$HEUREFIN", tournee.getHoraireFin().toString()));
		poid.setText(poid.getText().replace("$POIDS", Integer.toString(tournee.getPoids())));
		Vehicule v = tournee.getVehicule();
		imma.setText(imma.getText().replace("$IMMATRICULATION", v.getImmatriculation()));
		poidCamion.setText(poidCamion.getText().replace("$POIDSCAMION", Integer.toString(v.getPoidsMax())));

		idcommande.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Integer>("id"));
		libelle.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, String>("libelle"));
		poids.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Integer>("poids"));
		modifier.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Button>("modif"));
		supprimer.setCellValueFactory(new PropertyValueFactory<CommandeClassPanel, Button>("sup"));

		ArrayList<CommandeClassPanel> commandeList = new ArrayList<CommandeClassPanel>();
		for (Commande elemt : d.listCommande(tournee)) {
			commandeList.add(new CommandeClassPanel(elemt.getIdCommande(), elemt.getLibelle(), elemt.getPoids()));
		}
		ObservableList<CommandeClassPanel> Ovehi = FXCollections.observableArrayList(commandeList);
		tableCommande.setItems(Ovehi);
	}

	public static boolean isAdmin() {
		return admin;
	}

	public static void setAdmin(boolean admin) {
		infoTourneeControl.admin = admin;
	}

	public static int getIdTournee() {
		return idTournee;
	}

	public static void setIdTournee(int idTournee) {
		infoTourneeControl.idTournee = idTournee;
	}

	public void backButtonInfoTournee() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("addTourneeAdmin.fxml"));
		if (admin) {
			loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		} else {
			loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
		}
		Pane mainpane = loader.load();
		infoTournee.getChildren().setAll(mainpane);
	}

	public void addComandeButton() {

	}

	public void deltourneeButton() {

	}

	public void modiftourneeButton() {

	}

	public void itineraire() {

	}
}