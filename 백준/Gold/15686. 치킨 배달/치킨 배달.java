import java.util.*;
public class Main {
	static int n;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<int[]> target = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt(); // 치킨집 
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {  // map에 정보 입력
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {  // 치킨집 좌표 저장
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 2) target.add(new int[] {i, j});
			}
		}
		
		recursive(target, new int[m][2], 0, 0);
		System.out.println(answer);
	}
	
	
	
	private static void recursive(ArrayList<int[]> arr, int[][] sel, int idx, int k) {
		if(k == sel.length) {
			int temp = 0;  // 선택된 두 개의 치킨집의 치킨 거리 저장
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if(map[row][col] == 1) {
						int pickMin = Integer.MAX_VALUE;
						for (int i = 0; i < sel.length; i++) {
							// 선택된 두 개의 치킨집 중에서 거리가 짧은 치킨집의 거리 저장
							pickMin = Math.min(pickMin, (Math.abs(sel[i][0] - row) + Math.abs(sel[i][1] - col)));
						}
						temp += pickMin;
					}
				}
			}
			answer = Math.min(answer, temp);
			return;
		}

		for(int i = idx; i < arr.size(); i++){
			sel[k] = arr.get(i);
			recursive(arr, sel, i+1, k+1);
		}
	}
}