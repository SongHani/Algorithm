package bkj_15663_N과M_9; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 15663 : N과 M (9) - 순열_입력에 중복 수 포함 ver.
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
		
		permutationInputDuplc(0);
		
		System.out.println(sb.toString());
	}
	
	static void permutationInputDuplc(int cnt) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(); // 현재 찾으려는 자리 앞의 자리의 수들을 저장해놓은 list
		
		for(int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			
			int count = 0;
			
			for(int j = 0; j < list.size(); j++) {
				if (numbers[i] == list.get(j))
					count++;
			}
			
			if(count == 0) { // 중복이 없다면
				result[cnt] = numbers[i];
				isSelected[i] = true;
				
				list.add(numbers[i]);
				
				permutationInputDuplc(cnt+1);
				isSelected[i] = false;
			}

		}
	}

}
