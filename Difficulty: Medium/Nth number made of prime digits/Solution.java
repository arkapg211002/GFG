class Solution
{
    //Function to find nth number made of only prime digits.
    public static boolean isTrue(int n,String str){
        int rem=0;
        while(n>0){
            rem=n%10;
            if(!str.contains(String.valueOf(rem))){
                return false;
            }
            n=n/10;
        }
        return true;
    }
    public static int primeDigits(int n)
    {
        //Your code here
        String primes="2357";
        int count=0;
        int term=2;
        while(count<n){
            if(isTrue(term,primes)){
                count++;
            }
            if(count==n){
                return term;
            }
            term++;
        }
        return 0;
    }
}

