package templates;

import java.util.*;
import java.io.*;

public class GroupAnagrams {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String strs[] = new String[n];
		for (int i = 0; i < n; i++)
			strs[i] = br.readLine();

		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char[] ss = strs[i].toCharArray();
			Arrays.sort(ss);
			String temp = String.valueOf(ss);
			if (map.containsKey(temp))
				map.get(temp).add(strs[i]);
			else {
				List<String> list = new LinkedList<>();
				list.add(strs[i]);
				map.put(temp, list);
			}
		}
		// ArrayList al;
		ArrayList al = new ArrayList<>(map.values());
		System.out.println(map.values());
		System.out.println(al);

	}

}

// 6
//eat 
//tea 
//tan
//nat 
//ate
//bat
