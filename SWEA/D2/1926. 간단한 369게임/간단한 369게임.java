import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();

		for(int i = 1; i < n+1; i++) {
			String num = String.valueOf(i);
			int cnt = num.length() - num.replace("3", "").length() + num.length() - num.replace("6", "").length() + num.length() - num.replace("9", "").length();
			if (cnt == 0) {
				System.out.print(i+" ");
			}
			else {
				for(int j = 0; j < cnt; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		} 
			
	}
}
