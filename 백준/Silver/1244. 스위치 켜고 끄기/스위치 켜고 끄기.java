import java.util.Scanner;

public class Main {
	static int n, sNum, gender, num; // 스위치 개수, 학생수, 성별, 받은 번호
	static int[] on;
	static int[] dc = { -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		on = new int[n+1];
		for (int i = 1; i <= n; i++) {
			on[i] = sc.nextInt(2);
		}
		sNum = sc.nextInt();
		for (int i = 0; i < sNum; i++) {
			gender = sc.nextInt(); 
			num = sc.nextInt(); // number
			if (gender == 1)// 남자
			{
				for (int j = num; j <= n; j += num) {
					if (on[j] == 1) on[j] = 0;
					else on[j] = 1;
				}
			}
			if (gender == 2)// 여자
			{
				if(on[num] == 1) on[num] = 0;
				else on[num] = 1;
				
				for (int j = 1; j < n; j++) {
					int left = dc[0]*j + num;
					int right = dc[1]*j + num;
					if (left >= 1 && left <= n && right >=1 && right <= n) {
						if (on[left] != on[right]) break;
						else {
							if(on[left] == 1) on[right] = on[left] = 0;
							else on[right] = on[left] = 1;
						}
					}
				}
			}

		}
		for(int i=1;i<=n;i++) {
			System.out.print(on[i]+" ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
}