import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, zero = 0, b = 3, answer = Integer.MIN_VALUE;
	static int[][] map, sel;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) zero++;
			}
		}
		sel = new int[3][2];
		combination(0, 0);
		
		System.out.println(answer);
	}
	
	
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int zeroCnt = zero;
			int[][] copyMap = copy(map);
			for (int i = 0; i < 3; i++) {
				int r = sel[i][0];
				int c = sel[i][1];
				if(copyMap[r][c] == 0) {
					copyMap[r][c] = 1;
					zeroCnt--;
				}
				else return;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copyMap[i][j] == 2) q.offer(new int[] {i, j});
				}
			}
			bfs(copyMap, zeroCnt);
			
		} else {
			for(int i = start; i < n * m; i++) {
				int r = i / m; 
				int c = i % m; 
				sel[cnt] = new int[] {r,c};
				combination(cnt+1, i+1);
			}
		}
		
	}

	public static int[][] copy(int[][] src) {
        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }
 
        return copy;
    }
	
	private static void bfs(int[][] map, int cnt) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					map[nr][nc] = 2;
					cnt--;
				}
			}
		}
		answer = Integer.max(answer, cnt);
	}
}
