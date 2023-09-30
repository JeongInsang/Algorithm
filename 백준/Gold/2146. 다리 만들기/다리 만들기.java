import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, answer = Integer.MAX_VALUE;
	static int[][] map;
	static int island = 2;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					q.add(new int[] {i, j});
					map[i][j] = island;
					bfs();
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					q.add(new int[] {i, j, 0});
					bfs2(map[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void bfs2(int num) {
		boolean[][] visited = new boolean[n][n];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int depth = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if(map[nr][nc] == 0 && !visited[nr][nc]) {
						q.add(new int[] {nr, nc, depth+1});
						visited[nr][nc] = true;						
					}
					else if (map[nr][nc] != 0 && map[nr][nc] != num){
//						System.out.println("r c = " + r + " " + c + " nr nc =  " + nr + " " + nc);
						answer = Integer.min(answer, depth);
					}
				}
			}
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
				if(nr>=0&&nr<n&&nc>=0&&nc<n&&map[nr][nc]==1) {
					q.add(new int[] {nr, nc});
					map[nr][nc] = island;
				}
			}
		}
		island++;
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		} System.out.println();
	}

}
