package bkj_17413_단어_뒤집기_2; // 210222

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main { // 백준 17413번 : 단어 뒤집기 2

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String res = br.readLine();

		Stack<Character> stack = new Stack<>();
		
		int i = 0;
		
		while(i < res.length()) {
			if (res.charAt(i) == '<') {
				while(res.charAt(i) != '>') {
					sb.append(res.charAt(i++));
				}
				sb.append(">");
				i++;
				continue;
			}
			
			while(i < res.length() && res.charAt(i) != '<') {
				if (res.charAt(i) == ' ') {
					i++;
					break;
				}
				stack.push(res.charAt(i++));
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			if (i < res.length() && res.charAt(i) != '<')
				sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
