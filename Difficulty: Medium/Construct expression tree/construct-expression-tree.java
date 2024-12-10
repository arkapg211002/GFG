//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    char val;
    Node left, right;
    Node(char c)
    {
        val = c;
        left = right = null;
    }
}

class Construct
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            char postfix[] = str.toCharArray();
            GfG gfg = new GfG();
            Node et = gfg.constructTree(postfix);
            inorder(et);
            System.out.println();
        
System.out.println("~");
}
    }
    
    public static void inorder(Node et)
    {
        if(et != null)
        {
            inorder(et.left);
            System.out.print(et.val + " ");
            inorder(et.right);
        }
    }
    
    public static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
          return true;
          
        return false;
    }
}


// } Driver Code Ends



class GfG
{
    
    public static Node constructTree(char postfix[])
    {
        
        
        Stack<Node> stk  = new Stack<>();
      
     
      
        for(char c : postfix){
            if(c== '+' || c=='*'|| c=='/' || c=='-' || c=='^'){
           //      System.out.println(stk.peek().val);
                Node node = new Node(c);
                  if(!stk.isEmpty())
                node.right =  stk.pop();
                  if(!stk.isEmpty())
                   node.left =  stk.pop();
                   
                   stk.push(node);
                     //System.out.println("push"+stk.peek().val);
            }
            else {
                stk.push(new Node(c));
            }
       
        }
        
    //  System.out.println(stk.size());
        
        return stk.pop();
        
        
    }
    
}