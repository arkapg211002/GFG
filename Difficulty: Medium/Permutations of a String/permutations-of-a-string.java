//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        StringBuilder str=new StringBuilder(s);
        recur(0,str,set);
        ans.addAll(set);
        Collections.sort(ans);
        return ans;
    }
    void swap(StringBuilder s,int i,int j){
        char temp=s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,temp);
    }
    public void recur(int index,StringBuilder s,HashSet<String> set){
        if(index==s.length()){
            set.add(s.toString());
            return;
        }
        for(int i=index;i<s.length();i++){
            swap(s,index,i);
            recur(index+1,s,set);
            swap(s,index,i);
        }
    }
}
