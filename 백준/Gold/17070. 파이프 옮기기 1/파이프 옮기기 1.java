import java.util.Scanner;

public class Main {
	static int[][] map;
	static int n, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(answer);
	}
	private static void dfs(int r, int c, int state) {
		if(r >= n || c >= n || map[r][c] == 1) {
			return;
		}
//		System.out.println(r + " " + c);
		if(r == n-1 && c == n-1) {
			answer++;
			return;
		}
		
		
		switch (state) {
			case 0:
				if (r < n && c+1 < n && map[r][c+1] != 1) {
					dfs(r, c+1, 0);
				}
				if (r+1 < n && c+1 < n && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1) {
					dfs(r+1, c+1, 2);					
				}
				break;
				
			case 1:
				if (r+1 < n && c < n && map[r+1][c] != 1) {
					dfs(r+1, c, 1);					
				}
				if (r+1 < n && c+1 < n && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1) {
					dfs(r+1, c+1, 2);					
				}
				break;
				
			default:
				if (r < n && c+1 < n && map[r][c+1] != 1) {
					dfs(r, c+1, 0);					
				}
				if (r+1 < n && c < n && map[r+1][c] != 1) {
					dfs(r+1, c, 1);					
				}
				if (r+1 < n && c+1 < n && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1) {
					dfs(r+1, c+1, 2);					
				}
				break;
		}
	
	}

	
}