import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		int[] arr = new int[n];
		int answer = 0;
		int i = 0;
		arr[i]++;
	while(true) {
			if (arr[i] == m) break;
			
			if (arr[i] % 2 == 0) {
				if(i - l < 0) {
					arr[n-l+i]++;
					i = n-l+i;
				}
				else {
					arr[i-l]++;
					i = i-l;
				}
			}
			else {
				if(i + l >= n) {
					arr[l-(n-i)]++;  // 3
					i = l-(n-i);
				}
				else {
					arr[i+l]++;
					i = i+l;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}
