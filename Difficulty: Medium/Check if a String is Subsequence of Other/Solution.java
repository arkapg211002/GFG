// User function Template for Java

class Solution
{
    //Function to check if a string is subsequence of other string.
    public static boolean isSubSequence(String A, String B)
    {
        //code here
        int i = 0,j = 0;
        while(i<B.length() && j<A.length())
        {
            if(B.charAt(i) == A.charAt(j))
            {
                j++;
                i++;
            }
            else
            {
                i++;
            }
        }
        if(j == A.length())
        return true;
        else
        return false;
        
    }
};
