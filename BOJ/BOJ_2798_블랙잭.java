package bkj_2798_블랙잭; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 2798번 : 블랙잭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 카드 갯수
		int M = Integer.parseInt(st.nextToken()); // 3장의 카드의 합이 넘으면 안되는 수
		
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int maxSum = 0;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i+1; j < N - 1; j++) {
				for(int k = j+1; k < N; k++) {
					sum = cards[i] + cards[j] + cards[k];
					
					if (sum == M) {
						System.out.println(sum);
						return;
					} else if (sum < M) {
						maxSum = Math.max(maxSum, sum);
					}
				}
			}
		}
		
		System.out.println(maxSum);
	}

}
