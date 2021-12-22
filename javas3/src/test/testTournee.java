package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import JavaObject.Client;
import JavaObject.Commande;
import JavaObject.Tournee;
import JavaObject.Vehicule;

class testTournee {

	Client cl = new Client(1, "Amaury", "Mechin", 1, "Le bois du gast", 37360, "Sonzay", "France", "0607668045");
	Commande c = new Commande(1, "chocolat", 3, null, null, cl);
	Vehicule v = new Vehicule("BW 908 GR", 100);
	Tournee t = new Tournee(1, null, null, null, v);

	@Test
	void testAddCommande() {
		t.addCommande(c);
		ArrayList<Commande> listC = new ArrayList<Commande>();
		listC.add(c);
		assertTrue("Erreur", t.getListCommande().size() != 0);
		assertEquals("Erreur", t.getListCommande(), listC);
		assertEquals("Erreur", t.toString(),
				"Tournee [idTournee=" + t.getIdTournee() + ", date=" + t.getDate() + ", horaireDebut="
						+ t.getHoraireDebut() + ", horaireFin=" + t.getHoraireFin() + ", listCommande="
						+ t.getListCommande() + ", vehicule=" + t.getVehicule() + ", poids=" + t.getPoids() + "]");
		assertFalse("Erreur", t.getListCommande().isEmpty());
	}

	@Test
	void testDelCommande() {
		t.delCommande(c);
		ArrayList<Commande> listC = new ArrayList<Commande>();
		assertTrue("Erreur", t.getListCommande().isEmpty());
		assertEquals("Erreur", t.getListCommande(), listC);
		assertEquals("Erreur", t.toString(),
				"Tournee [idTournee=" + t.getIdTournee() + ", date=" + t.getDate() + ", horaireDebut="
						+ t.getHoraireDebut() + ", horaireFin=" + t.getHoraireFin() + ", listCommande="
						+ t.getListCommande() + ", vehicule=" + t.getVehicule() + ", poids=" + t.getPoids() + "]");
		assertFalse("Erreur", t.getListCommande().size() != 0);
	}

	@Test
	void testModifCommande() {
		t.modifCommande(c, "lait", 2, null, null, cl);
		Commande c2 = new Commande(1, "lait", 2, null, null, cl);
		assertTrue("Erreur", c.getLibelle() == "lait");
		assertEquals("Erreur", c, c2);
		assertEquals("Erreur", c.toString(),
				"Commande [idCommande=" + c.getIdCommande() + ", libelle=" + c.getLibelle() + ", poids=" + c.getPoids()
						+ ", heuredebut=" + c.getHeuredebut() + ", heurefin=" + c.getHeureFin() + ", Client="
						+ c.getClient() + "]");

		assertFalse("Erreur", c.getPoids() != 2);
	}

}
