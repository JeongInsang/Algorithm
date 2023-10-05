import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static ArrayList<Integer>[] area;
	static int[] people;
	static boolean[] vis;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		area = new ArrayList[n + 1];
		people = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			area[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			people[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			m = sc.nextInt();
			for (int j = 0; j < m; j++) {
				int another = sc.nextInt();
				area[i].add(another);
				area[another].add(i);
			}
		}
		vis = new boolean[n + 1];
		subset(1); 
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

	private static void subset(int cnt) {
		if (cnt == n) {
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (vis[i]) {
					a.add(i);
				} else
					b.add(i);
			}
			if (a.size() + b.size() != n) // 3개 이상일때
				return;
			if (a.size() == 0 || b.size() == 0) // 집합이 2개가 안될 때
				return;
			if (isPossible(a, 'a') && isPossible(b, 'b')) {
				int sum = 0;
				for (int i = 0; i < a.size(); i++) {
					sum += people[a.get(i)];
				}
				int sum2 = 0;
				for (int i = 0; i < b.size(); i++) {
					sum2 += people[b.get(i)];
				}
				answer = Math.min(answer, Math.abs(sum - sum2));
			}

			return;
		}
		vis[cnt] = true;
		subset(cnt + 1);
		vis[cnt] = false;
		subset(cnt + 1);

	}

	private static boolean isPossible(ArrayList<Integer> a, char team) {
		boolean[] connect = new boolean[n + 1];
		int cur = a.get(0);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(cur);
		connect[cur] = true;
		while (q.size() != 0) {
			int temp = q.poll();
			for (int j = 0; j < area[temp].size(); j++) {
				int next = area[temp].get(j);
				if (connect[next])
					continue;
				if ((team == 'a' && vis[next]) || (team == 'b' && vis[next] == false)) {// 같은 팀이라면
					q.add(next);
					connect[next] = true;
				}
			}
		}

		for (int i = 0; i < a.size(); i++) {
			if (!connect[a.get(i)]) // 같은 집합내 연결 안된애가 있다면 false
				return false; 
		}
		return true;
	}
}
