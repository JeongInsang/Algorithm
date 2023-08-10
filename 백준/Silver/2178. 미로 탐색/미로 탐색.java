import java.util.*;
public class Main {
	static int N;
	static int M;
	static int[][] Array;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int min;
	static boolean[][] check;

	static class Point {
		int r;
		int c;
		int v;

		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;

		N = sc.nextInt();
		M = sc.nextInt();
		Array = new int[N+1][M+1];
		
		for (int i = 0; i < N; i++) {
			s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) - '0' == 1) {
					Array[i][j] = 1;

				}
			}
		}
		check = new boolean[N][M];

		int ans = Integer.MAX_VALUE;
		check[0][0] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0,1));

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == N-1 && p.c == M-1) {
				ans = Math.min(ans, p.v);
				break;
			}
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if((nr >= 0) && (nr < N) && (nc >= 0) && (nc < M) && !check[nr][nc]
						&& Array[nr][nc] != 0) {
					check[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.v+1));
				}
			}
		}
		System.out.println(ans);
	}

	private static void recursive(int r, int c, int cnt) {

		if ((r == N-1) && (c == M-1)) {
			min = Math.min(min, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if ((nr >= 0) && (nr < N) && (nc >= 0) && (nc < M)) {
				if (Array[nr][nc] != 0 && check[nr][nc] == false) {
					check[nr][nc] = true;
					recursive(nr, nc, cnt + 1);
					check[nr][nc] = false;
				}
			}
		}
	}
}