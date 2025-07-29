class Solution {
    public int nthRoot(int n, int m) {
        if(n==1)return m;
        for(int i=2; i*i<=m; i++){
            if(Math.pow(i, n)==m)return i;
        }
        return -1;
        
        
    }
}
