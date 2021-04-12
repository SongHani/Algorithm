package bkj_12851_숨바꼭질_2; // 210214

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 백준 12851 : 숨바꼭질 2

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		boolean[] check = new boolean[100001]; // 방문했던 곳인지 체크
		int[] time = new int[100001]; // 동생을 잡는 최소 시간
		int[] way = new int[100001]; // 최소시간으로 동생을 잡는 방법의 수

		queue.offer(N);
		check[N] = true;
		way[N] = 1;

		while(!queue.isEmpty()) {
			int current = queue.poll();

			for(int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = current - 1;
				} else if (i == 1) {
					next = current + 1;
				} else {
					next = current * 2;
				}

				if (next >= 0 && next < check.length) {
					if (!check[next]) { // 가려는 곳이 방문한 적 없는 곳이면
						check[next] = true;
						time[next] = time[current] + 1;
						queue.offer(next);
						way[next] = way[current]; // 방문한 적 없는 곳이면 방법의 수도 늘리지 않음
					} else if (time[next] == time[current] + 1) { // 방문했던 곳이지만 이동 거리가 같은 경우 방법의 수 늘려주기
						way[next] += way[current];
					}
				}
			}
		}
		System.out.println(time[K] + "\n" + way[K]);
	}
}