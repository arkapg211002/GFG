

class Solution{
    static int[] sieve(int N){
        int prime[] = new int[N + 1];
        ArrayList<Integer> List = new ArrayList<>();
        
        int i = 2;
        while ( i * i <= N ){
            if ( prime[i] == 0 ){
                for ( int j = i + i; j <= N; j += i ){
                    prime[j] = 1; 
                }
            }
            i += 1;
        }
        
        for ( int j = 2; j <= N; j += 1 ){
            if ( prime[j] == 0 ){
                List.add(j);
            }
        }
        
        int ans[]=new int[List.size()];
        
        for(i=0; i<List.size();i++) ans[i]=List.get(i);
        return ans;
    }
}
