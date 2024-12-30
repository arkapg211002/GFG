//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int[] arr = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().largestDivisibleSubset(arr);

            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends



/*
2 190 10 102 182 183 114 103 26 108 63
Your Code's output is: 
2 10 190
It's Correct output is: 
2 26 182
*/


// User function Template for Java

class Solution {
    public ArrayList<Integer> largestDivisibleSubset(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int n=arr.length;
        int ct[]=new int[n];
        int ind[]= new int[n];
        int mx=1;
        ct[0]=1;
        for(int i=1;i<n;i++){
            ct[i]=1;
            ind[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    if(ct[i]<= (ct[j]+1)){
                        ct[i]=ct[j]+1;
                        ind[i]=j;
                    }
                }
            }
            mx=Math.max(ct[i], mx);
        }
        //  System.out.println(Arrays.toString(ct));
        // System.out.println("MX  +" +mx+ Arrays.toString(ind));
    
        ArrayList<Integer>  res= new ArrayList<>();
        
        for(int i=n-1;i>=0;i--){
            // System.out.print(" i = "+ i);
            if(ct[i]==mx){
                // System.out.println(" i = "+ i);
                ArrayList<Integer> li = new ArrayList<>();
                int x=ct[i];
                int ctr=0;
                int vl= ind[i];
                li.add(arr[i]);
                --x;
                int idx=i;
                while(x>0){
                    li.add(0,arr[ind[idx]] );
                    // System.out.println(" i = "+ i);
                    idx= ind[idx];
                    
                    if(ind[idx]== idx){
                        break;
                    }
                    ++ctr;
                    --x;
                }
                // System.out.println(li);
                if(res.size()==0){
                    res=li;
                }else{
                    for(int k=0;k<res.size();k++){
                        if(li.get(k)> res.get(k)){
                            res=li;
                            break;
                        }else if (li.get(k)== res.get(k)){
                            continue;
                        }
                        break;
                    }
                }
                // System.out.println(li +" and res= " +res);
                // return li;
                
            }else{
                continue;
            }
        }
        return res;
    }
}