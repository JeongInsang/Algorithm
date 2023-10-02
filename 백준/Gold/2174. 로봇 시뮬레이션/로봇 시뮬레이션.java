import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class robot{
		int num, row, col, dir;
		robot(int num, int row, int col, int dir) {	
			this.num = num;
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}
	
	static int r, c, n, cmd;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean flag = true;
	static ArrayList<robot> robots = new ArrayList<robot>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		n = sc.nextInt();
		cmd = sc.nextInt();
		map = new int[r][c];
		
		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			char d = sc.next().charAt(0);
			int dir = 0;
			if(d == 'S') dir = 3;
			else if(d == 'W') dir = 2;
			else if(d == 'N') dir = 1;
			robots.add(new robot(i, y, x, dir));
			map[y][x] = robots.get(i-1).num;
		}
		
//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}System.out.println();
		
		for (int i = 0; i < cmd; i++) {
			int num = sc.nextInt();
			char C = sc.next().charAt(0);
			int cnt = sc.nextInt();
			robot a = robots.get(num-1);
			flag = simulation(a, C, cnt);
//			System.out.println(a.dir);
			
			if(!flag) break;
			
		}
		
		if(flag) System.out.println("OK");
		

	}
	private static boolean simulation(robot a, char C, int cnt) {
		for (int j = 0; j < cnt; j++) {
			if(C == 'L') {
				a.dir = (a.dir + 1) % 4;  // 왼쪽으로 90도 회전 
			}
			else if(C == 'R') {
				a.dir = (a.dir + 3) % 4;  // 오른쪽으로 90도 회전 
			}
			else if(C == 'F'){
				int nr = a.row + dr[a.dir];
				int nc = a.col + dc[a.dir];
				if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if(map[nr][nc] == 0) {
						map[nr][nc] = a.num;
						map[a.row][a.col] = 0;
						a.row = nr;
						a.col = nc;
						
//						for (int i = 0; i < r; i++) {
//							System.out.println(Arrays.toString(map[i]));
//						}System.out.println();
					}
					else {
						System.out.printf("Robot %d crashes into robot %d", a.num, map[nr][nc]);
						return false;
					}
				}
				else {
					System.out.printf("Robot %d crashes into the wall", a.num);
					return false;
				}
			}
		}
		return true;
	}

}
//5 4
//2 2
//1 4 E
//5 4 W
//1 F 3
//2 F 1
