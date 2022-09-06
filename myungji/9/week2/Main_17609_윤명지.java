import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_17609_윤명지 {
	
	static ArrayList<Character> al_temp;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		ArrayList<Character> al;
		
		Stack<Character> st;
		String str;
		str = sc.nextLine();
		
		for(int tc=0; tc<T; tc++) {
			str = sc.nextLine();
			al = new ArrayList<>();
			al_temp = new ArrayList<>();
			
			boolean a = true;
			
			for(int i=0; i<str.length(); i++) {
				al.add(str.charAt(i));
				al_temp.add(str.charAt(i));
			}
			
			
			
			st = new Stack<>();
			
			if(al.size()%2==0) {
				for(int j=0; j<al_temp.size()/2; j++) {
					st.add(al_temp.get(j));
				}
				
				for(int j=al_temp.size()/2; j<al_temp.size(); j++) {
					if(st.isEmpty()!=true && st.peek() == al_temp.get(j)) {
						st.pop();
					}
				}
				
				if(st.isEmpty()==true) {
					System.out.println("0");
					continue;
				} else {
					for(int i=0; i<str.length(); i++) {
						for(int l=0; l<str.length(); l++) {
							al_temp = new ArrayList<>();
							if(i==l) {
								continue;
							}else {
								al_temp.add(al.get(l));
							}
						}
						st = new Stack<>();
						
						for(int l=0; l<al_temp.size()/2; l++) {
							st.add(al_temp.get(l));
						}
						
						for(int l=al_temp.size()/2; l<al_temp.size(); l++) {
							if(st.isEmpty()!=true && st.peek() == al_temp.get(l)) {
								st.pop();
							} else {
								System.out.println("2");
								a = false;
								break;
							}
						}
						
						if(a==false) {
							break;
						}
						
						if(st.isEmpty()==true) {
							System.out.println("1");
						}
						
					}
				}
			} else {
				for(int j=0; j<al_temp.size()/2; j++) {
					st.add(al_temp.get(j));
				}
				
				for(int j=al_temp.size()/2+1; j<al_temp.size(); j++) {
					if(st.isEmpty()!=true && st.peek() == al_temp.get(j)) {
						st.pop();
					}
				}
				
				if(st.isEmpty()==true) {
					System.out.println("0");
					continue;
				} else {
					for(int i=0; i<str.length(); i++) {
						for(int l=0; l<str.length(); l++) {
							al_temp = new ArrayList<>();
							if(i==l) {
								continue;
							}else {
								al_temp.add(al.get(l));
							}
						}
						st = new Stack<>();
						
						for(int l=0; l<al_temp.size()/2; l++) {
							st.add(al_temp.get(l));
						}
						
						for(int l=al_temp.size()/2+1; l<al_temp.size(); l++) {
							if(st.isEmpty()!=true && st.peek() == al_temp.get(l)) {
								st.pop();
							} else {
								System.out.println("2");
								a = false;
								break;
							}
						}
						
						if(a==false) {
							break;
						}
						
						if(st.isEmpty()==true) {
							System.out.println("1");
							break;
						}
						
					}
				}
			}
			
			
		}

	}

}
