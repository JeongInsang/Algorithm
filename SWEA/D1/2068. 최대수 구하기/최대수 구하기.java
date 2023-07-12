import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 0;
		t = sc.nextInt();
		for (int tc = 1; tc < t+1; tc++) {
			int num = 0;
			int ans = 0;
			for(int i = 0; i < 10; i++) {
				num = sc.nextInt();
				if(num > ans) {
					ans = num;
				}
			}
		System.out.println("#" + tc + " " + ans);
		}
	}

}
