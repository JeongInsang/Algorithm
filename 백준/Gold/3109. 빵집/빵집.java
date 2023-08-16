import java.util.*;

public class Main {
	static int r, c, answer;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		for (int row = 0; row < r; row++) {
			flag = false;
			solving(row, 0);
		}
		
		
		System.out.println(answer);
		
	}
	
	private static void solving(int row, int col) {
		if(flag) return;
		
		if(col == c-1) {  // 빵집 도착
			answer++;
			flag = true;
//			for (int i = 0; i < r; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			} System.out.println();
			return;
		}
		for(int d = 0; d<3; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == '.' && !flag) {
				map[nr][nc] ='O';
				solving(nr, nc);
			}
		}
	}

}
