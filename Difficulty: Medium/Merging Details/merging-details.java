//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {

    public List<List<String>> mergeDetails(List<List<String>> details) {
        int n = details.size();
        DisJointSet dsj = new DisJointSet(n);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //will keep everything into the map
        for(int i =0;i<n;i++)
        {
            //here j should start from 1 because first one contains the name 
            for(int j =1;j<details.get(i).size();j++)
            {
                String mail = details.get(i).get(j);
                if(map.containsKey(mail) == false)
                {
                    map.put(mail,i);
                }
                else
                {
                    dsj.unionBySize(map.get(mail),i);
                }
            }
        }
        
        //we will take out the values from the map and will form a list of string array
        List<String>[] mergedmail = new ArrayList[n];
        for(int i =0;i<n;i++)
        {
            mergedmail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> it:map.entrySet())
        {
            String mergemail = it.getKey();
            int node = dsj.findUltiParent(it.getValue());
            mergedmail[node].add(mergemail);
        }
        
        //now will elimate the duplicates and will form a ans list
        List<List<String>> ans = new ArrayList<>();
        for(int i =0;i<n;i++)
        {
            if(mergedmail[i].size()==0)
            {
                continue;
            }
            //sort the mergedmail array
            Collections.sort(mergedmail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for(String it:mergedmail[i])
            {
                temp.add(it);
            }
        
            ans.add(temp);
        }
        
        
        return ans;
    }
}

class DisJointSet
{
	private ArrayList<Integer> rank = new ArrayList<>();
	 ArrayList<Integer> parent = new ArrayList<>();
	private ArrayList<Integer> size = new ArrayList<>();
	public DisJointSet(int n)
	{
		for(int i=0;i<=n;i++)
		{
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}
	public int findUltiParent(int node)
	{
		if(node == parent.get(node))
		{
			return node;
		}
		int ult_p = findUltiParent(parent.get(node));
		parent.set(node,ult_p);
		return parent.get(node);
	}
	public void unionBySize(int u,int v)
	{
		int ulp_u = findUltiParent(u);
		int ulp_v = findUltiParent(v);
		
		if(rank.get(ulp_u) < rank.get(ulp_v))
		{
			parent.set(ulp_u,ulp_v);
			int size_u = size.get(ulp_u);
			size.set(ulp_v,size_u+ulp_v);
		}
		else
		{
			//parent of v will become u
			parent.set(ulp_v,ulp_u);
			size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
		}
		
	}
}