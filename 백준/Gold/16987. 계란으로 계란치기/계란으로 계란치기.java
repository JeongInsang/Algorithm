import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int n, answer = Integer.MIN_VALUE;
	static int[][] eggs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		eggs = new int[n][2];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				eggs[i][j] = sc.nextInt();
			}
		}
		
		func(0);
		System.out.println(answer);
		
	}

	private static void func(int i) {
		if(i < n) {
			if(eggs[i][0] >= 1) {  // 손에 있는 계란이 깨지지 않았다면
				for (int egg = 0; egg < n; egg++) {
					if(egg != i && eggs[egg][0] >= 1) {
						eggs[i][0] -= eggs[egg][1];
						eggs[egg][0] -= eggs[i][1];
						func(i+1);
						
						eggs[i][0] += eggs[egg][1]; // 0 : 189 , -44 
						eggs[egg][0] += eggs[i][1]; // 1 : -142
						// 2 : -280
					}
				}
			}
			
			else {
				func(i+1);
			}
						
		}
		int cnt = 0;
		for (int c = 0; c < n; c++) {  // 깨진 계란 개수 카운팅
			// System.out.println(eggs[c][0] + " " + eggs[c][1]);
			if(eggs[c][0] < 1) {
				cnt++;
			}
		}
		// System.out.println();
		answer = Math.max(answer, cnt);  // 가장 많이 깨진 계란 수 갱신
	}
}
