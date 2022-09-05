import java.util.ArrayList;
import java.util.Scanner;

public class Main_10819_최지성 {
	static int N;
	static int[] arr;
	static int result = Integer.MIN_VALUE;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// 입력이 크지 않음
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		perm(0, new ArrayList<Integer>());
		
		System.out.println(result);
	}

	public static void perm(int cnt, ArrayList<Integer> list) {
		if (cnt == N) {
			int now = calculate(list);
			
			if(result < now)
				result = now;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				list.add(cnt, arr[i]);
				perm(cnt + 1, list);
				list.remove(cnt);
				isSelected[i] = false;
			}
		}
	}
	
	public static int calculate(ArrayList<Integer> list) {
		int res = 0;
		
		for(int i = 0; i < N - 1; i++) {
			res += Math.abs(list.get(i) - list.get(i + 1));
		}
		
		return res;
	}
}
