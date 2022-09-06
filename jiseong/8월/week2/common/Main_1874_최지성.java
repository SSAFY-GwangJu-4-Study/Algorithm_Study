import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_1874_최지성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] seq = new int[N];

		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();
		boolean canMake = true;
		ArrayList<Character> arr = new ArrayList<>();

		int now = 0;// 받아야 하는 값의 인덱스
		for (int i = 1; i <= N; i++) {
			st.push(i);
			arr.add('+');

			if (st.peek() == seq[now]) {
				while (!st.isEmpty() && st.peek() == seq[now]) {
					st.pop();
					arr.add('-');
					now++;
				}
			}
		}

		if (!st.isEmpty())
			canMake = false;

		if (canMake) {
			for (char c : arr)
				System.out.println(c);
		} else {
			System.out.println("NO");
		}
	}
}
