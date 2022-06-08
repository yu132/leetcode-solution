package _0000_0099;

public class _44 {
/*	TLE
	class Solution {
	    public boolean isMatch(String s, String p) {
	    	p=p.replaceAll(Pattern.quote("?"), ".").
	    			replaceAll(Pattern.quote("*"), ".*");
	    	return s.matches(p);
	    }
	}*/
	
/*  TLE
	class Solution {
	    public boolean isMatch(String s, String p) {
	    	char[] sc=s.toCharArray();
	    	char[] pc=p.toCharArray();
	    	
	        return dfs(sc,pc,0,0);
	    }
	    
	    boolean dfs(char[] sc,char[] pc,int sIndex,int pIndex){
	    	while(true){
	    		
	    		if(sIndex==sc.length){
	    			if(pIndex==pc.length)
	    				return true;
	    			else{
	    				for(;pIndex<pc.length;pIndex++){
	    					if(pc[pIndex]!='*')
	    						return false;
	    				}
	    				return true;
	    			}
	    		}else if(pIndex==pc.length)
	    			return false;
	    		
	        	if(pc[pIndex]=='?'||sc[sIndex]==pc[pIndex]){
	        		++sIndex;
	        		++pIndex;
	        	}else if(pc[pIndex]=='*'){
	        		
	        		if(dfs(sc,pc,sIndex,pIndex+1))
        				return true;
	        		
	        		while(true){
	        			if(dfs(sc,pc,++sIndex,pIndex+1))
	        				return true;
	        			
	        			System.out.println(sIndex);
	        			
	        			if(sIndex==sc.length)
	        				return false;
	        		}
	        	}else
	        		return false;
	        }
	    }
	}*/
/*	 v1
	class Solution {
	    public boolean isMatch(String s, String p) {
	    	
	    	if(p.length()==0&&s.length()==0)
	    		return true;
	    	if(p.length()==0)
	    		return false;
	    	
	        int lstar=0,rstar=p.length()-1;
	        
	        char[] sc=s.toCharArray();
	    	char[] pc=p.toCharArray();
	    	
	    	int cCount=0;
	    	for(int i=0;i<p.length();i++){
	    		if(pc[i]!='*')
	    			++cCount;
	    	}
	    	
	    	if(cCount>s.length())
	    		return false;
	    	
	        while(pc[lstar]!='*'){
	        	if(pc[lstar]!='?'&&sc[lstar]!=pc[lstar])
	        		return false;
	        	
	        	++lstar;
	        	--cCount;
	        	
	        	if(lstar==sc.length&&lstar==pc.length)
	        		return true;
	        	if(lstar==sc.length){
	        		for(;lstar<pc.length;lstar++){
    					if(pc[lstar]!='*')
    						return false;
    				}
	        		return true;
	        	}if(lstar==pc.length)
	        		return false;
	        }
	        
	        int temp=sc.length-pc.length;
	        
	        while(pc[rstar]!='*'){
	        	if(pc[rstar]!='?'&&sc[temp+rstar]!=pc[rstar])
	        		return false;
	        	
	        	--rstar;
	        	--cCount;
	        }
	        
	        if(rstar==lstar)
        		return true;
	        
	        return dfs(sc,pc,lstar,rstar,temp+rstar+1,cCount);
	    }
	    
	    boolean dfs(char[] sc,char[] pc,int lstar,int rstar,int rs,int cCount){//rs=temp-rstar+1
	    	
	    	int sIndex=lstar,sStart=sIndex;
	    	int pIndex=lstar+1,pStart=pIndex;
	    	
	    	int cCountBefore=cCount;
	    	
	    	while(true){
	    		while(pIndex!=rstar&&pc[pIndex]=='*')
	    			++pIndex;
	    		
	    		if(sIndex==rs&&pIndex==rstar)
	    			return true;
	    		
	    		if(sIndex==rs)
	    			return false;
	    		
	    		if(pIndex==rstar)
	    			return true;
	    		
	    		pStart=pIndex;
	    		
	    		while(true){
	    			
	    			if(sIndex==rs||pIndex==rstar)
	    				break;
	    			
	    			if(cCount>rs-sIndex+1){
	    				System.out.println(4);
		    			return false;
	    			}
	    			
	    			if(pc[pIndex]=='*'){
	    				sStart=sIndex;
	    				cCountBefore=cCount;
	    				break;
	    			}if(pc[pIndex]=='?'||pc[pIndex]==sc[sIndex]){
	    				++sIndex;
	    				++pIndex;
	    				--cCount;
	    			}else{
	    				++sStart;
	    				sIndex=sStart;
	    				pIndex=pStart;
	    				cCount=cCountBefore;
	    			}
	    		}
	    	}
	    }
	}*/
	
	/**
	 * 本题的�?�想主要是遇�?*，就记录这个位置，如果后面的不能匹配，那么就把s的匹配位置加�?再进行匹�?
	 * 
	 * 
	 * @author 87663
	 *
	 */
	
	
	//短�?�且快的方法
	class Solution {
		public boolean isMatch(String s, String p) {
	        int sp = 0, pp = 0;
	        int match = 0;//s�?始匹配的位置
	        int star = -1;//p�?始匹配的位置，表示有*时即可返回上�?�?*的位置，s从match+1的位置开始重新比�?
	
	        while (sp < s.length()) {
	            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
	                sp ++;
	                pp ++;
	            } else if(pp < p.length() && p.charAt(pp) == '*') {
	                star = pp;
	                match = sp;
	                pp ++;
	            } else if (star != -1) {
	                pp = star + 1;
	                match ++;
	                sp = match;
	            } else return false;
	        }
	
	        while (pp < p.length() && p.charAt(pp) == '*') {
	            pp ++;
	        }
	
	        return pp == p.length();        
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new _44().new Solution().isMatch("a", 
				""));
	}
	
}
