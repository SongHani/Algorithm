package bkj_1302_베스트셀러; // 210207

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main { //  백준 1302 : 베스트셀러
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		for(int i = 0; i < N; i++) {
			String bName = br.readLine();

			if(map.containsKey(bName)) {
				map.put(bName, map.get(bName) + 1);
			} else {
				map.put(bName, 1);
			}
		}

		List<String> keyList = new ArrayList<>(map.keySet());

		Collections.sort(keyList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) < map.get(o2)) {
					return 1;
				} else {
					if (map.get(o1) == map.get(o2)) {
						return o1.compareTo(o2);
					} else {
						return -1;
					}
				}
			}
		});
		System.out.println(keyList.get(0));
	}
}