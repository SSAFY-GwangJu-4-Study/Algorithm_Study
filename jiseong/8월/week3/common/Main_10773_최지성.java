import java.util.Scanner;
import java.util.Stack;

public class Main_10773_최지성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			
			if(n != 0)
				st.push(n);
			else
				st.pop();
		}
		
		int sum = 0;
		
		while(!st.isEmpty()) {
			sum += st.pop();
		}
		
		System.out.println(sum);
	}
}
