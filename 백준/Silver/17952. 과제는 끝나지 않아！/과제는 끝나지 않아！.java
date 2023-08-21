import java.util.*;

public class Main {
	static int num, time, score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;  // 받은 점수의 합을 저장할 변수; 
		Stack<int[]> stack = new Stack<int[]>();
		
		for (int i = 0; i < N; i++) {
			num = sc.nextInt();
			if (num != 0){
				score = sc.nextInt();
				time = sc.nextInt();		
			}
			
			if(num == 1) {
				// 업무를 바로 시작하기 때문에 업무 시간이 1이면 점수 누적
				if(time == 1) {  
					answer += score;
				}
				else {
					// 업무를 받는것과 동시에 업무를 시작하므로 남은 시간에서 1을 빼고 stack에 넣어줌
					stack.add(new int[] {score, time-1});
				}
			}
			
			if(num == 0 && !stack.isEmpty()) {  // num이 0이고 스택이 비어있지 않으면 이전 업무 진행
				int[] temp = stack.pop();  // temp = [score, time-1]
				temp[1]--;
				if(temp[1] == 0) {  // 업무의 남은 시간이 0이면 점수 누적
					answer += temp[0];
				}
				else {  // 0이 아니면 다시 스택에 담음
					stack.add(temp);
				}
			}
		}
		System.out.println(answer);
	}

}
