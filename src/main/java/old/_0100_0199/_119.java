package old._0100_0199;

import java.util.ArrayList;
import java.util.List;

public class _119 {
/* v1 too slow
	class Solution {
	    public List<Integer> getRow(int rowIndex) {
	        Integer[] ans=new Integer[rowIndex+1];
	        
	        for(int i=0;i<=rowIndex;i++){
	        	for(int j=i;j>=0;j--){
	        		if(j==0||j==i)
	        			ans[j]=1;
	        		else
	        			ans[j]=ans[j-1]+ans[j];
	        	}
	        }
	        
	        return Arrays.asList(ans);
	    }
	}*/
	
	class Solution {
	    public List<Integer> getRow(int rowIndex) {
	        List<Integer> res = new ArrayList<Integer>();
	        long nk = 1;
	        for(int i = 0; i <= rowIndex; i++){
	            res.add((int)nk);
	            nk = nk * (rowIndex - i) / (i + 1);
	        }
	        return res;
	    }
	}
	
}
