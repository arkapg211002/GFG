//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);
            Solution obj = new Solution();
            int ans = obj.nCrModM(n, r, m);
            System.out.println(ans);

        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
     public int nCrModM(int n, int r, int m)
   {
     
         List<Integer>primes;
       primes=findPrimeFactors(m);
       List<Integer> rem=new ArrayList<Integer>();
       for(int p:primes){
           rem.add(rCnModPrimeLucas(n, r, p));
       }
       return findByCrt(primes, rem);
   }
   static List<Integer> findPrimeFactors(int n){
       Set<Integer> factors=new HashSet<>();
       List<Integer> ans=new ArrayList<Integer>();
       int c=2;
       while(n>1){
           if(n%c==0){
               factors.add(c);
               n/=c;
           }
           else
               c++;
       }
       for(int i:factors){
           ans.add(i);
       }
       return ans;
   }
    static int findByCrt(List<Integer> x,List<Integer> r){
       int N=x.size();
       int min_x=0;
       while(true){
           boolean found=true;
           for(int i=0;i<N;i++){
               if(min_x%x.get(i)!=r.get(i)){
                   found=false;
                   break;
               }
           }
           if(found){
               return min_x;
           }
           min_x++;
       }
   }
   static int rCnModP(int n, int r, int p){
       if(r==0||r==n){
           return 1;
       }
       int nCr[]=new int[r+1];
       nCr[0]=1;
       for(int i=1;i<=n;i++){
           for(int j=Math.min(i,r);j>0;j--){
               nCr[j]=(nCr[j]+nCr[j-1])%p;
           }
       }
       return nCr[r];
   }
   static int rCnModPrimeLucas(int n, int r, int p){
       if(r==0) {
           return 1;
       }
       return (rCnModPrimeLucas(n/p, r/p, p)*rCnModP(n%p, r%p, p))%p;
   }
}