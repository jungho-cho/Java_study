
public class StringTypeTest {
	public static void main(String args[])
	{
		String a = "Happy Java";
		String b = "a";
		String c = "123";
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println();
		
		String aa = new String("Happy Java");
		String bb = new String("a");
		String cc = new String("123");
		
		System.out.println("aa = " + aa);
		System.out.println("bb = " + bb);
		System.out.println("cc = " + cc);
		System.out.println();
		
		String aaa = "hello";
		String bbb = "java";
		String ccc = "hello";
	
		System.out.println("aaa equals bbb : " + aaa.equals(bbb));
		System.out.println("aaa equals ccc : " + aaa.equals(ccc));
		System.out.println();
		
		String d = "hello";
		String e = new String("hello");
		
		System.out.println("d equals e : " + d.equals(e));
		System.out.println("d == e : " + d == e);
		System.out.println();
		
		String dd = "Hello Java";
		System.out.println("dd.indexOf(\"Java\") ==> " + dd.indexOf("Java"));
		
		System.out.println("dd.replaceAll(\"Java\", \"World\") ==> " + dd.replaceAll("Java", "Wrold"));
		System.out.println("after replaceAll from dd ==> " + dd);
		System.out.println("dd.substring ==> " + dd.substring(0, 4));
		System.out.println("after dd.substring ==> " + dd);
		System.out.println("dd.toUpperCase ==> " + dd.toUpperCase());
		System.out.println("after dd.toUpperCase ==> " + dd);
	}
}
