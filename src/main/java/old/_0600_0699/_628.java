package old._0600_0699;

import java.util.Random;

public class _628 {
	
	public static void main(String[] args) {
		
		Random r=new Random();
		System.out.print("[");
		for(int i=0;i<3;i++){
			System.out.print(r.nextInt(2001)-1000+",");
		}
		
		System.out.println(r.nextInt(2001)-1000+"]");
	}

	class Solution {
	    public int maximumProduct(int[] nums) {
	    	
	    	int p=0,z=0;
	    	for(int i=0;i<nums.length;i++){
	    		if(nums[i]>0)
	    			++p;
	    		else if(nums[i]==0)
	    			++z;
	    	}
	    	
	    	if(p==0){
	    		if(z>=1)
	    			return 0;
	    		else{
	    			
	    			int nmax1=0,nmax2=0,nmax3=0;
	    	    	boolean b1=true,b2=true,b3=true;
	    			
	    	    	for(int i=0;i<nums.length;++i){
    	    			if(b1||nums[i]>=nmax1){
    	    				b3=b2;
    	    				b2=b1;
    	    				b1=false;
    	    				nmax3=nmax2;
    	    				nmax2=nmax1;
    	    				nmax1=nums[i];
    	    			}else if(b2||nums[i]>=nmax2){
    	    				b3=b2;
    	    				b2=false;
    	    				nmax3=nmax2;
    	    				nmax2=nums[i];
    	    			}else if(b3||nums[i]>nmax3){
    	    				b3=false;
    	    				nmax3=nums[i];
    	    			}
	    	    	}
	    	    	
	    	    	return nmax1*nmax2*nmax3;
	    		}
	    	}
	    	
	    	int pmax1=0,pmax2=0,pmax3=0,nmin1=0,nmin2=0;
	    	boolean b1=true,b2=true,b3=true,b4=true,b5=true;
	    	
	    	for(int i=0;i<nums.length;++i){
	    		if(nums[i]>0){
	    			if(b1||nums[i]>=pmax1){
	    				b3=b2;
	    				b2=b1;
	    				b1=false;
	    				pmax3=pmax2;
	    				pmax2=pmax1;
	    				pmax1=nums[i];
	    			}else if(b2||nums[i]>=pmax2){
	    				b3=b2;
	    				b2=false;
	    				pmax3=pmax2;
	    				pmax2=nums[i];
	    			}else if(b3||nums[i]>pmax3){
	    				b3=false;
	    				pmax3=nums[i];
	    			}
	    		}else{
	    			if(b4||nums[i]<=nmin1){
	    				b5=b4;
	    				b4=false;
	    				nmin2=nmin1;
	    				nmin1=nums[i];
	    			}else if(b5||nums[i]<nmin2){
	    				b5=false;
	    				nmin2=nums[i];
	    			}
	    		}
	    	}
	    	
	    	if(b2){
	    		return pmax1*nmin1*nmin2;
	    	}else if(b5){
	    		return pmax1*pmax2*pmax3;
	    	}
	    	
	        return Math.max(pmax1*pmax2*pmax3, pmax1*nmin1*nmin2);
	    }
	}
	
}
