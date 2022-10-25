import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_최지성 {
	static class Building {
		int idx;
		int height;

		public Building(int idx, int height) {
			super();
			this.idx = idx;
			this.height = height;
		}

		@Override
		public String toString() {
			return "[idx=" + idx + ", height=" + height + "]";
		}
	}

	static int N;
	static int[] H;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		H = new int[N];

		for (int i = 0; i < N; i++) {
			H[i] = Integer.parseInt(br.readLine());
		}

		Stack<Building> st = new Stack<>();
		st.push(new Building(N - 1, H[N - 1]));
		long count = 0;

		for (int i = N - 2; i >= 0; i--) {
//			System.out.println(st.toString());
			if (!st.isEmpty() && H[i] >= st.peek().height) {
				while (!st.isEmpty() && H[i] > st.peek().height) {
					st.pop();
				}
				count += st.isEmpty() ? (long)(N - 1 - i) : st.peek().idx - i - 1;
//				System.out.println("count : " + count);
				st.push(new Building(i, H[i]));
			} else {
//				System.out.println(H[i]);
				st.push(new Building(i, H[i]));
			}
		}

		System.out.println(count);
	}
}
