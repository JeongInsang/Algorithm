import java.util.*;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static char[][] map;
	static int n, total;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == '1') {
					bfs(i, j);
//					print();
//					System.out.println();
				}
			}
		}
		System.out.println(total);
		Collections.sort(arr);
		for(int i : arr) System.out.println(i);
	}
 	

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i, j});
		map[i][j] = '0';
		total++;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '1') {
					q.offer(new int[] {nr, nc});
					map[nr][nc] = '0';
					cnt++;
				}
			}
		}
		arr.add(cnt);
	}
	
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
