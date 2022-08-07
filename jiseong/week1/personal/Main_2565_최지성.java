import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2565_최지성 {
	public static int N;
	public static int[][] eWire; // 전깃줄 배열
	public static int[] dest;
	public static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		eWire = new int[N][2];
		dest = new int[N];
		count = new int[N];

		for (int i = 0; i < N; i++) {
			eWire[i][0] = sc.nextInt();
			eWire[i][1] = sc.nextInt();
		}

		Arrays.sort(eWire, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[0] - arr2[0];
			}
		});

		install();

		int max = -1;

		for (int i = 0; i < N; i++)
			max = Math.max(max, count[i]);

//		System.out.println(Arrays.toString(dest));
//		System.out.println(Arrays.toString(count));
		
		System.out.println(N - max);
	}

	public static void install() {
		dest[0] = eWire[0][1];

		for (int i = 0; i < N; i++) {
			count[i] = 1;

			for (int j = 0; j < i; j++) {
				if (canInstall(j, i)) { // 연결 가능하면
					count[i] = Math.max(count[i], count[j] + 1);

					if (dest[i] == 0)
						dest[i] = eWire[i][1];
					else
						dest[i] = Math.min(dest[i], eWire[i][1]);
				} else {
					if (dest[i] == 0)
						dest[i] = eWire[i][1];
					else
						dest[i] = Math.min(dest[i], eWire[i][1]);
				}
			}
		}
	}

	public static boolean canInstall(int prev, int newWire) {
		if (eWire[newWire][1] > dest[prev]) {
			return true;
		}

		return false;
	}
}
