import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		boolean[][] map = new boolean[100][100];
		
		for (int i = 0; i < 4; i++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rigthX = sc.nextInt();
			int rigthY = sc.nextInt();
			for (int row = leftX-1; row < rigthX-1; row++) {
				for (int col = leftY; col < rigthY; col++) {
					map[row][col] = true;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
