package templates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knapsack {
	static int[][] dp;
	static int n, cap, i;
	static int[] w, profit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cap = Integer.parseInt(br.readLine());
		w = new int[n + 1];
		i = 1;
		for (String s : br.readLine().split(" ")) {
			w[i++] = Integer.parseInt(s);
		}
		i = 1;
		profit = new int[n+1];
		for (String s : br.readLine().split(" ")) {
			profit[i++] = Integer.parseInt(s);
		}
		dp = new int[n + 1][cap + 1];
		for (i = 0; i < cap + 1; i++) {
			dp[0][i] = 0;
		}

		for (int j = 1; j < n + 1; j++) {
			dp[j][0] = 0;
			for (int k = 1; k < cap + 1; k++) {
				if (w[j] <= k && (dp[j-1][k-w[j]]+profit[j] > dp[j-1][k])) {
					dp[j][k] = Math.max(dp[j - 1][k - w[j]] + profit[j], dp[j - 1][k]);
				} else {
					dp[j][k] = dp[j - 1][k];
				}
			}
		}
		for(int j =0;j<n+1;j++)
		System.out.println(Arrays.toString(dp[j]));
		System.out.println(dp[n][cap]);
	}

}
