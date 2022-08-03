

import java.util.Arrays;
import java.util.Scanner;

public class Main_11650_이서정 {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	int num[][]=new int[n][2];
	
	for(int i=0; i<n; i++) {
		num[i][0] = input.nextInt();
		num[i][1] = input.nextInt();
	}
	
	Arrays.sort(num, (o1, o2) -> {
		if(o1[0] == o2[0]) {
			return o1[1] - o2[1];
		} else {
			return o1[0] - o2[0];
		}
	});
	
	

	
	}
}
