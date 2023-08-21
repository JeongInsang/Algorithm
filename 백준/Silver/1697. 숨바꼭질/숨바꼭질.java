import java.util.*;

public class Main {
	static int n, k, depth;
	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		q.offer(new int[] {n, depth});
		visited[n] = true;
		
		bfs();
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp[0] == k) {
				System.out.println(temp[1]);
				break;
			}
			if(temp[0]*2 < visited.length && !visited[temp[0]*2]) {
				q.offer(new int[] {temp[0]*2, temp[1]+1});
				visited[temp[0]*2] = true;
			}
			if(temp[0]+1 < visited.length && !visited[temp[0]+1]) {
				q.offer(new int[] {temp[0]+1, temp[1]+1});
				visited[temp[0]+1] = true;
			}
			if(temp[0] -1 >= 0 && !visited[temp[0]-1]) {
				q.offer(new int[] {temp[0]-1, temp[1]+1});
				visited[temp[0]-1] = true;
			}
		}
	}
}
