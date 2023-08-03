import java.util.Scanner;

public class Main {
	static int n, s, answer;
	static int[] arr;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		sel = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		func(0, 0, 0);
		System.out.println(answer);
		
	}
	
	private static void func(int idx, int sum, int cnt) {
		if(idx == n) {
			if(sum == s && cnt > 0) {
				answer++;
			}
			return;
		}
		
		sel[idx] = true;
		func(idx + 1, sum + arr[idx], cnt+1);
		sel[idx] = false;
		func(idx + 1, sum, cnt);
	}

}