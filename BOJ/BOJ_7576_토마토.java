import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 { // 210414 _ BFS
	static int M, N;
	static int[][] box;
	static int[] dI = {-1, 0, 1, 0}, dJ = {0, 1, 0, -1}; // 인접한 방향 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수 j
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수 i
		
		box = new int[N][M]; // 토마토를 담을 상자 배열
		
		for(int i = 0; i < N; i++) { // 1 = 익은 토마토, 2 = 익지 않은 토마토, -1 = 토마토 없는 칸
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M]; // 방문 체크 배열
		int day = 0, notRipen = 0, makeRipen = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) { // 익은 토마토의 위치를 queue에 offer
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				} else if (box[i][j] == 0) { // 익어야 하는 토마토의 개수 counting
					notRipen++;
				}
			}
		}
		
		if(notRipen == 0) { // 익혀야 할 토마토가 없으면 그냥 0 출력
			System.out.println(0);
			return;
		}
		
		int size = 0;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			
			while(--size >= 0) {
				int[] currentTomato = queue.poll();
				
				int currentI = currentTomato[0], currentJ = currentTomato[1];
				
				for(int k = 0; k < 4; k++) {
					int nextI = currentI + dI[k], nextJ = currentJ + dJ[k];
					
					if(nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M) // 상자 범위 초과
						continue;
					
					if(visited[nextI][nextJ]) // 이미 확인한 적 있음
						continue;
					
					if(box[nextI][nextJ] == -1) // 인접한 방향에 토마토가 없음
						continue;
					
					queue.offer(new int[] {nextI, nextJ});
					makeRipen++; // 익게 만든 토마토 개수를 counting
					visited[nextI][nextJ] = true;
				}
			}
			day++;
			
			if (makeRipen == notRipen) { // 모든 토마토를 익혔다면 (예제 입력 4, 5)
				System.out.println(day);
				return;
			} 
		}
		
		System.out.println(-1);
	}
}