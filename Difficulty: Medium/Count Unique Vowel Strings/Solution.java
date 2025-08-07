class Solution {
    public int factorial(int n){
        int fact =1;
        for(int i=2; i<=n; i++){
            fact*=i;
        }
        return fact;
    }
    public boolean isVowel(char ch){
        return "aeiou".indexOf(ch) == -1? false: true;
    }
    
    public int vowelCount(String s) {
        // code here
        int totalways=1;
        TreeMap<Character, Integer> m = new TreeMap<>();
        for(char c: s.toCharArray()){
            if(isVowel(c)) m.put(c, m.getOrDefault(c, 0)+1);
        }
        if(m.size()==0) return 0;
        
        for(char c: m.keySet()){
                totalways*=m.get(c);
        }
        return factorial(m.size()) * totalways;
    }
    
}
