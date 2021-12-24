package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import JavaObject.Admin;
import JavaObject.Client;
import JavaObject.DAO;
import JavaObject.Entreprise;

public class TestAdmin {

	Admin a = new Admin("Gangneux", "Alexis", "mdp", "julien.boisgard37@gmail.com");
	DAO d = new DAO();

	@Test
	public void testAjouterEntreprise() {
		Boolean b = a.ajouterEntreprise("logitech", "alexis", "gangneux", 4, "rue machin", 37100, "tours", "france",
				"02558589", "mdp");
		assertTrue(b);

	}

	@Test
	public void testSupprimerEntreprise() {
		boolean b = a.supprimerEntreprise("logitech");
		ArrayList<Entreprise> list = d.listEntreprise();
		assertTrue(b);
	}

	@Test
	public void testAjouterClient() {
		boolean b = a.ajouterClient("alexis", "gangneux", 43, "rue blabla", 37390, "Cerelles", "france", "0250806090");
		ArrayList<Client> list = d.listClient();
		assertTrue(b);

	}

	@Test
	public void testSupprimerClient() {
		boolean b = a.supprimerClient(d.listClient().get(0));
		ArrayList<Client> list = d.listClient();
		assertTrue(b);
	}

	@Test
	public void testModifierEntreprise() {
		// a.ajouterEntreprise("alpha", "france", "rue charle", 37100, "tours", 40,
		// "bardel", "francois", "0708909",
		// "mdp");
		Entreprise e = d.listEntreprise().get(0);
		boolean b = a.ModifEntreprise(e, "françois", "bardel", 12, "rue charle", 37100, "tours", "france", "080808808",
				"mdp");
		assertTrue(b);
	}

	@Test
	public void testModifierClient() {
		// a.ajouterClient("amaury", "mechin", 45, "rue de sonzay", 37100, "paumer",
		// "france", "021456971");
		Client c = d.listClient().get(0);
		boolean b = a.ModifClient(d.listClient().get(0), "john", "cause", 13, "rue bouda", 37800, "tourcoing", "france",
				"70809007808");
		assertTrue(b);
	}

}
