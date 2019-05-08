package _1000_1099;

public class _1006 {

	public static void main(String[] args) {
		/*for(int i=1;i<100000;i++){
			int x=(i+2)*(i+1);
			
			if(x/i!=i+3){
				System.out.println(x);
			}
		}*/
		int i=131;
		while(i>=0){
			System.out.println(i);
			i-=4;
		}
	}
	
	//2*3=6 6/1=6!=4  3*4=12 12/2=6!=5
	
	
	
	class Solution {
	    public int clumsy(int N) {
	        switch(N){
	        case 1:
	        	return 1;
	        case 2:
	        	return 2;
	        case 3:
	        	return 6;
	        case 4:
	        	return 7;
	        	
        	default:
	        	switch (N%4) {
		        case 1:
		        	return N+2;
		        case 2:
		        	return N+2;
		        case 3:
		        	return N-1;
		        case 0:
		        	return N+1;
				}
	        }
	        
	        return -1;
	    }
	}
	
}
