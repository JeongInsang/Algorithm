import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n, k, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			visited = new boolean[n][n];
			answer = 0;
			int high = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					high = Integer.max(high, map[i][j]);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] == high) {
						visited[i][j] = true;
						dfs(i, j, 1, 0);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void dfs(int r, int c, int depth, int cut) {
		answer = Integer.max(answer, depth);
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]) {
				if(map[r][c] > map[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, depth+1, cut);
					visited[nr][nc] = false;
				}
				else if(cut == 0) {
					for (int i = 1; i <= k; i++) {
						if(map[r][c] > map[nr][nc] - i) {
							map[nr][nc] -= i;
							visited[nr][nc] = true;
							dfs(nr, nc, depth+1, cut+1);
							map[nr][nc] += i;
							visited[nr][nc] = false;							
						}
					}
				}
			}
		}
	}

}
