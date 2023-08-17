import java.util.*;

public class Solution {
	static int[][] map;
	static int n;
	static int answer;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static Queue<int[]> q = new LinkedList<int[]>();
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			answer = 1;
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					q.add(new int[] {i, j, map[i][j]});
					bfs();
				}
			}
			Collections.sort(nums);
			System.out.println("#" + tc + " " + nums.get(0) + " " + (answer+1));
			nums.clear();
		}
	}
	
	private static void bfs() {
		int move = 0;
		int num = q.peek()[2];
		
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == map[temp[0]][temp[1]] + 1) {
					move++;
					q.add(new int[] {nr, nc});
					temp[0] = nr;
					temp[1] = nc;
					break;
				}
			}
		}
		
		if(answer <= move) {
			if(move > answer) nums.clear();
			answer = move;
			nums.add(num);
		}
	}

}
