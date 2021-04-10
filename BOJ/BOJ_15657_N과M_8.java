package bkj_15657_N과M_8; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 15657 : N과 M (8) - 중복순열_비내림차순_입력ver.
	static int N, M;
	static int[] numbers, result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		permutationRepetNondescInput(0, 0);
		
		System.out.println(sb.toString());
	}
	static void permutationRepetNondescInput(int cnt, int start) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = numbers[i];
			permutationRepetNondescInput(cnt+1, i);
		}
	}
}
