package bkj_2164_카드_2; // 210210

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main { // 백준 2164번 : 카드2

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> card = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			card.offer(i);
		}
		
		while(card.size() != 1) {
			card.poll(); // 맨 위 카드 버리기
			card.offer(card.poll()); // 그 다음 카드 뽑아서 맨 밑에 옮기기
		}
		
		sb.append(card.poll());
		
		System.out.println(sb.toString());
	}

}
