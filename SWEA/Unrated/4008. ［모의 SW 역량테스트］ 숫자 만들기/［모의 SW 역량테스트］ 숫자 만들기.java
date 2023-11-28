import java.util.Scanner;

public class Solution {
	static int n;
	static int resultMax;
	static int resultMin;
	static int[] operator, nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			operator = new int[4];
			nums = new int[n];
			resultMax = Integer.MIN_VALUE;
			resultMin = Integer.MAX_VALUE;
			
			for (int i = 0; i < 4; i++) {  // 연산자 입력 
				operator[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {  // 숫자 입력 
				nums[i] = sc.nextInt();
			}
			
			dfs(0, nums[0]);
			System.out.println("#" + tc + " " + (resultMax - resultMin));
		}
	}
	private static void dfs(int cnt, int value) {
		if(cnt == n-1) {
			resultMax = Integer.max(resultMax, value);
			resultMin = Integer.min(resultMin, value);
//			System.out.println(resultMax + " " + resultMin);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				
				if(i == 0) {
					dfs(cnt+1, value + nums[cnt+1]);
				} else if (i == 1) {
					dfs(cnt+1, value - nums[cnt+1]);
				} else if (i == 2) {
					dfs(cnt+1, value * nums[cnt+1]);
				} else {
					dfs(cnt+1, value / nums[cnt+1]);					
				}
				
				operator[i]++;
			}
		}
	}

}
//2
//5
//2 1 0 1
//3 5 3 7 9
//6
//4 1 0 0
//1 2 3 4 5 6