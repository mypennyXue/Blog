package JavaBase;

public class IntegerTest {


	public static void main(String[] args) {
		Integer x = new Integer(123);
		Integer y = new Integer(123);
		System.out.println(x == y);
		Integer z = Integer.valueOf(123);
		Integer k = Integer.valueOf(123);
		System.out.println(z == k);
	}

}
