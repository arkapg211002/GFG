//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends

//User function Template for Java
class Solution{
    static long nineDivisors(long N){
       long root = (long) Math.floor(Math.sqrt(N));
 

ArrayList<Long> l = new ArrayList<>();
for (long i = 2; i <= root / 2; i++)
if (isPrime(i))
l.add(i);
 

int count = 0;
for (int i = 0; i < l.size(); i++) {
long a = l.get(i);
if (Math.pow(a, 4) <= root) {
count++;
}
for (int j = i + 1; j < l.size(); j++) {
long b = l.get(j);
if (a * b <= root) {
count++;
} else
break;
}
}
 
return count;
 
}
 
static boolean isPrime(long n) {
long root = (long) Math.floor(Math.sqrt(n));
 
for (long i = 2; i <= root; i++)
if (n % i == 0)
return false;
return true;
    }
}


//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nineDivisors(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends