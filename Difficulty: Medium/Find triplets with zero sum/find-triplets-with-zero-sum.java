//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=n-3;i>-1;i--){
            int x=arr[i+1];
            for(int j=i+2;j<n;j++){
                set.add(x+arr[j]);
            }
            if(set.contains(-arr[i])) return true;
        }
        return false;
    }
}