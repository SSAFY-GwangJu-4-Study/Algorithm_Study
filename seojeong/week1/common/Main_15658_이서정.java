

import java.util.Scanner;

public class Main_15658 {

	static int num[];
	static int cal[];
	static int n,resultMax,resultMin;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		num = new int[n];
		cal = new int[4];
		
		
		for(int i=0; i<num.length; i++) {
			num[i]= input.nextInt();
		}
		for(int i=0; i<4; i++) {
			cal[i] = input.nextInt();
		}
		
		  resultMax = Integer.MIN_VALUE;
	      resultMin = Integer.MAX_VALUE;
	      getresult(1,num[0]);
	      System.out.println(resultMax);
	      System.out.println(resultMin);
	
	}

	public static void getresult(int ind,int sum) {
		if(ind>=n) {
			resultMax = Math.max(resultMax, sum);
            resultMin = Math.min(resultMin, sum);
            return;
		}
		for(int i =0; i<4; i++) {
			if(cal[i]==0) continue;
			cal[i]--;
			switch(i) {
			case 0:
				getresult(ind+1,sum+num[ind]);
				break;
			case 1:
				getresult(ind+1,sum-num[ind]);
				break;
			case 2:
				getresult(ind+1,sum*num[ind]);
				break;
			case 3:
				getresult(ind+1,sum/num[ind]);
				break;
			}
			cal[i]++;
		}
		
	}
	

}
