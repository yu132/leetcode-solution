package old._0000_0099;

public class _32 {
/*	v1
	class Solution {
	    public int longestValidParentheses(String s) {
	        int[] len=new int[s.length()];
	        
	        Deque<Integer> stack=new ArrayDeque<>();
	        
	        int max=0;
	        
	        for(int i=0;i<s.length();i++){
	        	
	        	if(s.charAt(i)=='('){
	        		stack.push(i);
	        	}else{
	        		
	        		if(!stack.isEmpty()){
	        			int index=stack.pop();
	        			
	        			len[i]=(index>0?len[index-1]:0)+i-index+1;
	        			
	        			max=Math.max(max, len[i]);
	        		}
	        	}
	        	
	        }
	        
	        return max;
	    }
	}*/
	
	class Solution {
	    public int longestValidParentheses(String s) {
	        int maxnum = 0;
	        int left = 0;
	        int right = 0;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            
	            if (left == right) {
	                maxnum = Math.max(maxnum, 2 * left);
	            } else if (left < right) {
	                left = right = 0;
	            }
	        }
	        
	        left = right = 0;
	        for (int i = s.length() - 1; i >= 0; i--) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            
	            if (left == right) {
	                maxnum = Math.max(maxnum, 2 * left);
	            } else if (left > right) {
	                left = right = 0;
	            }
	        }
	        
	        return maxnum;
	    }
	}
}
