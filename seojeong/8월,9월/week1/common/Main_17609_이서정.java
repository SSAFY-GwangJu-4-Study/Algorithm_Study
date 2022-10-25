import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17609_이서정 {
	
	static String st;
	static char put;
	static ArrayList<Character> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(str.nextToken());
		for(int t=0; t<T; t++) {
			st=br.readLine();
			
			list = new ArrayList<Character>();
			
			for(int i=0; i<st.length(); i++) {
				list.add(st.charAt(i));
			}
			
			if(check()==true) {
				System.out.println("0");
			}
			else {
				remove();	
			}		
		}
	
		
	}

static boolean check() {
	for(int i=0; i<=list.size()/2; i++) {
		if(list.get(i)!=list.get(list.size()-i-1)) {
			return false;
			}
		}
	return true;
	}

static void remove() {
	
	for(int i=0; i<st.length(); i++) {
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		list = new ArrayList<Character>();
		
		for(int j=0; j<i; j++) {
			list1.add(st.charAt(j));
		}

		for(int j=i+1; j<st.length(); j++) {
			list2.add(st.charAt(j));
		}
		
		for(int j=0; j<list1.size(); j++) {
			list.add(list1.get(j));
		}
		for(int j=0; j<list2.size(); j++) {
			list.add(list2.get(j));
		}
		if(check()==true) {
			System.out.println("1");
			return;
			}
		}
	System.out.println("2");

	}
}

