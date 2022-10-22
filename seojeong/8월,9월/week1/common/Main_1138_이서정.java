package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1138_이서정 {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int num=input.nextInt();
	 List<Integer> people = new ArrayList<>();
	 int p[]=new int[num+1];
	 
	 for(int i=1; i<=num; i++) {
		 p[i]=input.nextInt();
	 }
	 
	 for(int i=num; i>=1; i--) {
		 people.add(p[i], i); 
	 }
	 
	 for(int pe:people) {
		 System.out.print(pe+" ");
	 }

	
	}
}
