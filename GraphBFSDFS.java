package templates;

import java.util.*;

public class GraphBFSDFS {
	static boolean visited[];
	static LinkedList<Integer> adj[];
	static Queue<Integer> q;
	static int start, nodes, edge;
	static int[] dist;
	static int[][] edges;

	static void bfs() {
		dist = new int[nodes + 1];
		visited = new boolean[nodes + 1];
		q = new LinkedList<>();
		adj = new LinkedList[nodes + 1];
		for (int i = 1; i < nodes + 1; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < edge; i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}

		visited[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i : adj[node]) {
				if (visited[i] == false) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[node] + 1;
				}
			}
		}

	}

	static void dfs(int s) {
		if (visited[s]) {
			return;
		}
		visited[s] = true;
		for(int i : adj[s])
		{
			//visited[i] = true;
			dist[i] = dist[s]+1;
			dfs(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nodes = sc.nextInt();
		edge = sc.nextInt();
		edges = new int[edge][2];
		for (int i = 0; i < edge; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			edges[i][0] = u;
			edges[i][1] = v;
		}
		start = sc.nextInt();
		bfs();
		System.out.println(Arrays.toString(dist));
		dist = new int[nodes + 1];
		visited = new boolean[nodes+1];
		dfs(start);
		System.out.println(Arrays.toString(dist));
	}
}
