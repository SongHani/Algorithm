package bkj_3985_롤_케이크; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 3985번 : 롤 케이크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine()); // 롤 케이크의 길이
		int N = Integer.parseInt(br.readLine()); // 총 방청객 수
		
		int[] rollCake = new int[L+1];
		
		int expectNum = 0, expectAmount = 0, realNum = 0, realAmount = 0;
		int start = 1, end = L;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int j = start; j <= end; j++) {
				if (rollCake[j] == 0) {
					rollCake[j] = i;
					count++;
				}
			}
			
			if (expectAmount < end - start) {
				expectAmount = end - start;
				expectNum = i;
			}
			
			if (realAmount < count) {
				realAmount = count;
				realNum = i;
			}
		}
		
		System.out.println(expectNum + "\n" + realNum);
	}

}
