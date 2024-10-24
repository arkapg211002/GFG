//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
	public static void main (String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
                
        int t=Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            String s=in.readLine().trim();
            int q=Integer.parseInt(in.readLine().trim());
            query a[]=new query[q];
            for(int i=0;i<q;i++){
                String str=in.readLine().trim();
                String st[]=str.split(" ");
                if(st[0].trim().equals("1")){
                    a[i]=new query("1",st[1],st[2],"");
                }else{
                    a[i]=new query("2",st[1],st[2],st[3]);
                }
            }
            Solution ob=new Solution();
            ArrayList<Character> ans=ob.easyTask(n,s,q,a);
            for(char ch:ans){
                out.print(ch+" ");
            }out.println();
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int nq,query queries[])
    {
        ArrayList<Character> charList=new ArrayList<>(s.length());
        for(char c:s.toCharArray())
           charList.add(c);
           
        ArrayList<Character> res=new ArrayList<>();  
        
        int[] charCount;
         
        for(query q:queries){
            
            if(q.type.equals("1"))
                charList.set(Integer.parseInt(q.a),q.b.charAt(0));
            else{
               charCount=new int[26];
               
                int start=Integer.parseInt(q.a);
                int end=Integer.parseInt(q.b);
                int k=Integer.parseInt(q.c);
                
                for(int i=start;i<=end;i++)
                   {
                    char c = charList.get(i);
                    charCount[(int)c -97]++;
                   }
                   
                 int count = 0;
                char resultChar = 0;

                for (int i=25;i>=0;i--) {
                    count += charCount[i];
                    if (count >= k) {
                        resultChar = (char)(i+97);
                        break;
                    }
                }

                 res.add(resultChar);
            }
        }
        return res;
    }
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}