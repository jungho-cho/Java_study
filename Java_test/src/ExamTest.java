
public class ExamTest {
	int erste;
	int zweite;
	int dritte;
	int vierte;
	int funfte;
	int nummerCount;
	ExamTest() {
		erste = 3;
		zweite = 10;
		dritte = 40;
		vierte = 1;
		funfte = 101;
		nummerCount = 5;
	}
	void sort() {
		int temp = 0;
		for (int i=0; i<nummerCount; i++) {
			if (isBig(this.erste, this.zweite) == false) {
				temp = erste;
				erste = zweite;
				zweite = temp;
			}
			if (isBig(this.zweite, this.dritte) == false) {
				temp = zweite;
				zweite = dritte;
				dritte = temp;
			}
			if (isBig(this.dritte, this.vierte) == false) {
				temp = dritte;
				dritte = vierte;
				vierte = temp;
			}
			if (isBig(this.vierte, this.funfte) == false) {
				temp = vierte;
				vierte = funfte;
				funfte = temp;
			}
		}
	}
	boolean isBig(int a, int b) {
		return (a > b);
	}
	void printAll() {
		System.out.println("erste = " + this.erste);
		System.out.println("zweite = " + this.zweite);
		System.out.println("dritte = " + this.dritte);
		System.out.println("vierte = " + this.vierte);
		System.out.println("funfte = " + this.funfte);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExamTest et = new ExamTest();
		et.printAll();
		et.sort();
		et.printAll();
	}

}
