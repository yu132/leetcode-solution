package _400_499;

public class _427 {

	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    public Node() {}

	    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
	        val = _val;
	        isLeaf = _isLeaf;
	        topLeft = _topLeft;
	        topRight = _topRight;
	        bottomLeft = _bottomLeft;
	        bottomRight = _bottomRight;
	    }
	};
	
	class Solution {
	    public Node construct(int[][] grid) {
	    	return build(grid,0,grid.length-1,0,grid.length-1);
	    }
	    
	    public Node build(int[][] grid,int fx,int tx,int fy,int ty){
	    	if(fx==tx&&fy==ty)//leaf
	    		return new Node(grid[fx][fy]==1,true,null,null,null,null);
	    	
	    	System.out.println(fx+" "+tx+" "+fy+" "+ty);
	    	
	    	int midx=(fx+tx)>>>1;
	    	int midy=(fy+ty)>>>1;
	    	
	    	Node tl=build(grid,fx,midx,fy,midy);
	    	Node tr=build(grid,fx,midx,midy+1,ty);
	    	Node bl=build(grid,midx+1,tx,fy,midy);
	    	Node br=build(grid,midx+1,tx,midy+1,ty);
	    	
	    	if(tl.isLeaf&&tr.isLeaf&&bl.isLeaf&&br.isLeaf&&tl.val==tr.val&&tl.val==bl.val&&tl.val==br.val)
	    		return new Node(tl.val,true,null,null,null,null);
	    	else
	    		return new Node(false,false,tl,tr,bl,br);
	    }
	}
	
}
