//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends






/*You are required to complete this method */
class Node{
    Node[] links=new Node[26];
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
}
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
      int cnt=0;
      Node root=new Node();
      for(int i=0;i<st.length();i++){
          Node node=root;
          for(int j=i;j<st.length();j++){
              if(!node.containsKey(st.charAt(j))){
                  cnt++;
                  node.put(st.charAt(j),new Node());
              }
              node=node.get(st.charAt(j));
          }
      }
    return cnt+1;
   }
}