// https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

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
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
        Arrays.sort(arr, new Comparator<Job>(){
           public int compare(Job j1, Job j2) {
               return j2.profit-j1.profit;
           }
        });
        
        int count=0;
        int maxProfit=0;
        int maxDeadline=0;
        for(Job j:arr){
            maxDeadline=Math.max(maxDeadline, j.deadline);
        }
        int[] schArr=new int[maxDeadline+1];
        Arrays.fill(schArr, -1);
        
        for (Job j : arr) {
            for (int d = j.deadline; d > 0; d--) { // Start from the job's deadline and move backwards
                if (schArr[d] == -1) { // If the slot is available
                    schArr[d] = j.id;
                    maxProfit += j.profit;
                    count++;
                    break;
                }
            }
        }

        return new int[]{
            count,maxProfit
        };
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
