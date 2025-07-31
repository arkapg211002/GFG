class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x:arr){
            pq.add(A*x*x+B*x+C);
        }
        
        ArrayList<Integer> list= new ArrayList<>();
        
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        return list;
        
    }
}
