import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] card = new int[n];
		int max_score = 0;
		
		for(int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n - 2; i++) {
			for(int j = i+1; j < n; j ++) {
				for(int k = j+1; k < n; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= m && sum > max_score) {
						max_score = sum;
					}
				}
			}
		}
		System.out.println(max_score);
	}

}