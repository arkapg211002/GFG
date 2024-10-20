//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
  ArrayList<String> result = new ArrayList<>(); // to store the array and reutrn it 
        int n =s.length();
        // we will run three loop as three dots are needs to make ip 
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){

                    String s1 = generate(s,n,i,j,k); // we will make generate funciton to generate valid strings 
                    if(s1.length()>0){
                        result.add(s1);
                    }
                }
            }
        }


        return  result;

    }
    
     public static String generate(String txt,int m,int a,int b,int f){
       String s1= txt.substring(0,a); 
       String s2= txt.substring(a,b); 
       String s3= txt.substring(b,f); 
       String s4= txt.substring(f,m);  // we create all the 4 parts of the ip now we will check if they all statify then return 
       // that string else return an empty string
       String res ="";
       if(check(s1) &&check(s2) && check(s3) && check(s4) ){
        res = s1+"."+s2+"."+s3+"."+s4 ; 
        return res; 
       }else{
     return res;
       }

    
    }
    public static boolean check(String sii){
   int n =sii.length(); 
  if(n<=0 || n>3){// if length is substring is 0 or greater than 3 invalid 
    return false;
  }else if(n>1 && sii.charAt(0)=='0'){  // if length is greater than 1 and we have first char as 0 menas 06 aise then invalid 
    return false;
  }else {
    int p = Integer.parseInt(sii); // if the substring is three digit only but greate than 255 means more than 8 bit so invalid 
    if(p>255){
        return false;
    }else{
        return true ;
    }
  } 
    }
}

