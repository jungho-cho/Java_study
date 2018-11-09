import java.util.ArrayList;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean money = true;
		
		if (money) 
		{
			System.out.println("go taxi");
		} 
		else 
		{
			System.out.println("go walk");
		}
		
		int x = 3;
		int y = 2;
		System.out.println();
		System.out.println("x < y => " + (x < y));
		System.out.println("x > y => " + (x > y));
		System.out.println("x == y => " + (x == y));
		System.out.println("x != y => " + (x != y));
		
		int nMoney = 2000;
		if (nMoney >= 3000)
		{
			System.out.println("go taxi");
		} 
		else 
		{
			System.out.println("go walk");
		}
		
		int nMoney2 = 2000;
		boolean hasCard = true;
		if (nMoney2 >= 3000 || hasCard)
		{
			System.out.println("go taxi");
		} 
		else 
		{
			System.out.println("go walk");
		}
		
		ArrayList<String> pocket = new ArrayList<String>();
		pocket.add("paper");
		pocket.add("handphone");
		pocket.add("money");
		
		if (pocket.contains("money"))
		{
			System.out.println("go taxi");
		} 
		else 
		{
			System.out.println("go walk");
		}
		
		ArrayList<String> pocket2 = new ArrayList<String>();
		hasCard = true;
		pocket2.add("paper");
		pocket2.add("handphone");
		
		if (pocket.contains("money"))
		{
			System.out.println("go taxi");
		} 
		else if (hasCard)
		{
			System.out.println("go taxi");
		}
		else 
		{
			System.out.println("go walk");
		}
	}
}
