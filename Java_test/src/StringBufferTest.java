
public class StringBufferTest {
	public static void main(String args[])
	{
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("jump to java");
		System.out.println(sb.toString());
		System.out.println();
		
		String s = "";
		s += "hello";
		s += " ";
		s += "jump to java";
		System.out.println(s);
		System.out.println();
		
		StringBuffer sbsb = new StringBuffer();
		sbsb.append("jump to java");
		sbsb.insert(0, "hello ");
		System.out.println(sbsb.toString());
		System.out.println();
		System.out.println(sbsb.substring(0,4));
	}
}
