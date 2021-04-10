package bkj_1158_요세푸스_문제; // 210210

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 백준 1158번 : 요세푸스 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		int count = 1;
		while(!queue.isEmpty()) {
			count = 1;
			while(count < K) {
				queue.offer(queue.poll());
				count++;
			}
			sb.append(queue.poll());
			if (queue.size() >= 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}

}
