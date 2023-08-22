import java.util.*;

public class Main {
	static int l, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		char[] password = new char[c];
		char[] sel = new char[l];
		
		for (int i = 0; i < c; i++) {
			password[i] = sc.next().charAt(0);
		}
		Arrays.sort(password);
		recursive(password, sel, 0, 0);
	}
	private static void recursive(char[] password, char[] sel, int idx, int k) {
		if (k == sel.length) {
			int cnt = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' ||sel[i] == 'o' ||sel[i] == 'u') {
					cnt++;
				}
			}
			if(cnt >= 1 && l-cnt >= 2) {
				for (int i = 0; i < sel.length; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = idx; i < password.length; i++) {
			sel[k] = password[i];
			recursive(password, sel, i+1, k+1);
		}
	}

}
