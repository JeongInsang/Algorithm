import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution{
	static int n, k, slice;
	static String[] nums;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			nums = new String[n];
			nums = sc.next().split("");
			list = new ArrayList<Integer>();
			int rotate = n / 4;  // 회전 수 
			slice = n / rotate;  // 한 변에 들어갈 수 있는 숫자의 수 
			for (int i = 0; i < rotate; i++) {
				if(i == 0) {  // 0번째는 회전하지 않음 
					addNumber(rotate);
				}
				else {  // 시계방향으로 한칸씩 회전 
					String temp = nums[n-1];
					for (int j = n-1; j > 0; j--) {
						nums[j] = nums[j-1];
					} 
					nums[0] = temp;
					addNumber(rotate);
				}
			}
			Set<Integer> set = new HashSet<Integer>(list);  // 리스트를 set으로 변환하여 중복 제거
			list = new ArrayList<Integer>(set);  // 중복 제거된 set을 다시 리스트로 변환 
			Collections.sort(list, Collections.reverseOrder());  // 리스트 내림차순 정렬 
			System.out.println("#" + tc + " " + list.get(k-1));
		}
	}
	private static void addNumber(int cnt) {  // slice개 만큼 자른 16진수 문자열을 10진수로 변환하여 리스트에 저장 
		for (int i = 0; i < slice; i++) {
			String[] temp = new String[cnt];
			for (int j = i * cnt, k = 0; j < (i+1) * cnt; j++, k++) {	
				temp[k] = nums[j];
			}
			String hex = String.join("", temp);
			list.add(Integer.parseInt(hex,16));

		}
	}

}
