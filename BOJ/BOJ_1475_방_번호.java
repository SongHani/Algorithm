package bkj_1475_방_번호; // 210226

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 1475번 : 방 번호

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] set = new int[10];

		String N = br.readLine();
		int count = 0;

		for(int i = 0; i < N.length(); i++) {
			int index = Character.getNumericValue(N.charAt(i));

			set[index]++;
		}

		set[6] += set[9];

		if (set[6] % 2 != 0) {
			set[6]++;
		}

		set[6] /= 2;

		for(int i = 0; i < 9; i++) {
			count = Math.max(count, set[i]);
		}

		sb.append(count);

		System.out.println(sb.toString());
	}
}
