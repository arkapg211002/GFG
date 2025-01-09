//{ Driver Code Starts
import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
public int missingNumber(String s)
  {
      if(Integer.parseInt(s.charAt(1)+"")==Integer.parseInt(s.charAt(0)+"")+2){
          return Integer.parseInt(s.charAt(0)+"")+1;
      }
      char start=s.charAt(0);
      int i=0;
      for(i=1;i<s.length()-1;i++){
          if(s.charAt(i)!=start && s.charAt(i+1)==start){
              i=i+1;
              break;
          }
          if(s.charAt(i)==start){
              int k=i;
              while(s.charAt(k++)==start);
              i=k;
              break;
          }
         if(Integer.parseInt(s.charAt(i)+"")==(Integer.parseInt(start+"")+1)){
             break;
         }
      }
      int length=i;
      int check=Integer.parseInt(s.substring(0,i));
      int p=0;
      for(i=0;i<s.length();i++){
          Boolean nines=true;
          for(int j=0;j<(check+"").length();j++){
              if((check+"").charAt(j)!='9'){
                  nines=false;
                  break;
              }
          }
          if(s.indexOf(String.valueOf(check+1),p)==s.indexOf(String.valueOf(check),p)+length){
              check++;
              if(nines) length+=1;
          }
          else if(s.indexOf(String.valueOf(check+2),p)==s.indexOf(String.valueOf(check),p)+length){
              return check+1;
          }
          else{
              break;
          }
          p+=length-1;
      }
      return -1;
  }
}
