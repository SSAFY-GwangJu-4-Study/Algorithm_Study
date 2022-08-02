import java.util.Scanner;

public class Main_10870_송해찬 {

	static int pibonachi(int i) {
		if(i==0) {
			return 0;
		}
		else if(i==1  i==2) {
			return 1;
		}
		else {
			return pibonachi(i-1) + pibonachi(i-2);
		}
	}
	public static void main(String[] args) {
		 TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		System.out.println(pibonachi(N));
	}

}
