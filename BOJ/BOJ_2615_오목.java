package bkj_2615_오목; // 210219

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 2615번 : 오목
	static int[] moveI = {-1, 0, 1, 1}, moveJ = {1, 1, 1, 0};
	static int[][] GO;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		GO = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				GO[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int win = 0;

		for(int i = 0; i < 19; i++) { // 검은색 : 1		흰색 : 2
			for(int j = 0; j < 19; j++) {
				if (GO[i][j] == 0)
					continue;
				
				for(int k = 0; k < 4; k++) {
					int beforeI = i - moveI[k], beforeJ = j - moveJ[k];

					if (beforeI < 0 || beforeI >= 19 || beforeJ < 0 || beforeJ >= 19 || GO[i][j] == GO[beforeI][beforeJ]) {
						continue;
					}

					win = check(i, j, k, GO[i][j]);
					if (win != 0) {
						System.out.println(win + "\n" + (i+1) + " " + (j+1));
						return;
					}
				}
			}
		}

		System.out.println(0);
	}

	static int check(int i, int j, int k, int num) {
		int count = 1, nextI = i, nextJ = j;

		while(true) {
			nextI += moveI[k]; nextJ += moveJ[k];

			if (nextI < 0 || nextJ < 0 || nextI >= 19 || nextJ >= 19)
				break;

			if (GO[nextI][nextJ] == num) {
				count++;
			} else
				break;
		}

		if (count == 5) {
			return num;
		}
		
		return 0;
	}
}
