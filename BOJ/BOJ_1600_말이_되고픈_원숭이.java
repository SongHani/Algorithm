package bkj_1600_말이_되고픈_원숭이; // 210324

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 백준 1600번 : 말이 되고픈 원숭이
	static class Point {
		int i;
		int j;
		int move;
		int countK;
		
		public Point(int i, int j, int move, int countK) {
			super();
			this.i = i;
			this.j = j;
			this.move = move;
			this.countK = countK;
		}
	}
	static int K, W, H, map[][];
	static int[] hI = {-2, -1, 1, 2, 2, 1, -1, -2}, hJ = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dI = {-1, 0, 1, 0}, dJ = {0, 1, 0, -1};
	static boolean[][][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine()); // 원숭이는 말처럼 K번 이동 가능
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 격자판 가로 길이
		H = Integer.parseInt(st.nextToken()); // 격자판 세로 길이
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1]; // 원숭이처럼 움직인 곳과 말처럼 움직인 곳이 겹칠 수도 있기 때문에, 방문 체크는 따로 관리해야함.
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		if (sb.length() == 0) { // 도착 못했다면 -1 출력
			sb.append(-1);
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int currentI = p.i, currentJ = p.j;
			
			if (currentI == H-1 && currentJ == W-1) {
				sb.append(p.move);
				break;
			}
			
			for(int k = 0; k < 4; k++) { // 인접 방향으로 이동
				int nextI = currentI + dI[k], nextJ = currentJ + dJ[k];
				
				if (nextI < 0 || nextJ < 0 || nextI >= H || nextJ >= W) {
					continue;
				}
				
				if (visited[nextI][nextJ][p.countK]) {
					continue;
				}
				
				if (map[nextI][nextJ] == 1) { // 장애물이 있다면 
					continue;
				}
			
				queue.offer(new Point(nextI, nextJ, p.move + 1, p.countK)); // 인접한 방향으로 이동
				visited[nextI][nextJ][p.countK] = true;
			}

			if (p.countK < K) { // 아직 말처럼 K번만큼 이동하지 않았다면
				
				for(int m = 0; m < 8; m++) {
					int nextHI = currentI + hI[m], nextHJ = currentJ + hJ[m];
					
					if (nextHI < 0 || nextHJ < 0 || nextHI >= H || nextHJ >= W) {
						continue;
					}
					
					if (visited[nextHI][nextHJ][p.countK + 1]) { // 이미 countK+1번일 때 이 자리에 도착했다면, 그 때가 가장 빨랐을 때
						continue;
					}
					
					if (map[nextHI][nextHJ] == 1) { // 장애물이 있다면 
						continue;
					}
					
					queue.offer(new Point(nextHI, nextHJ, p.move + 1, p.countK + 1));
					visited[nextHI][nextHJ][p.countK+1] = true;
				}
			}
		}
	}
}