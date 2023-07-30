import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = n;  // 높이가 1인 직사각형은 무조건 n개 이므로 n개 부터 시작

        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            for(int j = i; i * j <= n; j++){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
