package bkj_15650_N과M_2; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 15650 : N과 M (2) - 조합
	static int N, M;
	static int[] numbers, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		result = new int[M];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		combination(0, 0);
	}
	
	static void combination(int cnt, int start) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = numbers[i];
			
			combination(cnt+1, i+1);
		}
	}

}
