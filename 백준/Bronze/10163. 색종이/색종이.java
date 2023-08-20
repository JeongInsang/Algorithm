import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[1001][1001];
		int[] answer = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			int leftX = sc.nextInt();  // 2
			int leftY = sc.nextInt();  // 2
			int rigthX = sc.nextInt(); // 6
			int rigthY = sc.nextInt(); // 6
			for (int row = leftY; row < leftY + rigthY; row++) {
				for (int col = leftX; col < leftX + rigthX; col++) {
					map[row][col] = i;
				}
			}
		}
		for(int idx = 1; idx <= n; idx++) {
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(map[i][j] == idx) answer[idx]++;
				}
			}
			System.out.println(answer[idx]);
		}
	}

}
