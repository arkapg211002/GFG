//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
	public static void main(String args[]) throws IOException { 
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int n = sc.nextInt();
			
			int arr[][] = new int[n][2];
          
        	for( int i=0 ; i<n ; i++ ){            
            	for( int j=0 ; j<2 ; j++ ){
                	arr[i][j] = sc.nextInt();
            	}
         	}
            
            solver solve = new solver();
			System.out.println( solve.max_non_overlapping(arr,n) ); 
			t--;
		
System.out.println("~");
}
	} 
}


// } Driver Code Ends



// ranges[i][0] is the start of ith range
// ranges[i][1] is the end of ith range

class solver
{
    static int max_non_overlapping(int ranges[][], int n){
        Arrays.sort(ranges,(a,b) -> a[1] - b[1] == 0 ? b[0] - a[0] : a[1] - b[1]);
        int count = 1;
        int last =  ranges[0][1];
        for(int i = 1 ; i < n ; i++){
            if(last <= ranges[i][0]) {
                count++;
                last = ranges[i][1];
            }
        }
        return count;
    }
}