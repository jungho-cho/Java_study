
public class BooleanTest {
	public static void main(String args[])
	{
		int base = 180;
		int height = 185;
		boolean isTall = height > base;
		
		if (isTall)
		{
			System.out.println("키가 큽니다");
		}
		
		int i = 3;
		boolean isOdd = i % 2 == 1;
		
		if (isOdd)
		{
			System.out.println("홀수 입니다.");
		}
	}
}
