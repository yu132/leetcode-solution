package _0700_0799;

public class _794 {

	class Solution {
		
		int[] comp=new int[]{0,0,0,1,0,2, 1,0,1,1,1,2, 2,0,2,1,2,2,
				0,0,1,0,2,0, 0,1,1,1,2,1, 0,2,1,2,2,2,
				0,0,1,1,2,2, 2,0,1,1,0,2};
		
	    public boolean validTicTacToe(String[] board) {
	        char[][] c=new char[][]{board[0].toCharArray(),board[1].toCharArray(),board[2].toCharArray()};
	        
	        int winX=0,winO=0;
	        
	        for(int i=0;i<8;++i){
	        	if(c[comp[i*6]][comp[i*6+1]]==c[comp[i*6+2]][comp[i*6+3]]&&c[comp[i*6]][comp[i*6+1]]==c[comp[i*6+4]][comp[i*6+5]])
	        		if(c[comp[i*6]][comp[i*6+1]]=='X')
	        			++winX;
	        		else if(c[comp[i*6]][comp[i*6+1]]=='O')
	        			++winO;
	        }
	        
	        int countX=0,countO=0;
	        
	        for(int i=0;i<3;++i)
	        	for(int j=0;j<3;++j)
	        		if(c[i][j]=='X')
	        			++countX;
	        		else if(c[i][j]=='O')
	        			++countO;
	        
	        if(countO>countX)
	        	return false;
	        
	        if(countX-1>countO)
	        	return false;
	        
	        if(winX>=1&&winO>=1)
	        	return false;
	        
	        if(winX==1)
	        	if(countX-1==countO)
	        		return true;
	        	else
	        		return false;
	        
	        if(winO==1)
	        	if(countX==countO)
	        		return true;
	        	else
	        		return false;
	        
	        return true;
	    }
	}
	
}
