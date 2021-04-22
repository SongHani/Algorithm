package 신규_아이디_추천; // 210328

public class Solution { // 프로그래머스 : 신규 아이디 추천 
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        
        // 1단계) 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2단계) 소문자  숫자  -  _  . 제외 모두 빼기
        String id = "";
        
        for(int i = 0; i < new_id.length(); i++) {
        	char ch = new_id.charAt(i);
        	
        	if (ch >= 'a' && ch <= 'z') {
        		id += String.valueOf(ch);
        	} else if (ch >= '0' && ch <= '9') {
        		id += String.valueOf(ch);
        	} else if (ch == '-' || ch == '_' || ch == '.') {
        		id += String.valueOf(ch);
        	}
        }
        
        // 3단계) .가 2번 이상 연속된 부분 하나의 마침표로 치환
        for(int i = 0; i < id.length(); i++) {
        	if (id.charAt(i) == '.') {
        		int j = i+1;
        		String dot = ".";
        		
        		while(j != id.length() && id.charAt(j) == '.') {
        			dot += ".";
        			j++;
        		}
        		
        		if (dot.length() >= 2) {
        			id = id.replace(dot, ".");
        		}
        	}
        }
        
        // 4단계) .가 처음이나 끝에 있다면 제거
        if (id.charAt(0) == '.') {
        	id = id.substring(1, id.length());
        }
        if (id.length() > 0 && id.charAt(id.length()-1) == '.') {
        	id = id.substring(0, id.length()-1);
        }
        
        // 5단계) 빈 문자열이라면 a 대입
        if (id.length() == 0) {
        	id += "a";
        }
        
        // 6단계) 길이가 16자 이상이라면, 처음 15개까지만 남기기. 제거 후 마지막에 . 있다면 제거
        if (id.length() >= 16) {
        	id = id.substring(0, 15);
        }
        if (id.length() > 0 && id.charAt(id.length()-1) == '.') {
        	id = id.substring(0, id.length()-1);
        }
        
        // 7단계) 길이가 2자 이하라면, 마지막 문자를 3이 될 때까지 반복
        if (id.length() <= 2) {
        	while(id.length() < 3) {
        		id += id.charAt(id.length()-1);
        	}
        }
        
        answer = id;
        
        return answer;
    }
}