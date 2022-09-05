import java.util.Arrays;
import java.util.Scanner;

/**
 * 길이에 대해서 이진 탐색
 * 
 * @author multicampus
 *
 */
public class Main_2110_최지성 {
	public static int N;
	public static int C;
	public static int[] houses;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		C = sc.nextInt();
		houses = new int[N];

		for (int i = 0; i < N; i++) {
			houses[i] = sc.nextInt();
		}

		Arrays.sort(houses);

		int lo = 1;
		int hi = houses[N - 1] - houses[0];
		int mid = (lo + hi) / 2;
		
		while(lo <= hi) {		// 이분 탐색 조건 
			mid = (lo + hi) / 2;	// 중간 값 기억
			
			// System.out.println(canSetIn(mid) + " " + hi + " " + mid + " " + lo);
			
			if(canSetIn(mid)) {
				lo = mid + 1;			// lo와 hi 할당 기억			
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(hi);
	}

	public static boolean canSetIn(int dist) {
		int count = 1;

		int prev = 0;
		for (int i = 1; i < houses.length; i++) {
			if (houses[i] - houses[prev] >= dist) {
				prev = i;
				count++;
			}
		}

		return count >= C;
	}
}
