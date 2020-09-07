package templates;

import java.util.*;

public class DfsBfs {
	static int n;
	static LinkedList<Integer>[] adj;
	static boolean[] visited;
	static int[] level;

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int x : adj[v]) {
			if (!visited[x] ) {
				level[x] = level[v] + 1;
				dfs(x);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Write function for BFS
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		adj = new LinkedList[n + 1];
		visited = new boolean[n + 1];
		level = new int[n + 1];
		level[1] = 1;
		for (int i = 1; i < n + 1; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 1; i < n; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
		}
		sc.close();
		dfs(1);
		System.out.println(Arrays.toString(level));
	}

}
