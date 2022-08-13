import java.util.Scanner;

public class Main_1541_윤명지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] str_m = str.split("-");
		
		int sum = Integer.MAX_VALUE;
		
		for(int i=0; i<str_m.length; i++) {
			int tmp = 0;
			
			String[] str_a = str_m[i].split("\\+");
			
			for(int j=0; i<str_a.length; j++) {
				tmp = tmp + Integer.parseInt(str_a[j]);
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum = sum - tmp;
			}
		}
		
		System.out.println(sum);
		

	}

}
