//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            N_ary_Tree tree = new N_ary_Tree();
            Node curr = null;
            Queue<Node> q = new LinkedList<>();
            for(int i = 0; i < s.length; i++){
                if(i == 0){
                    curr = tree.add(Integer.parseInt(s[0]), null);
                } else if(s[i].equals(" ")){
                    continue;
                } else if(!q.isEmpty() && s[i].equals("N")){
                    curr = q.remove();
                } else if(!s[i].equals("N")){
                    q.add(tree.add(Integer.parseInt(s[i]), curr));
                }
            }
            Solution soln = new Solution();
            ot.println(soln.duplicateSubtreeNaryTree(tree.root));
        }

        ot.close();
    }
}
class Node{
    int data;
    List<Node> children;
    Node(int val){
        this.data = val;
        this.children = new ArrayList<>();
    }
}
class N_ary_Tree{
    Node root;
    int size;
    N_ary_Tree(){
        this.size = 0;
        this.root = null;
    }
    Node add(int key, Node parent){
        Node node = new Node(key);
        if(parent == null){
            this.root = node;
            this.size = 1;
        } else{
            parent.children.add(node);
            this.size++;
        }
        return node;
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution{
    public int duplicateSubtreeNaryTree(Node root){
        // Code here
        TreeMap<Integer,ArrayList<Node>> h = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Node> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Node x=q.poll();
            
            if(h.containsKey(x.data)){
                boolean m=false;
                for(Node n : h.get(x.data)){
                    if(check(x,n)){
                        boolean p=true;
                        m=true;
                        for(Node f : ans){
                            if(check(x,f)){
                                p=false;
                                break;
                            }
                        }
                        if(p) ans.add(x);
                    }
                }
                if(!m){
                    ArrayList<Node> t = h.get(x.data);
                    t.add(x);
                    h.put(x.data,t);
                }
            }else{
                ArrayList<Node> t = new ArrayList<>();
                t.add(x);
                h.put(x.data,t);
            }
            
            //adding childrens
            for(Node n : x.children){
                q.offer(n);
            }
        }
        return ans.size();
    }
    boolean check(Node r1,Node r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null || r1.children.size()!=r2.children.size() || r1.data!=r2.data) return false;
        boolean x = true;
        for(int i=0;i<r1.children.size();i++){
            x = x&&check(r1.children.get(i),r2.children.get(i));
        }
        return x;
    }
    
}