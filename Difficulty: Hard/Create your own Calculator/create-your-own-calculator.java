//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            double[][] Arr = new double[3][4];
            for(int i = 0; i < 3; i++){
                String input_line[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < 4; j++){
                    Arr[i][j] = Double.parseDouble(input_line[j]);
                }
            }
            Solution ob = new Solution();
            double[] ans = ob.myCalculator(Arr);
            for(int i = 0; i < ans.length; i++)
            {
                if(isInteger(ans[i]))
                System.out.print((int)ans[i] + " ");
                else
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isInteger(double N)
	{
		int X = (int)N;
		double temp2 = N - X;
		if (temp2 > 0)
		{
			return false;
		}
		return true;
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public double[] myCalculator(double[][] a) {
        double jk[] = new double[3];
        int t = a.length;
        while (t != 0) {
            double a1 = a[0][0], b1 = a[0][1], c1 = a[0][2], d1 = a[0][3];
            double a2 = a[1][0], b2 = a[1][1], c2 = a[1][2], d2 = a[1][3];
            double a3 = a[2][0], b3 = a[2][1], c3 = a[2][2], d3 = a[2][3];
            double dx = 0, dy = 0, dz = 0, d = 0;
            dx = d1 * (b2 * c3 - b3 * c2) - b1 * (d2 * c3 - d3 * c2) + c1 * (d2 * b3 - d3 * b2);
            dy = a1 * (d2 * c3 - d3 * c2) - d1 * (a2 * c3 - a3 * c2) + c1 * (a2 * d3 - a3 * d2);
            dz = a1 * (b2 * d3 - b3 * d2) - b1 * (a2 * d3 - a3 * d2) + d1 * (a2 * b3 - a3 * b2);
            d = a1 * (b2 * c3 - b3 * c2) - b1 * (a2 * c3 - a3 * c2) + c1 * (a2 * b3 - a3 * b2);
            if (d == 0) {
                jk[0] = 0;
                jk[1] = 0;
                jk[2] = 0;
            } else {
                double x1 = (dx / d), y1 = (dy / d), z1 = (dz / d);
                jk[0] = Math.floor(x1);
                jk[1] = Math.floor(y1);
                jk[2] = Math.floor(z1);
            }
            t--;
        }
        return jk;
    }
}