import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_최지성 {
	static int numOfVer;
	static int numOfEdge;
	static int start;
	static boolean graph[][];
	static boolean visited[];
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		numOfVer = Integer.parseInt(st.nextToken());
		numOfEdge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		graph = new boolean[numOfVer + 1][numOfVer + 1];
		visited = new boolean[numOfVer + 1];

		for (int i = 0; i < numOfEdge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = true;
			graph[b][a] = true;
		}

		DFS(start);
		bw.write("\n");
		bw.flush();
		visited = new boolean[numOfVer + 1];
		BFS(start);

		bw.flush();
		br.close();
		bw.close();
	}

	public static void DFS(int v) throws IOException {
		visited[v] = true;// 해당 노드를 방문했다고 표시
		bw.write(v + " ");
		for (int i = 1; i < numOfVer + 1; i++) {
			if (graph[v][i] == true && !visited[i]) {
				DFS(i);
			}
		}
	}

	public static void BFS(int v) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int j = 1; j < numOfVer + 1; j++) {
				if (graph[temp][j] == true && visited[j] == false) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}
	}
}
