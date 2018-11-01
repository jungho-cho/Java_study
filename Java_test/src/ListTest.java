import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList pitches = new ArrayList();
		pitches.add("138");
		pitches.add("129");
		pitches.add("142");
		
		for (int i=0; i<pitches.size(); i++) 
		{
			System.out.println("pitches[" + i + "] => " + pitches.get(i));
		}
		
		System.out.println("size => " + pitches.size());
		System.out.println("contains 142 => " + pitches.contains("142"));
		System.out.println("remove from 129 => " + pitches.remove("129"));
		System.out.println("remove from index(0) => " + pitches.remove(0));
	}

}
