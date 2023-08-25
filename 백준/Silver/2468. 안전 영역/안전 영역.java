import java.util.*;

public class Main {
	static int n, answer;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = -1;
		
		int[][] map = new int[n][n];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		for (int h = 0; h <= max; h++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] <= h) map[i][j] = 0;
				}
			}
			bfs(map);
		}
		System.out.println(answer);
	}
	private static void bfs(int[][] map) {
		
		int[][] copyMap = copy(map);
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(copyMap[i][j] != 0) {
					q.offer(new int[] {i, j});
					copyMap[i][j] = 0;
					
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int row = temp[0];
						int col = temp[1];
						
						for (int d = 0; d < 4; d++) {
							int nr = row + dr[d];
							int nc = col + dc[d];
							if(check(nr, nc) && copyMap[nr][nc] != 0) {
								q.offer(new int[] {nr, nc});
								copyMap[nr][nc] = 0;
							}
						}
					}
					cnt++;
					
				}
				
			}
		}
		answer = Math.max(answer, cnt);
		
	}
	
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < n && nc >= 0 && nc < n) return true;
		return false;
	}
	
	private static int[][] copy(int[][] map) {
		int[][] copy = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			copy[i] = map[i].clone();
		}
		
		return copy;
	}
}