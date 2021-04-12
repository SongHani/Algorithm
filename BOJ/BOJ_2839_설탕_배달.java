package bkj_2839_설탕_배달; // 210216

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 2839 : 설탕 배달
	static int N, numBags = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		delivery();
		sb.append(numBags);

		System.out.println(sb.toString());
	}

	static void delivery() {

		int max5kg = N / 5; // 5kg로만 배달했을 때 가질 수 있는 봉지의 최대 갯수
		int num3kg, count = 0;
		boolean check = false;

		for(int i = 0; i <= max5kg; i++) {
			if ((N - 5 * i) % 3 == 0) { // 5kg 배달하고 남은 kg이 3kg의 배수일 때
				num3kg = (N-5*i) / 3; // 3kg로 배달 할 수 있는 봉지의 갯수
				count = (i + num3kg);
				numBags = Math.min(count, numBags);
				check = true;
			}
		}

		if (!check) {
			numBags = -1;
		}
	}
}
