import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int n, answer;
	static int[][] table;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			table = new int[n][n];
			answer = Integer.MAX_VALUE;
			sel = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			comb(0, 0);  // 재료의 절반을 뽑는 조합 
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void comb(int idx, int cnt) {
		if(cnt == n/2) {  //  절반의 재료를 뽑으면 answer 갱신 
			answer = Integer.min(answer, synergy());
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = idx; i < n; i++) {
			sel[i] = true;
			comb(i+1, cnt+1);
			sel[i] = false;
		}
	}
	private static int synergy() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i != j) {
					if(sel[i] && sel[j]) result += table[i][j];
					else if(!sel[i] && !sel[j]) result -= table[i][j];
				}
			}
		}
		return Math.abs(result);
	}

}
