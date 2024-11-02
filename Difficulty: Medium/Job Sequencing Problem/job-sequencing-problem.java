//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


 /*
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
};
*/
 

 /*
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
};
*/
    class Solution{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        
        Arrays.sort(arr,(a,b)->(a.deadline-b.deadline));
       
    boolean vis[]=new boolean[arr[n-1].deadline+1];
    Arrays.sort(arr,(a,b)->a.profit-b.profit);
    int k=0;int j=0;
    for(int i=n-1;i>=0;i--){
        Job h=arr[i];
        if(vis[h.deadline]){
          int m=h.deadline;
          while(m>=1){
              if(!vis[m]){
                 k+=h.profit;
            j++;
            vis[m]=true;break;  
              }
              m--;
          }
            
            continue;
        }else{
            k+=h.profit;
            j++;
            vis[h.deadline]=true;
        }
        
    }
      
       int ans[]=new int[2];
       ans[0]=j;ans[1]=k;
       return ans;
    }
}