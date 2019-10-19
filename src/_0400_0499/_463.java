package _0400_0499;

public class _463 {
/*  v1
	class Solution {
		
		int[] dir=new int[]{1,0,0,1,-1,0,0,-1};
		
		int near=0;
		int count=0;
		
	    public int islandPerimeter(int[][] grid) {
	        for(int i=0;i<grid.length;i++){
	        	for(int j=0;j<grid[0].length;j++){
	        		if(grid[i][j]==1){
	        			dfs(grid,i,j);
	        			break;
	        		}
	        	}
	        }
	        
	        return count*4-near/2;
	    }
	    
	    void dfs(int[][] grid,int i,int j){
	    	grid[i][j]=2;
	    	++count;
	    	
	    	for(int x=0;x<4;x++){
	    		int ix=i+dir[x*2];
	    		int jx=j+dir[x*2+1];
	    		
	    		if(ix<0||ix>=grid.length||jx<0||jx>=grid[0].length)
		    		continue;
	    		if(grid[ix][jx]>0)
	    			++near;
	    		if(grid[ix][jx]==1)
	    			dfs(grid,ix,jx);
	    	}
	    }
	}*/
	
	/**
	 * 只�?�虑左上，右下由于�?�是有在其右下的块能够检查出左上有块，所以检查到�?�?-2即可 
	 *
	 */
	class Solution {
	    public int islandPerimeter(int[][] grid) {
	        int count = 0;//record the value of the answer
	        for(int i = 0;i < grid.length;i++){
	            for(int j = 0;j < grid[0].length;j++){
	                if(grid[i][j] == 1){
	                    count += 4;
	                    if(i - 1 >= 0 && grid[i - 1][j] == 1){
	                        count -= 2;
	                    }
	                    if(j - 1 >= 0 && grid[i][j - 1] == 1){
	                        count -= 2;
	                    }
	                }

	            }
	        }
	        return count;
	    }
	}
	
}
