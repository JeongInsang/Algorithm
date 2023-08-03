import java.util.Scanner;

public class Solution {
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			
			for (int tc = 1; tc <= t; tc++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int arr[][] = new int[n][n];
				int answer = 0;
				
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						arr[i][j] = sc.nextInt();
					}
				}
				
				for (int i = 0; i < n-m+1; i++) {
					for (int j = 0; j < n-m+1; j++) {
						int maxFly = 0;
						for (int k = i; k < i+m; k++) {
							for (int l = j; l < j+m; l++) {
								maxFly += arr[k][l];
							}
						}
						answer = Math.max(answer, maxFly);
					}
				}
                System.out.println("#" + tc + " " + answer);
			}
		}
	}

