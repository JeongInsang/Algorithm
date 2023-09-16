import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] cheese;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean flag;
	
	static Queue<int[]> Q = new ArrayDeque<int[]>(); // 공기를 담을 큐
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		cheese = new int[n][m];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cheese[i][j] = sc.nextInt();
			}
		}
		
		Q.offer(new int[] {0, 0});
		cheese[0][0] = 2;  // 외부 공기(2), 내부 공기(0)
		bfs();
		
		while(true) {
			cheeseAddQ();  // 외부 공기에 접촉한 치즈를 큐에 담는 함수 
			
			if(!flag) break;  // 남은 치즈가 없다면 while문 종료 
			while(!Q.isEmpty()) {  // 외부 공기에 접촉한 치즈는 녹음 
				int[] t = Q.poll();
				cheese[t[0]][t[1]] = 2;
			}
			
			// 외부 공기에 접촉한 내부 공기를 2로 바꿔줌 
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(cheese[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr >= 1 && nr < n-1 && nc >= 1 && nc < m-1 && cheese[nr][nc] == 2) {
								Q.offer(new int[] {i, j});
								cheese[i][j] = 2;
								bfs();								
							}
						}
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

	private static void cheeseAddQ() {
		flag = false;  
		for (int i = 1; i < n-1 ; i++) {
			for (int j = 1; j < m-1; j++) {
				if(cheese[i][j] == 1) {
					flag = true; // 모눈종이에 치즈가 남아있다면 flag를 true로 변경 
					int cnt = 0;  // 외부 공기와 접촉한 변의 수
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(cheese[nr][nc] == 2) cnt++;
					}
					
					if(cnt >= 2) {  // 외부 공기와 접촉한 변이 2개 이상이면 큐에 담음 
						Q.add(new int[] {i, j});
					}
				}
			}
		}
		
	}
	
	private static void bfs() {	
		while(!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && cheese[nr][nc] == 0) {
					Q.offer(new int[] {nr, nc});
					cheese[nr][nc] = 2;
				}
			}
		}
		
	}
	
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(cheese[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
}

//8 9
//0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0
//0 1 1 0 0 0 1 1 0
//0 1 0 1 1 1 0 1 0
//0 1 0 0 1 0 0 1 0
//0 1 0 1 1 1 0 1 0
//0 1 1 0 0 0 1 1 0
//0 0 0 0 0 0 0 0 0
