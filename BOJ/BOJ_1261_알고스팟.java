package bkj_1261_알고스팟; // 210324

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 백준 1261번 : 알고스팟
	static class Point implements Comparable<Point> {
		int i;
		int j;
		int breakWall;

		public Point(int i, int j, int breakWall) {
			super();
			this.i = i;
			this.j = j;
			this.breakWall = breakWall;
		}

		@Override
		public int compareTo(Point o) { // 오름차순으로 부순 벽의 갯수 정렬
			return this.breakWall - o.breakWall;
		}
	}
	
	static int N, M, maze[][];
	static boolean[][] visited;
	static int[] dI = {-1, 0, 1, 0}, dJ = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 미로 가로 크기
		N = Integer.parseInt(st.nextToken()); // 미로 세로 크기
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		bfs();
		
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(0, 0, 0)); // 시작점 넣기
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int currentI = p.i, currentJ = p.j;
			
			if (currentI == N-1 && currentJ == M-1) {
				sb.append(p.breakWall);
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int nextI = currentI + dI[k], nextJ = currentJ + dJ[k];
				
				if(nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M) { // 미로 밖이면
					continue;
				}
				
				if (visited[nextI][nextJ]) { // 방문한 곳이면
					continue;
				}
				
				if(maze[nextI][nextJ] == 1) { // 만약 이동하려는 곳이 벽이라면
					queue.offer(new Point(nextI, nextJ, p.breakWall + 1));
				} else {
					queue.offer(new Point(nextI, nextJ, p.breakWall));
				}
				
				visited[nextI][nextJ] = true;
			}
		}
	}
}