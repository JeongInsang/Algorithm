import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map, dis;
	static Queue<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			dis = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String[] str = sc.next().split(""); 
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			dis[0][0] = 0; 
			q = new ArrayDeque<int[]>();
			q.add(new int[] {0, 0});
			bfs();
			System.out.printf("#%d" + " " + dis[n-1][n-1], tc);
			System.out.println();
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if(dis[nr][nc] > dis[r][c] + map[r][c]) {
						dis[nr][nc] = dis[r][c] + map[r][c];
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
	}

}