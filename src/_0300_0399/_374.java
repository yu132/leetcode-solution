package _0300_0399;

public class _374 {
	
	class GuessGame{
		public int guess(int num){
			return 0;
		}
	}

	public class Solution extends GuessGame {
	    public int guessNumber(int n) {
	        int f=1,b=n;
	        
	        while(f<=b){
	        	int mid=(f+b)>>>1;
	        	
	        	int ans=guess(mid);
	        	
	        	if(ans==1){
	        		f=mid+1;
	        	}else if(ans==-1){
	        		b=mid-1;
	        	}else{
	        		return mid;
	        	}
	        }
	        
	        throw new IllegalArgumentException();
	    }
	}
	
}
