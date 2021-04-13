package bkj_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maxCount;
	static int[][] map;
	static List<Location> space; 
	static List<Location> virus;
	static Location[] newWall;
	
	static class Location {
		int i;
		int j;
		
		public Location(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		maxCount = Integer.MIN_VALUE;
		map = new int[N][M];
		space = new LinkedList<>();
		virus = new LinkedList<>();
		newWall = new Location[3]; // 벽은 꼭 3개 세워야 함.
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0 : 빈칸, 1 : 벽, 2 : 바이러스
				
				if (map[i][j] == 0) { // 벽을 세울 수 있는 빈칸의 위치를 list에 추가
					space.add(new Location(i, j));
				}
				
				if (map[i][j] == 2) {
					virus.add(new Location(i, j));
				}
			}
		}
		
		combination(0, 0);
		
		System.out.println(maxCount);
		
	}
	
	static void combination(int cnt, int start) {
		if (cnt == 3) {
			for(Location location : newWall) {
				map[location.i][location.j] = 1; // 벽 세워주기
			}
			
			bfs(); // 안전 영역 크기 찾으러 가기
			
			for(Location location : newWall) {
				map[location.i][location.j] = 0; // 벽 다시 없애주기
			}
			return;
		}
		
		for(int i = start; i  < space.size(); i++) {
			newWall[cnt] = space.get(i);
			combination(cnt+1, i+1);
		}
	}
	
	static int[] dI = {-1, 0, 1, 0}, dJ = {0, 1, 0, -1};
	
	static void bfs() { // 안전 영역 개수 구하기
		Queue<Location> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int spread = 0;
		
		for(int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i)); // 바이러스 위치 넣기
			
			while(!queue.isEmpty()) {
				Location current = queue.poll();
				visited[current.i][current.j] = true;
				
				for(int k = 0; k < 4; k++) {
					int nextI = current.i + dI[k], nextJ = current.j + dJ[k];
					
					if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M) {
						continue;
					}
					
					if (visited[nextI][nextJ])
						continue;
					
					if (map[nextI][nextJ] == 1) {
						continue;
					}
					
					if (map[nextI][nextJ] == 0) {
						spread++; // 바이러스 퍼지는 곳 세주기
						visited[nextI][nextJ] = true;
						queue.offer(new Location(nextI, nextJ));
					}
				}
			}
		}
		
		// 안전 영역 개수 구하기
		int safetyZone = space.size() - 3 - spread;
		
		maxCount = Math.max(maxCount, safetyZone);
	}
}