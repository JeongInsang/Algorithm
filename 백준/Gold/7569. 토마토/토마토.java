import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, h, answer, cnt;
	static int[][][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] dh = {1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();  // 가로
		n = sc.nextInt();  // 세로
		h = sc.nextInt();  // 높이
		map = new int[n][m][h];
		
		for (int H = h-1; H >= 0; H--) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j][H] = sc.nextInt();
					if(map[i][j][H] == 1) q.add(new int[] {i, j, H, 0});
					else if(map[i][j][H] == 0) cnt++;
				}
			}
		}
		
		bfs();
		System.out.println(cnt == 0? answer:-1);
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0], col = cur[1], H = cur[2], depth = cur[3];
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc][H] == 0) {
					map[nr][nc][H] = 1;
					q.add(new int[] {nr, nc, H, depth+1});
					cnt--;
				}
			}
			
			for (int d = 0; d < 2; d++) {
				int nh = H + dh[d];
				if(nh >= 0 && nh < h && map[row][col][nh] == 0) {
					map[row][col][nh] = 1;
					q.add(new int[] {row, col, nh, depth+1});
					cnt--;
				}
			}
			
			answer = depth;
		}
	}

}
