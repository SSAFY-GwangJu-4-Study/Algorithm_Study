import java.util.Arrays;
import java.util.Scanner;

public class Main_15658_최지성 {
	static int N; // 숫자 개수
	static int[] arr; // 숫자들
	static int[] opCnt; // op의 개수 저장
	static int[] op; // 사용된 op 저장
	static int[] used; // 연산자 사용 수
	static int max;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		opCnt = new int[4];
		op = new int[N - 1]; // 숫자 n개면 연산자는 n-1개
		used = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			opCnt[i] = sc.nextInt();
		}

		insertOP(0);

		System.out.println(max);
		System.out.println(min);
	}

	public static void insertOP(int cnt) {
		if (cnt == N - 1) {
			int sum = calc();
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (used[i] < opCnt[i]) {
				op[cnt] = i;
				used[i]++;
				insertOP(cnt + 1);
				used[i]--;
			}
		}
	}
	
	public static int calc() {
		int sum = arr[0];
		
		for(int i = 1; i < N; i++) {
			switch(op[i - 1]) {
			case 0 :
				sum += arr[i];
				break;
			case 1 :
				sum -= arr[i];
				break;
			case 2 :
				sum *= arr[i];
				break;
			case 3 :
				sum /= arr[i];
				break;
			}
		}
		
		return sum;
	}
}
