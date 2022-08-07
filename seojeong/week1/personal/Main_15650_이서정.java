import java.util.Arrays;
import java.util.Scanner;

public class Main_15650_이서정 {

	static int a;
	static int b;
	static int num[];
	static boolean isSelected[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		a=input.nextInt();
		b=input.nextInt();
		num = new int[b];
		isSelected = new boolean[a+1];
		comb(0,1);
	}

	static void comb(int cnt,int start) {
		if(cnt>=b) {
			for(int i=0; i<b; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
			
		for(int i=start; i<=a; i++) {
//			if(isSelected[i])
//				continue;
			num[cnt]=i;
//			isSelected[i]=true;  
			comb(cnt+1,i+1);
//			isSelected[i]=false;  
		}
	}
}
