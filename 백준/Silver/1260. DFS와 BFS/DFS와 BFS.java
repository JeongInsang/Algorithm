import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, v;
	static int[][] graph;
	static boolean[] visitedBFS, visitedDFS;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		graph = new int[n+1][n+1];
		visitedBFS = new boolean[n+1];
		visitedDFS = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
	}
	private static void dfs(int v) {
		visitedDFS[v] = true;
		
		System.out.print(v + " ");
		for (int i = 1; i <= n; i++) {
			if(graph[v][i] == 1 && !visitedDFS[i]) dfs(i);
		}
	}
	private static void bfs(int v) {
		q.offer(v);
		visitedBFS[v] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 1; i <= n; i++) {
				if(graph[cur][i] == 1 && !visitedBFS[i]) {
					q.offer(i);
					visitedBFS[i] = true;
				}
			}
		}
	}

}
