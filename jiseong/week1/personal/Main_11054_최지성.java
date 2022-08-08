import java.util.Arrays;
import java.util.Scanner;

public class Main_11054_최지성 {
	public static int N;
	public static int[] arr;
	public static int[] inclength;
	public static int[] declength;
	public static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		inclength = new int[N];
		declength = new int[N];
		answer = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		bis();

//		System.out.println(Arrays.toString(inclength));
//		System.out.println(Arrays.toString(declength));
//		System.out.println(Arrays.toString(answer));

		int max = -1;

		for (int l : answer)
			max = Math.max(max, l);

		System.out.println(max);
	}

	public static void bis() {
		// LIS
		for (int k = 0; k < N; k++) {
			inclength[k] = 1; // 일단 나 혼자 포함
			for (int i = 0; i < k; i++) {
				if (arr[i] < arr[k]) { // 앞에 있는 것들 중에 현재 내 값보다 작으면 나는 그 수열 뒤에 들어갈 수 있음
					inclength[k] = Math.max(inclength[k], inclength[i] + 1); // 기존 값과 새로운 값 비교
				}
			}
		}

		// LDS : 가장 긴 부분 감소 수열
		for (int k = N - 1; k >= 0; k--) {
			declength[k] = 1; // 일단 나 혼자 포함
			for (int i = N -1; i >= k; i--) {
				if (arr[i] < arr[k]) { // 앞에 있는 것들 중에 현재 내 값보다 작으면 나는 그 수열 뒤에 들어갈 수 있음
					declength[k] = Math.max(declength[k], declength[i] + 1); // 기존 값과 새로운 값 비교
				}
			}
		}

		for (int i = 0; i < N; i++)
			answer[i] = inclength[i] + declength[i] - 1;
	}
}
