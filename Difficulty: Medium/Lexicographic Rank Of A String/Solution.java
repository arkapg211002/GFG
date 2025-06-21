// User function Template for Java

class Solution
{
    //Function to find lexicographic rank of a string.
    static long fact(long n){
        if(n<=1){
            return 1;
        }
        return (n*fact(n-1))%1000000007;
    }
    static long findRank(String S) 
    {
        long n = S.length();
        long m = 0;
        long res = 1;
        int[] count = new int[256];
        for(int i=0;i<n;i++){
            if(count[S.charAt(i)]==1){
                return 0;
            } else{
                count[S.charAt(i)]++;
            }
        }
        for(int i=1;i<256;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<n;i++){
            m = fact(n-i-1);
            res=  (res + (m*count[S.charAt(i)-1]))%1000000007;
            for(int j=S.charAt(i);j<256;j++){
                count[j]--;
            }
        }
        return res;
    }
}
