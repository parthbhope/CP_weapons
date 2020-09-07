package templates;

import java.io.*;

public class PrimeSieve {

	static long[] nos;
	static boolean[] isprime;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nos = new long[n + 1];

		isprime = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nos[i] = i;
		}
		for (int i = 2; i <= n; i++) {
			isprime[i] = true;

		}
		isprime[0] = false;
		isprime[1] = false;
		for (int i = 2; i * i < n + 1; i++) {
			if (isprime[i]) {
				for (int p = i * i; p < n + 1; p += i) {
					isprime[p] = false;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (isprime[i])
				System.out.print(nos[i] + " ");
		}
	}

}
