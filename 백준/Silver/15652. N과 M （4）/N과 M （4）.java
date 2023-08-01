import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		int[] sel = new int[m];
		
		for(int i = 1; i <= n; i++) arr[i-1] = i;
		
		recursive(arr, sel, 0, 0);
		
	}
	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if(k == sel.length) {
			for(int i : sel) {
				System.out.print(i + " ");
			} System.out.println();
			return;
		}
		
		for(int i = idx; i < arr.length; i++){
			sel[k] = arr[i];
			recursive(arr, sel, i, k+1);
		}
	}
}