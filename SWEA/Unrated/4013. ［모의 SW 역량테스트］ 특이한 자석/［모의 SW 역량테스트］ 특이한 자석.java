import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int k, num, dir;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			k = sc.nextInt();  // 자석의 회전 수
			arr = new int[4][8];
			num = 0;
			dir = 0;
			int answer = 0;
			for (int i = 0; i < 4; i++) {  // 자성 정보 입력
				for (int j = 0; j < 8; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < k; i++) {  // 자석 번호, 회전 방향 입력
				num = sc.nextInt() - 1;
				dir = sc.nextInt();
				visited = new boolean[4];
				visited[num] = true;
				turn(num, dir);

			}
			
			for (int i = 0; i < 4; i++) {
				if(arr[i][0] == 1) {
					if(i == 0) answer += 1;
					else if (i == 1) answer += 2;
					else if (i == 2) answer += 4;
					else answer += 8;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void turn(int num, int dir) {
		int temp2 = arr[num][2];
		int temp6 = arr[num][6];
		
 		if(dir == 1) {
			int temp = arr[num][7];
			for (int d = 7; d >= 0; d--) {
				arr[num][d] = arr[num][(d+7) % 8];
			} arr[num][0] = temp;
		}
		
		else {
			int temp = arr[num][0];
			for (int d = 0; d < 8; d++) {
				arr[num][d] = arr[num][(d+1) % 8];				
			} arr[num][7] = temp;
		}
		
		int left = num - 1;
		int right = num + 1;
		if(left >= 0 && !visited[left] && temp6 != arr[left][2]) {
			visited[left] = true;
			turn(left, dir*-1);
		}
		
		if(right < 4 && !visited[right] && temp2 != arr[right][6]) {
			visited[right] = true;
			turn(right, dir*-1);
		}
	}

}

