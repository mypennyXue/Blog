package JavaBase;

import sun.rmi.runtime.Log;

public class SwitchTest {
	public static void main(String[] args) {
		char season1 = 3;
		byte season2 = 3;
		short season3 = 3;
		int season4 = 3;

		Character season11 = 3;
		Byte season22 = 3;
		Short season33 = 3;
		Integer season44 = 3;

		long seasonf5 = 3;
		double season6 = 3;
		float season7 = 3;
		boolean season8 = false;

		String strSeason = "";

		switch (strSeason) {

			case "":
				strSeason = "Spring";
				break;
			case "1":
				strSeason = "Summer";
				break;

			default:
				strSeason = "四季中没有这个季节";
				break;
		}
		System.out.println("strSeason :" + strSeason);

	}
}
