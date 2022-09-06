import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_5397_최지성 {
	static Stack<Character> origin;
	static Stack<Character> temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			origin = new Stack<>();
			temp = new Stack<>();

			char[] input = br.readLine().toCharArray();

			for (int i = 0; i < input.length; i++) {
				exec(input[i]);
			}
			
			while(!temp.isEmpty()) {
				origin.push(temp.pop());
			}
			
			StringBuilder sb = new StringBuilder();
			while(!origin.isEmpty()) {
				sb.append(origin.pop());
			}
			
			System.out.println(sb.reverse().toString());
		}
	}

	public static void exec(char cmd) {
		switch (cmd) {
		case '<':
			if (!origin.isEmpty())
				temp.push(origin.pop());
			break;
		case '>':
			if (!temp.isEmpty())
				origin.push(temp.pop());
			break;
		case '-':
			if (!origin.isEmpty())
				origin.pop();
			break;
		default:
			origin.push(cmd);
			break;
		}
	}
}
