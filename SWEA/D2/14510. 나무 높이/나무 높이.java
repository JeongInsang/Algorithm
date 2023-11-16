import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();  // 나무의 갯수
			int[] array = new int[N];  // 나무의 높이를 담는 배열
			
			int odd = 0;  // 홀수날
			int even = 0;  // 짝수날
			int ans = 0;  // 정답
			
			// array에 값 넣기
			for(int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}
			
			
			// find maxValue
			int max = 0;
			for(int i = 0; i < N; i++) {
				max = Math.max(max, array[i]);
			}
			
			// 짝수날과 홀수날 구하기
			for(int i=0; i < N; i++) {
				int diff = max - array[i];
				if(diff == 0) continue;  // max 값과 나무의 키가 같으니까 계속 continue
				
				odd += diff % 2;  // 홀수날, 나머지가 필요 !!
				even += diff / 2;  // 짝수날, 당연히 몫이 필요
			}
			
			if(even > odd) {  // 짝수날이 더 많다? 
				while(Math.abs(even - odd) > 1) {  // 절대값이 1보다 클때가지
					even--;  // 짝수  -= 1
					odd += 2;  // 홀수 += 2
				}
			}
			
			// 홀수날이 더 많으면 날짜는 odd*2 - 1
			if(odd > even) ans = 2*odd-1;
			else if(odd == even) ans = odd + even;
			else ans = even * 2;
			
			System.out.println("#" + tc + " " + ans);
		}

	}

}