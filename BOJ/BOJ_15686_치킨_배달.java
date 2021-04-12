package bkj_15686_치킨_배달; // 210217

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // 백준 15686번 : 치킨 배달
	static int N, M, selectNum;
	static int minDistance = Integer.MAX_VALUE;
	static List<location> house = new ArrayList<>();
	static List<location> chicken = new ArrayList<>();
	static boolean[] check;
//	static int[] selectedChicken;
	
	static class location {
		int i, j;

		public location(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int temp;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					house.add(new location(i, j));
				}
				if (temp == 2) {
					chicken.add(new location(i, j));
				}
			}
		}
		
		check = new boolean[chicken.size()];
		
		for(int i = M; i >= 1; i--) { // 최대 M개의 치킨집을 고르니까, M개부터 최소 1개까지 줄여가며 조합 검색
			selectNum = i;
			combination(0, 0);
		}
		
		System.out.println(minDistance);
	}
	
	static void combination(int cnt, int start) {
		if (cnt == selectNum) {
			minDistance = Math.min(minDistance, getMin());
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			check[i] = true;
			combination(cnt+1, i+1);
			check[i] = false;
		}
	}
	
	static int getMin() {
		int count = 0, tmp;
		
		for(location house : house) {
			tmp = Integer.MAX_VALUE;
			for(int i = 0; i < chicken.size(); i++) {
				if (!check[i])
					continue;
				
				// 각 집에서 치킨집까지의 거리 중에서 제일 짧은 거리를 tmp에 저장
				tmp = Math.min(tmp, Math.abs(house.i - chicken.get(i).i) + Math.abs(house.j - chicken.get(i).j));
			}
			count += tmp; // 치킨 거리에 더함
			if (count > minDistance) // 지금까지의 치킨 거리가 현재 도시의 최소 치킨 거리보다 크면 더 이상 검색할 필요 X
				return count;
		}
		return count;
	}
}