package bkj_15649_N과M_1; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 15649 : N과 M (1) - 순열
	static int N, M;
	static int[] numbers, result;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		isSelected = new boolean[N];
		result = new int[M];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		permutation(0);
	}
	
	static void permutation(int cnt) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			
			result[cnt] = numbers[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			
			isSelected[i] = false;
		}
	}
}
