package JavaBase;

public class Ortest {
	public static void main(String[] args) {
		boolean right = true;
		boolean left = false;
		String str = null;

		if (left && str.equals("")) {
			System.out.println("&& true");
		}

		int a = 1;
		int b = 2;

		System.out.println(a & b);

		if (left & str.equals("")) {
			System.out.println("& true");
		}
	}
}
