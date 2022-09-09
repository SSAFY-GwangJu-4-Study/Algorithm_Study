import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_최지성 {
	static StringBuilder answer = new StringBuilder();
	static final int SUCCESS = 100001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		loop: for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			int index = isPalindrome(str);
			StringBuilder sb = new StringBuilder(str);
			
			if (index == SUCCESS) {
				answer.append(0 + "\n");
				continue;
			} else {
				if (isPalindrome(sb.deleteCharAt(index).toString()) == SUCCESS) {
					answer.append(1 + "\n");
					continue loop;
				}
				sb = new StringBuilder(str);
				if (isPalindrome(sb.deleteCharAt(sb.length()-1-index).toString()) == SUCCESS) {
					answer.append(1 + "\n");
					continue loop;
				}

				answer.append(2 + "\n");
			}
		}

		System.out.println(answer.toString());
	}

	public static int isPalindrome(String str) {
		for (int i = 0, size = str.length(); i < size / 2; i++) {
			if (str.charAt(i) != str.charAt(size - 1 - i)) {
				return i;
			}
		}

		return SUCCESS;
	}
}
