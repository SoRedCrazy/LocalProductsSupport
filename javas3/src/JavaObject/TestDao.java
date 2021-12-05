package JavaObject;

public class TestDao {

	public static void main(String[] args) {
		
		DAO d=new DAO();
		Client cl=d.ajouterclient("julien","boisgard",3,"rue",37200,"ville","pays",060,"julien.boisgard37@gmail.com");
		
		System.out.println(cl.toString());
	}

}
