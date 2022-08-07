import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1931_이서정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int com[][]=new int [n][2];
		for(int i=0; i<n; i++) {
			com[i][0]=input.nextInt();
			com[i][1]=input.nextInt();
		}
		
		Arrays.sort(com, (o1,o2)->{
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
				return o1[1]-o2[1];
			});
		

		
		int count=1;
		int start=com[0][1];
		for(int i=1; i<n; i++) {
			if(com[i][0]>=start) {
				count++;
				start=com[i][1];
			}
		}
		System.out.println(count);
		
	}

}
