package bkj_2999_비밀_이메일; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 2999번 : 비밀 이메일

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String enc = br.readLine();
		int N = enc.length();
		int limitIndex = (int)Math.sqrt(N);
		int R = 1, C = N; // R : j		C : i (행렬이 왜.. R이 행(i) 아닌감..)
		
		for(int i = limitIndex; i >= 1; i--) {
			if (N % i == 0) {
				R  = i;
				C = N / i;
				break;
			}
		}
		
		int index = 0;
		char[][] letter = new char[C][R];
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				letter[i][j] = enc.charAt(index++);
			}
		}
		
		for(int j = 0; j < R; j++) {
			for(int i = 0; i < C; i++) {
				sb.append(letter[i][j]);
				
			}
		}
		
		System.out.println(sb.toString());
	}
}
