package bkj_2407_조합; // 210324

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main { // 백준 2407번 : 조합 (DP)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[][] comb = new BigInteger[n+1][m+1]; // int, long 범위 초과하는 수 처리하기 위해 BigInteger형으로 선언
		comb[0][0] = new BigInteger("1");
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					comb[i][j] = new BigInteger("1");
					continue;
				}
				
				// nCm = (n-1)C(m-1) + (n-1)C(m) 개념 이용
				
				comb[i][j] = comb[i-1][j-1].add(comb[i-1][j]);
				
				if (j == m) { // j가 m 이상인 경우 더 이상 값 구할 필요 X
					break;
				}
			}
		}
		
		System.out.println(comb[n][m]);
	}
}