import java.util.Scanner;

public class char to int {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		for (int i = n; i <= m; i++) {
			int check = 0;
			String str = String.valueOf(i);
			if (str.length() == 1) {
				result++;
				continue;
			}
			char[] arr = new char[str.length()];
			for (int j = 0; j < str.length(); j++) {
				arr[j] = str.charAt(j);
			}
			
			for (int j = 0; j < arr.length/2; j++) {
				if (arr[j] != arr[arr.length-j-1]) break;
				else check = 1;
			}
			if (check == 1) result++;
		}
		System.out.println(result);
	}
}
