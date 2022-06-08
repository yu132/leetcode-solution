package _0800_0899;

public class _809 {

	class Solution {
	    public int expressiveWords(String S, String[] words) {
	    	
	    	int count=0;
	    	
	        l:for(int i=0;i<words.length;++i){
	        	
	        	int indexS=0,indexW=0;
	        	
	        	while(indexW<words[i].length()&&indexS<S.length()){
	        		
	        		char c1=words[i].charAt(indexW);
	        		char c2=S.charAt(indexS);
	        		
	        		if(c1!=c2)
	        			continue l;
	        		
	        		int repeat=1;
	        		for(++indexW;indexW<words[i].length();++indexW,++repeat){
	        			if(words[i].charAt(indexW)!=c1)
	        				break;
	        		}
	        		
	        		int echo=1;
	        		for(++indexS;indexS<S.length();++indexS,++echo){
	        			if(S.charAt(indexS)!=c2)
	        				break;
	        		}
	        		
	        		if(echo<repeat)
	        			continue l;
	        		else if(echo>repeat){
	        			if(echo<3)
	        				continue l;
	        		}
	        		
	        	}
	        	if(indexW==words[i].length()&&indexS==S.length())
	        		++count;
	        }
	    	
	    	return count;
	    }
	}
	
}
