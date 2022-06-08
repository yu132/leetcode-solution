package other.simple.array;

public class _10 {

	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        for(int i=0;i<9;i++){
	        	int[] nums=new int[10];
	        	for(int j=0;j<9;j++){
	        		if(board[i][j]!='.'){
	        			if(nums[ board[i][j]-'0' ]==0)
	        				nums[ board[i][j]-'0' ]=1;
	        			else
	        				return false;
	        		}
	        	}
	        }
	        
	        for(int i=0;i<9;i++){
	        	int[] nums=new int[10];
	        	for(int j=0;j<9;j++){
	        		if(board[j][i]!='.'){
	        			if(nums[ board[j][i]-'0' ]==0)
	        				nums[ board[j][i]-'0' ]=1;
	        			else
	        				return false;
	        		}
	        	}
	        }
	        
	        for(int i=0;i<3;i++){
	        	for(int j=0;j<3;j++){
	        		
	        		int[] nums=new int[10];
	        		
	        		for(int x=i*3;x<(i+1)*3;x++){
	        			for(int y=j*3;y<(j+1)*3;y++){
	        				if(board[x][y]!='.'){
	    	        			if(nums[ board[x][y]-'0' ]==0)
	    	        				nums[ board[x][y]-'0' ]=1;
	    	        			else
	    	        				return false;
	    	        		}
	        			}
	        		}
	        		
	        	}
	        }
	        
	        return true;
	    }
	}
	
}
