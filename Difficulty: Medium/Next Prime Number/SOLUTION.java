//{ Driver Code Starts

// } Driver Code Ends

import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=n+1;i<=1000;i++){
            if(check(i)){
                System.out.println(i);
                break;
            }
        }
    }
    static boolean check(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0)count++;
        }
        if(count==2)return true;
        return false;
    }
    
}


//{ Driver Code Starts.
// } Driver Code Ends
