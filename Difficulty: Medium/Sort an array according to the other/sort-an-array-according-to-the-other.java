//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        Arrays.sort(A1);
        int arr[]=new int[N];
        int k=0;
        ArrayList<Integer> ok = new ArrayList<>();
        HashMap<Integer,Integer> hs= new HashMap<>();
        for(int i=0;i<N;i++){
          hs.put(A1[i], hs.getOrDefault(A1[i], 0) + 1);
        }
        for(int i=0;i<M;i++){
            if(hs.containsKey(A2[i])){
                int time=hs.get(A2[i]);
                for(int j=0;j<time;j++){
                    arr[k++]=A2[i];
                }
                hs.remove(A2[i]);
           }
        }
        for(Map.Entry<Integer,Integer> entry: hs.entrySet()){
          int count = entry.getValue();
            while (count > 0){
                ok.add(entry.getKey());
                count--;
            }
        }
        Collections.sort(ok);
        for(int i = 0; i < ok.size(); i++){
         arr[k++] = ok.get(i);
         }
        return arr;
    }
}





//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends