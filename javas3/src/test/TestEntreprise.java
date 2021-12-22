package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import JavaObject.DAO;
import JavaObject.Entreprise;
import JavaObject.Tournee;
import JavaObject.Vehicule;

class TestEntreprise {

	Entreprise ent = new Entreprise("logitech", 4, "rue machin", 37000, "tours", "france", "amaury", "mechin",
			"02558589", "mdp");
	DAO d = new DAO();

	@Test
	void testAjouterVehicule() {
		ent.ajouterVehicule("BW 908 GR", 100);
		ArrayList<Vehicule> listV = d.listVehicule();
		assertFalse("Erreur", listV.isEmpty());
		assertTrue("Erreur", listV.size() == 1);
		assertEquals("Erreur", listV.get(0), ent.getVehicule());

	}

	@Test
	void testSupprimerVehicule() {
		ent.supprimerVehicule(d.listVehicule().get(0));
		ArrayList<Vehicule> listV = d.listVehicule();
		assertFalse("Erreur", listV.size() != 0);
		assertEquals("Erreur", listV.get(0), ent.getVehicule());
		assertTrue("Erreur", listV.isEmpty());
	}

	@Test
	void testAjouterTournee() {
		ent.ajouterTournee(null, null, null, null);
		ArrayList<Tournee> listT = d.listTournee();
		assertTrue("Erreur", listT.size() == 1);
		assertFalse("Erreur", listT.isEmpty());
		assertEquals("Erreur", listT.get(0), ent.getTournee());
	}

	@Test
	void testModifierTournee() {
		Vehicule v = new Vehicule("BW 908 GR", 100);
		ent.modifierTournee(null, null, null, v, d.listTournee().get(0));
		assertTrue("Erreur", ent.getVehicule().get(0).getImmatriculation() == "BW 908 GR");
		assertEquals("Erreur", d.listTournee().get(0).getVehicule(), v);
		assertFalse("Erreur", ent.getVehicule().get(0).getPoidsMax() != 100);
	}

	@Test
	void testSupprimerTournee() {
		ent.supprimerTournee(d.listTournee().get(0));
		assertTrue("Erreur", d.listTournee().isEmpty());
		assertEquals("Erreur", d.listTournee(), ent.getTournee());
		assertFalse("Erreur", d.listTournee().size() != 0);
	}

	@Test
	void testAjouterCommandeTournee() {

	}

	@Test
	void testSupprimerCommandeTournee() {

	}
}
