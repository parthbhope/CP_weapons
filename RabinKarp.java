package templates;

import java.util.*;

public class RabinKarp {
	static String t, s;
	static final long p = 31;
	static final long m = 1000000009;
	static long hashpat = 0;
	static long[] pows, pfxhash;

	static void calcpows(int n) {
		pows = new long[n];
		pows[0] = 1;
		for (int i = 1; i < n; i++)
			pows[i] = (pows[i - 1] * p) % m;
	}

	static long patternhash() {
		for (int i = 0; i < s.length(); i++) {
			hashpat = (hashpat + (s.charAt(i) - 'a' + 1) * pows[i]) % m;
		}
		return hashpat;
	}

	static void prefixhash(int n) {
		pfxhash = new long[n + 1];
		pfxhash[0]=0;
		//pfxhash[0] = t.charAt(0)-'a'+1;
		for (int i = 0; i < n; i++) {
			pfxhash[i + 1] = (pfxhash[i] + (t.charAt(i) - 'a' + 1) * pows[i]) % m;
		}
		System.out.println(Arrays.toString(pfxhash));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = new String(sc.nextLine());
		s = new String(sc.nextLine());
		if (t.length() < s.length())
			System.out.println("0 occurences as text is smaller than pattern");
		else {
			calcpows(t.length());
			long hs = patternhash();
			System.out.println("pattern hashval " + hs);
			prefixhash(t.length());
			for (int i = 0; i <= t.length() - s.length(); i++) {
				long substrhash = (pfxhash[i + s.length()] + m - pfxhash[i]) % m; 
				// substring hash value is scaled by p^i so mult p^i%m and pattern to compare
				System.out.println("comp pfh and ptrhash " + substrhash + " " + hs * pows[i] % m);
				if (substrhash == hs * pows[i] % m) {
					System.out.println(i + " " + t.substring(i, i + s.length()));
				}
			}
		}

	}

}
