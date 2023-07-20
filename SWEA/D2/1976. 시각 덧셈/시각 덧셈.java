import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc < t+1; tc++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int hour = h1 + h2;
			int minute = m1 + m2;
			
			if(hour > 12) hour -= 12;
			if(minute >= 60) {
				minute -= 60;
				hour += 1;
			}
			System.out.println("#" + tc + " " + hour + " " + minute);
		}
	}
}