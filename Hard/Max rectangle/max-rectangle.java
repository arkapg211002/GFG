//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends




/*Complete the function given below*/
class Solution {
    public static int[] nextSmaller(int x[]){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int ans[] = new int[x.length];
        for(int i = x.length - 1;i>=0;i--)
        {
            int curr = x[i];
            while(s.peek()!=-1 && x[s.peek()] >= curr)
            {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }
    public static int[] prevSmaller(int x[]){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int ans[] = new int[x.length];
        for(int i = 0;i<x.length;i++)
        {
            int curr = x[i];
            while(s.peek()!=-1 && x[s.peek()] >= curr)
            {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int next[] = nextSmaller(heights);
        int prev[] = prevSmaller(heights);
        for(int i = 0;i<heights.length;i++)
        {
            int l = heights[i];
            if(next[i]==-1)
            {
                next[i] = heights.length;
            }
            int b = next[i] - prev[i] - 1;
            int newArea = l*b;
            area = Math.max(area,newArea);
            
        }
        return area;
    }
    public int maxArea(int M[][], int n, int m) {
        int ans = largestRectangleArea(M[0]);
        for(int i = 1;i<n;i++)
            {
                for(int j = 0;j<m;j++)
                {
                    if(M[i][j] != 0)
                        M[i][j] = M[i][j] + M[i-1][j];
                    else
                        M[i][j] = 0;
                }
                ans = Math.max(ans,largestRectangleArea(M[i]));
            }
            return ans;
    }
}