import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			String memory = sc.next();
			int answer = 0;
			char num = '0';
			
			for (int i = 0; i < memory.length(); i++) {
				if(memory.charAt(i) != num) {
					answer++;
					num = memory.charAt(i);
				}
			}
			System.out.printf("#%d %d",tc, answer);
            System.out.println();
		}
	}

}