package bkj_1793_타일링; // 210324

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main { // 백준 1793번 : 타일링
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		
		BigInteger[] tile = new BigInteger[251]; // n의 범위가 250까지니까, 미리 만들어놓기
		tile[0] = new BigInteger("1");
		tile[1] = new BigInteger("1");
		
		for(int i = 2; i <= 250; i++) { // 점화식 : tile[n] = tile[n-2]x2 + tile[n-1]
			tile[i] = tile[i-2].multiply(new BigInteger("2")).add(tile[i-1]);
		}
		
		while(scan.hasNextInt()) {
			int n = Integer.parseInt(scan.nextLine().trim());
			System.out.println(tile[n]);
		}
		
		scan.close();
	}
}