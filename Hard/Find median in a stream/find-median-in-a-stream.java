//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //T = O(n log n)
    // s = n
    
    //using the heap
    
    PriorityQueue<Integer> right = new PriorityQueue<>(); // min heap
    PriorityQueue<Integer> left = new PriorityQueue<>( Comparator.reverseOrder()  ); // max heap
    
    public  void insertHeap(int x)
    {
        
        
        if( left.isEmpty() || x < left.element() ){
            
            left.add( x);
            
        }else{
            
            right.add(x);
        }
        
        // now doing equal the size of the heap or left > right by 1 
        
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public void balanceHeaps()
    {
       // here we equal the size of the heap of left > right by 1 
       
       int diff = left.size() - right.size();
       
       switch(diff){
          
        
        case -1: left.add(right.poll()); //right is big
                 break;
        case 2: right.add( left.poll()); // left is big
                 break;
                 
        default: break;
           
       }
       

    }
    
    //Function to return Median.
    public  double getMedian()
    {
        // here we return ans based on condtion even and odd
         int totalSize = left.size() +  right.size();
         
     // If the total size is odd, return the top element of the larger heap.
 
        if (totalSize % 2 != 0) {
            
            // becase we are maintaing left > right by 1 that is odd in left 
            return left.peek();
        } else {
        // If the total size is even, return the average of the top elements of both heaps.
             return (left.peek() + right.peek()) / 2.0;
        }      
         
         
    }
    
}

