import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();  // 원본 암호문의 길이
			List<Integer> arr = new ArrayList<>();  // 원본 암호문
			for(int i = 0; i < n; i++) arr.add(sc.nextInt());
			
			int m = sc.nextInt();  // 명령어 개수
			for(int cmd = 0; cmd < m; cmd++) {
				String insert = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int i = 0; i < y; i++) {
					int s = sc.nextInt();
					arr.add(x+i, s);
				}
			}
			System.out.print("#" + tc + " ");
			for(int cnt = 0; cnt < 10; cnt++) {
				System.out.print(arr.get(cnt) + " ");
			}
			System.out.println();
		}
	}

}
