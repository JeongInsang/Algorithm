import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		for (int i = 2; i <= n; i++) {
			arr[i] = 1 + arr[i-1];
			if(i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i/3] + 1);
			}
			if(i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i/2] + 1);
			}
		}
		System.out.println(arr[n]);
	}
}