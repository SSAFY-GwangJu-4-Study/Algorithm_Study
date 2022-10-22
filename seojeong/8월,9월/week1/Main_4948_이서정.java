
import java.util.Scanner;

public class Main_4948_이서정 {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int a=input.nextInt();
		
		while(a!=0) {
			int count=0;
			int result = 0;
			for(int i=a+1; i<=a*2; i++) {
				for(int j=2; j<i; j++) {
					if(i%j==0) {
						count++;
					}
				}
				if(count==0) {
					result++;
				}
				count=0;
			}
			System.out.print(result);
			a=input.nextInt();
			
		}
	}
}