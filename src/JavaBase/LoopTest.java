package JavaBase;

import java.io.*;
import java.util.*;

public class LoopTest {

	public LoopTest() {}

	public String LoopTest() {
		return "123";
	}



	public static void main(String[] args) {
		int arr[][] = {{1,2,3},{4,5,6,7},{9}};

		boolean found = false;

//		try {
//			for (int i = 0; i < arr.length && !found; i++) {
//				for (int j = 0; j < arr[i].length ; j++) {
//					System.out.println("i=" + i + "arr[i][j]" + arr[i][j] +",j=" + j);
//					if (arr[i][j] == 5) {
//						throw new Exception();
//					}
//				}
//			}
//		} catch (Exception e) {
//
//		}
//		ok:
//		for (int i = 0; i < arr.length ;i++ ) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.println(arr[i][j]);
//				if (j == 2) {
//
//					 break ok;
//				}
//			}
//		}

		LoopTest loopTest = new LoopTest();
		System.out.println(loopTest.LoopTest());

	}




}
