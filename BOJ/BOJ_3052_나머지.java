package bkj_3052_나머지; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 3052번 : 나머지

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] remainder = new int[42];
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			
			remainder[num % 42]++;
		}
		
		int count = 0;
		for(int i = 0; i < remainder.length; i++) {
			if (remainder[i] != 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
