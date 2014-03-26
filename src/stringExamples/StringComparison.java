package stringExamples;

public class StringComparison {

	static String str = "woodpecker";
	static StringBuffer strBuf = new StringBuffer("woodpecker");
	static StringBuilder strBld = new StringBuilder("woodpecker");
	
	public static void main(String[] args) {
		System.out.println("STR= " + str);
		System.out.println("STRBUF= " + strBuf);
		str.concat(" is");
		strBuf.append(" is");
		System.out.println("STR= " + str);
		System.out.println("STRBUF= " + strBuf);
		
		System.out.println(str.substring(3,4));
	}

}
