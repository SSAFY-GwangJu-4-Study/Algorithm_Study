import java.util.ArrayList;
import java.util.Scanner;

/**
 * LIS를 binary search로 만들기
 * 
 * @author 지성이
 *
 */
public class Main_11053_최지성_bs {
	public static int N;
	public static int[] arr;
	public static ArrayList<Integer> lis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		lis = new ArrayList<>();

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		makeLis();

//		int max = -1;

//		for (int l : lis)
//			System.out.print(l + " ");

		System.out.println(lis.size());
	}

	public static void makeLis() {
		lis.add(arr[0]);

		for (int i = 1; i < N; i++) {
			if(lis.contains(arr[i]))
				continue;
			
			if (arr[i] > lis.get(lis.size() - 1)) {
				lis.add(arr[i]);
			} else if (arr[i] < lis.get(lis.size() - 1)) {
				int index = binarySearch(arr[i]);
				lis.set(index, arr[i]);
			}
		}
	}

	// 처음으로 n이 들어가야 하는 위치
	// ex. 1 6이 있을 때 다음 숫자가 3이면 3은 현재 6이 있는 자리에 들어가야 한다
	public static int binarySearch(int n) {
		int lo = 0;
		int hi = lis.size() - 1;
		int mid = (hi + lo) / 2;

		while (lo < hi) {
			mid = (hi + lo) / 2;

			if (lis.get(mid) > n) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return hi;
	}
}
