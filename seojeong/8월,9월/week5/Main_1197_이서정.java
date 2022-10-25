package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main_1197_이서정 {

	static int V,E;
	static int p[];
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	
	static void make() {
		p=new int[V+1];
		for(int i=1; i<=V; i++) {
			p[i]=i;	
		}
	}
	
	static int find(int i) {
		if(p[i]==i) return i;
		else return p[i]=find(p[i]);
	}
	
	static boolean union(int x,int y) {
		int aRoot = find(x);
        int bRoot = find(y);
        
		if(aRoot==bRoot){
			return false;
		}
		else {
			p[bRoot]=aRoot;
			return true;
			}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int test=0; test<T; test++) {
			st = new StringTokenizer(br.readLine());
			
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			
			Edge[] getedge=new Edge[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				getedge[i]=new Edge(from, to, weight);
				
				
			}
			
			make();
			Arrays.sort(getedge);
			long result=0;
			int count = 0;
			for(Edge e:getedge) {
				if(union(e.from,e.to)) {
					result+=e.weight;
					if(++count==V-1) {
						break;
					}	
				}
				
			}
			System.out.printf("#%d %d",test+1,result);
			System.out.println();
		}

		
	}

}
