import java.util.Scanner;

public class Main_11050_최지성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int bico = bico(N, K);

		System.out.println(bico);
	}

	public static int bico(int N, int K) {
		if(N == K || K == 0)
			return 1;
		
		return bico(N - 1, K) + bico(N - 1, K - 1);
	}
}
