import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, rgb, rb;
	static char[][] map;
	static boolean[][] rgbVisited, rbVisited ;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] str = sc.next().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		
		rgbVisited = new boolean[n][n];
		rbVisited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!rgbVisited[i][j]) {
					q.add(new int[] {i, j});
					rgbVisited[i][j] = true;
					bfs();
				}
				if(!rbVisited[i][j]) {
					q.add(new int[] {i, j});
					rbVisited[i][j] = true;
					bfs2();
				}
			}
		}
		System.out.println(rgb + " " + rb);
	}
	private static void bfs2() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !rbVisited[nr][nc]) {
					if(map[r][c] == 'R' || map[r][c] == 'G') {
						if(map[nr][nc] == 'R' || map[nr][nc] == 'G') {
							q.add(new int[] {nr, nc});
							rbVisited[nr][nc] = true;
						}
					}else {
						if(map[nr][nc] == map[r][c]) {
							q.add(new int[] {nr, nc});
							rbVisited[nr][nc] = true;
						}
					}
				}
			}
		}
		rb++;
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !rgbVisited[nr][nc] && map[r][c] == map[nr][nc]) {
					q.add(new int[] {nr, nc});
					rgbVisited[nr][nc] = true;
				}
			}
		}
		rgb++;
	}

}
