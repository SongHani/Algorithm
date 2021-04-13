package bkj_2941_크로아티아_알파벳; // 210223

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 2941번 : 크로아티아 알파벳

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i = 0, count = 0;
		
		String res = br.readLine();
		
		for(i = 0; i < res.length(); i++) {

			count++;

			switch(res.charAt(i)) {
				case 'c' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == '=' || res.charAt(i+1) == '-') {
							i++;
						}
					}
					break;
				case 'd' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == 'z') {
							if (i < res.length() - 2) {
								if (res.charAt(i+2) == '=') {
									i += 2;
								}
							}
						} else if (res.charAt(i+1) == '-') {
							i++;
						}
					}
					break;
				case 'l' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == 'j') {
							i++;
						}
					}
					break;
				case 'n' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == 'j') {
							i++;
						}
					}
					break;
				case 's' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == '=') {
							i++;
						}
					}
					break;
				case 'z' :
					if (i < res.length() - 1) {
						if (res.charAt(i+1) == '=') {
							i++;
						}
					}
					break;
				}
		}
		
		System.out.println(count);
	}
}
