package _0300_0399;

public class _378 {
/*  v1
	class Solution {
	    public int kthSmallest(int[][] matrix, int k) {

	    	PriorityQueue<Integer> heap=new PriorityQueue<>((x,y)->y-x);
	    	
	    	l:for(int i=0;i<matrix.length;++i){
	    		for(int j=0;j<matrix.length;++j){
	    			if(heap.size()<k) 
	    				heap.add(matrix[i][j]);
	    			else{
	    				if(matrix[i][j]<heap.peek()){
	    					heap.poll();
	    					heap.add(matrix[i][j]);
	    				}else
	    					continue l;
	    			}
	    		}
	    	}
	    	
	    	return heap.peek();
	    }
	}*/
	
	// >>>1 只�?�用于正�? 如果有负�? ，那么就用l+(r-l)/2来折�?
	
	class Solution {
		public int kthSmallest(int[][] matrix, int k) {
			 
			 int n=matrix.length;
			 
	         int l=matrix[0][0],r=matrix[n-1][n-1];
	        
	         while(l<=r){
	        	 
	        	int mid=l+(r-l)/2;
	        	
	        	int count=0;
	        	
	        	for(int i=n-1,j=0;i>=0&&j<n;){
	        		if(matrix[i][j]>mid)
	        			--i;
	        		else{
	        			count+=i+1;
	        			++j;
	        		}
	        	}
	        	
	        	if(count>=k)
	        		r=mid-1;
	        	else
	        		l=mid+1;
	         }
	        
	         return l;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new _378().new Solution().kthSmallest(new int[][]{{-5}}, 1));
	}
	
}
