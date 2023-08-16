import java.util.*;

public class Main {
	static int n, W, B;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		recursive(0, 0, n);
		System.out.println(W);
		System.out.println(B);
		
	}
	
	private static void recursive(int r, int c, int size) {
		if(checkNum(r, c, size)) {
			if(map[r][c] == 1) B++;
			else W++;
			return;
		}
		
		size /= 2;
		recursive(r, c, size);
		recursive(r, c+size, size);
		recursive(r+size, c, size);
		recursive(r+size, c+size, size);
	}
	
	private static boolean checkNum(int r, int c, int size) {
		int firstNum = map[r][c];
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(firstNum != map[i][j]) return false;
			}
		}
		return true;
	}
}
