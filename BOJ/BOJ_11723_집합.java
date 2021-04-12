package bkj_11723_집합; // 210215

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 11723 : 집합
	static int flag;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		String operation;
		int x;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			operation = st.nextToken();
			
			if (operation.equals("add")) {
				x = Integer.parseInt(st.nextToken());
				add(x);
			} else if (operation.equals("remove")) {
				x = Integer.parseInt(st.nextToken());
				remove(x);
			} else if (operation.equals("check")) {
				x = Integer.parseInt(st.nextToken());
				check(x);
			} else if (operation.equals("toggle")) {
				x = Integer.parseInt(st.nextToken());
				toggle(x);
			} else if (operation.equals("all")) {
				all();
			} else if (operation.equals("empty")) {
				empty();
			}
		}
		System.out.println(sb.toString());
	}
	static void add(int x) { 
		if ((flag & 1 << x) == 0) { // 없다면
			flag |= 1 << x; // 플래그 추가
		}
	}
	
	static void remove(int x) {
		if ((flag & 1 << x) != 0) { // 있다면
			flag &= (~(1 << x)); // 플래그 삭제
		}
	}
	
	static void check(int x) { // check 연산이 주어질 때마다 결과 출력할 것
		if ((flag & 1 << x) != 0) { // 있다면
			sb.append("1\n");
		} else { // 없다면
			sb.append("0\n");
		}
	}
	
	static void toggle(int x) {
		if ((flag & 1 << x) != 0) { // 있다면
			flag &= (~(1 << x)); // 플래그 삭제
		} else { // 없다면
			flag |= 1 << x; // 플래그 추가
		}
	}
	
	static void all() {
		flag = (1 << 21) - 1; 
	}
	
	static void empty() {
		flag = 0;
	}
}
