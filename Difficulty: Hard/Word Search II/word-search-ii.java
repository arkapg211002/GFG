//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];  // 26 letters in the alphabet
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    // Check if a word exists in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
}


    public ArrayList<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();  // To avoid duplicate words
        boolean[][] visited = new boolean[board.length][board[0].length];

        // DFS helper method to explore the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    dfs(board, trie, visited, i, j, "", result);
                }
            }
        }

        // Convert the result set to ArrayList
        return new ArrayList<>(result);
    }

    // Depth-first search to explore the board and form words
    private void dfs(char[][] board, Trie trie, boolean[][] visited, int i, int j, String currentWord, Set<String> result) {
        // Check if out of bounds or cell already visited
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        currentWord += board[i][j];
        if (!trie.startsWith(currentWord)) {
            return;  // If current prefix is not valid, stop exploring
        }

        if (trie.search(currentWord)) {
            result.add(currentWord);  // If it's a valid word, add to the result
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Explore all 4 possible directions (up, down, left, right)
        int[] directions = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k];
            int newJ = j + directions[k + 1];
            dfs(board, trie, visited, newI, newJ, currentWord, result);
        }

        // Unmark the cell as visited for backtracking
        visited[i][j] = false;
    }

    // Example usage
    
        

        // Your code here
    
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First N and M input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);
            char board[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row[] = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = row[j].charAt(0);
                }
            }
            String words[] = br.readLine().trim().split(" ");
            // br.readLine();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findWords(board, words);
            Collections.sort(ans);
            if (ans.size() == 0) {
                System.out.println("[]");
                System.out.println("~");
                continue;
            }
            for (String s : ans) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends