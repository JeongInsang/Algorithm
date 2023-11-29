import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n, w, h, answer, brick;
	static int[][] map, copyMap;
	static int[] sel;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			sel = new int[n];
			brick = 0;
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) brick++;
				}
			}
			
			perm(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void perm(int idx) {  // 중복 순열 
		if(idx == n) {
			copyMap = copy();
//			for (int i = 0; i < h; i++) {
//				System.out.println(Arrays.toString(copyMap[i]));
//			}System.out.println();
			for (int i = 0; i < n; i++) {
				dropBrick(sel[i]);
			}
//			System.out.println(Arrays.toString(sel));
//			for (int i = 0; i < h; i++) {
//				System.out.println(Arrays.toString(copyMap[i]));
//			}System.out.println();
			int cnt = 0;  
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(copyMap[i][j] != 0) {
						cnt++;
					}
				}
			}
			answer = Integer.min(answer, cnt);  // 남은 벽돌 수 갱신 
			return;
		}
		
		for (int i = 0; i < w; i++) {
			sel[idx] = i;
			perm(idx+1);
		}
	}
	
	private static void dropBrick(int b) {  // 벽돌 떨어뜨리기 
		for (int i = 0; i < h; i++) {
			if(copyMap[i][b] != 0) {
				crush(i, b, copyMap[i][b]);
				break;
			}
		}
	}
	private static void crush(int row, int col, int range) {  // 벽돌 부수기 
		q = new ArrayDeque<int[]>();
		q.add(new int[] {row, col, range});
		copyMap[row][col] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int p = cur[2];
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < p; i++) {
					int nr = r + dr[d] * i;
					int nc = c + dc[d] * i;
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && copyMap[nr][nc] != 0){
						q.add(new int[] {nr, nc, copyMap[nr][nc]});
						copyMap[nr][nc] = 0;
					}
				}
			}
		}
		
		sort();
	}

	
	private static void sort() {  // 빈 공간 채우기 
		for (int row = h-2; row >= 0; row--) {
			for (int col = 0; col <	w; col++) {
				if(copyMap[row][col] != 0) {
					int r = row;
					for (int i = 0; i < h-1-row; i++) {
						int nr = r + 1;
						if(nr < h && copyMap[nr][col] == 0) {
							copyMap[nr][col] = copyMap[r][col];
							copyMap[r][col] = 0;
							r = nr;
						}
						else {
							break;
						}
					}
				}
			}
		}
	}
	
	private static int[][] copy() {
		int[][] temp = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			temp[i] = map[i].clone();
		}
		
		return temp;
	}
}
