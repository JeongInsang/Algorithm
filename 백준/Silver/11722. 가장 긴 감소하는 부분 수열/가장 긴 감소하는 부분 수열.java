import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n+1];
		int[] memo = new int[n+1];
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.fill(memo, 1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if(nums[j] > nums[i]) {
					memo[i] = Math.max(memo[i], memo[j]+1);
				}
			}
			answer = Math.max(answer, memo[i]);
		}
		System.out.println(answer);
	}

}
