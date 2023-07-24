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
				if (arr[b-2] < arr[b] && arr[b-1] < arr[b]) {
					int maxLeft = Math.max(arr[b-2], arr[b-1]);
					
					if (arr[b+2] < arr[b] && arr[b+1] < arr[b]) {
						int maxRight = Math.max(arr[b+1], arr[b+2]);
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
