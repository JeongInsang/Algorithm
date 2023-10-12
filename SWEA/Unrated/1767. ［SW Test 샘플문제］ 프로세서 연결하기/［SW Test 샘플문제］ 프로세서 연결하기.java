import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n, maxCore, minLine, lineCnt;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	static ArrayList<int[]> list;
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			list = new ArrayList<int[]>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1 && i != 0 && i != n-1 && j != 0 && j != n-1) {
						list.add(new int[] {i, j});
					}
				}
			}
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + minLine);
		}
		
	}
	private static void dfs(int idx, int core, int line) {
		
		if(idx == list.size()) {
			if(maxCore < core) {
				maxCore = core;
				minLine = line;
			}
			else if(maxCore == core){
				if(minLine > line) {
					minLine = line;
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(check(list.get(idx), i)) {
				connect(list.get(idx), i, 2);
				dfs(idx+1, core+1, line+lineCnt);
				connect(list.get(idx), i, 0);
			}
		}
		
		dfs(idx+1, core, line);
	}
	private static void connect(int[] core, int d, int val) {
		lineCnt = 0;
		int nr = core[0] + dr[d];
		int nc = core[1] + dc[d];
		while(nr >= 0 && nr < n && nc >= 0 && nc < n) {
			map[nr][nc] = val;
			nr += dr[d];
			nc += dc[d];
			lineCnt += 1;
		}
		
	}
	
	private static boolean check(int[] core, int d) {
		int nr = core[0] + dr[d];
		int nc = core[1] + dc[d];
		
		while(nr >= 0 && nr < n && nc >= 0 && nc < n) {
			if(map[nr][nc] == 0) {
				nr += dr[d];
				nc += dc[d];
			}
			else {
				return false;
			}
		}
		return true;
	}

}
