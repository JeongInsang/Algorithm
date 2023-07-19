import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();

		for(int i = 1; i < n+1; i++) {
			String num = String.valueOf(i);
			int cnt = 0;
            
            for(int j = 3; j < 10; j+=3){
            	cnt += num.length() - num.replace(String.valueOf(j), "").length();
            }
            if (cnt == 0) {
                System.out.print(i+" ");
            }
            else {
                for(int k = 0; k < cnt; k++) {
                    System.out.print("-");
                }
                System.out.print(" ");
			} 
        }
	}
}

