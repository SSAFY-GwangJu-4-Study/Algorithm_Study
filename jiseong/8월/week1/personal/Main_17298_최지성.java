import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main_17298_최지성 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];

		String line = br.readLine();
		String[] input = line.split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[N - i - 1]);
		}

		Arrays.fill(ans, -1);

		Stack<Integer> st = new Stack<>();
		for (int i = 1; i < N; i++) {
			if (arr[i] < arr[i - 1]) {
				ans[i] = arr[i - 1];
				st.add(arr[i - 1]);
			} else {
				
				if (arr[i] < ans[i - 1]) {
					ans[i] = ans[i - 1];
				}
				else {
					while(!st.isEmpty()) {
						int max = st.peek();
						
						if(max <= arr[i])
							st.pop();
						else {
							ans[i] = max;
							st.add(arr[i]);
							break;
						}
					}
					
					if(!st.isEmpty()) {
						st.add(arr[i]);
					}
				}
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			bw.write("" + ans[i] + " ");
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
