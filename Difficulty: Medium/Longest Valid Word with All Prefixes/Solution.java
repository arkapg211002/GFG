class Solution {
    static String longestValidWord(String[] words) {
        
        Arrays.sort(words);
        String longestWord = "";

        for (String word : words) {
            boolean valid = true;

                for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);

               if (Arrays.binarySearch(words, prefix) < 0) {
                    valid = false;
                    break;
                }
            }

            if (valid && (word.length() > longestWord.length() || 
            (word.length() == longestWord.length() && 
                              word.compareTo(longestWord) < 0))) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
