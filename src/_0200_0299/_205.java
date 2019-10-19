package _0200_0299;

public class _205 {
/* v1
	class Solution {
	    public boolean isIsomorphic(String s, String t) {
	        Map<Character,Character> map=new HashMap<>();
	        
	        Map<Character,Character> mapInv=new HashMap<>();
	        
	        if(s.length()!=t.length())
	        	return false;
	        
	        for(int i=0;i<s.length();i++){
	        	char sc=s.charAt(i);
	        	char tc=t.charAt(i);
	        	
	        	Character replaceC=map.put(sc, tc);
	        	Character replaceCInv=mapInv.put(tc, sc);
	        	
	        	if(replaceC!=null&&replaceC!=tc)
	        		return false;
	        	
	        	if(replaceCInv!=null&&replaceCInv!=sc)
	        		return false;
	        }
	        
	        return true;
	    }
	}*/
	
	class Solution {
	   public boolean isIsomorphic(String s, String t) {
	        char[] sc = s.toCharArray();
	        char[] tc = t.toCharArray();
	        int[] map = new int[512];
	        for (int i = sc.length-1;i >= 0;i--) {
	            if (map[sc[i]] != map[tc[i]+256]) {
	                return false;
	            }
	            map[sc[i]] = map[tc[i] + 256] = i;
	        }
	        return true;

	    }
	}
	
}
