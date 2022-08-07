import java.util.Arrays;
import java.util.Scanner;

public class Main_15649_이서정 {

	static boolean isSelected[];
	static int a;
	static int b;
	static int num[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		a=input.nextInt();
		b=input.nextInt();
		isSelected = new boolean[a+1];
		num = new int[b];
		perm(0);
	}

	static void perm(int cnt) {
		if(cnt>=b) {
			for(int i=0; i<b; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
			
		for(int i=1; i<=a; i++) {
			if(isSelected[i]) continue;
			isSelected[i]=true;
			num[cnt]=i;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
}
