package bkj_15651_N과M_3; // 210212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 15651 : N과 M (3) - 중복순열
	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[N];
		
		permutationRepet(0);
		
		System.out.println(sb.toString());
	}
	
	static void permutationRepet(int cnt) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " "); // 여기가 sysout이면 시간초과 오류남
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			result[cnt] = i;
			
			permutationRepet(cnt+1);
		}
	}

}
