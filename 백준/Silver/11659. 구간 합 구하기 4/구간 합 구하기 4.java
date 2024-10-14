import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            arr[i+1] += arr[i] + num[i];
        }

        for (int k = 0; k < m; k++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
