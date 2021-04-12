package bkj_1931_회의실_배정; // 210216

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백준 1931 : 회의실 배정
	static class MeetingRoom implements Comparable<MeetingRoom> {
		int start, end;
		
		public MeetingRoom(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			return (diff != 0)? diff : (this.start - o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		MeetingRoom[] m = new MeetingRoom[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(getSchedule(m));
	}

	public static int getSchedule(MeetingRoom[] m) {
		Arrays.sort(m);
		
		int count = 1, index = 0;
		
		for (int i = index + 1; i < m.length; i++) {
			if (m[index].end <= m[i].start) {
				count++;
				index = i;
			}
		}
		
		return count;
	}
}
