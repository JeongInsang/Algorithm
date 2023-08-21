import java.util.*;

public class Main {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visitedDFS, visitedBFS;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		// 인접행렬 사용 DFS, BFS
		arr = new int[N+1][N+1];
		visitedDFS = new boolean[N+1];
		visitedBFS = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}

	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		visitedBFS[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[temp][i] == 1 && !visitedBFS[i]) {
					q.offer(i);
					visitedBFS[i] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visitedDFS[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if(arr[v][i] == 1 && !visitedDFS[i]) {
				dfs(i);
			}
		}
	}

}
