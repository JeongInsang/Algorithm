import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<N; i++) {
			int tmp = sc.nextInt();
			switch(tmp) {
			case 1:
				stack.add(sc.nextInt());
				break;
			case 2:
				if(!stack.isEmpty()) {
					sb.append(stack.pop() + "\n");
				}
				else {
					sb.append(-1 + "\n");
				}
				break;
			case 3:
				sb.append(stack.size() + "\n");
				break;
			case 4:
				if(stack.isEmpty()) {
					sb.append(1 + "\n");
				}
				else {
					sb.append(0 + "\n");
				}
				break;
			case 5:
				if(!stack.isEmpty()) {
					sb.append(stack.peek() + "\n");
				}
				else {
					sb.append(-1 + "\n");
				}
				break;
			}
		}
		System.out.println(sb);

	}

}
