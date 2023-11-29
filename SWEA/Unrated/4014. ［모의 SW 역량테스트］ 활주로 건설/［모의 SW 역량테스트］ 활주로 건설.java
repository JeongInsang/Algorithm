import java.util.Scanner;

public class Solution {
	static int n, x, answer;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			x = sc.nextInt();
			map = new int[n][n];
			answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < n; i++) {
				checkRow(i);
				checkCol(i);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void checkCol(int i) {
		boolean[] check = new boolean[n];
		for (int j = 0; j < n-1; j++) {
			if(map[j][i] == map[j+1][i]) {  // 앞, 뒤칸의 높이가 같으면 continue
				continue;
			} 
			else if(Math.abs(map[j][i] - map[j+1][i]) >= 2) {  // 앞, 뒤칸의 높이 차이가 2이상이면 return
				return;
			}
			else if(map[j][i] - map[j+1][i] == 1) {  // 내리막길 
				for (int k = j+2; k <= j+x; k++) {
					if(k >= n || map[j+1][i] != map[k][i] || check[k]) return;  // 경사로가 맵을 벗어나는 경우 or 앞, 뒤 칸의 높이가 경사로 길이만큼 같지 않으면 return
					check[k] = true;
				}
			}
			else if(map[j][i] - map[j+1][i] == -1) {  // 오르막길 
				for (int k = j; k >= j+1-x; k--) {
					if(k < 0 || map[j][i] != map[k][i] || check[k]) return;  // 경사로가 맵을 벗어나는 경우 or 앞, 뒤 칸의 높이가 경사로 길이만큼 같지 않으면 return
					check[k] = true;
				}
			}
		}
		answer++;
	}
	private static void checkRow(int i) {
		boolean[] check = new boolean[n];
		for (int j = 0; j < n-1; j++) {
			if(map[i][j] == map[i][j+1]) {  // 앞, 뒤칸의 높이가 같으면 continue
				continue;
			} 
			else if(Math.abs(map[i][j] - map[i][j+1]) >= 2) {  // 앞, 뒤칸의 높이 차이가 2이상이면 return
				return;
			}
			else if(map[i][j] - map[i][j+1] == 1) {  // 내리막길 
				for (int k = j+2; k <= j+x; k++) {
					if(k >= n || map[i][j+1] != map[i][k] || check[k]) return;  // 경사로가 맵을 벗어나는 경우 or 앞, 뒤 칸의 높이가 경사로 길이만큼 같지 않으면 return
					check[k] = true;
				}
			}
			else if(map[i][j] - map[i][j+1] == -1) {  // 오르막길 
				for (int k = j; k >= j+1-x; k--) {
					if(k < 0 || map[i][j] != map[i][k] || check[k]) return;  // 경사로가 맵을 벗어나는 경우 or 앞, 뒤 칸의 높이가 경사로 길이만큼 같지 않으면 return
					check[k] = true;
				}
			}
		}
		answer++;
	}

}
