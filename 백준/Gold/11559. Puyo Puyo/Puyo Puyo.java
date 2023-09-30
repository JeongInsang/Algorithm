import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static int answer;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String[] str = sc.next().split("");
			for (int j = 0; j < 6; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		
		while(true) {
			flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j] != '.') {
						q.add(new int[] {i, j});
						crush(map[i][j]);
					}
				}
			}
			if(flag) {
				answer++;
				sort();				
			}
			else break;
		}
		System.out.println(answer);
		
	}
	private static void sort() {
		for (int row = 10; row >= 0; row--) {
			for (int col = 0; col < 6; col++) {
				if(map[row][col] != '.') {
					int r = row;
					for (int i = 0; i < 11-row; i++) {
						int nr = r + 1;
						if(nr < 12 && map[nr][col] == '.') {
							map[nr][col] = map[r][col];
							map[r][col] = '.';
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
	private static void crush(char puyo) {
		char[][] copy = mapCopy();
		int cnt = 1;
		
		copy[q.peek()[0]][q.peek()[1]] = '.';
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && copy[nr][nc] == puyo) {
					q.add(new int[] {nr, nc});
					copy[nr][nc] = '.';
					cnt++;
				}
			}
		}
		
		if(cnt >= 4) {
			map = copy;
			flag = true;
		}
	}
	private static char[][] mapCopy() {
		char[][] copyMap = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			copyMap[i] = map[i].clone();
		}
		return copyMap;
	}
}
