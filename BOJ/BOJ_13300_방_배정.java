package bkj_13300_방_배정; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 13300번 : 방 배정

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 총 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방에 최대로 넣을 수 있는 학생 수
		
		int[][] students = new int[7][2]; // students[1][0] : 1학년 여학생 수, students[1][1] = 1학년 남학생 수
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[grade][gender]++;
		}
		
		int count = 0;
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				if (students[i][j] > 0) {
					if (students[i][j] > K) {
						count += (students[i][j] / K);
						if (students[i][j] % K != 0) {
							count++;
						}
					} else {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
