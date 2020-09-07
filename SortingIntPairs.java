package templates;

import java.util.*;

public class SortingIntPairs {
	static class Pair implements Comparable<Pair> {
		int i, j;

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.i == p.i)
				return this.j - p.j;
			return this.i - p.i;
		}

	}

	static ArrayList<Pair> al;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int h = sc.nextInt();
				int k = sc.nextInt();
				al.add(new Pair(h, k));
			}
			Collections.sort(al);
			int x = 0, y = 0;
			StringBuilder sb = new StringBuilder();
			boolean flag = true;
			for (Pair p : al) {
				if (p.i >= x && p.j >= y) {
					for (int r = 0; r < p.i - x; r++)
						sb.append("R");
					for (int u = 0; u < p.j - y; u++)
						sb.append("U");
					x = p.i;
					y = p.j;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == false)
				System.out.println("NO");
			else
				System.out.println("YES \n" + sb.toString());

		}
	}

}
