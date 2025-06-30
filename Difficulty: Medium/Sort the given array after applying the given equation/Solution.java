class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
         int n=arr.length;
        for(int i=0; i<n; i++){
            int x=arr[i];
            arr[i]=(A*x*x+B*x+C);
        }
        Arrays.sort(arr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : arr) {
            arrayList.add(num); 
        }
        return arrayList;
    }
}
