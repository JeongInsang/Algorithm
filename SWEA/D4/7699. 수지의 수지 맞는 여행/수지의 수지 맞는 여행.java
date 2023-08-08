import java.util.*;

public class Solution {
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static char[][] map;
	private static int r, c,answer;
	private static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			r = sc.nextInt();
			c = sc.nextInt();
			visit = new boolean[26];
			answer = Integer.MIN_VALUE;
			map = new char[r][c];
			for (int i = 0; i < r; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			visit[map[0][0] - 65] = true;
			dfs(0, 0, 1);
			System.out.println("#" + tc + " " + answer);
			
		}
	}

	private static void dfs(int pr, int pc, int cnt) {
		answer = Math.max(answer, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nr = pr + dr[i];
			int nc = pc + dc[i];
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && !visit[map[nr][nc] - 65]) {
				visit[map[nr][nc] - 65] = true;
//				System.out.println(nr + " " + nc + " " + map[nr][nc] + " " + cnt);
				dfs(nr, nc, cnt+1);
//				System.out.println();
				visit[map[nr][nc] - 65] = false;
			}
		}
	}
}