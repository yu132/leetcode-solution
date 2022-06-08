package _0100_0199;

public class _165 {
	class Solution {
	    public int compareVersion(String version1, String version2) {
	        String[] sp1=version1.split("\\.");
	        String[] sp2=version2.split("\\.");
	        
	        int length=Math.min(sp1.length, sp2.length);
	        
	        for(int i=0;i<length;i++){
	        	int n1=Integer.valueOf(sp1[i]);
	        	int n2=Integer.valueOf(sp2[i]);
	        	
	        	if(n1>n2)
	        		return 1;
	        	else if(n1<n2)
	        		return -1;
	        }
	        
	        if(sp1.length>sp2.length)
		        for(int i=length;i<sp1.length;i++){
		        	int n1=Integer.valueOf(sp1[i]);
		        	int n2=0;
		        	
		        	if(n1>n2)
		        		return 1;
		        	else if(n1<n2)
		        		return -1;
		        }
	        else if(sp1.length<sp2.length)
	        	for(int i=length;i<sp2.length;i++){
		        	int n1=0;
		        	int n2=Integer.valueOf(sp2[i]);
		        	
		        	if(n1>n2)
		        		return 1;
		        	else if(n1<n2)
		        		return -1;
		        }
	        else
	        	return 0;
	        
	        return 0;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new _165().new Solution().compareVersion("1", "1.1"));
	}
}
