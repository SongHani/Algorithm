package bkj_1202_보석_도둑; // 210328

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 백준 1202번 : 보석 도둑
	static class Jewelry implements Comparable<Jewelry> {
		int weight;
		int value;
		
		public Jewelry(int weight, int profits) {
			super();
			this.weight = weight;
			this.value = profits;
		}

		@Override
		public int compareTo(Jewelry o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석의 총 개수
		int K = Integer.parseInt(st.nextToken()); // 상덕이가 가지고 있는 가방의 개수
		Jewelry[] jewls = new Jewelry[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewls[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(jewls); // 보석의 무게 오름차순으로 정렬 (1, 2, 5)
		
		int[] bags = new int[K]; // 가방의 최대 수용 무게 저장
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags); // 가방의 무게 오름차순으로 정렬 (2, 10)
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 보석의 가치 내림차순 정렬
		
		int index = 0;
		long result = 0L;
		// 주의) N = K = 300,000 이고 모든 Vi = 1,000,000 이면 정답의 최댓값은 300,000,000,000으로 int 범위 2,147,483,647을 넘습니다.
		
		for(int i = 0; i < K; i++) {
			while(index < N && bags[i] >= jewls[index].weight) { // 가방에 담기는 무게의 보석은 전부 queue에 넣기
				queue.offer(jewls[index++].value);
			}
			
			if(!queue.isEmpty()) {
				result += queue.poll();
			}
		}
		System.out.println(result);
	}
}