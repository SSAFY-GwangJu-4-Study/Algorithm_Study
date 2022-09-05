import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2805_최지성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[] tree = new Integer[N];

		line = br.readLine();
		st = new StringTokenizer(line);

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		long hi = 2_000_000_000;
		long lo = 0;

		while (lo + 1 < hi) {
			// 높이에 대해서 binary search
			long temp = hi + lo;
			long mid = temp / 2;
			
			if (isOver(tree, mid, M)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(lo);
	}

	public static boolean isOver(Integer[] tree, long height, int M) {
		int length = 0;
		boolean isOver = false;

		for (int i = 0; i < tree.length; i++) {
			if (tree[i] > height)
				length += (tree[i] - height);

			if (length >= M) {
				isOver = true;
			}
		}

		return isOver;
	}
}
