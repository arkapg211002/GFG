//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
        	String [] str = br.readLine().trim().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	ArrayList<ArrayList<Integer>> trains = new ArrayList<>();
        	for(int i = 0; i < m; i++) {
        		str = br.readLine().trim().split(" ");
        		ArrayList<Integer> arr = new ArrayList<>();
        		for(int j = 0; j < 3; j++)
        			arr.add(Integer.parseInt(str[j]));
        		trains.add(arr);
        	}
        	Solution obj = new Solution();
        	int res = obj.maxStop(n, m, trains);
        	System.out.println(res);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
	int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
	   if(m == 0) {
	       return 0;
	   } 
	    
       Collections.sort(trains, new Comparator<>() {
          public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
              if(t1.get(2) == t2.get(2)) {
                  if(t1.get(1) == t2.get(1)) {
                      return Integer.compare(t2.get(0), t1.get(0));
                  }
                  return Integer.compare(t1.get(1), t2.get(1));
              }
              return Integer.compare(t1.get(2), t2.get(2));
          }
       });
       
       int totalTrainCanBeStopped = 1;
       
       ArrayList<Integer> lastTrain = trains.get(0);
       
       for(int i=1; i<m; i++) {
           ArrayList<Integer> currTrain = trains.get(i);
           if((currTrain.get(2) != lastTrain.get(2)) || (currTrain.get(0) >= lastTrain.get(1))) {
               totalTrainCanBeStopped++;
               lastTrain = currTrain;
           }
       }
       
       return totalTrainCanBeStopped;
    }
    
}