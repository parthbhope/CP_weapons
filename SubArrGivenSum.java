package templates;

import java.io.*;

public class SubArrGivenSum {
	static int t;
	static int n;
	static long k;
	static long arr[];
	static int[] nk;

	public static void main(String[] args) throws IOException {
		// array has non negative numbers output the first subarr with the given sum

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			nk = new int[2];
			int i = 0;
			for (String s : br.readLine().split(" ")) {
				nk[i++] = Integer.parseInt(s);
			}

			n = nk[0];
			k = nk[1];
			arr = new long[n];
			i = 0;
			for (String s : br.readLine().split(" ")) {
				arr[i++] = Integer.parseInt(s);
			}
			long sum = arr[0];
			boolean flag = false;
			int j = 0;
			for (i = 1; i <= n; i++) {// <=n for including the last ele

				while (sum > k && j < i - 1)
					sum -= arr[j++];

				if (sum == k) {
					System.out.println(j + " " + (i - 1));
					flag = true;
					break;
				}
				if (i < n)// to avoid exception
					sum += arr[i];
			}
			if (!flag)
				System.out.println("-1");
		}
	}

}
