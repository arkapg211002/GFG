//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {

    int parent[];

    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {

        // Code Here

        ArrayList<String>ans=new ArrayList<>();

        parent =new int[n+1];

        for(int i=0;i<=n;i++){

            parent[i]=i;

        }

        for(int i=0;i<n;i++)

        {

            int a=find(mix[i][0]);

            int b=find(mix[i][1]);

              boolean x=true;

            for(int j=0;j<m;j++){

                int c=find(danger[j][0]);

                int d=find(danger[j][1]);

            if((a==c&&b==d)||(a==d&&b==c)){

                x=false;

                break;

            }

            }

        if(x){union(a,b);

        ans.add("Yes");}

        else ans.add("No");

      

    }

    return ans;

    }

    void union(int x,int y){

        int x_ref=find(x);

        int y_ref=find(y);

        if(x_ref==y_ref)return;

        parent[x_ref]=y_ref;

    }

    int find(int x){

        if(parent[x]==x)

        return x;

        return find(parent[x]);

    }

}