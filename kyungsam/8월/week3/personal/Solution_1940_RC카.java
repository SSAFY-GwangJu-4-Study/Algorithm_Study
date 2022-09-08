import java.util.Scanner;

public class Solution_1940_RC카 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int speed=0;
			int dist=0;
			for(int i=0;i<N;i++) {
				int order =sc.nextInt();
				switch (order) {
				case 1:
					speed+=sc.nextInt();
					dist +=speed;
					break;
				case 2:
					speed-=sc.nextInt();
					if(speed<0)speed=0;
					dist +=speed;
					break;
				case 0:
					dist+=speed;
					break;
				}
			}
			System.out.println("#"+tc+" "+dist);
		}
	}

}
