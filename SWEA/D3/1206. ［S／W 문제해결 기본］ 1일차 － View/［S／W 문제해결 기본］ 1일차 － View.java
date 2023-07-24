import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 10;
		
		for(int tc = 1; tc < t+1; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int answer = 0;
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int b = 2; b < n - 2; b++) {
				int l1 = arr[b-2];
				int l2 = arr[b-1];
				if (l1 < arr[b] && l2 < arr[b]) {
					int maxLeft = Math.max(l1, l2);
					int r1 = arr[b+2];
					int r2 = arr[b+1];
					if (r1 < arr[b] && r2 < arr[b]) {
						int maxRight = Math.max(r1, r2);
						int maxHight = Math.max(maxLeft, maxRight);
						answer += arr[b] - maxHight;
					}
					else continue;
				}
				else continue;
			}
			System.out.println("#"+ tc + " " + answer);
		}
	}

}
