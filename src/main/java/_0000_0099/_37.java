package _0000_0099;

public class _37 {

	class Solution {
		
		boolean[][][] mark33=new boolean[3][3][9];
        
        boolean[][] rowMark=new boolean[9][9];
        boolean[][] colMark=new boolean[9][9];
		
	    public void solveSudoku(char[][] board) {
	        //init
	        for(int row=0;row<9;row++){
	        	for(int col=0;col<9;col++){
	        		
	        		if(board[row][col]!='.'){
	        		
		        		int index=board[row][col]-'0'-1;
		        		
		        		mark33[row/3][col/3][index]=true;
		        		
		        		rowMark[row][index]=true;
		        		
		        		colMark[col][index]=true;
	        		}
	        	}
	        }
	        
	        dfs(board,0,0);
	    }
	    
	    boolean dfs(char[][] board,int row,int col){
	    	if(col>8){
	    		++row;
	    		col=0;
	    		if(row>8)
	    			return true;
	    	}
	    	
	    	if(board[row][col]!='.')
	    		return dfs(board,row,col+1);
	    	
	    	for(int num=1;num<=9;num++){
	    		if(!mark33[row/3][col/3][num-1]&&
	    				!rowMark[row][num-1]&&
	    				!colMark[col][num-1]){
	    			board[row][col]=(char) (num+'0');
	    			
	    			mark33[row/3][col/3][num-1]=true;
	    			rowMark[row][num-1]=true;
	    			colMark[col][num-1]=true;
	    			
	    			if(dfs(board,row,col+1))
	    				return true;
	    			
	    			board[row][col]='.';
	    			
	    			mark33[row/3][col/3][num-1]=false;
	    			rowMark[row][num-1]=false;
	    			colMark[col][num-1]=false;
	    		}
	    	}
	    	
	    	return false;
	    }
	}
	
}
