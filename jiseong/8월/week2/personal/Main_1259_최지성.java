import java.util.Scanner;

public class Main_1259_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (String str = sc.nextLine(); !str.equals("0"); str = sc.nextLine()) {
			if (str.length() % 2 == 0) {
				StringBuilder sb = new StringBuilder(str.substring(str.length() / 2));

				if (sb.reverse().toString().equals(str.subSequence(0, str.length() / 2)))
					System.out.println("yes");
				else
					System.out.println("no");
			} else {
				StringBuilder sb = new StringBuilder(str.substring(str.length() / 2 + 1));

				if (sb.reverse().toString().equals(str.subSequence(0, str.length() / 2)))
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}
