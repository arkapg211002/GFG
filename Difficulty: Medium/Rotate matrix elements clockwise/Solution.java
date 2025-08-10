// User function Template for Java

class Solution {
    int[][] rotateMatrix(int M, int N, int Mat[][]) {
        // code here
   
        int prev=0, temp=0;
        
        for(int i=0; i<N;i++){
            
            if(i<M-1-i && i< N-1-i){
            
            prev = Mat[i+1][i];
            for(int j=i; j<N-1-i; j++){
                temp = Mat[i][j];
                Mat[i][j] = prev;
                prev = temp;
            }
            
            for(int j=i; j<M-1-i; j++){
                temp = Mat[j][N-1-i];
                Mat[j][N-1-i] = prev;
                prev = temp;
            }
            
            for(int j=N-1-i; j>i; j--){
                temp = Mat[M-i-1][j];
                Mat[M-i-1][j] = prev;
                prev = temp;
            }
            
            for(int j=M-1-i; j>i; j--){
                temp = Mat[j][i];
                Mat[j][i] = prev;
                prev = temp;
            }
            
            } else break;
        }
        
        return Mat;
        
    }
}

