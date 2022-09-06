import java.util.Scanner;

public class Main_6603_윤명지 {
	
	static int k;
	static int[] arr;
	static int[] numbers;
	
	public static void comb(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<k; i++) {
			numbers[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			
			if(k==0) {
				break;
			}
			
			arr = new int[k];
			numbers = new int[6];
			
			for(int i=0; i<k; i++) {
				arr[i] = sc.nextInt();
			}
			
			comb(0,0);
			System.out.println();
			
		}

	}

}
