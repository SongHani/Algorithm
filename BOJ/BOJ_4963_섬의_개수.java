package bkj_4963_섬의_개수; // 210214

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 4963 : 섬의 개수
	static int[] moveI = {-1, -1, 0, 1, 1, 1, 0, -1}, moveJ = {0, 1, 1, 1, 0, -1, -1, -1};
	static int w, h; // w : 너비 (j)		h : 높이 (i)
	static int[][] map; // 1 : 땅		2 : 바다
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		while(true) {
			String tmp = br.readLine();
			if (tmp.equals("0 0")) 
				break;

			int landNum = 0;

			st = new StringTokenizer(tmp);

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			visited = new boolean[h][w];

			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) { // 현 위치가 방문하지 않은 땅이라면
						landNum++;
						visited[i][j] = true;
						searchLand(i, j);
					}
				}
			}
			sb.append(landNum + "\n");
		}
		System.out.println(sb.toString());
	}

	static void searchLand(int i, int j) {
		for(int k = 0; k < 8; k++) { // 섬의 위치 8방 탐색
			int nextI = i + moveI[k], nextJ = j + moveJ[k];

			if (nextI >= 0 && nextJ >= 0 && nextI < h && nextJ < w) { // 이동하려는 곳의 위치가 지도 범위 내
				if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) { // 이동하려는 곳이 방문하지 않은 땅이라면
					visited[nextI][nextJ] = true;
					searchLand(nextI, nextJ); // 이동한 위치부터 다시 탐색 시작
				}
			} 
		}
	}
}
