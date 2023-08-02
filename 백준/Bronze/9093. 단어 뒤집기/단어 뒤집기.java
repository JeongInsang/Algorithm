import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			String s = br.readLine();
			String[] arr = s.split(" ");

			for (int i = 0; i < arr.length; i++) {
				for(int j = arr[i].length()-1; j >= 0; j--) {
					sb.append(arr[i].charAt(j));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
