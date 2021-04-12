package bkj_2567_색종이_2; // 210217

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 2567번 : 색종이 - 2
	static int[] checkI = {-1, 0, 1, 0}, checkJ = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int [][] paper = new int[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int indexJ = Integer.parseInt(st.nextToken());
			int indexI = Integer.parseInt(st.nextToken());
			
			for(int i = indexI; i < indexI + 10; i++) {
				for(int j = indexJ; j < indexJ + 10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		int border = 0;

		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 4; k++) {
					int moveI = i+checkI[k], moveJ = j+checkJ[k];
					if (paper[i][j] == 1) { // 색종이 영역일 때
						if (moveI == -1 || moveI == 100 || moveJ == -1 || moveJ == 100) { // 경계선 부분이면 둘레 길이 추가
							border++;
						}
					} else { // 아무것도 없는 영역일 때
						if (moveI < 0 || moveJ < 0 || moveI >= 100 || moveJ >= 100) { // 도화지 범위 초과하면 continue
							continue;
						}
						if (paper[moveI][moveJ] == 1) { // 사방탐색했을 때 색종이가 있으면 둘레 길이 추가
							border++;
						}
					}
				}
			}
		}

		System.out.println(border);
	}
}
