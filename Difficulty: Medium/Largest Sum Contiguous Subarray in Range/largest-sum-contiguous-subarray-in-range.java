//{ Driver Code Starts
//Initial Template for Java

// Java program to find Largest Sum Contiguous 
// Subarray in a given range with updates 

import java.util.*;

class GFG  
{ 
  
    // Structure to store 4 values that are  
    // to be stored in the nodes 
    static class node 
    { 
        int sum, prefixsum, suffixsum, maxsum; 
    }; 
      
    // array to store the segment tree 
    static node[] tree = new node[4 * 1000]; 
      
    // function to build the tree 
    static void build(int arr[], int low,  
                      int high, int index) 
    { 
        // the leaf node 
        if (low == high)  
        { 
            tree[index].sum = arr[low]; 
            tree[index].prefixsum = arr[low]; 
            tree[index].suffixsum = arr[low]; 
            tree[index].maxsum = arr[low]; 
        }  
        else 
        { 
            int mid = (low + high) / 2; 
      
            // left subtree 
            build(arr, low, mid, 2 * index + 1); 
      
            // right subtree 
            build(arr, mid + 1, high, 2 * index + 2); 
      
            // parent node's sum is the summation  
            // of left and rigth child 
            tree[index].sum = tree[2 * index + 1].sum +  
                              tree[2 * index + 2].sum; 
      
            // parent node's prefix sum will be equivalent 
            // to maximum of left child's prefix sum or left  
            // child sum + right child prefix sum. 
            tree[index].prefixsum = Math.max(tree[2 * index + 1].prefixsum,  
                                             tree[2 * index + 1].sum +  
                                             tree[2 * index + 2].prefixsum); 
      
            // parent node's suffix sum will be equal to right 
            // child suffix sum or rigth child sum + suffix  
            // sum of left child 
            tree[index].suffixsum = Math.max(tree[2 * index + 2].suffixsum,  
                                             tree[2 * index + 2].sum + 
                                             tree[2 * index + 1].suffixsum); 
      
            // maxum will be the maximum of prefix, suffix of 
            // parent or maximum of left child or right child 
            // and summation of left child's suffix and right  
            // child's prefix. 
            tree[index].maxsum = Math.max(tree[index].prefixsum, 
                                 Math.max(tree[index].suffixsum,  
                                 Math.max(tree[2 * index + 1].maxsum,  
                                 Math.max(tree[2 * index + 2].maxsum, 
                                          tree[2 * index + 1].suffixsum + 
                                          tree[2 * index + 2].prefixsum)))); 
        } 
    } 
    
    
// } Driver Code Ends
//User function Template for Java

public static void updateval(int index,int new_val,int low,int high,int ind){
    if(low==high){
        tree[ind].sum = new_val;
        tree[ind].prefixsum = new_val;
        tree[ind].suffixsum = new_val;
        tree[ind].maxsum = new_val;
    }
    else{
        int mid = low+(high-low)/2;
        if(index<=mid) updateval(index,new_val,low,mid,2*ind+1);
        else updateval(index,new_val,mid+1,high,2*ind+2);
        int left=2*ind+1,right = 2*ind+2;
        tree[ind].sum = tree[left].sum+tree[right].sum;
        tree[ind].prefixsum = Math.max(tree[left].prefixsum,tree[left].sum+tree[right].prefixsum);
        tree[ind].suffixsum = Math.max(tree[right].suffixsum,tree[right].sum+tree[left].suffixsum);
        tree[ind].maxsum = Math.max(tree[ind].prefixsum,
                           Math.max(tree[ind].suffixsum,
                           Math.max(tree[left].maxsum,
                           Math.max(tree[right].maxsum,tree[left].suffixsum+tree[right].prefixsum))));
    }
}


//Function to update a value in input array and segment tree.
static void update(int arr[], int arrSize, int index, int value)
{
    // Your code here
    arr[index-1] = value;
    updateval(index-1,value,0,arr.length-1,0);
    
}


public static node getRangeSum(int low,int high,int l,int r,int ind)
{
    if(low>=l&&high<=r)
     return tree[ind];
    else if(high<l||low>r) {
        node temp = new node();
        temp.sum=temp.prefixsum=temp.suffixsum=temp.maxsum =-1000002;
        return temp;
    }
    else{
        int mid = low+(high-low)/2;
        // if (l > mid) {
        //     getRangeSum(mid+1,high,l,r,2*ind+2);
        // }

        // // left subtree
        // if (r <= mid) {
        //     getRangeSum(low,mid,l,r,2*ind+1);
        // }
        node left = getRangeSum(low,mid,l,r,2*ind+1);
        node right = getRangeSum(mid+1,high,l,r,2*ind+2);
        node temp = new node();
        temp.sum = left.sum+right.sum;
        temp.prefixsum = Math.max(left.prefixsum,left.sum+right.prefixsum);
        temp.suffixsum = Math.max(right.suffixsum,right.sum+left.suffixsum);
        temp.maxsum = Math.max(temp.prefixsum,
                      Math.max(temp.suffixsum,
                      Math.max(left.maxsum,
                      Math.max(right.maxsum,left.suffixsum+right.prefixsum))));
        return temp;
    }
}
 

//Funciton to return the Maximum-Sum in the range.
static int query(int arr[], int n, int left, int right) 
{
    // code here
    return getRangeSum(0,n-1,left-1,right-1,0).maxsum;
}


//{ Driver Code Starts.
      
    // Driver Code 
    public static void main(String[] args)  
    { 
        
        Scanner sc = new Scanner(System.in); 
        
        int t;
        t = sc.nextInt();
        
        while(t-->0)
        {
            int n, q, index, value, left, right, type;
            n = sc.nextInt();
            q = sc.nextInt();
            
            int a[] = new int[n];
            
            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
                
            for (int i = 0; i < 4 * 1000; i++)  
            { 
                tree[i] = new node(); 
            } 
              
            // build the tree 
            build(a, 0, n - 1, 0); 
            
            for(int i=0; i<q; i++)
            {
                type = sc.nextInt();
    	        if(type==1){
    	            left = sc.nextInt();
    	            right = sc.nextInt();
    	            System.out.println(query(a,n, left, right)); 
    	            
    	        } else {
    	            index = sc.nextInt();
    	            value = sc.nextInt();
    	            
    	            //a[index - 1] = value; 
    	            
    	            update(a, n, index, value);
                    //updateUtil(a, 0, 0, n - 1, index - 1, value);
    	        }
            }
        
        
System.out.println("~");
}
        
    } 
}
  

// } Driver Code Ends