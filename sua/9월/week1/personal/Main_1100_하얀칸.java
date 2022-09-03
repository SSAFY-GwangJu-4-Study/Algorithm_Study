import java.util.Scanner;

public class Main_1100_하얀칸 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean white = false;
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			String s = sc.next();
			if(white == true) white = false;
			else white = true;
			for (int j = 0; j < 8; j++) {
				int tmp = s.charAt(j);
				if(white == true && tmp == 'F') cnt++;
				
				if(white == true) white = false;
				else white = true;
				
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
