package parseTokFormatExamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingExample {

	static Pattern pat = Pattern.compile("abc");
	static Matcher mat = pat.matcher("abababcbcaabcabbcbdba");
	
	static Pattern p_whiteSpace 	= Pattern.compile("[\\s+]");
	static Pattern p_nonWhiteSpace 	= Pattern.compile("[\\S+]");
	static Matcher m_ws 	= p_whiteSpace.matcher("This is a Example");
	static Matcher m_nws 	= p_nonWhiteSpace.matcher("This is a Example");
	
	public static void main(String[] args) {
		while (mat.find()) {
			System.out.println(mat.start() + " " + mat.group());
		}
		
		System.out.println("White space characters");
		while (m_ws.find()) {
			System.out.println(m_ws.start());
		}
		System.out.println("=======================");
		
		System.out.println("Non White space characters");
		while (m_nws.find()) {
			System.out.println(m_nws.start() + m_nws.groupCount());
		}
		System.out.println("=======================");
	}
}
