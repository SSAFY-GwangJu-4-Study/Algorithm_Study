import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최지성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				if (!pq.isEmpty())
					sb.append(pq.poll()).append("\n");
				else
					sb.append(0).append("\n");
			} else {
				pq.offer(n);
			}
		}
		
		System.out.println(sb.toString());
	}
}
