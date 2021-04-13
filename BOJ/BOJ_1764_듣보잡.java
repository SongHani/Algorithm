package bkj_1764_듣보잡; // 210328

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // 백준 1764번 : 듣보잡

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
		
		HashSet<String> see = new HashSet<>();
		
		List<String> result = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			see.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			
			if(see.contains(name)) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		
		sb.append(result.size() + "\n");
		
		for(String tmp : result) {
			sb.append(tmp + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
