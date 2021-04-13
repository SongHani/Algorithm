package bkj_12865_평범한_배낭; // 210328

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 12865번 : 평범한 배낭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 배낭의 무게
		
		int[][] items = new int[N+1][2]; // items[i][0] : 무게, items[i][1] : 가치
		int[][] D = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if (items[i][0] > w) {
					D[i][w] = D[i-1][w];
				} else {
					D[i][w] = Math.max(D[i-1][w], D[i-1][w-items[i][0]] + items[i][1]);
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
