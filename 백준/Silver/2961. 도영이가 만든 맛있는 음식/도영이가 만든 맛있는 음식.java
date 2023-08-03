import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, min;
	static int[][] arr;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][2];
		sel = new boolean[n];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		func(0, 1, 0, 0);
		System.out.println(min);
		
	}
	
	private static void func(int idx, int sour, int bitter, int cnt) {
		if(idx == n) {
			if(cnt > 0) {
				min = Math.min(Math.abs(sour - bitter), min);
			}
			return;
		}
		
		sel[idx] = true;
		func(idx + 1, arr[idx][0] * sour, arr[idx][1] + bitter, cnt + 1);
		sel[idx] = false;
		func(idx + 1, sour, bitter, cnt);
	}

}
