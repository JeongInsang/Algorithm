import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int r, c, t, head, bottom;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		map = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) q.add(new int[] {i, j});
			}
		}
		
		head = q.poll()[0]; // 공기 청정기 위, 아래 구분 
		bottom = q.poll()[0];	
		
		for (int time = 0; time < t; time++) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(map[i][j] != -1 && map[i][j] != 0) {
						q.add(new int[] {i, j, map[i][j]});  // 미세먼지를 큐에 담음 
					}
				}
			}
			diffusion();  // 확산 
			wind();  // 공기청정기 가동
//			for (int i = 0; i < r; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			} System.out.println();
		}
		
		int answer = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] != -1) answer += map[i][j];
			}
		}
		System.out.println(answer);
	}
	private static void wind() {
		// 공기 청정기 위쪽(반시계방향 순환)
		for (int i = head-1; i >= 0; i--) {  // 왼쪽면 이동  
			if(map[i+1][0] != -1) map[i+1][0] = map[i][0];
		}
		for (int i = 1; i < c; i++) {  // 위쪽면 이동 
			map[0][i-1] = map[0][i];
		}
		for (int i = 1; i <= head; i++) {  // 오른쪽면 이동 
			map[i-1][c-1] = map[i][c-1];
		}
		for (int i = c-2; i > 0; i--) {  // 아랫면 이동 
			map[head][i+1] = map[head][i];
		} map[head][1] = 0;
		
		// 공기 청정기 아래쪽(시계방향 순환)
		for (int i = bottom+2; i < r; i++) {
			map[i-1][0] = map[i][0];
		}
		for (int i = 1; i < c; i++) {
			map[r-1][i-1] = map[r-1][i];
		}
		for (int i = r-2; i >= bottom; i--) {
			map[i+1][c-1] = map[i][c-1];
		}
		for (int i = c-2; i > 0; i--) {
			map[bottom][i+1] = map[bottom][i];
		} map[bottom][1] = 0;
	}
	private static void diffusion() {
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			int w = cur[2];
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != -1) {
					map[nr][nc] += w / 5;
					cnt++;
				}
			}
			map[row][col] -= cnt * (w / 5);
		}
	}

}