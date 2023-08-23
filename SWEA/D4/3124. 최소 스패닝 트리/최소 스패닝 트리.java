import java.util.*;

public class Solution {
	
	static void make() {
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int v, e;
    static long answer;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			v = sc.nextInt();
			e = sc.nextInt();
			answer = 0;
			
			parents = new int[v+1];
			make();
			int[][] edgeList = new int[e][3];
			
			for (int i = 0; i < e; i++) {
				edgeList[i][0] = sc.nextInt();  // 시작
				edgeList[i][1] = sc.nextInt();  // 끝
				edgeList[i][2] = sc.nextInt();  // 가중치
			}
			
			Arrays.sort(edgeList, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});
			int cnt = 0;
			for (int i = 0; i < e; i++) {
				if(union(edgeList[i][0], edgeList[i][1])) {
					answer += edgeList[i][2];
					cnt++;
					if(cnt == v-1) break;
				}
				else continue;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

}
