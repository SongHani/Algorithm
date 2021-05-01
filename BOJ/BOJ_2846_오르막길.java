import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 { // 210501
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] path = new int[N]; // 길의 높이를 저장해놓은 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
		
		int start =  0, end = 0, diff = 0;
		
		int i = 0;
		while(i < N-1) {
			if(path[i] < path[i+1]) {
				start = i;
				
				int k = i;
				while(path[k] < path[k+1]) {
					k++;
					if(k == N-1)
						break;
				}
				end = k;
				diff = Math.max(diff, path[end]-path[start]);
				i = end;
			}
			i++;
		}
		
		System.out.println(diff);
		
	}
}