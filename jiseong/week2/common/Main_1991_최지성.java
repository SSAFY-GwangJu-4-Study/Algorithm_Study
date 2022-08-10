import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_최지성 {
	public static int[][] connect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		connect = new int[26][2];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");

			int p = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';

			connect[p][0] = left;
			connect[p][1] = right;
		}

//		for(int i = 0; i < 26;i++) {
//			for(int j = 0; j < 2; j++) {
//				System.out.print(connect[i][j] + " ");
//			}
//			System.out.println();
//		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}

	public static void preOrder(int node) {
		System.out.print((char) (node + 'A'));

		if (hasLeft(node)) {
			preOrder(connect[node][0]);
		}

		if (hasRight(node)) {
			preOrder(connect[node][1]);
		}
	}

	public static void inOrder(int node) {
		if (hasLeft(node)) {
			inOrder(connect[node][0]);
		}
		
		System.out.print((char) (node + 'A'));

		if (hasRight(node)) {
			inOrder(connect[node][1]);
		}
	}

	public static void postOrder(int node) {
		if (hasLeft(node)) {
			postOrder(connect[node][0]);
		}
		
		if (hasRight(node)) {
			postOrder(connect[node][1]);
		}
		
		System.out.print((char) (node + 'A'));
	}

	public static boolean hasLeft(int index) {
		return connect[index][0] >= 0;
	}

	public static boolean hasRight(int index) {
		return connect[index][1] >= 0;
	}
}
