import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(func(n));
		}
	}

	private static int func(int n) {
		if(n == 1) return 1;
		else if (n == 2) return 2;
		else if(n == 3) return 4;
		
		return func(n-1) + func(n-2) + func(n-3);
	}
}
// 