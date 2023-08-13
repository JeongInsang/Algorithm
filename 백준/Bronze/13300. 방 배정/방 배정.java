import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int room = 0;
		int[][] std = new int[6][2];
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			if(s == 0) std[y-1][0]++;
			else std[y-1][1]++;
		}
		
		for (int i = 0; i < std.length; i++) {
			for (int j = 0; j < 2; j++) {
				if(std[i][j] != 0 && std[i][j] <= k) room++;
				else if(std[i][j] > k) {room += Math.ceil((double)std[i][j] / k);
				}
			}
		}
		
		System.out.println(room);
	}

}
