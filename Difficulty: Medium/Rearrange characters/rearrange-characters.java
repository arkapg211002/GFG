//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Solution
{
	public static String rearrangeCharacters(String s) {
	
		//code here
		 StringBuilder str=new StringBuilder(s);
        HashMap<Character,Integer> m=new HashMap<>();
        for(int i=0;i<str.length();i++){
            m.put(str.charAt(i),m.getOrDefault(str.charAt(i),0)+1);
        }
        char ch='a';
        int x=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> e:m.entrySet()){
            if(e.getValue()>x){
                x=e.getValue();
                ch=e.getKey();
            }
        }
        int i=0;
        while(x>0&&i<str.length()){
            str.setCharAt(i,ch);
            x--;
            i+=2;
        }
        if(x>0)
        return "-1";
        m.remove(ch);
            for(Map.Entry<Character,Integer> e:m.entrySet()){
            int v=e.getValue();
            while(v>0){
            if(i>=str.length())
            i=1;
            str.setCharAt(i,e.getKey());
            v--;
            i+=2;
            }
        }
        return str.toString();
	}
}