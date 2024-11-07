//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            double a[] = new double[(int)(n)];
            double getAnswer[] = new double[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Double.parseDouble(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.nullPoints(n, a, getAnswer); 
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n-1;i++)
                output.append(String.format("%.2f", getAnswer[i])+" ");
                
            System.out.println(output);
            
        
System.out.println("~");
}
	}
}



// } Driver Code Ends




//User function Template for Java

class Solution {
    
    private double neutralPoint(double low, double high,double[] magnets){
        while(high-low>1e-6){
            double mid=(low+high)/2;
            double totalForce=0.0;
            for(double magnet:magnets){
                totalForce+=1.0/(mid-magnet);
            }
            if(Math.abs(totalForce)<1e-6){
                return mid;
            }else if(totalForce<0){
                high=mid;
            }else{
                low=mid;
            }
        }
        return low;
    }
    
    public void nullPoints(int n, double magnets[], double getAnswer[])
    {
        // Your code goes here 
        for(int i=0;i<n-1;i++){
            getAnswer[i]=Math.round(neutralPoint(magnets[i],magnets[i+1],magnets)*100.0)/100.0;
            
        }
        
    }
    
}

