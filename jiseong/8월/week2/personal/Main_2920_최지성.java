import java.util.Scanner;

public class Main_2920_최지성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean asc = false;
		boolean desc = false;

		int start = sc.nextInt();

		switch (start) {
		case 1:
			asc = true;

			for (int i = 2; i <= 8; i++) {
				if(sc.nextInt() != i)
					asc = false;
			}
			break;
		case 8:
			desc = true;

			for (int i = 7; i >= 1; i--) {
				if(sc.nextInt() != i)
					desc = false;
			}

			break;
		}
		
		if(asc)
			System.out.println("ascending");
		else if(desc)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
