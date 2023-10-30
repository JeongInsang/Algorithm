import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, answer = Integer.MAX_VALUE;
	static int[][] map, sel;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean flag;
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] arr = sc.next().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		bfs();
		
		System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
	}

	private static void bfs() {
		boolean[][][] visited = new boolean[n][m][2];
		q = new ArrayDeque<int[]>();
		q.offer(new int[] {0, 0, 1, 0});
		visited[0][0][0] = true;
		int depth = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			depth = cur[2];
			int wall = cur[3];
//			System.out.println("r : " + row + " " + "c : " + col);
			if(row == n-1 && col == m-1) {
				answer = Integer.min(answer, depth);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && wall == 0) {
					if(map[nr][nc] == 1) {
						if(visited[nr][nc][wall+1]) continue;
						
						q.offer(new int[] {nr, nc, depth+1, wall+1});
						visited[nr][nc][wall+1] = true;
					}
					else {
						if(!visited[nr][nc][wall]) {
							q.offer(new int[] {nr, nc, depth+1, wall});
							visited[nr][nc][wall] = true;	
						}
					}
				}
				
				else if(nr >= 0 && nr < n && nc >= 0 && nc < m && wall == 1) {
					if(map[nr][nc] == 1) {
						continue;
					}
					else {
						if(!visited[nr][nc][wall]) {
							q.offer(new int[] {nr, nc, depth+1, wall});
							visited[nr][nc][wall] = true;							
						}
					}
				}
			}
		}
	}
}
