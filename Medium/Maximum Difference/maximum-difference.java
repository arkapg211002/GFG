//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int a[], int n)
    {
    	// Your code here
    	int la[]=new int[n];
    	int ra[]=new int[n];
    	Stack<Integer>s=new Stack<>();
    	s.push(a[0]);
    	la[0]=0;
    	for(int i=1;i<n;i++)
    	{
    	    while(!s.isEmpty() && s.peek()>=a[i]) s.pop();
    	    la[i]=(!s.isEmpty())? s.peek() : 0;
    	    s.push(a[i]);
    	}
    	s.removeAllElements();
    	s.push(a[n-1]);
    	ra[n-1]=0;
    	for(int i=n-2;i>=0;i--)
    	{
    	    while(!s.isEmpty() && s.peek()>=a[i]) s.pop();
    	    ra[i]=(!s.isEmpty())? s.peek() : 0;
    	    s.push(a[i]);
    	}
    	s.removeAllElements();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=(int)Math.max(max,(int)Math.abs(la[i]-ra[i]));
        }
	    return max;
    }
}