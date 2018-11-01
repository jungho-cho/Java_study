import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("peo", "people");
		map.put("base", "baseball");
		
		System.out.println("size => " + map.size());
		System.out.println("get peo =>" + map.get("peo"));
		System.out.println("is contain peo => " + map.containsKey("peo"));
		System.out.println("remove peo => " + map.remove("peo"));
		System.out.println("size => " + map.size());
	}

}
