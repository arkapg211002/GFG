//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       ArrayList<Integer>ans=new ArrayList<>(m);
       Arrays.sort(arr2);
       
       for(int i=0;i<m;i++) {
           int s=0,e=n-1,ind=-1;
           
           
           while(s<=e) {
               int mid=s+(e-s)/2;
               
               if(arr2[mid] > arr1[i]) {
                   e=mid-1;
               }else {
                   ind=mid;
                   s=mid+1;
               }
           }
           
           ans.add(ind+1);
       }
       return ans;
    }
}