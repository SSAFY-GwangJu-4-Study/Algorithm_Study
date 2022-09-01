import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution_3_윤명지2{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt1 = 0;
			int cnt2 = 0;
			int c = 1;
			int d = 1;
			
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			Queue<Integer> q3 = new LinkedList<>();
			Queue<Integer> q4 = new LinkedList<>();
			int x,y;
			for(int i=0; i<N/2; i++) {
				x = sc.nextInt();
				q1.add(x);
				q3.add(x);
			}
			for(int i=N/2; i<N; i++) {
				y = sc.nextInt();
				q2.add(y);
				q4.add(y);
			}
			
			
			while(true) {
				arr = new int[N];
				cnt1 ++;
				c = 2;
				if(cnt1 == 6) {
					//System.out.println("#"+tc+" -1");
					break;
				}
				
				boolean a = false;
				int b = 1;
				if(q1.peek()<q2.peek()) {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q1.isEmpty()!= true && q2.isEmpty()!= true && q1.peek()<q2.peek()) {
								arr[i] = q1.peek();
								q1.poll();
							} else {
								a = true;
							}
						}
						
						if(a == true) {
							if(b == 1) {
								if(q1.isEmpty() == true) {
									b = b*-1;
								} else {
									arr[i] = q2.peek();
									q2.poll();
									b = b*-1;
									continue;
								}
							}
							if(b==-1) {
								if(q1.isEmpty() == true) {
									arr[i] = q2.peek();
									q2.poll();
									continue;
								} else {
									arr[i] = q1.peek();
									q1.poll();
									b = b*-1;
									continue;
								}
							}
						}
					}
				} else {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q1.isEmpty()!= true && q2.isEmpty()!= true && q1.peek()>q2.peek()) {
								arr[i] = q2.peek();
								q2.poll();
								continue;
							} else {
								a = true;
							}
						}
						
						if(a == true) {
							if(b == 1) {
								if(q2.isEmpty() == true) {
									b = b*-1;
								} else {
									arr[i] = q1.peek();
									q1.poll();
									b = b*-1;
									continue;
								}
							}
							if(b==-1) {
								if(q2.isEmpty() == true) {
									arr[i] = q1.peek();
									q1.poll();
									continue;
								} else {
									arr[i] = q2.peek();
									q2.poll();
									b = b*-1;
									continue;
								}
							}
						}
					}
				}
				
				
				for(int i=1; i<=N; i++) {
					if(arr[i-1] == i) {
						continue;
					} else {
						c = 1;
					}
				}
				
				if(c==2) {
					//System.out.println("#"+tc+" "+cnt);
					break;
				} else {
					for(int i=0; i<N/2; i++) {
						q1.add(arr[i]);
					} 
					
					for(int i=N/2; i<N; i++) {
						q2.add(arr[i]);
					}
					
//					c = 2;
//					for(int i=N; i>=1; i--) {
//						if(arr[i-1] == N) {
//							continue;
//						} else {
//							c = 1;
//						}
//					}
//					if(c==2) {
//						System.out.println("#"+tc+" "+cnt);
//						break;
//					} else {
//						
//					}
				}
				
				
			}
			
			while(true) {
				arr = new int[N];
				cnt2 ++;
				c = 2;
				if(cnt2 == 6) {
					break;
				}
				
				boolean a = false;
				int b = 1;
				if(q3.peek()>q4.peek()) {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q3.isEmpty()!= true && q4.isEmpty()!= true && q3.peek()>q4.peek()) {
								arr[i] = q3.peek();
								q3.poll();
							} else {
								a = true;
							}
						}
						
						if(a == true) {
							if(b == 1) {
								if(q3.isEmpty() == true) {
									b = b*-1;
								} else {
									arr[i] = q4.peek();
									q4.poll();
									b = b*-1;
									continue;
								}
							}
							if(b==-1) {
								if(q3.isEmpty() == true) {
									arr[i] = q4.peek();
									q4.poll();
									continue;
								} else {
									arr[i] = q3.peek();
									q3.poll();
									b = b*-1;
									continue;
								}
							}
						}
					}
				} else {
					for(int i=0; i<N; i++) {
						if(a == false) {
							if(q3.isEmpty()!= true && q4.isEmpty()!= true && q3.peek()<q4.peek()) {
								arr[i] = q4.peek();
								q4.poll();
								continue;
							} else {
								a = true;
							}
						}
						
						if(a == true) {
							if(b == 1) {
								if(q4.isEmpty() == true) {
									b = b*-1;
								} else {
									arr[i] = q3.peek();
									q3.poll();
									b = b*-1;
									continue;
								}
							}
							if(b==-1) {
								if(q4.isEmpty() == true) {
									arr[i] = q3.peek();
									q3.poll();
									continue;
								} else {
									arr[i] = q4.peek();
									q4.poll();
									b = b*-1;
									continue;
								}
							}
						}
					}
				}
				for(int i=N; i>=1; i--) {
					if(arr[N-i] == i) {
						continue;
					} else {
						c = 1;
					}
				}
				
				if(c==2) {
					break;
				} else {
					for(int i=0; i<N/2; i++) {
						q3.add(arr[i]);
					} 
					
					for(int i=N/2; i<N; i++) {
						q4.add(arr[i]);
					}
					
				}
				
				
			}
			
			if(cnt1 >=6 && cnt2>=6) {
				System.out.println("#"+tc+" -1");
			} else {
				System.out.println("#"+tc+" "+Math.min(cnt1, cnt2));
			}
				

		}
	}

}
