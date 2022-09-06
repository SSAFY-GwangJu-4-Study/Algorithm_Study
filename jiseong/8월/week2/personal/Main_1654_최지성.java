import java.util.Arrays;
import java.util.Scanner;

public class Main_1654_최지성 {
	public static long res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		long lo = 1;
		long hi = Integer.MAX_VALUE;
		long mid = (hi + lo) / 2;
		res = 0;

		while (lo <= hi) {
			mid = (hi + lo) / 2;

			if (count(arr, mid) >= N) {
				res = Math.max(res, mid);
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(res);

	}

	public static int count(int[] arr, long len) {
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i] / len;
		}

		return cnt;
	}
}
