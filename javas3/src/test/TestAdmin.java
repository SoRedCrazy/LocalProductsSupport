package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import JavaObject.Admin;
import JavaObject.Client;
import JavaObject.DAO;
import JavaObject.Entreprise;

public class TestAdmin {

	Admin a = new Admin("Gangneux", "Alexis", "mdp", "Gangneux.alexis@..fr");
	DAO d = new DAO();

	@Test
	public void testAjouterEntreprise() {
		a.ajouterEntreprise("logitech", "alexis", "gangneux", 4, "rue machin", 37100, "tours", "france", "02558589",
				"mdp");
		ArrayList<Entreprise> list = d.listEntreprise();
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
		assertEquals(list, d.listEntreprise());

	}

	@Test
	public void testSupprimerEntreprise() {
		a.supprimerEntreprise("logitech");
		ArrayList<Entreprise> list = d.listEntreprise();
		assertTrue(list.isEmpty());
		assertEquals(list, d.listEntreprise());
		assertTrue(list.size() == 0);
	}

	@Test
	public void testAjouterClient() {
		a.ajouterClient("alexis", "gangneux", 43, "rue blabla", 37390, "Cerelles", "france", "0250806090");
		ArrayList<Client> list = d.listClient();
		assertFalse(list.isEmpty());
		assertEquals(list, d.listClient());
		assertTrue(list.size() == 1);

	}

	@Test
	public void testSupprimerClient() {
		a.supprimerClient(d.listClient().get(0));
		ArrayList<Client> list = d.listClient();
		assertTrue(list.isEmpty());
		assertEquals(list, d.listClient());
		assertFalse(list.size() == 1);
	}

	@Test
	public void testModifierEntreprise() {
		Entreprise e = new Entreprise(null, null, null, null, null, null, null, null, null, null);
		a.ModifEntreprise(e, "MODIF", null, 12, null, null, null, null, null, null);
		assertTrue(e.getSiret() == "MODIF");
		assertTrue(e.getNumeroDeRue() == 12);
	}

	@Test
	public void testModifierClient() {
		a.ajouterClient("julien", null, null, null, null, null, null, null);
		a.ModifClient(d.listClient().get(0), null, "Boisgard", null, null, null, null, null, "0607806086");
		Client c = d.listClient().get(0);
		assertTrue(c.getNom() == "Boisgard");
		assertTrue(c.getNumTelephone() == "0607806086");
	}

}
