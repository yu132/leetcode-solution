package old._0500_0599;

public class _507 {
/*  v1
	class Solution {
	    public boolean checkPerfectNumber(int num) {
	        
	    	if(num<=1)
	    		return false;
	    	
	    	int count=1;
	    	
	    	int sqrt=(int) Math.sqrt(num);
	    	
	    	for(int i=2;i<=sqrt;++i){
	    		if(num%i==0){
	    			count+=i;
	    			count+=num/i;
	    			if(count>num)
	    				break;
	    		}
	    	}
	    	
	    	return count==num;
	    }
	}*/
	
	class Solution {
	    public boolean checkPerfectNumber(int num) {
	        switch (num) {
	        case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
			}
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		Solution s=new _507().new Solution();
		for(int i=0;i<=100000000;++i)
			if(s.checkPerfectNumber(i))
				System.out.println(i);
		
	}
	
}
