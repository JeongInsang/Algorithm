import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[100][100];
		int n = sc.nextInt();
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			int left = sc.nextInt();
			int rigth = sc.nextInt();
			
			for (int l = left-1; l < left+9; l++) {
				for (int r = rigth-1; r < rigth+9; r++) {
					map[l][r] = true;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]) answer++;
			}
		}
		System.out.println(answer);
	}

}
