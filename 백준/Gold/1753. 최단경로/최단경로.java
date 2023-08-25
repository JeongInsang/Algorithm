import java.util.*;

public class Main {
	static class vertex implements Comparable<vertex>{
		int v, w;  // 도착점, 가중치
		vertex(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V, E, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		// 인접 리스트
		ArrayList<vertex>[] adj = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<vertex>();
		}
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			adj[s].add(new vertex(e, w));
		}
		
		int[] dist = new int[V+1];  // 거리(가중치) 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V+1];  // 방문 배열
		
		PriorityQueue<vertex> q = new PriorityQueue<>();
		dist[K] = 0;
		q.offer(new vertex(K, dist[K]));
		int cnt = 0;
		
		while(!q.isEmpty()) {
			vertex cur = q.poll();
			int minIdx = cur.v;
			
			if(visited[minIdx]) continue;
			
			visited[minIdx] = true;
			cnt++;
			if(cnt == V) break;
			
			for(vertex next : adj[minIdx]) {
				if(dist[next.v] > dist[minIdx] + next.w) {
					dist[next.v] = dist[minIdx] + next.w;
					q.offer(new vertex(next.v, dist[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);;
		}
	}
}
