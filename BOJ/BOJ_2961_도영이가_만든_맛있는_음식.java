package bkj_2961_도영이가_만든_맛있는_음식; // 210216

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 2961 : 도영이가 만든 맛있는 음식
	static int N;
	static int minDiff = Integer.MAX_VALUE;
	static int[] foodS, foodB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		foodS = new int[N];
		foodB = new int[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			foodS[i] = Integer.parseInt(st.nextToken());
			foodB[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSubset(1 << N);
		
		System.out.println(minDiff);
	}
	
	static void generateSubset(int caseCount) {
		for(int flag = 1; flag < caseCount; flag++) {
			int sumS = 1, sumB = 0;
			for(int j = 0; j < N; j++) {
				if ((flag & 1 << j) != 0) {
					sumS *= foodS[j];
					sumB += foodB[j];
				}
			}
			minDiff = Math.min(minDiff, (sumS > sumB)? sumS-sumB : sumB - sumS);
		}
	}
}
