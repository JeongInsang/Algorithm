import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] sushi = new int[n];
		int[] check = new int[d+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i = 0; i < n; i++) {
			sushi[i] = sc.nextInt();
		}
		
		int answer = 1;
		check[c]++;
		
		
		for (int i = n-k; i < n; i++) {
			if(check[sushi[i]] == 0) {
				answer++;
			}
			check[sushi[i]]++;
			q.offer(sushi[i]);
		}
		
		int cnt = answer;
		for (int i = 0; i < n-1; i++) {	// 슬라이딩 윈도우 수행
			int temp = q.poll();	// 큐에서 하나 빼줌
			check[temp]--;	// 먹은 횟수 차감
			
			if (check[temp] == 0) cnt--;	// 먹은 횟수가 0이 된 경우, 먹은 초밥 개수를 하나 차감
			q.add(sushi[i]);	// 큐에 하나 넣어줌
			
			if (check[sushi[i]] == 0) cnt++;	// 아직 먹지 않은 초밥이면 먹은 초밥 개수를 하나 증가시킴
			check[sushi[i]]++;	// 먹은 횟수 증가
			
			if(cnt>answer) {
				answer = cnt;	// 총 먹은 초밥 개수가 더 큰 값을 저장
			}
		}
		System.out.println(answer);
	}

}
