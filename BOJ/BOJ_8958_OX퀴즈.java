package bkj_8958_OX퀴즈; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 8958번 : OX퀴즈

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "X");
			
			int score = 0;
			
			while(st.hasMoreTokens()) {
				int length = st.nextToken().length();
				score += (length * (length + 1) / 2);
			}
			
			sb.append(score + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
