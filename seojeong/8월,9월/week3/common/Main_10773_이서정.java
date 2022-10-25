import java.util.Scanner;
import java.util.Stack;

public class Main_10773_이서정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			int num=input.nextInt();
			if(num==0) {
				stack.pop();
			}
			else {
				stack.push(num);	
			}
				
		}
		
		int result=0;
		for(int i=stack.size(); i>0; i--) {
			result=result+stack.pop();
		}
		
		System.out.println(result);
	}

}
