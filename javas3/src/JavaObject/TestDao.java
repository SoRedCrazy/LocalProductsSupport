package JavaObject;

public class TestDao {

	public static void main(String[] args) {
		
		DAO d=new DAO();
		Entreprise et2=new Entreprise(6516, 3, "ruegrevy", 37500, "azayh", "france", "jarod", "nom", 00000, "azerty37");
		boolean t=d.modifEntreprise(et2);
		
		System.out.println(t);
	}

}
