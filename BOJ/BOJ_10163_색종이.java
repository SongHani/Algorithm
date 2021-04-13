package bkj_10163_색종이; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 10163번 : 색종이

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] plane = new int[101][101];
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int startI = Integer.parseInt(st.nextToken()), startJ = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken()), width = Integer.parseInt(st.nextToken());
			
			for(int i = startI; i < startI + height; i++) {
				for(int j = startJ; j < startJ + width; j++) {
					plane[i][j] = n;
				}
			}
		}
		
		for(int n = 1; n <= N; n++) {
			int count = 0;
			for(int i = 0; i < plane.length; i++) {
				for(int j = 0; j < plane.length; j++) {
					if (plane[i][j] == n) {
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
