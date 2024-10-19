//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution

{

    public static int kthSmallest(int[][]mat,int n,int k)

    {

        //code here.

        int m = n*n;

        int r = mat.length;

        int c = mat[0].length;

        int[] arr = new int[m];

        int ind = 0;

        for(int i=0;i<r;i++){

            for(int j=0;j<c;j++){

                arr[ind] = mat[i][j];

                ind++;

            }

        }

        Arrays.sort(arr);

        int s=arr[k-1];

       

return s;

    }

}