//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
     ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> C=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> dp=new ArrayList<>();
        for(int s:A){
            set.add(s);
        }
        for(int s:set){
            C.add(s);
        }
        Collections.sort(C);
        func(0,0,B,dp,res,C);
        Collections.sort(res,com);
        return res;
        
    }
    
        Comparator<ArrayList<Integer>> com=new Comparator<ArrayList<Integer>>(){
        public int compare(ArrayList<Integer> i, ArrayList<Integer> j){
            int p1=0;

            while(p1<i.size() &&  p1<j.size()){
                if(i.get(p1)>j.get(p1)){
                    return 1;
                }
                else if(i.get(p1)==j.get(p1)){
                    p1+=1;
                }
                else{
                    return -1;
                }
            }
            return 0;
        }
    };
    public  void func(int  i,int sum,int k,ArrayList<Integer> dp, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr){
        if(i>=arr.size() || sum>k){
            return ;
        }
        dp.add(arr.get(i));
        sum+=arr.get(i);
        if(sum==k){
            res.add(new ArrayList<>(dp));
        }
        if(sum<k){
            func(i,sum,k,dp,res,arr);
        }
        sum-=dp.get(dp.size()-1);
        dp.remove(dp.size()-1);
        func(i+1,sum,k,dp,res,arr);
    }
}