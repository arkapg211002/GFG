//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            long ans = ob.findgroups(arr);
            System.out.println(ans);
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    public long findgroups(int[] arr) {
        // Your Code goes here
        long zero=0;
        long one=0;
        long two=0;
        for(int i: arr){
            if(i%3==0) zero++;
            if(i%3==1) one++;
            if(i%3==2) two++;
        }
        long ans=0;
        //group of 2
        //case 1 when all 2 are mltiple of three
        ans+=(zero*(zero-1))/2L;
        //case 2 when 1 rem is 1 one is 2
        ans+=(one*two);
        //for a group of 3
        //case 1: when all are multiple of 3 : rem is 0
        ans+=(zero*(zero-1)*(zero-2))/6L;
        //case 2: when one rem is 0 one is 2 and one is 1
        ans+=(zero*one*two);
        //case 3: when all three are 1s
        ans+=(one*(one-1)*(one-2))/6L;
        //case 4: when all three are 2
        ans+=(two*(two-1)*(two-2))/6L;
        return ans;
    }
}