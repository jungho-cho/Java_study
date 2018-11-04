import java.util.ArrayList;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers[] = {"one", "two", "three"};
		for (int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println("==========================================");
		int marks[] = {90, 25, 67, 45, 80};
		for (int i=0; i<marks.length; i++) {
			if (marks[i] >= 60) {
				System.out.println((i+1)+" hat bestanden");
			} else {
				System.out.println((i+1)+" hat nicht bestanden");
			}
		}
		System.out.println("==========================================");
		for (int i=0; i<marks.length; i++) {
			if (marks[i] < 60) {
				continue;
			}
			System.out.println((i+1)+" hat bestanden");
		}
		System.out.println("==========================================");
		for (int i=2; i<10; i++) {
			for (int j=1; j<10; j++) {
				System.out.print(i + "*" + j + "=" + (i*j));
				System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println("==========================================");
		for (int i=1; i<10; i++) {
			for (int j=2; j<10; j++) {
				System.out.print(j + "*" + i + "=" + (i*j));
				System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println("==========================================");
		ArrayList<String> arrNumbers = new ArrayList<String>();
		arrNumbers.add("eins");
		arrNumbers.add("zwei");
		arrNumbers.add("drei");
		for (String number : arrNumbers) {
			System.out.println(number);
		}
	}
}
