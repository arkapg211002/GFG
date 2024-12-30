//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.find(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution{
    static int find(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n;i>=1;i--){
            int temp = i;
            while(temp>0){
                int k = temp%10;
                list.add(k);
                temp/=10;
            }
            Collections.reverse(list);
            ArrayList<Integer> newList = new ArrayList<>(list);
            Collections.sort(newList);
            if(newList.equals(list)){
                return i;
            }
            list.clear();
            newList.clear();
        }
        return -1;
    }
}