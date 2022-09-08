import java.util.Scanner;
import java.util.Stack;

public class Main_10828_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		Stack<String> st = new Stack<>();
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String[] exec = sc.nextLine().split(" ");

			if (exec.length == 2) {
				st.push(exec[1]);
			} else {
				switch (exec[0]) {
				case "pop":
					sb.append(st.isEmpty() ? -1 : st.pop()).append("\n");
					break;
				case "size":
					sb.append(st.size()).append("\n");
					break;
				case "empty":
					sb.append(st.isEmpty() ? 1 : 0).append("\n");
					break;
				case "top":
					sb.append(st.isEmpty() ? -1 : st.peek()).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
