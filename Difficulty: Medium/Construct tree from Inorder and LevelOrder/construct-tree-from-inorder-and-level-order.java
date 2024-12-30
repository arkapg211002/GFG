//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    
System.out.println("~");
}
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends




/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    HashMap<Integer,Integer> map = new HashMap<>();
    public Node buildTree(int inord[], int level[]){
    mapping(level);
    	
    	Node root= helper(inord,0,inord.length-1);
    	return root;
    }
    Node helper(int inord[],int start,int end) {
    	if(start>end) return null;
    	
    	int index=start;
    	for(int j=start+1;j<=end;j++) {
    		if(map.get(inord[j])<map.get(inord[index])) {
    			index=j;
    		}
    	}
    	Node root=new Node(inord[index]);
    	root.left=helper(inord,start,index-1);
    	root.right=helper(inord,index+1,end);
    	return root;
    }
    public void mapping(int level[]) {
    	for(int i=0;i<level.length;i++) {
    		map.put(level[i], i);
    	}
    }
   
}


