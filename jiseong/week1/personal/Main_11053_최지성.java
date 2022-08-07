import java.util.Scanner;

public class Main_11053_최지성 {
	public static int N;
	public static int[] arr;
	public static int[] length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		length = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		lis();
		
		int max = -1;
		
		for(int l : length)
			max = Math.max(max, l);
			
		System.out.println(max);
	}

	public static void lis() {
		for (int k = 0; k < N; k++) {
			length[k] = 1;	// 일단 나 혼자 포함
			for (int i = 0; i < k; i++) {
				if (arr[i] < arr[k]) {	// 앞에 있는 것들 중에 현재 내 값보다 작으면 나는 그 수열 뒤에 들어갈 수 있음
					length[k] = Math.max(length[k], length[i] + 1);	// 기존 값과 새로운 값 비교
				}
			}
		}
	}
}
