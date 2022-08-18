import java.util.Scanner;
import java.util.Stack;

public class Main_9012_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 0; tc < T; tc++) {
			char[] ps = sc.nextLine().toCharArray();

			Stack<Character> st = new Stack<>();

			boolean result = true;

			for (int i = 0; i < ps.length; i++) {
				if (ps[i] == '(')
					st.push(ps[i]);
				else {
					if (st.isEmpty())
						result = false;
					else
						st.pop();
				}
			}
			
			if(!st.isEmpty())
				result = false;
			
			System.out.println(result ? "YES" : "NO");
		}
	}
}
