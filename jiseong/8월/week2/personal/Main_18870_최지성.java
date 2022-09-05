import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18870_최지성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] inputArr = new int[N][2]; // 인덱스, 값

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		for (int i = 0; i < N; i++) {
			inputArr[i][0] = i;
			inputArr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputArr, (arr1, arr2) -> {
			return arr1[1] - arr2[1];
		});

		int now = inputArr[0][1];
		int rank = 0;

		for (int i = 0; i < N; i++) {
			if (inputArr[i][1] == now) {
				inputArr[i][1] = rank;
			} else if (inputArr[i][1] > now) {
				now = inputArr[i][1];
				inputArr[i][1] = ++rank;
			}
		}

		Arrays.sort(inputArr, (arr1, arr2) -> {
			return arr1[0] - arr2[0];
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(inputArr[i][1] + " ");
		}
		
		System.out.println(sb.toString());
	}
}
