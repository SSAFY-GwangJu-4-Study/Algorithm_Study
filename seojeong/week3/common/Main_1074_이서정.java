import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_이서정 {

	static int getz[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int num = (int)Math.pow(2,N);
    
	    int startx=0;
	    int midx=num/2;
	    int endx=num;
	    
	    int starty=0;
	    int midy=num/2;
	    int endy=num;
	    
	    int count=0;
	    int plusnum=N;

	    while(plusnum>0) {
	    midx=(startx+endx)/2;
	    midy=(starty+endy)/2;
	    plusnum--;
	    if(midx<=r&&midy<=c) {
	    	count=count+3*((int)Math.pow(2,plusnum)*(int)Math.pow(2,plusnum));
	    	startx=midx;
	    	starty=midy;
	    	System.out.println(count);
	    }
	
	    else if(midx<=r&&midy>c) {
	    	count=count+2*((int)Math.pow(2,plusnum)*(int)Math.pow(2,plusnum));
	    	startx=midx;
	    	endy=midy-1;
	    }
	    else if(midx>r&&midy<=c) {
	    	count=count+1*((int)Math.pow(2,plusnum)*(int)Math.pow(2,plusnum));
	    	endx=midx-1;
	    	starty=midy;
	    }
	    else if(midx>r&&midy>c) {
	    	endx=midx-1;
	    	endy=midy-1;
	    	}
	    }
	    
//	    if(r%2==0 && c%2==1) {
//	    	count=count+1;
//	    }
//	    else if(r%2==1 && c%2==0) {
//	    	count=count+2;
//	    }
//	    else if(r%2==1 && c%2==1) {
//	    	count=count+3;
//	    }

	    System.out.println(count);
	    


	}
}