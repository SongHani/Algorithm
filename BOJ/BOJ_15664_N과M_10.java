package bkj_15664_N과M_10; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 15664 : N과 M (10) - 조합_입력에 중복 수 포함 ver.
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
		
		combinationInputDuplc(0, 0);
		
		System.out.println(sb.toString());
	}
	
	static void combinationInputDuplc(int cnt, int start) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = start; i < N; i++) {
			int count = 0;
			
			for(int j = 0; j < list.size(); j++) {
				if (numbers[i] == list.get(j)) {
					count++;
				}
			}
			
			if (count == 0) {
				result[cnt] = numbers[i];
				list.add(numbers[i]);
				combinationInputDuplc(cnt+1, i+1);
			}
		}
	}
}
