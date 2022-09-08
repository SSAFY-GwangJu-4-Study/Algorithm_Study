import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14889_최지성 {
	static int N;
	static int[][] synergy;
	static int[] startTeam;
	static int[] linkTeam;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		synergy = new int[N][N];
		min = Integer.MAX_VALUE;
		startTeam = new int[N / 2];
		linkTeam = new int[N / 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);

		System.out.println(min);
	}

	public static void dfs(int cnt, int stCnt, int start) {
		if (stCnt > N / 2) {
			return;
		}

		if (cnt == N / 2) {
			int res = 0;

			boolean[] visited = new boolean[N];

			for (int i = 0; i < startTeam.length; i++) {
				visited[startTeam[i]] = true;
			}

			ArrayList<Integer> s = new ArrayList<>();
			ArrayList<Integer> l = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if (visited[i])
					s.add(i);
				else
					l.add(i);
			}

			int startTeamSum = 0;
			int linkTeamSum = 0;

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					startTeamSum += (synergy[s.get(i)][s.get(j)]);
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					linkTeamSum += (synergy[l.get(i)][l.get(j)]);
				}
			}

			res = Math.abs(startTeamSum - linkTeamSum);

			min = Math.min(min, res);
			return;
		}

		for (int i = start; i < N; i++) {
			startTeam[cnt] = i;
			dfs(cnt + 1, stCnt + 1, i + 1);
		}
	}
}
