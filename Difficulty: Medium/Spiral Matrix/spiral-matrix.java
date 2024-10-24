//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findK(int arr[][], int r, int c, int k){
	    int i=0;
		int j=0;
		int tne=r*c;
		int cnt=0;
	
		
		while(i<r && j<c && cnt<tne) {
			for(int x=i,y=j;y<c && cnt<tne ;y++) {
			    cnt++;
			    if(cnt==k)return arr[x][y];
			}
			i++;
			
			for(int x=i,y=c-1;x<r&& cnt<tne ;x++) {
		    	cnt++;
		    	if(cnt==k)return arr[x][y];
			}
			c--;
			
			for(int x=r-1,y=c-1;y>=j && cnt<tne;y--) {
			  	cnt++;
		    	if(cnt==k)return arr[x][y];
			}
			r--;
		
			for(int x=r-1,y=j;x>=i && cnt<tne;x--) {
			 	cnt++;
		    	if(cnt==k)return arr[x][y];
			}
			j++;			
			
		}
		
		return -1;
	}
}