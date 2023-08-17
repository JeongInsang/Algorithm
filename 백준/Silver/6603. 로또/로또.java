import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			recursive(arr, new int[6], 0, 0);
			System.out.println();
		}
	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if(k == sel.length) {
			for(int i : sel) System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, sel, i+1, k+1);
		}
	}
	
}
