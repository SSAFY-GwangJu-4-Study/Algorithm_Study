import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_9375_최지성 {
	static int N;
	static HashMap<String, Integer> cloth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			cloth = new HashMap<>();

			N = Integer.parseInt(br.readLine());

			String line = null;
			StringTokenizer st = null;

			for (int i = 0; i < N; i++) {
				line = br.readLine();
				st = new StringTokenizer(line, " ");

				st.nextToken();

				String type = st.nextToken();
				if (cloth.containsKey(type)) {
					int n = cloth.get(type);
					cloth.put(type, n + 1);
				} else {
					cloth.put(type, 1);
				}
			}

			int result = 1;

			for (int i : cloth.values()) {
				result *= (i + 1);
			}

			System.out.println(result - 1);
		}
	}

}
