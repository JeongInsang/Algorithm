import java.util.*;

public class Solution {
	static int n, m;
	static int[] parents;
	
	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int x) {
		if(x == parents[x]) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	
	private static void union(int x, int y) {
		if(check(x, y)) return;
		
		parents[findSet(y)] = findSet(x);
	}
	
	private static boolean check(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		if(xRoot == yRoot) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n+1];
			make();
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				int cmd = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(cmd == 0) union(x, y);
				else {
					if(check(x, y)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}

}
