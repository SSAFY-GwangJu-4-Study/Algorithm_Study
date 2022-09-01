import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution_3_윤명지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt = 0;
			boolean c = false;
			
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			for(int i=0; i<N/2; i++) {
				q1.add(i);
			}
			for(int i=N/2; i<N; i++) {
				q2.add(i);
			}
			
			while(true) {
				cnt ++;
				if(cnt == 6) {
					System.out.println("#"+tc+" -1");
					break;
				}
				boolean a = false;
				c = false;
				int b = 1;
				if(q1.peek()<q2.peek()) {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q1.isEmpty()!= true && q2.isEmpty()!= true && q1.peek()>q2.peek()) {
								arr[i] = q1.peek();
								q1.poll();
							} else {
								a = true;
							}
						} else {
							if(b == -1){
								if(q1.isEmpty()!=true) {
									b = b*-1;
								} else {
									arr[i] = q1.peek();
									q1.poll();
									b = b*-1;
									continue;
								}
							}
							if(b == 1) {
								if(q1.isEmpty()==true) {
									arr[i] = q2.peek();
									q2.poll();
								} else {
									arr[i] = q2.peek();
									q2.poll();
									b = b* -1;
								}
							}

						}

					}
				}
				
				if(q1.peek()>q2.peek()) {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q1.isEmpty()!= true && q2.isEmpty()!= true && q1.peek()<q2.peek()) {
								arr[i] = q2.peek();
								q2.poll();
							} else {
								a = true;
							}
						} else {
							if(b == -1){
								if(q2.isEmpty()!=true) {
									b = b*-1;
								} else {
									arr[i] = q2.peek();
									q2.poll();
									b = b*-1;
									continue;
								}
							}
							if(b == 1) {
								if(q2.isEmpty()==true) {
									arr[i] = q1.peek();
									q1.poll();
								} else {
									arr[i] = q1.peek();
									q1.poll();
									b = b* -1;
								}
							}

						}

					}
				}
				
				for(int i=0; i<N; i++) {
					if(arr[i] == i) {
						continue;
					} else {
						c = true;
					}
				}
				
				for(int i=0; i<N; i++) {
					if(arr[i] == N-i-1) {
						continue;
					} else {
						c = true;
					}
				}
				
				if(c == false) {
					System.out.println("#"+tc+" "+cnt);
					break;
				} else {
					for(int i=0; i<N/2; i++) {
						q1.add(arr[i]);
					} 
					
					for(int i=N/2; i<N; i++) {
						q2.add(arr[i]);
					}
				}
			}
			
		}

	}

}
