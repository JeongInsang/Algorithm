import java.util.Scanner;

public class Main {
	static int k, num, dir;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[4][8];
		for (int i = 0; i < 4; i++) {  // 자성 정보 입력
			String[] str = sc.next().split("");
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		k = sc.nextInt();  // 자석의 회전 수
		num = 0;
		dir = 0;
		int answer = 0;
		
		for (int i = 0; i < k; i++) {  // 자석 번호, 회전 방향 입력
			num = sc.nextInt() - 1;
			dir = sc.nextInt();
			visited = new boolean[4];
			visited[num] = true;
			turn(num, dir);  // 회전

		}
		
		for (int i = 0; i < 4; i++) {
			if(arr[i][0] == 1) {
				answer += (int)Math.pow(2, i);
			}
		}
		System.out.println(answer);
		}
	
	private static void turn(int num, int dir) {
		int temp2 = arr[num][2];
		int temp6 = arr[num][6];
		
 		if(dir == 1) {  // 시계방향 회전
			int temp = arr[num][7];
			for (int d = 7; d >= 0; d--) {
				arr[num][d] = arr[num][(d+7) % 8];
			} arr[num][0] = temp;
		}
		
		else {  // 반시계 방향 회전
			int temp = arr[num][0];
			for (int d = 0; d < 8; d++) {
				arr[num][d] = arr[num][(d+1) % 8];				
			} arr[num][7] = temp;
		}
		
		int left = num - 1;  // 왼쪽 톱니바퀴
		int right = num + 1;  // 오른쪽 톱니바퀴
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

