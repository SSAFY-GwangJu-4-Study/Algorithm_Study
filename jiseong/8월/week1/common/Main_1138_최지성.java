
import java.util.Scanner;

public class Main_1138_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int cnt = arr[i];
			
			for (int j = 0; j < N; j++) {
				if (ans[j] == 0) {
					if (cnt == 0) {
						ans[j] = i + 1;
						break;
					}
					cnt--;

				}
			}
		}

		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}
