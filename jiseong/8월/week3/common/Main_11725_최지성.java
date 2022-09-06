import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_최지성 {
	static int N;
	static ArrayList<ArrayList<Integer>> adj;
	static Queue<Integer> q;
	static int[] parent;
	static boolean[] checked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		checked = new boolean[N + 1];

		adj = new ArrayList<>();
		q = new LinkedList<>();

		String line = null;
		StringTokenizer st = null;

		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			adj.get(n1).add(n2);
			adj.get(n2).add(n1);
		}

		checked[1] = true;
		q.offer(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < adj.get(now).size(); i++) {
				int n = adj.get(now).get(i);

				if (!checked[n]) {
					parent[n] = now;
					checked[n] = true;
					q.offer(n);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

}
