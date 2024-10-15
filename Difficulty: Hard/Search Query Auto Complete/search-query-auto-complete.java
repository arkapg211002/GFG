//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String sentences[] = new String[n];
            int times[] = new int[n];
            for (int i = 0; i < n; i++) {
                sentences[i] = sc.nextLine();
                times[i] = sc.nextInt();
            }
            AutoCompleteSystem obj = new AutoCompleteSystem(sentences, times);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                String query = sc.nextLine();
                StringBuilder qq = new StringBuilder();
                for (int j = 0; j < query.length(); j++) {
                    char x = query.charAt(j);
                    qq.append(String.valueOf(x));
                    ArrayList<String> suggestions = obj.input(x);
                    if (x == '#') continue;
                    out.print("Typed : \"" + qq.toString() + "\" , Suggestions: \n");
                    for (String y : suggestions) out.print(y + "\n");
                }
            }
        }
        out.flush();
    }
}
// } Driver Code Ends




// User function Template for Java

class AutoCompleteSystem {
    class TrieNode {
        TrieNode child[];
        int times;
        
        TrieNode() {
            this.child = new TrieNode[27];
            this.times = 0;
        }
    }
    
    TrieNode root;
    public AutoCompleteSystem(String sentences[], int times[]) {
        root = new TrieNode();
        
        for(int i = 0; i < sentences.length; i++) {
            insert(sentences[i], 0, sentences[i].length(), root, times[i]);
        }
        inpStr = "";
    }
    
    public void insert(String str, int ind, int len, TrieNode root, int times) {
        if(ind >= len) {
            root.times += times;
            return;
        }
        
        int ch = str.charAt(ind) - 'a';
        if(ch == ' ' - 'a') ch = 26;
        
        if(root.child[ch] == null) {
            root.child[ch] = new TrieNode();
        }
        
        insert(str, ind+1, len, root.child[ch], times);
    }
    
    class Pair implements Comparable<Pair>{
        String str;
        int times;
        
        Pair(String s, int t) {
            this.str = s;
            this.times = t;
        }
        
        public int compareTo(Pair p) {
            if(this.times == p.times) {
                return p.str.compareTo(this.str);
            }
            return this.times - p.times;
        }
    }
    
    public void search(String str, TrieNode root, PriorityQueue<Pair> pq) {
        if(root.times > 0) {
            if(pq.size() < 3) {
                pq.add(new Pair(str, root.times));
            }
            else if(pq.peek().times < root.times){
                pq.poll();
                pq.add(new Pair(str, root.times));
            }
        }
        
        
        if(root.child[26] != null) search(str+' ', root.child[26], pq);
        for(int i = 0; i < 26; i++) {
            if(root.child[i] != null) {
                search(str+((char)(i+'a')), root.child[i], pq);
            }
        }
    }
    
    String inpStr;
    ArrayList<String> input(char c) {
        
        ArrayList<String> ans = new ArrayList<String>();
        if(c == '#') {
            insert(inpStr, 0, inpStr.length(), root, 1);
            inpStr = "";
            return ans;
        }
        
        inpStr += c;
        int len = inpStr.length();
        TrieNode curr = root;
        int ch, i;
        for(i = 0; i < len; i++) {
            ch = inpStr.charAt(i) - 'a';
            if(ch == ' ' - 'a') ch = 26;
            
            if(curr.child[ch] == null) return ans;
            curr = curr.child[ch];
        }
        
        String str = inpStr.substring(0, i);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        
        //
        // while(!pq.isEmpty()) {
        //     System.out.println(pq.poll().str);
        // }
        // System.out.println("--");
        
        search(str, curr, pq);
        
        while(!pq.isEmpty()) {
            ans.add(0, pq.poll().str);
        }
        
        return ans;
    }
}






















