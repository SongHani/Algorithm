package bkj_13549_숨바꼭질_3; // 210215

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 백준 13549 : 숨바꼭질 3

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (N >= K) { // 11 5
			System.out.println(N-K + "\n");
		} else {
			Queue<Integer> queue = new LinkedList<>();
			int[] visitedTime = new int[100001];
			
			Arrays.fill(visitedTime, -1);
			
			queue.offer(N);
			visitedTime[N] = 0;
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				
				int time = 0, next;
				
				for(int i = 0; i < 3; i++) { // 큐에 넣는 순서 중요! 순간이동은 0초기 때문에, 우선순위가 높다고 보고 먼저 queue에 넣어줘야 함.
					if (i == 0) {
						next = current * 2;
						time = 0;
					} else if (i == 1) {
						next = current - 1;
						time = 1;
					} else {
						next = current + 1;
						time = 1;
					}
					
					if (next == K) {
						System.out.println(visitedTime[current] + time);
						return;
					}
					
					if (next >= 0 && next < visitedTime.length && visitedTime[next] ==  -1) {
						queue.offer(next);
						visitedTime[next] = visitedTime[current] + time;
					}
					
				}
			}
		}
		
	}

}
