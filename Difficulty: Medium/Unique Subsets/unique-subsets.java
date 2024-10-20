//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends

class solve
{
    //Function to find all possible unique subsets.
    static SortedSet<String> ans;
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        ans = new TreeSet<>();
        Arrays.sort(arr);
        
        traverse(arr, n, 0, new ArrayList<Integer>());
        
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        
        for(String a: ans){
            
            ArrayList<Integer> subset = new ArrayList<>();
            
            for(int i = 0;i<a.length();i++){
                subset.add(a.charAt(i) - '0');
            }
            
            subsets.add(subset);
            
            
        }
        
        return subsets;
        
    }
    
    
    private static void traverse(int[] arr, int n, int i, ArrayList<Integer> curr){
        
        if(i == n){
            
            StringBuilder currans = new StringBuilder();
            for(int ele : curr){
                currans.append(ele);
            }
            
            ans.add(currans.toString());
            
            return;
            
        }
        
        // exclude element
        traverse(arr, n, i+1, curr);
        
        // include element
        curr.add(arr[i]);
        traverse(arr, n, i+1, curr);
        curr.remove(curr.size()-1); // remove the last element when backtracking
        
        
    }
    
}


