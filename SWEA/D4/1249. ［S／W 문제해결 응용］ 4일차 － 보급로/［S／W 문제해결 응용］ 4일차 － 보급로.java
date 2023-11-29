import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int n, answer;
	static int[][] map, arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(arr[i], Integer.MAX_VALUE);
			}
			arr[0][0] = 0;
			dfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void dfs(int r, int c) {
		if(r == n-1 && c == n-1) {
			answer = Integer.min(answer, arr[r][c]);
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			int cost = 0;
			if(nr>=0 && nr<n && nc>=0 && nc<n) {
				cost = map[nr][nc];
				if(cost + arr[r][c] < arr[nr][nc]) {
					arr[nr][nc] = cost + arr[r][c];
					dfs(nr, nc);
				}
			}
		}
	}

}
