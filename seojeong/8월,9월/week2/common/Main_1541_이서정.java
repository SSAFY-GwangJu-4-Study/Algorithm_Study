package algorithm;

import java.util.Scanner;

public class Main_1541_이서정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner input=new Scanner(System.in);
		String get=input.next();
		
		String cal[]=new String[get.length()];
		String cal2[]=new String[get.length()];
		String firstcal[]=new String[get.length()];
		String tempcal[]=new String[get.length()];
		
		cal=get.split("-");
		
		int add=0;
		int firstadd=0;
		int secondadd=0;
		int result=0;
		
		if(cal.length<2) {
			cal2=get.split("\\+");
			for(int i=0; i<cal2.length; i++) {
				add=add+Integer.parseInt(cal2[i]);
			}
			result=add;
		}
		
		//배열의 요소가 2개 부터는 첫번째 배열을 제외한 애들을 다 더한다음에 첫번째 요소에서 빼기(우선첫번째 요소 애들 다 더해주기)
		else {
			firstcal=cal[0].split("\\+");
			for(int i=0; i<firstcal.length; i++) {
				firstadd=firstadd+Integer.parseInt(firstcal[i]);
			}//첫번째 -가 나올때까지 값 더해줌
			
			for(int j=1; j<cal.length; j++) {
				tempcal=cal[j].split("\\+");
				for(int i=0; i<tempcal.length; i++) {
					secondadd=secondadd+Integer.parseInt(tempcal[i]);
				}//첫번째 -가 나올때까지 값 더해줌
			}
			result=firstadd-secondadd;
		}
		
		System.out.println(result);
	}

}
