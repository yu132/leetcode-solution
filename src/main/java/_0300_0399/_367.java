package _0300_0399;

public class _367 {
/* v1
	class Solution {
	    public boolean isPerfectSquare(int num) {
	        int temp=1;
	        while(num>0){
	        	num-=temp;
	        	temp+=2;
	        }
	        return num==0;
	    }
	}*/
	
	public static void main(String[] args) {
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
	
	class Solution {
	    public boolean isPerfectSquare(int num) {
	        if(num==1)
	            return true;
	        int l=1,r=Math.min(46340, num/2);
	        while(l<=r){
	        	int mid=(l+r)>>>1;
	        	
	        	int square=mid*mid;
	        	
	        	if(square==num)
	        		return true;
	        	if(square<num)
	        		l=mid+1;
	        	else
	        		r=mid-1;
	        }
	        return false;
	    }
	}
	
}
