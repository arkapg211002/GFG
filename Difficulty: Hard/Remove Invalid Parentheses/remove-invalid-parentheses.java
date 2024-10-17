//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    
    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<String> a)
    {
        for(int i = 0; i < a.size()-1; i++)
            System.out.print(a.get(i)+" ");
        System.out.println(a.get(a.size()-1));
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            ArrayList<String> res = obj.removeInvalidParentheses(s);
            
            StringArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> removeInvalidParentheses(String s){
    ArrayList<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    //Count extra '(' and ')' to be deleted
    int[] count = getDeleteCount(s);
    int toDeleteLeft = count[0];
    int toDeleteRight = count[1];
    recurParentheses(toDeleteLeft, toDeleteRight, 0, 0, 0, false, false, s, sb, list);
    Collections.sort(list);
    return list;
    }
    public static int[] getDeleteCount(String s){
    int L1 = 0, L2 = 0, R1 = 0, R2 = 0, toDeleteLeft = 0, toDeleteRight = 0;
    for(int i = 0; i < s.length(); i++){
        char ch1 = s.charAt(i), ch2 = s.charAt(s.length() - 1 - i);
        /*( ) ( ) ) ( )
          |     | | |
          L1   R1 R2L2 */
        if(ch1 == '(') L1++;
        if(ch1 == ')') R1++;
        if(ch2 == '(') L2++;
        if(ch2 == ')') R2++;
        toDeleteLeft = Math.max(toDeleteLeft, L2 - R2);
        toDeleteRight = Math.max(toDeleteRight, R1 - L1);
    }
    return new int[]{toDeleteLeft, toDeleteRight};
    }
    public static void recurParentheses(int toDeleteLeft, int toDeleteRight, int toSelectLeft, int toSelectRight, int index, boolean deletedLeft, boolean deletedRight, String s, StringBuilder sb, ArrayList<String>list){
    //Unbalanced
    if(toSelectLeft < toSelectRight) return;
    //Check if valid
    if(index == s.length()){
        //Found balanced
        if(toDeleteLeft == 0 && toDeleteRight == 0 && toSelectLeft == toSelectRight) list.add(sb.toString());
        return;
    }
    char ch = s.charAt(index);
    if(ch == '('){
        //Select, avoiding duplicates as not extra encountered yet
        if(!deletedLeft || s.charAt(index-1) != '('){
            sb.append(ch);
            recurParentheses(toDeleteLeft, toDeleteRight, toSelectLeft + 1, toSelectRight, index + 1, false, false, s, sb, list);
            //Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
        //Not selected, delete
        if(toDeleteLeft > 0) recurParentheses(toDeleteLeft - 1, toDeleteRight, toSelectLeft, toSelectRight, index + 1, true, false, s, sb, list);
    }
    else if(ch == ')'){
        //Select, avoiding duplicates as not extra encountered yet
        if(!deletedRight || s.charAt(index-1) != ')'){
            sb.append(ch);
            recurParentheses(toDeleteLeft, toDeleteRight, toSelectLeft, toSelectRight + 1, index + 1, false, false, s, sb, list);
            //Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
        //Not selected, delete
        if(toDeleteRight > 0) recurParentheses(toDeleteLeft, toDeleteRight - 1, toSelectLeft, toSelectRight, index + 1, false, true, s, sb, list);
        
    }
    else{
        sb.append(ch);
        recurParentheses(toDeleteLeft, toDeleteRight, toSelectLeft, toSelectRight, index + 1, false, false, s, sb, list);
        //Backtrack
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
    }
}
        
