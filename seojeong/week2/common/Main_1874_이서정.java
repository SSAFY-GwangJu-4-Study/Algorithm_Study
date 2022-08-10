package algorithm;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main_1874_이서정 {
public static void main(String[] args) {
	Scanner input= new Scanner(System.in);
	int n=input.nextInt();
	Stack<Integer> st=new Stack<Integer>();
	int num[] = new int[n+1];
	LinkedList<Character> list = new LinkedList<>();
	
	for(int i=1; i<n+1; i++) {
		num[i]=input.nextInt();
	}
	
	int index=1;
	for(int i=1; i<=n; i++) {
		st.add(i);
		list.add('+');
//		System.out.println("+");
		if(num[index]==i) {
			st.pop();
			list.add('-');
//			System.out.println("-");
			index++;
			while((!st.isEmpty())&&st.peek()==num[index]) {
					st.pop();
					list.add('-');
//					System.out.println("-");
					index++;
			}
		}
		
		
		
		
	}
	if(!st.isEmpty()) {
		System.out.println("NO");	
	}
	else {
		for(char a:list) {
			System.out.println(a);
		}
	}
	
	


	}
}