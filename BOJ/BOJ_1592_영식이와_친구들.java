package bkj_1592_영식이와_친구들; // 210219

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 1592번 : 영식이와 친구들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 한 사람당 받아야하는 공의 횟수
		int L = Integer.parseInt(st.nextToken()); // 공을 넘기는 폭
		
		int index = 1;
		int[] cntBall = new int[N+1];
		
		cntBall[index]++;
		
		while(true) {
			if (cntBall[index] % 2 == 0) { // 반시계 방향으로 이동
				index = (index - L) < 1? N-Math.abs(index-L) : index - L;
			} else { // 시계 방향으로 이동
				index = (index + L) > N? (index + L) - N : index + L;
			}
			
			cntBall[index]++;
			
			if (cntBall[index] == M) {
				break;
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += cntBall[i];
		}
		
		System.out.println(sum-1);
	}

}
