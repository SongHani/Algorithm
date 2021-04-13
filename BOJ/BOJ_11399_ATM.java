package bkj_11399_ATM; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 11399번 : ATM
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		int minTime = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				minTime += P[j];
			}
		}
		System.out.println(minTime);
	}
}
