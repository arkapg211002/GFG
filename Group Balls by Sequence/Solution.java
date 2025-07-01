class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length; 
        
        if(n % k != 0) {
            return false; 
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
        }
        
        while(!map.isEmpty()) {
            int startingPoint = map.firstKey(); 
            int count = map.get(startingPoint); 
            
            for(int i = 0; i < k; i++) {
                int currentPoint = startingPoint + i; 
                if(!map.containsKey(currentPoint) || map.get(currentPoint) < count) {
                    return false;
                }
                if(map.get(currentPoint) == count) {
                    map.remove(currentPoint); 
                }
                else {
                    map.put(currentPoint , map.get(currentPoint) - count); 
                }
            }
        }
        
        return true;  
        
    }
}
