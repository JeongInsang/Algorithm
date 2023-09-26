import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, zero, time, answer = Integer.MAX_VALUE;
	static int[][] map, sel;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) map[i][j] = -1;
				else if(map[i][j] != -1) zero++;
			}
		}
		
		sel = new int[m][2];
		combination(0, 0);
		
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer-1);
	}

	private static void combination(int cnt, int start) {
		if(cnt == m) {
			int zeroCnt = zero;
			boolean[][] visited = new boolean[n][n];
			
			for (int i = 0; i < m; i++) {
				int r = sel[i][0];
				int c = sel[i][1];
				q.offer(new int[] {r, c, 0});
				visited[r][c] = true;
				zeroCnt--;
			}
			bfs(zeroCnt, visited);
			return;
		} else {
			for(int i = start; i < n * n; i++) {
				int r = i / n; 
				int c = i % n;
				if(map[r][c] == 2) {
					sel[cnt] = new int[] {r, c, 0};
					combination(cnt+1, i+1);					
				}
			}
		}
	}
	
	private static void bfs(int cnt, boolean[][] visited) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			time = cur[2] + 1;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && (map[nr][nc] != -1 && !visited[nr][nc])) {
					q.offer(new int[] {nr, nc, time});
					visited[nr][nc] = true;
					cnt--;
				}
			}
		}
		if(cnt <= 0) answer = Integer.min(answer, time);
	}
}
