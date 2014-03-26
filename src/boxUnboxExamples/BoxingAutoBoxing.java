package boxUnboxExamples;

public class BoxingAutoBoxing {
	static Integer i1 = new Integer(3);
	static int i2 = 3;
	static Integer i3 = new Integer(3);
	
	static Integer i4 = 126 +126;
	static Integer i5 = 252;
	
	public static void main(String[] args) {
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
		System.out.println(i1.equals(i2));
		/* The equals method of Object class is overridden in the 
			Integer Class. This will compare the values and return true. 
		*/
		System.out.println(i1.equals(i3));
		
		System.out.println( i4 == i5);
		System.out.println( i4.equals(i5));
	}
}
