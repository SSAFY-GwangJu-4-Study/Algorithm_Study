import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_1990_최지성 {
	static long s;
	static long e;
	static ArrayList<Long> arr = new ArrayList<>();
	static String[] start = new String[] { "11", "33", "55", "77", "99" };
	static String[] append = new String[] { "00", "11", "22", "33", "44", "55", "66", "77", "88", "99" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		e = sc.nextInt();

		init();

		for (int i = 0; i < 5; i++) {
			StringBuilder sb = new StringBuilder("" + start[i]);

			find(sb);
		}

		Collections.sort(arr);

		for (long l : arr)
			System.out.println(l);

		System.out.println(-1);
	}

	public static void init() {
		long[] bin = new long[] { 2, 3, 5, 7 };

		for (int i = 0; i < 4; i++) {
			if (bin[i] >= s)
				arr.add(bin[i]);
		}
	}

	public static void find(StringBuilder sb) {
		long num = Long.parseLong(sb.toString());

		if (num > e)
			return;

		if (num >= s && isPrime(sb)) {
			arr.add(num);
		}

		for (int i = 0; i < 10; i++) {
			// 중간에 하나씩 넣으면서 소수 확인
			StringBuilder nsb = new StringBuilder(sb);
			nsb.insert(sb.length() / 2, i);
			if (Long.parseLong(nsb.toString()) >= s && Long.parseLong(nsb.toString()) <= e && isPrime(nsb))
				arr.add(Long.parseLong(nsb.toString()));
		}

		for (int i = 0; i < 10; i++) {
			// sb에 append[0] ~ append[9] 끼워넣고 넘기기
			StringBuilder nsb = new StringBuilder(sb);
			nsb.insert(sb.length() / 2, append[i]);
			find(new StringBuilder(nsb));
		}
	}

	public static boolean isPrime(StringBuilder sb) {
		long num = Long.parseLong(sb.toString());

		if (num < 2)
			return false;

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

//	public static boolean isPalindrome(StringBuilder sb) {
//		String s = sb.toString();
//
//		int j = s.length() - 1;
//
//		for (int i = 0; i < s.length() / 2; i++, j--) {
//			if (s.charAt(i) != s.charAt(j)) {
//				return false;
//			}
//		}
//		return true;
//
//	}
}
