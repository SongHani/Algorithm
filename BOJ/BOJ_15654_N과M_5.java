package bkj_15654_N과M_5; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 15654 : N과 M (5) - 순열_입력ver.
	static int N, M;
	static int[] numbers, result;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		isSelected = new boolean[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		permutationInput(0);
		
		System.out.println(sb.toString());
	}
	static void permutationInput(int cnt) { 
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			
			result[cnt] = numbers[i];
			isSelected[i] = true;
			
			permutationInput(cnt+1);
			isSelected[i] = false;
		}
	}
}
