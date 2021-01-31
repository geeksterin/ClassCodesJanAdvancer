package string;

public class StringDemo {

	public static void main(String[] args) {
		String str = "abc";
		String str2 = "abc";
//		str2 = "def";
//		str2+='a';
		String str3 = new String("abc");
		System.out.println(str==str3);
		System.out.println(str.equals(str3));

	}

}
