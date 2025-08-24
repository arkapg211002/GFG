class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int x : arr) {
            if (x % 2 == 0) even.add(x);
            else odd.add(x);
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);


        int idx = 0;
        for (int x : odd) arr[idx++] = x;
        for (int x : even) arr[idx++] = x;
    }
}
