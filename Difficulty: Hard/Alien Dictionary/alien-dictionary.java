//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        if(n==1) {
            return "a";
        }
        //create adjList
        ArrayList<Set<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<k;i++) {
            adjList.add(new HashSet<>());
        }
        
        for(int i=0;i<n-1;i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            int j=0, m=0;
            while(j<word1.length() && m<word2.length()) {
                if(word1.charAt(j)!=word2.charAt(m)) {
                    
                    int w1 = (int)(word1.charAt(j)-'a');
                    int w2 = (int)(word2.charAt(m)-'a');
                    adjList.get(w1).add(w2);
                    break;
                }
                j++;
                m++;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[k];
        
        
        for(int i=0;i<k;i++) {
            if(!visited[i])
                topologicalSort(adjList, i, result, visited);
        }
        
        
        String finalResult= "";
        for(int i=result.size()-1;i>=0;i--) {
            finalResult+= (char)('a'+result.get(i));
        }
        
        return finalResult;
        
    }
    
    
    void topologicalSort(ArrayList<Set<Integer>> adjList, int v, ArrayList<Integer> result, boolean[] visited) {
        visited[v] = true;
        Set<Integer> set = adjList.get(v);
        for(Integer s : set) {
            if(!visited[s])
                topologicalSort(adjList, s, result, visited);
        }
        result.add(v);
    }  
}