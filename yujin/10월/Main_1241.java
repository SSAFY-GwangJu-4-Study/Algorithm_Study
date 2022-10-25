import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// G5 머리 톡톡 
public class Main_1241 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] num = new int[1000001];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			num[arr[i]]++;
		}
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 1; j * j <= arr[i]; j++) {
				if (arr[i] % j == 0) {
					cnt += num[j];
					if (j != arr[i] / j) {
						cnt += num[arr[i] / j];
					}
				}
			}
			System.out.println(cnt - 1);
		}
	}

}
