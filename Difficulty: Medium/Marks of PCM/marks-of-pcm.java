//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    class Student{
        int physics,chemistry,maths;
        Student(int ph,int chm,int math){
            this.physics=ph;
            this.chemistry=chm;
            this.maths=math;
        }
        
    }
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        // your code here
        Student[] arr=new Student[N];
        for(int i=0;i<N;i++){
            arr[i]=new Student(phy[i],chem[i],math[i]);
        }
        
            Arrays.sort(arr,(a,b)->{
                //physics sort
                if(a.physics!=b.physics) return a.physics-b.physics;
                if(a.chemistry!=b.chemistry) return b.chemistry-a.chemistry;
                return a.maths-b.maths;
                
            });
            for(int i=0;i<N;i++){
                phy[i]=arr[i].physics;
                chem[i]=arr[i].chemistry;
                math[i]=arr[i].maths;
              }
    }
}