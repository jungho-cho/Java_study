
public class MethodTest {
//	public int sum(int a, int b) {
//		return a+b;
//	}
	public void sum(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a+b));
	}
	public String say() {
		return "Hallo";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3;
		int b = 4;
		
		MethodTest mTest = new MethodTest();
//		int c = mTest.sum(a, b);
//		System.out.println(c);
		mTest.sum(a, b);
		String strSay = mTest.say();
		System.out.println(strSay);
	}

}
