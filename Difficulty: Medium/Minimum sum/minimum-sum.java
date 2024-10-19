//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        Arrays.sort(arr);
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i%2==0)sb1.append(String.valueOf(arr[i]));
            else sb2.append(String.valueOf(arr[i]));
        }
        String temp=getSum(sb1.toString(),sb2.toString());
        StringBuilder res= new StringBuilder();
        int i;
        for(i=0;i<temp.length();i++){
            if(temp.charAt(i)=='0') continue;
            else break;
        }
        for(int j=i;j<temp.length();j++){
            res.append(temp.charAt(j));
        }
        if(res.toString().equals(""))res.append("0");
        return res.toString();
    }
    String getSum(String s1, String s2){
        StringBuilder res=new StringBuilder("");
        int carry=0,temp=0;
        int i,j;
        for(i=s1.length()-1,j=s2.length()-1;i>=0 && j>=0;i--,j--){
            temp=carry+Integer.valueOf(s1.charAt(i)-48)+Integer.valueOf(s2.charAt(j)-48);
            if(temp>9){
                carry=1;
                temp-=10;
            }else carry=0;
            res.insert(0,String.valueOf(temp));
        }
        while(i>=0){
            temp=carry+Integer.valueOf(s1.charAt(i)-48);
            if(temp>9){
                carry=1;
                temp-=10;
            }else carry=0;
            res.insert(0,String.valueOf(temp));
            i--;
        }
        while(j>=0){
            temp=carry+Integer.valueOf(s2.charAt(j)-48);
            if(temp>9){
                carry=1;
                temp-=10;
            }else carry=0;
            res.insert(0,String.valueOf(temp));
            j--;
        }
        if(carry==1) res.insert(0,1);
        return res.toString();
    }
}