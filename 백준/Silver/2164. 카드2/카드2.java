import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		LinkedList<Integer> card = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) card.offer(i);
		
		while(card.size() != 1) {
			card.poll();
			card.offer(card.poll());
		}
		System.out.println(card.peek());
	}
}