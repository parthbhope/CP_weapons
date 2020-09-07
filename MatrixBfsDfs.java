package templates;

import java.io.*;
import java.util.Arrays;

public class MatrixBfsDfs {
	static int n, m;
	static int[][] arr;
	static boolean visited[][];

	static int dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m)
			return 0;

		if (arr[i][j] == 0 || !visited[i][j])
			return 0;
		visited[i][j] = true;
		int sum = 1;
		for (int row = i - 1; row <= i + 1; row++) {
			for (int col = j - 1; col <= j + 1; col++) {
					sum += dfs(row, col);
				
			}
		}
		System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n][m];
		arr = new int[m][n];
		for (int i = 0; i < n; i++) {
			int j = 0;
			for (String s : br.readLine().split(" ")) {
				arr[i][j++] = Integer.parseInt(s);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		int max = 0;
		int localmax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j]==false) {
					localmax = dfs(i, j);
					max = Math.max(localmax, max);
				}
			}
		}
		System.out.println(max);
	}
}
