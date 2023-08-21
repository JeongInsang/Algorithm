import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a, b, c;
		a = b = c= 0;
	
		while(t >= 10) {  // t가 10보다 작아지면 t를 0으로 만들 수 없기 때문에 while문 종료
			if (t >= 300) {
				a += t / 300;
				t %= 300;
			} 
			else if (t >= 60) {
				b += t / 60;
				t %= 60;
			} 
			else if (t >= 10) {
				c += t / 10;
				t %= 10;
			}
		}
		
		if(t == 0) {
			System.out.println(a + " " + b + " " + c);
		}
		else System.out.println(-1);
		
		
		
	}

}
