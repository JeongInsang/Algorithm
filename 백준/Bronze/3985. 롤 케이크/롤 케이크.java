import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[l];
		int maxCake = Integer.MIN_VALUE;
		int maxCnt = Integer.MIN_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		for (int i = 1; i < n+1; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			p--; k--;
			if(k-p+1 > maxCake) {
				maxCake = k-p+1;
				ans1 = i;
			}
			int cnt = 0;
			for (int j = p; j <= k; j++) {
				if(arr[j] == 0) {
					arr[j] = i;
					cnt++;
				}
			}
			if(cnt > maxCnt) {
				maxCnt = cnt;
				ans2 = i;
			}
			
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}

}
